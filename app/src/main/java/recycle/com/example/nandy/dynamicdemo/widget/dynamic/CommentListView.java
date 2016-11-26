package recycle.com.example.nandy.dynamicdemo.widget.dynamic;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import recycle.com.example.nandy.dynamicdemo.R;


/**
 * Created by yiwei on 16/7/9.
 */


public class CommentListView extends LinearLayout {


    private static final String TAG = "CommentListView";
    private int itemColor;
    private int itemSelectorColor;
    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;
//    private List<DynamicDetailVM.DataBean.CommentBean> mDatas;
    private LayoutInflater layoutInflater;

    public OnItemClickListener getOnItemClickListener() {
        return onItemClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public OnItemLongClickListener getOnItemLongClickListener() {
        return onItemLongClickListener;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

//    public void setDatas(List<DynamicDetailVM.DataBean.CommentBean> datas) {
//        if (datas == null) {
//            datas = new ArrayList<>();
//        }
//        mDatas = datas;
//        notifyDataSetChanged();
//    }
//
//    public List<DynamicDetailVM.DataBean.CommentBean> getDatas() {
//        return mDatas;
//    }

    public CommentListView(Context context) {
        super(context);
    }

    public CommentListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttrs(attrs);
    }

    public CommentListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttrs(attrs);
    }

    protected void initAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.PraiseListView, 0, 0);
        try {
            //textview的默认颜色
            itemColor = typedArray.getColor(R.styleable.PraiseListView_item_color, getResources().getColor(R.color.white));
            itemSelectorColor = typedArray.getColor(R.styleable.PraiseListView_item_selector_color, getResources().getColor(R.color.color_8290AF));

        } finally {
            typedArray.recycle();
        }
    }

    public void notifyDataSetChanged() {

        removeAllViews();
//        if (mDatas == null || mDatas.size() == 0) {
//            return;
//        }
//        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//        for (int i = 0; i < mDatas.size(); i++) {
//            final int index = i;
//            View view = getView(index);
//            if (view == null) {
//                throw new NullPointerException("listview item layout is null, please check getView()...");
//            }
//
//            addView(view, index, layoutParams);
//        }
    }

    private View getView(final int position) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(getContext());
        }
        View convertView = layoutInflater.inflate(R.layout.item_comment, null, false);

        TextView commentTv = (TextView) convertView.findViewById(R.id.commentTv);
//        final CircleMovementMethod circleMovementMethod = new CircleMovementMethod(itemSelectorColor, itemSelectorColor);
//        final DynamicDetailVM.DataBean.CommentBean bean = mDatas.get(position);
//        String name = bean.getUsername();
//        String id = bean.getId();
//        String toReplyName = bean.getP_username();
//        SpannableStringBuilder builder = new SpannableStringBuilder();
//        builder.append(setClickableSpan(name, bean.getUser_id()));
//        if (!TextUtils.isEmpty(toReplyName)) {
//            builder.append(commentTv.getContext().getString(R.string.huifu));
//            builder.append(setClickableSpan(toReplyName, bean.getP_user_id()));
//        }
//        builder.append(": ");
//        //转换表情字符
//        String contentBodyStr = bean.getContent();
//        builder.append(UrlUtils.formatUrlString(contentBodyStr));
//        commentTv.setText(builder);
//
//        commentTv.setMovementMethod(circleMovementMethod);
//        commentTv.setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (circleMovementMethod.isPassToTv()) {
//                    if (onItemClickListener != null) {
//                        onItemClickListener.onItemClick(position);
//                    }
//                }
//            }
//        });
//        commentTv.setOnLongClickListener(new OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                if (circleMovementMethod.isPassToTv()) {
//                    if (onItemLongClickListener != null) {
//                        onItemLongClickListener.onItemLongClick(position);
//                    }
//                    return true;
//                }
//                return false;
//            }
//        });

        return convertView;
    }


    @NonNull
    private SpannableString setClickableSpan(final String textStr, final String id) {
        SpannableString subjectSpanText = new SpannableString(textStr);
//        subjectSpanText.setSpan(new SpannableClickable(itemColor) {
//                                    @Override
//                                    public void onClick(View widget) {
//                                        DynamicDetailActivity.launch(App.getInstance(), id);
//                                    }
//                                }, 0, subjectSpanText.length(),
//                Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return subjectSpanText;
    }

    public static interface OnItemClickListener {
        public void onItemClick(int position);
    }

    public static interface OnItemLongClickListener {
        public void onItemLongClick(int position);
    }


}
