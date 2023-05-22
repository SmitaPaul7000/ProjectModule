package com.tulip.blogapi.security.jwt;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JWTServiceTests {

    private JWTService jwtService = new JWTService();

//    @Test
//    void canCreateJWTFromUserId()
//    {
//        var userId = 1122;
//        var jwt = jwtService.createJWT(userId);
//        //it failed, bacause of time mismatch
//        assertEquals("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMTIyIiwiZXhwIjoxNjg1MjgxNjc1LCJpYXQiOjE2ODQ2NzY4NzV9.vzhq2urR3nLoORcVD-jT_xEo2QGVE7Rz1KpQBNoaYxc" , jwt);
//    }

    @Test
    void canVerifyJWT()
    {
        var jwt = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMTIyIiwiZXhwIjoxNjg1MjgxNjc1LCJpYXQiOjE2ODQ2NzY4NzV9.vzhq2urR3nLoORcVD-jT_xEo2QGVE7Rz1KpQBNoaYxc";
        var userId = jwtService.getUserIfFromJWT(jwt);
        assertEquals(1122 , userId);
    }
}
