package com.annarm.douban.moive.network.response;

import java.util.List;

/**
 * description:
 *
 * @author wangzhijun
 * date 2018/11/13 15:04
 * @version V1.0
 */
public class MovieListModal {

    /**
     * count : 1
     * start : 0
     * total : 41
     * subjects : [{"rating":{"max":10,"average":7.4,"stars":"40","min":0},"genres":["动作","科幻","惊悚"],"title":"毒液：致命守护者","casts":[{"alt":"https://movie.douban.com/celebrity/1049489/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5110.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5110.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5110.jpg"},"name":"汤姆·哈迪","id":"1049489"},{"alt":"https://movie.douban.com/celebrity/1049491/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p19972.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p19972.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p19972.jpg"},"name":"米歇尔·威廉姆斯","id":"1049491"},{"alt":"https://movie.douban.com/celebrity/1036731/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4767.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4767.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4767.jpg"},"name":"里兹·阿迈德","id":"1036731"}],"collect_count":189361,"original_title":"Venom","subtype":"movie","directors":[{"alt":"https://movie.douban.com/celebrity/1274906/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360083887.75.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360083887.75.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360083887.75.jpg"},"name":"鲁本·弗雷斯彻","id":"1274906"}],"year":"2018","images":{"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2537158013.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2537158013.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2537158013.jpg"},"alt":"https://movie.douban.com/subject/3168101/","id":"3168101"}]
     * title : 正在上映的电影-北京
     */

    private int count;
    private int start;
    private int total;
    private String title;
    private List<SubjectsBean> subjects;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<SubjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<SubjectsBean> subjects) {
        this.subjects = subjects;
    }

    public static class SubjectsBean {
        /**
         * rating : {"max":10,"average":7.4,"stars":"40","min":0}
         * genres : ["动作","科幻","惊悚"]
         * title : 毒液：致命守护者
         * casts : [{"alt":"https://movie.douban.com/celebrity/1049489/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5110.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5110.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5110.jpg"},"name":"汤姆·哈迪","id":"1049489"},{"alt":"https://movie.douban.com/celebrity/1049491/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p19972.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p19972.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p19972.jpg"},"name":"米歇尔·威廉姆斯","id":"1049491"},{"alt":"https://movie.douban.com/celebrity/1036731/","avatars":{"small":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4767.jpg","large":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4767.jpg","medium":"https://img1.doubanio.com/view/celebrity/s_ratio_celebrity/public/p4767.jpg"},"name":"里兹·阿迈德","id":"1036731"}]
         * collect_count : 189361
         * original_title : Venom
         * subtype : movie
         * directors : [{"alt":"https://movie.douban.com/celebrity/1274906/","avatars":{"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360083887.75.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360083887.75.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360083887.75.jpg"},"name":"鲁本·弗雷斯彻","id":"1274906"}]
         * year : 2018
         * images : {"small":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2537158013.jpg","large":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2537158013.jpg","medium":"https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2537158013.jpg"}
         * alt : https://movie.douban.com/subject/3168101/
         * id : 3168101
         */

        private RatingBean rating;
        private String title;
        private int collect_count;
        private String original_title;
        private String subtype;
        private String year;
        private ImagesBean images;
        private String alt;
        private String id;
        private List<String> genres;
        private List<CastsBean> casts;
        private List<DirectorsBean> directors;

        public RatingBean getRating() {
            return rating;
        }

        public void setRating(RatingBean rating) {
            this.rating = rating;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getCollect_count() {
            return collect_count;
        }

        public void setCollect_count(int collect_count) {
            this.collect_count = collect_count;
        }

        public String getOriginal_title() {
            return original_title;
        }

        public void setOriginal_title(String original_title) {
            this.original_title = original_title;
        }

        public String getSubtype() {
            return subtype;
        }

        public void setSubtype(String subtype) {
            this.subtype = subtype;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public ImagesBean getImages() {
            return images;
        }

        public void setImages(ImagesBean images) {
            this.images = images;
        }

        public String getAlt() {
            return alt;
        }

        public void setAlt(String alt) {
            this.alt = alt;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<String> getGenres() {
            return genres;
        }

        public void setGenres(List<String> genres) {
            this.genres = genres;
        }

        public List<CastsBean> getCasts() {
            return casts;
        }

        public void setCasts(List<CastsBean> casts) {
            this.casts = casts;
        }

        public List<DirectorsBean> getDirectors() {
            return directors;
        }

        public void setDirectors(List<DirectorsBean> directors) {
            this.directors = directors;
        }

        public static class RatingBean {
            /**
             * max : 10
             * average : 7.4
             * stars : 40
             * min : 0
             */

            private int max;
            private double average;
            private String stars;
            private int min;

            public int getMax() {
                return max;
            }

            public void setMax(int max) {
                this.max = max;
            }

            public double getAverage() {
                return average;
            }

            public void setAverage(double average) {
                this.average = average;
            }

            public String getStars() {
                return stars;
            }

            public void setStars(String stars) {
                this.stars = stars;
            }

            public int getMin() {
                return min;
            }

            public void setMin(int min) {
                this.min = min;
            }
        }

        public static class ImagesBean {
            /**
             * small : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2537158013.jpg
             * large : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2537158013.jpg
             * medium : https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2537158013.jpg
             */

            private String small;
            private String large;
            private String medium;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }
        }

        public static class CastsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1049489/
             * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5110.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5110.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5110.jpg"}
             * name : 汤姆·哈迪
             * id : 1049489
             */

            private String alt;
            private AvatarsBean avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBean getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBean avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBean {
                /**
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5110.jpg
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5110.jpg
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p5110.jpg
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }

        public static class DirectorsBean {
            /**
             * alt : https://movie.douban.com/celebrity/1274906/
             * avatars : {"small":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360083887.75.jpg","large":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360083887.75.jpg","medium":"https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360083887.75.jpg"}
             * name : 鲁本·弗雷斯彻
             * id : 1274906
             */

            private String alt;
            private AvatarsBeanX avatars;
            private String name;
            private String id;

            public String getAlt() {
                return alt;
            }

            public void setAlt(String alt) {
                this.alt = alt;
            }

            public AvatarsBeanX getAvatars() {
                return avatars;
            }

            public void setAvatars(AvatarsBeanX avatars) {
                this.avatars = avatars;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public static class AvatarsBeanX {
                /**
                 * small : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360083887.75.jpg
                 * large : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360083887.75.jpg
                 * medium : https://img3.doubanio.com/view/celebrity/s_ratio_celebrity/public/p1360083887.75.jpg
                 */

                private String small;
                private String large;
                private String medium;

                public String getSmall() {
                    return small;
                }

                public void setSmall(String small) {
                    this.small = small;
                }

                public String getLarge() {
                    return large;
                }

                public void setLarge(String large) {
                    this.large = large;
                }

                public String getMedium() {
                    return medium;
                }

                public void setMedium(String medium) {
                    this.medium = medium;
                }
            }
        }
    }
}
