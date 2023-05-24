package py.com.icejas.quizz.commons.bean;

import java.sql.Timestamp;

public class AccessToken {
    private String value;
    private Timestamp expiration;

    public AccessToken() {
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Timestamp getExpiration() {
        return expiration;
    }

    public void setExpiration(Timestamp expires) {
        this.expiration = expires;
    }
}
