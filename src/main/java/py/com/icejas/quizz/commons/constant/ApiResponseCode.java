package py.com.icejas.quizz.commons.constant;

public enum ApiResponseCode {
    USER_NOT_FOUND ("db100"),
    BAD_REQUEST_DATA("rq100"),
    LOGIN_FAILED("db101"),
    LOGIN_SUCCESFULLY("a100"),
    UNEXPECTED_ERROR("500");

    private String code;
    ApiResponseCode(String code) {
        this.code = code;

    }
    public String getCode(){
        return this.code;
    }
}
