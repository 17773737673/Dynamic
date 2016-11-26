package recycle.com.example.nandy.dynamicdemo.domain.model;


import recycle.com.example.nandy.dynamicdemo.domain.interactor.UseCase;

/**
 * Created by nandy on 16/11/25.
 */
public class ResultModel<ResultModel> implements UseCase.ResponseValues {

    private static final int RESPONSE_CODE_SUCCESS = 200;

    private int responseCode;

    private String responseMessage;

    private ResultModel result;

    public int getExpire_time() {
        return expire_time;
    }

    public void setExpire_time(int expire_time) {
        this.expire_time = expire_time;
    }

    private int expire_time;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public ResultModel getResult() {
        return result;
    }

    public void setResult(ResultModel result) {
        this.result = result;
    }

    public boolean isSuccess() {
        return responseCode == RESPONSE_CODE_SUCCESS;
    }

}
