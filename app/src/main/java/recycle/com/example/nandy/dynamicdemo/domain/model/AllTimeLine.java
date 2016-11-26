package recycle.com.example.nandy.dynamicdemo.domain.model;

import java.util.List;

/**
 * Created by nandy on 16/10/13.
 */
public class AllTimeLine extends ResultModel<AllTimeLine.ResultBean> {

    public static class ResultBean {
        private String count;
        private String totalRows;
        private int nowPage;
        private String html;
        private int totalPages;
        private int dataCount;
        private List<DataBean> data;

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


        public static class DataBean {
            private String user_id;
            private String username;
            private String portrait;
            private String id;
            private String uid;
            private String type;
            private String text;
            private List<String> pictures;
            private String video;
            private String videoThumb;
            private Link link;
            private String news;
            private String create_time;
            private String status;
            private String is_open;
            private String allow_user_ids;
            private List<Like> like;
            private List<Comment> comment;


            public String getVideoThumb() {
                return videoThumb;
            }

            public void setVideoThumb(String videoThumb) {
                this.videoThumb = videoThumb;
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

            public String getPortrait() {
                return portrait;
            }

            public void setPortrait(String portrait) {
                this.portrait = portrait;
            }

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

            public List<String> getPictures() {
                return pictures;
            }

            public void setPictures(List<String> pictures) {
                this.pictures = pictures;
            }

            public String getVideo() {
                return video;
            }

            public void setVideo(String video) {
                this.video = video;
            }

            public Link getLink() {
                return link;
            }

            public void setLink(Link link) {
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

            public List<Like> getLike() {
                return like;
            }

            public void setLike(List<Like> like) {
                this.like = like;
            }

            public List<Comment> getComment() {
                return comment;
            }

            public void setComment(List<Comment> comment) {
                this.comment = comment;
            }

            public boolean isLike(String uid) {
                if (like != null) {
                    for (Like l : like) {
                        if (uid.equals(l.getUser_id())) {
                            return true;
                        }
                    }
                }
                return false;
            }
        }


    }


    public static class Like {

        private String user_id;
        private String username;
        private String create_time;

        public String getUser_id() {
            return user_id;
        }

        public String getUsername() {
            return username;
        }

        public String getCreate_time() {
            return create_time;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }
    }

    public static class Comment {

        private String user_id;
        private String username;
        private String content;
        private String create_time;
        private String id;
        private String pid;
        private String p_username;
        private String p_user_id;


        public String getP_username() {
            return p_username;
        }

        public void setP_username(String p_username) {
            this.p_username = p_username;
        }

        public String getP_user_id() {
            return p_user_id;
        }

        public void setP_user_id(String p_user_id) {
            this.p_user_id = p_user_id;
        }


        public String getUser_id() {
            return user_id;
        }

        public String getUsername() {
            return username;
        }

        public String getContent() {
            return content;
        }

        public String getCreate_time() {
            return create_time;
        }

        public String getId() {
            return id;
        }

        public String getPid() {
            return pid;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setCreate_time(String create_time) {
            this.create_time = create_time;
        }

        public void setId(String id) {
            this.id = id;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }
    }

    public static class Link {
        private String title;
        private String description;
        private String image;
        private String url;
        private String thumb;

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
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

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
