package com.example.mynewslayoutlib.Bean;

/**
 * Created by Administrator on 2017/6/15.
 */

public class NewUpSelfLocToNetBean {

    /**
     * status : 0
     * msg : ok
     * nr : {"dlzt":"1"}
     */

    private String status;
    private String msg;
    private NrBean nr;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public NrBean getNr() {
        return nr;
    }

    public void setNr(NrBean nr) {
        this.nr = nr;
    }

    public static class NrBean {
        /**
         * dlzt : 1
         */

        private String dlzt;

        public String getDlzt() {
            return dlzt;
        }

        public void setDlzt(String dlzt) {
            this.dlzt = dlzt;
        }
    }
}
