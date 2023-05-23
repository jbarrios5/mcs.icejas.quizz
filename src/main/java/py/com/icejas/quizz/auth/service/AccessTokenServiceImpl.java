package py.com.icejas.quizz.auth.service;

import org.springframework.stereotype.Component;
import py.com.icejas.quizz.commons.AccessToken;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
@Component
public class AccessTokenServiceImpl implements AccessTokenService{
    @Override
    public AccessToken createAccessToken() {
        Timestamp timestamp = new Timestamp(new Date().getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp.getTime());

        // add 10 minutes
        cal.add(Calendar.MINUTE, 10);
        timestamp = new Timestamp(cal.getTime().getTime());

        AccessToken accessToken = new AccessToken();
        accessToken.setValue(UUID.randomUUID().toString());
        accessToken.setExpiration(timestamp);
        return accessToken;
    }

    @Override
    public Boolean isExpiration() {
        return null;
    }
}
