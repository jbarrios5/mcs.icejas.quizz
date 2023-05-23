package py.com.icejas.quizz.constants;

public enum ApiError {
    USER_NOT_FOUND ("db100"),
    BAD_REQUEST_DATA("rq100"),
    LOGIN_FAILED("db101"),
    UNEXPECTED_ERROR("500");
    private String code;
    ApiError(String code) {
        this.code = code;

    }
    public String getCode(){
        return this.code;
    }
}
