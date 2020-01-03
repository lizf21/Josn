package ctci.water.iotconfig.dao;


import ctci.water.iotconfig.model.LoginToken;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@Mapper
public interface LoginTokenDAO {

    String TABLE_NAME =  " login_token ";
    String TABLE_FIELDS = " user_id, token, expired ";
    //String SELECT_FIELDS = " id, " + TABLE_FIELDS;

    @Insert({"insert into", TABLE_NAME, "(",TABLE_FIELDS, ") values (#{user_id}, #{token}, #{expired} )"})
    int addToken(LoginToken token);

    @Select({"select", TABLE_FIELDS," from", TABLE_NAME, " where token = #{token}"})
    LoginToken selectByToken(String token);

    @Select({"select" , TABLE_FIELDS, " from", TABLE_NAME, " where user_id = #{user_id}"})
    LoginToken selectByUserId(int user_id);

    @Update({"update", TABLE_NAME, " set expired = #{expired} where token = #{token}"})
    void updateTokenExpriedTime(@Param("token") String token, @Param("expired") Date expired);

    @Update({"update", TABLE_NAME, " set token = #{token}, expired = #{expired} where user_id = #{user_id}"})
    void updateLoginToken(@Param("user_id") int user_id, @Param("token") String token, @Param("expired") Date expired);
}

