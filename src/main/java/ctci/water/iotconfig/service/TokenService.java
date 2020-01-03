package ctci.water.iotconfig.service;

import ctci.water.iotconfig.dao.LoginTokenDAO;
import ctci.water.iotconfig.model.LoginToken;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class TokenService {

    @Autowired
    LoginTokenDAO lTokenDAO;
    public static Logger logger = LoggerFactory.getLogger(TokenService.class);

    public boolean checkTokenExprie(String token){
        Date nowDate = new Date();
        LoginToken logintoken = new LoginToken();
        logintoken= lTokenDAO.selectByToken(token);
        if(logintoken==null){
            return false;
        }
        Date expireData=logintoken.getExpired();
        if(nowDate.compareTo(expireData)>=0){
            logger.info("the token is expried");
            return false;
        }else{
            logger.info("the token is normal");
            return true;
        }
    }

    public void updateTokenExpriedTime(String token){
        Date nowDate = new Date();
        nowDate.setTime(30*60*1000+nowDate.getTime());
        lTokenDAO.updateTokenExpriedTime(token,nowDate);
    }
}