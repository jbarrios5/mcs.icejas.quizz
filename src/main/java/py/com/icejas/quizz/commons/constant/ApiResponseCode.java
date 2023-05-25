package py.com.icejas.quizz.commons.constant;

public enum ApiResponseCode {
    USER_NOT_FOUND ("db100"),
    USER_INVALIDED("db101"),
    LOGIN_FAILED("db102"),
    SESSION_ERROR("db103"),
    BAD_REQUEST_DATA("rq100"),
    SESSION_EXPIRES("db104"),
    UNEXPECTED_ERROR("500");



    private String code;
    ApiResponseCode(String code) {
        this.code = code;

    }
    public String getCode(){
        return this.code;
    }
}
