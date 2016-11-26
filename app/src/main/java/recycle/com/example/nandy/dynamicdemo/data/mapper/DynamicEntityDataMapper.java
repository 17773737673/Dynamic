package recycle.com.example.nandy.dynamicdemo.data.mapper;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import recycle.com.example.nandy.dynamicdemo.domain.model.AllTimeLine;
import recycle.com.example.nandy.dynamicdemo.moudle.DynamicVM;

/**
 * Created by nandy on 16/11/11.
 * <p/>
 * 数据映射类
 */
public class DynamicEntityDataMapper {

    @Inject
    public DynamicEntityDataMapper() {
    }

    /**
     * @param result 把朋友圈 个人详情，相册，等一些界面的相同数据统一映射成一个类型的数据，方便传递
     * @return
     */
    public DynamicVM transformVM(AllTimeLine.ResultBean result) {
        return new DynamicVM(result.getCount(), result.getTotalRows(), result.getNowPage(),
                result.getHtml(), result.getTotalPages(), result.getDataCount(),
                transformList(result.getData()));
    }

    private List<DynamicVM.DataBean> transformList(List<AllTimeLine.ResultBean.DataBean> data) {
        List<DynamicVM.DataBean> dataBeen = new ArrayList<>();
        if (data == null) return dataBeen;
        for (AllTimeLine.ResultBean.DataBean bean : data) {
            dataBeen.add(transformVMList(bean));
        }
        return dataBeen;
    }

    //    transformToUserComment transformToUserLike transformToLink
    public DynamicVM.DataBean transformVMList(AllTimeLine.ResultBean.DataBean bean) {
        return new DynamicVM.DataBean(bean.getId(), bean.getUid(),
                bean.getType(), bean.getText(), bean.getVideo(),
                bean.getVideoThumb(), transformToLink(bean.getLink()),
                bean.getNews(), bean.getCreate_time(), bean.getStatus(),
                bean.getIs_open(), bean.getAllow_user_ids(), bean.getPictures(),
                transformToUserLike(bean.getLike()), transformToUserComment(bean.getComment()),
                "", bean.getPortrait(), bean.getUsername(), false);
    }

    private DynamicVM.DataBean.LinkBean transformToLink(AllTimeLine.Link link) {
        if (link != null) {
            DynamicVM.DataBean.LinkBean linkBean = new DynamicVM.DataBean.LinkBean();
            linkBean.setDescription(link.getDescription());
            linkBean.setTitle(link.getTitle());
            linkBean.setUrl(link.getUrl());
            linkBean.setImage(link.getThumb());
            return linkBean;
        }
        return null;
    }

    private List<DynamicVM.DataBean.LikeBean> transformToUserLike(List<AllTimeLine.Like> like) {
        List<DynamicVM.DataBean.LikeBean> likes = new ArrayList<>();
        if (like != null) {
            for (AllTimeLine.Like entity : like) {
                DynamicVM.DataBean.LikeBean result = new DynamicVM.DataBean.LikeBean();
                result.setUser_id(entity.getUser_id());
                result.setCreate_time(entity.getCreate_time());
                result.setUsername(entity.getUsername());
                likes.add(result);
            }
        }
        return likes;
    }

    private List<DynamicVM.DataBean.CommentBean> transformToUserComment(List<AllTimeLine.Comment> comment) {
        List<DynamicVM.DataBean.CommentBean> comments = new ArrayList<>();
        if (comment != null) {
            for (AllTimeLine.Comment entity : comment) {
                DynamicVM.DataBean.CommentBean result = new DynamicVM.DataBean.CommentBean();
                result.setId(entity.getId());
                result.setUser_id(entity.getUser_id());
                result.setContent(entity.getContent());
                result.setCreate_time(entity.getCreate_time());
                result.setPid(entity.getPid());
                result.setUsername(entity.getUsername());
                result.setP_user_id(entity.getP_user_id());
                result.setP_username(entity.getP_username());
                comments.add(result);
            }
        }
        return comments;
    }
}
