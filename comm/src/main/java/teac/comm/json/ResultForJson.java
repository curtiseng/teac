package teac.comm.json;

import java.io.Serializable;

/**
 * 封装请求的返回结果
 * Created by yangzifeng on 2016/11/16.
 */
public class ResultForJson<T> implements Serializable{
    private int resultStatus;
    private String msg;
    private T data;

    public static class Builder<T> {
        private int resultStatus;
        private String msg;
        private T data;

        public Builder data(T data) {
            this.data = data;
            return this;
        }

        public Builder msg(String msg) {
            this.msg = msg;
            return this;
        }

        public Builder resultStatus(int resultStatus) {
            this.resultStatus = resultStatus;
            return this;
        }

        public ResultForJson build(){
            return new ResultForJson(this);
        }
    }

    private ResultForJson(Builder<T> builder){
        resultStatus = builder.resultStatus;
        msg = builder.msg;
        data = builder.data;
    }


    public int getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(int resultStatus) {
        this.resultStatus = resultStatus;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResultForJson{" +
                "resultStatus=" + resultStatus +
                ", msg='" + msg + '\'' +
                ", entity=" + data +
                '}';
    }
}
