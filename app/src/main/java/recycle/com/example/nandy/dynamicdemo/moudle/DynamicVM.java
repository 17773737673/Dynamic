package recycle.com.example.nandy.dynamicdemo.moudle;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

import recycle.com.example.nandy.dynamicdemo.App;
import recycle.com.example.nandy.dynamicdemo.utils.DateUtils;

/**
 * Created by nandy on 16/10/26.
 */
public class DynamicVM implements Parcelable {

    private String count;
    private String totalRows;
    private int nowPage;
    private String html;
    private int totalPages;
    private int dataCount;
    private List<DataBean> data;
    public static String datesame = "";

    public DynamicVM(String count, String totalRows, int nowPage, String html, int totalPages, int dataCount, List<DataBean> data) {
        this.count = count;
        this.totalRows = totalRows;
        this.nowPage = nowPage;
        this.html = html;
        this.totalPages = totalPages;
        this.dataCount = dataCount;
        this.data = data;
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(String totalRows) {
        this.totalRows = totalRows;
    }

    public int getNowPage() {
        return nowPage;
    }

    public void setNowPage(int nowPage) {
        this.nowPage = nowPage;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getDataCount() {
        return dataCount;
    }

    public void setDataCount(int dataCount) {
        this.dataCount = dataCount;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean implements Parcelable {

        public DataBean(String id, String uid, String type, String text, String video,
                        String video_thumb, LinkBean link, String news, String create_time,
                        String status, String is_open, String allow_user_ids, List<String> pictures,
                        List<LikeBean> like, List<CommentBean> comment, String date, String portrait,
                        String username, boolean isShow) {
            this.id = id;
            this.uid = uid;
            this.type = type;
            this.text = text;
            this.video = video;
            this.video_thumb = video_thumb;
            this.link = link;
            this.news = news;
            this.create_time = create_time;
            this.status = status;
            this.is_open = is_open;
            this.allow_user_ids = allow_user_ids;
            this.pictures = pictures;
            this.like = like;
            this.comment = comment;
            this.date = date;
            this.portrait = portrait;
            this.username = username;
            this.isShow = isShow;
        }

        private String id;
        private String uid;
        private String type;
        private String text;
        private String video;
        private String video_thumb;
        private LinkBean link;
        private String news;
        private String create_time;
        private String status;
        private String is_open;
        private String allow_user_ids;
        private List<String> pictures;
        private List<LikeBean> like;
        private List<CommentBean> comment;
        private String date;
        private String portrait;
        private String username;

        public boolean isLike(List<DynamicVM.DataBean.LikeBean> like) {
            if (like != null) {
                for (DynamicVM.DataBean.LikeBean l : like) {
                    if (String.valueOf(App.getInstance().uid).equals(l.getUser_id())) {
                        return true;
                    }
                }
            }
            return false;
        }

        public boolean isShow() {
            return isShow;
        }

        public void setShow(boolean show) {
            isShow = show;
        }

        private boolean isShow;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUid() {
            return uid;
        }

        public void setUid(String uid) {
            this.uid = uid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getVideo() {
            return video;
        }

        public void setVideo(String video) {
            this.video = video;
        }

        public String getVideo_thumb() {
            return video_thumb;
        }

        public void setVideo_thumb(String video_thumb) {
            this.video_thumb = video_thumb;
        }

        public LinkBean getLink() {
            return link;
        }

        public void setLink(LinkBean link) {
            this.link = link;
        }

        public String getNews() {
            return news;
        }

        public void setNews(String news) {
            this.news = news;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIs_open() {
            return is_open;
        }

        public void setIs_open(String is_open) {
            this.is_open = is_open;
        }

        public String getAllow_user_ids() {
            return allow_user_ids;
        }

        public void setAllow_user_ids(String allow_user_ids) {
            this.allow_user_ids = allow_user_ids;
        }

        public List<String> getPictures() {
            return pictures;
        }

        public void setPictures(List<String> pictures) {
            this.pictures = pictures;
        }

        public List<LikeBean> getLike() {
            return like;
        }

        public void setLike(List<LikeBean> like) {
            this.like = like;
        }

        public List<CommentBean> getComment() {
            return comment;
        }

        public void setComment(List<CommentBean> comment) {
            this.comment = comment;
        }

        public void setDate(String date) {
            String formattedTime2 = DateUtils.getFormattedTime2(Long.parseLong(date), App.getInstance().getApplicationContext());
            this.date = formattedTime2;
            if (datesame.equals(formattedTime2)) {
                this.isShow = false;
            } else {
                this.isShow = true;
            }
            datesame = formattedTime2;
        }

        public String getDate() {
            return date;
        }

        public void setPortrait(String portrait) {
            this.portrait = portrait;
        }

        public String getPortrait() {
            return portrait;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getUsername() {
            return username;
        }

        public static class LinkBean implements Parcelable {

            private String title;
            private String description;
            private String url;
            private String image;


            public LinkBean(String title, String description, String url, String image) {
                this.title = title;
                this.description = description;
                this.url = url;
                this.image = image;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.title);
                dest.writeString(this.description);
                dest.writeString(this.url);
                dest.writeString(this.image);
            }

            public LinkBean() {
            }

            protected LinkBean(Parcel in) {
                this.title = in.readString();
                this.description = in.readString();
                this.url = in.readString();
                this.image = in.readString();
            }

            public static final Creator<LinkBean> CREATOR = new Creator<LinkBean>() {
                @Override
                public LinkBean createFromParcel(Parcel source) {
                    return new LinkBean(source);
                }

                @Override
                public LinkBean[] newArray(int size) {
                    return new LinkBean[size];
                }
            };
        }

        public static class LikeBean implements Parcelable {
            private String user_id;
            private String username;
            private String create_time;


            public LikeBean(String user_id, String username, String create_time) {
                this.user_id = user_id;
                this.username = username;
                this.create_time = create_time;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.user_id);
                dest.writeString(this.username);
                dest.writeString(this.create_time);
            }

            public LikeBean() {
            }

            protected LikeBean(Parcel in) {
                this.user_id = in.readString();
                this.username = in.readString();
                this.create_time = in.readString();
            }

            public static final Creator<LikeBean> CREATOR = new Creator<LikeBean>() {
                @Override
                public LikeBean createFromParcel(Parcel source) {
                    return new LikeBean(source);
                }

                @Override
                public LikeBean[] newArray(int size) {
                    return new LikeBean[size];
                }
            };
        }

        public static class CommentBean implements Parcelable {
            private String user_id;
            private String username;
            private String content;
            private String create_time;
            private String id;
            private String pid;
            private String p_user_id;
            private String p_username;


            public CommentBean(String user_id, String username, String content, String create_time,
                               String id, String pid, String p_user_id, String p_username) {
                this.user_id = user_id;
                this.username = username;
                this.content = content;
                this.create_time = create_time;
                this.id = id;
                this.pid = pid;
                this.p_user_id = p_user_id;
                this.p_username = p_username;
            }

            public String getUser_id() {
                return user_id;
            }

            public void setUser_id(String user_id) {
                this.user_id = user_id;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public String getCreate_time() {
                return create_time;
            }

            public void setCreate_time(String create_time) {
                this.create_time = create_time;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getPid() {
                return pid;
            }

            public void setPid(String pid) {
                this.pid = pid;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.user_id);
                dest.writeString(this.username);
                dest.writeString(this.content);
                dest.writeString(this.create_time);
                dest.writeString(this.id);
                dest.writeString(this.pid);
                dest.writeString(this.p_user_id);
                dest.writeString(this.p_username);
            }

            public CommentBean() {
            }

            protected CommentBean(Parcel in) {
                this.user_id = in.readString();
                this.username = in.readString();
                this.content = in.readString();
                this.create_time = in.readString();
                this.id = in.readString();
                this.pid = in.readString();
                this.p_user_id = in.readString();
                this.p_username = in.readString();
            }

            public static final Creator<CommentBean> CREATOR = new Creator<CommentBean>() {
                @Override
                public CommentBean createFromParcel(Parcel source) {
                    return new CommentBean(source);
                }

                @Override
                public CommentBean[] newArray(int size) {
                    return new CommentBean[size];
                }
            };

            public void setP_user_id(String p_user_id) {
                this.p_user_id = p_user_id;
            }

            public String getP_user_id() {
                return p_user_id;
            }

            public void setP_username(String p_username) {
                this.p_username = p_username;
            }

            public String getP_username() {
                return p_username;
            }
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.id);
            dest.writeString(this.uid);
            dest.writeString(this.type);
            dest.writeString(this.text);
            dest.writeString(this.video);
            dest.writeString(this.video_thumb);
            dest.writeParcelable(this.link, flags);
            dest.writeString(this.news);
            dest.writeString(this.create_time);
            dest.writeString(this.status);
            dest.writeString(this.is_open);
            dest.writeString(this.allow_user_ids);
            dest.writeStringList(this.pictures);
            dest.writeList(this.like);
            dest.writeList(this.comment);
            dest.writeString(this.date);
            dest.writeByte(this.isShow ? (byte) 1 : (byte) 0);
        }

        public DataBean() {
        }

        protected DataBean(Parcel in) {
            this.id = in.readString();
            this.uid = in.readString();
            this.type = in.readString();
            this.text = in.readString();
            this.video = in.readString();
            this.video_thumb = in.readString();
            this.link = in.readParcelable(LinkBean.class.getClassLoader());
            this.news = in.readString();
            this.create_time = in.readString();
            this.status = in.readString();
            this.is_open = in.readString();
            this.allow_user_ids = in.readString();
            this.pictures = in.createStringArrayList();
            this.like = new ArrayList<LikeBean>();
            in.readList(this.like, LikeBean.class.getClassLoader());
            this.comment = new ArrayList<CommentBean>();
            in.readList(this.comment, CommentBean.class.getClassLoader());
            this.date = in.readString();
            this.isShow = in.readByte() != 0;
        }

        public static final Creator<DataBean> CREATOR = new Creator<DataBean>() {
            @Override
            public DataBean createFromParcel(Parcel source) {
                return new DataBean(source);
            }

            @Override
            public DataBean[] newArray(int size) {
                return new DataBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.count);
        dest.writeString(this.totalRows);
        dest.writeInt(this.nowPage);
        dest.writeString(this.html);
        dest.writeInt(this.totalPages);
        dest.writeInt(this.dataCount);
        dest.writeList(this.data);
    }

    public DynamicVM() {
    }

    protected DynamicVM(Parcel in) {
        this.count = in.readString();
        this.totalRows = in.readString();
        this.nowPage = in.readInt();
        this.html = in.readString();
        this.totalPages = in.readInt();
        this.dataCount = in.readInt();
        this.data = new ArrayList<DataBean>();
        in.readList(this.data, DataBean.class.getClassLoader());
    }

    public static final Creator<DynamicVM> CREATOR = new Creator<DynamicVM>() {
        @Override
        public DynamicVM createFromParcel(Parcel source) {
            return new DynamicVM(source);
        }

        @Override
        public DynamicVM[] newArray(int size) {
            return new DynamicVM[size];
        }
    };
}
