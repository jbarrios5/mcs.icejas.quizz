package py.com.icejas.quizz.auth.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import py.com.icejas.quizz.commons.bean.AccessToken;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;
@Component
public class AccessTokenServiceImpl implements AccessTokenService{
    private static final Logger log = LoggerFactory.getLogger(AccessTokenServiceImpl.class);
    @Override
    public AccessToken createAccessToken() {
        log.info("Creating accessToken...");
        Timestamp timestamp = new Timestamp(new Date().getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp.getTime());

        // add 10 minutes
        cal.add(Calendar.MINUTE, 60);
        timestamp = new Timestamp(cal.getTime().getTime());

        AccessToken accessToken = new AccessToken();
        accessToken.setValue(UUID.randomUUID().toString());
        accessToken.setExpiration(timestamp);

        log.info("accessToken created sucessfully");
        return accessToken;
    }

    @Override
    public Boolean isExpiration() {
        return null;
    }
}
