package py.com.icejas.quizz.commons.constant;

public enum UserStatus {
    ACTIVE("S"),
    INACTIVE("N");
    private final String value;
    private UserStatus(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }

}
