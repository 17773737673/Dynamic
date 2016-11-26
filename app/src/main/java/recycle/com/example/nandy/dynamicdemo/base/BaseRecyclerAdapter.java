package recycle.com.example.nandy.dynamicdemo.base;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * RecycleAdapter基类
 * <p/>
 * Created by ZhangWF(zhangwf0929@gmail.com) on 15/4/17.
 */
public abstract class BaseRecyclerAdapter<D, V extends BaseViewHolder<D>> extends RecyclerView.Adapter<V> {

    private static final String TAG = "BaseRecyclerAdapter";

    public interface OnItemClickListener {
        void onItemClick(View view, Object item, int position);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View view, Object item, int position);
    }

    public List<D> items = new ArrayList<>();

    // 用set不用map的原因是，如果用MyLinearLayoutManager布局，onCreateViewHolder会多次调用，导致一个position有多个holder
    private final HashSet<V> mHolderCache = new HashSet<>();

    protected abstract V getViewHolder(int viewType, View v);

    protected abstract int getItemLayout(int viewType);

    private OnItemClickListener onItemClickListener;

    private OnItemLongClickListener onItemLongClickListener;

    private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (null != onItemClickListener) {
                Object o = v.getTag();
                if (o instanceof Integer) {
                    int position = (int) v.getTag();
                    onItemClickListener.onItemClick(v, getItem(position), position);
//                    Log.d("zwf", "item onClick " + position + " itemView " + v);
                }
            }
        }
    };

    private final View.OnLongClickListener mOnLongClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            if (onItemLongClickListener != null) {
                Object o = v.getTag();
                if (o instanceof Integer) {
                    int position = (int) v.getTag();
                    onItemLongClickListener.onItemLongClick(v, getItem(position), position);
                    return true;
                }
            }
            return false;
        }
    };

    @Override
    public V onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(getItemLayout(viewType), parent, false);
        if (view != null) {
            view.setOnClickListener(mOnClickListener);
            view.setOnLongClickListener(mOnLongClickListener);
        }
//        Log.d("zwf", "item onCreateViewHolder " + view);
        return getViewHolder(viewType, view);
    }

    @Override
    public void onBindViewHolder(V holder, int position) {
//        Log.d("zwf", "item onBindViewHolder " + position + " itemView " + holder.itemView);
        holder.setItem(getItem(position), position);
        mHolderCache.add(holder);
    }

    @Override
    public int getItemCount() {
        return items == null ? 0 : items.size();
    }

    public void setItems(List<D> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    public List<D> getItems() {
        if (null == items) {
            items = new ArrayList<>();
        }
        return items;
    }

    public D getItem(int pos) {
        if (null == items || items.size() - 1 < pos) {
            return null;
        }
        return items.get(pos);
    }

    public void addItemAtFirst(D item) {
        addItem(item, 0);
    }

    public void addItemAtLast(D item) {
        int index = getItemCount();
        addItem(item, index);
    }

    private void addItem(D item, int position) {
        if (null == items) {
            items = new ArrayList<>();
        }
        items.add(position, item);
        if (items.size() > 1) {
            notifyItemInserted(position);
        } else {
            // 如果只有一个元素，并使用了FullLayoutManager，动态添加对象时，控件高度不会自适应
            notifyDataSetChanged();
        }
    }

    public void setItem(int index, D item) {
        if (null == items) {
            items = new ArrayList<>();
            items.add(item);
            notifyItemInserted(0);
        } else if (index >= 0 && index < items.size()) {
            items.set(index, item);
            notifyItemChanged(index);
        }
    }

    public void setOnItemClickListener(OnItemClickListener itemClickListener) {
        this.onItemClickListener = itemClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener itemLongClickListener) {
        this.onItemLongClickListener = itemLongClickListener;
    }

    // 从开始添加数据
    public void addItemsAtFirst(List<D> newItems) {
        addItems(newItems, false);
    }

    // 从末尾添加数据
    public void addItemsAtLast(List<D> newItems) {
        addItems(newItems, true);
    }

    private void addItems(List<D> newItems, boolean isAtLast) {
        if (null == items) {
            items = new ArrayList<>();
        }
        int index = 0;
        if (isAtLast) {
            index = getItemCount();
            items.addAll(newItems);
        } else {
            items.addAll(0, newItems);
        }
        notifyItemRangeInserted(index, newItems.size());
    }

    public void release() {
        if (null != items) {
            items.clear();
        }
        if (null != mHolderCache) {
            mHolderCache.clear();
        }
    }

    private void removeItem(int index) {
        if (items != null && index >= 0 && index < items.size()) {
            items.remove(index);
            updatePosition(index);
            notifyItemRemoved(index);
        }
    }

    public void removeItem(D item) {
        if (items != null) {
            int index = items.indexOf(item);
            removeItem(index);
        }
    }

    public void onItemDismiss(int position) {
        removeItem(position);
    }

    public boolean onItemMove(int fromPosition, int toPosition) {
        if (items == null || fromPosition < 0 || fromPosition >= items.size() ||
                toPosition < 0 || toPosition >= items.size()) {
            return false;
        }
//        Log.d(TAG, String.format("onItemMove from %d to %d", fromPosition, toPosition));
        swap(fromPosition, toPosition);
        notifyItemMoved(fromPosition, toPosition);
        return true;
    }

    public void clearView() {
//        Log.d(TAG, "onItemMoved or swipe end");
    }

    private void swap(int fromPosition, int toPosition) {
        try {
            if (fromPosition < toPosition) {
                for (int i = fromPosition; i < toPosition; i++) {
                    Collections.swap(items, i, i + 1);
                    updatePosition(i, i + 1);
                }
            } else {
                for (int i = fromPosition; i > toPosition; i--) {
                    Collections.swap(items, i, i - 1);
                    updatePosition(i, i - 1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 更新holder对应的index tag，保证item click等事件生效
    private void updatePosition(int fromPosition, int toPosition) {
        for (V holder : mHolderCache) {
            Object o = holder.itemView.getTag();
            if (o instanceof Integer) {
                int pos = (int) o;
                if (pos == fromPosition) {
                    holder.itemView.setTag(toPosition);
                    holder.position = toPosition;
                } else if (pos == toPosition) {
                    holder.itemView.setTag(fromPosition);
                    holder.position = fromPosition;
                }
            }
        }
    }

    // 更新holder对应的index tag，保证item click等事件生效
    private void updatePosition(int delPosition) {
        for (V holder : mHolderCache) {
            Object o = holder.itemView.getTag();
            if (o instanceof Integer) {
                int pos = (int) o;
                if (pos > delPosition) {
                    pos--;
                    holder.itemView.setTag(pos);
                    holder.position = pos;
                }
            }
        }
    }

    public boolean canDrag(RecyclerView.ViewHolder holder) {
        return true;
    }

    public boolean canDropOver(RecyclerView.ViewHolder current, RecyclerView.ViewHolder target) {
        return true;
    }
}
