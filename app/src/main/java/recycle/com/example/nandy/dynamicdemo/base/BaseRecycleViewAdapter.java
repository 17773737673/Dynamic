package recycle.com.example.nandy.dynamicdemo.base;

import android.content.Context;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class BaseRecycleViewAdapter<T> extends RecyclerView.Adapter<BaseBindingViewHolder> {

    public final Context mContext;
    protected List<T> data;
    public final LayoutInflater mLayoutInflater;

    public BaseRecycleViewAdapter(Context context) {
        data = new ArrayList<>();
        mLayoutInflater = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mContext = context;
    }

    @Override
    public BaseBindingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(BaseBindingViewHolder holder, int position) {

    }


    public void setData(List<T> d) {
        this.data = d;
    }


    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return size();
    }

    public List<T> getData() {
        return data;
    }

    public T get(int position) {
        return data.get(position);
    }


    public void add(T elem) {
        if (elem == null) return;
        data.add(elem);
        notifyItemChanged(data.size() - 1);
    }


    public void add(int location, T elem) {
        if (elem == null) return;
        data.add(location, elem);
        notifyDataSetChanged();

    }

    public void reset(List<T> elems) {
        if (elems == null) return;
        data.clear();
        data.addAll(elems);
        notifyDataSetChanged();
    }


    public void addAll(int location, List<T> elems) {
        if (elems == null) return;
        data.addAll(location, elems);
        notifyItemChanged(location, elems.size());
    }


    public void addAll(List<T> elems) {
        if (elems == null) return;
        int positionStart = data.size();
        data.addAll(elems);
        notifyItemRangeInserted(positionStart + 1, elems.size());
//        notifyDataSetChanged();
    }


    public void remove(T elem) {
        data.remove(elem);
        notifyDataSetChanged();
    }


    public void remove(int position) {
        if (position >= 0 && position < data.size()) {
            data.remove(position);
            notifyItemRemoved(position);
//            notifyDataSetChanged();
        }
    }


    public void clear() {
        data.clear();
        notifyDataSetChanged();
    }

    public int size() {
        return data == null ? 0 : data.size();
    }


    public boolean isEmpty() {
        return data == null || data.isEmpty();
    }


    public OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
