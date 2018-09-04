package com.bw.movie.ui.member.act_follow_cinema.bean;

import java.util.List;

/**
 * @author BySevenGroup_zwj
 * @create 2018/9/1 17:56
 * @Description
 */
public class FollowCinemaBean {
    /**
     * result : [{"address":"东城区滨河路乙1号雍和航星园74-76号楼","followCinema":false,"id":1,"logo":"http://172.17.8.100/images/movie/logo/qcgx.jpg","name":"青春光线电影院"},{"address":"西城区前门大街大栅栏街36号","followCinema":false,"id":2,"logo":"http://172.17.8.100/images/movie/logo/dgl.jpg","name":"大观楼电影院"}]
     * message : 查询成功
     * status : 0000
     */

    private String message;
    private String status;
    private List <ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List <ResultBean> getResult() {
        return result;
    }

    public void setResult(List <ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * address : 东城区滨河路乙1号雍和航星园74-76号楼
         * followCinema : false
         * id : 1
         * logo : http://172.17.8.100/images/movie/logo/qcgx.jpg
         * name : 青春光线电影院
         */

        private String address;
        private boolean followCinema;
        private int id;
        private String logo;
        private String name;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public boolean isFollowCinema() {
            return followCinema;
        }

        public void setFollowCinema(boolean followCinema) {
            this.followCinema = followCinema;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}