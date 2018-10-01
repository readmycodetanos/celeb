package com.readmycodetanos.project_temp_2019.api.result;

import java.util.List;

/**
 * ================================================
 * Date:2018/9/26
 * Description:
 * ================================================
 */
public class ContentBean {

    /**
     * error : false
     * results : [{"_id":"57c83777421aa97cbd81c74d","en_name":"wow","name":"科技资讯","rank":1}]
     */

    private boolean error;
    private List<ResultsBean> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<ResultsBean> getResults() {
        return results;
    }

    public void setResults(List<ResultsBean> results) {
        this.results = results;
    }

    public static class ResultsBean {
        /**
         * _id : 57c83777421aa97cbd81c74d
         * en_name : wow
         * name : 科技资讯
         * rank : 1
         */

        private String _id;
        private String en_name;
        private String name;
        private int rank;

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public String getEn_name() {
            return en_name;
        }

        public void setEn_name(String en_name) {
            this.en_name = en_name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }
    }
}
