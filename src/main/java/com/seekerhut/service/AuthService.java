package com.seekerhut.service;

import com.seekerhut.mapper.GeneralUserDAO;
import com.seekerhut.model.GeneralUser;
import com.seekerhut.utils.CommonFunctions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.codec.digest.DigestUtils;

import javax.annotation.Resource;
import java.util.Date;

@Service("AuthService")
public class AuthService {
    @Resource
    private GeneralUserDAO generalUserMapper;

    public String captchaGenerator() {
        return "";
    }

    public int registerLv1(String ip, String token, String verifyCode) {
        return 0;
    }

    public int registerLv2(String username, String passhash) {
        String hashSalt = CommonFunctions.generateRandomString(32);
        String passHash2 = DigestUtils.sha256Hex(passhash + hashSalt);
        GeneralUser user = new GeneralUser();
        user.setIsDeleted(false);
        user.setCreateTime(new Date());
        user.setName(username);
        user.setPasshash(passHash2);
        user.setSalt(hashSalt);
        user.setAdminState(0);
        user.setExpireTime(new Date());
        user.setExp(0);
        user.setGold(100);
        user.setLastLoginTime(new Date());
        generalUserMapper.insertSelective(user);
        return 0;
    }

    public int login(String username, String passhash, String ip) {
        GeneralUser user = generalUserMapper.getUserByName(username);
        if (user == null) {
            return -1;
        }
        String storedPassHash = user.getPasshash();
        String salt = user.getSalt();
        if (DigestUtils.sha256Hex(passhash + salt).equals(storedPassHash)) {
            return 0;
        } else {
            return -1;
        }
    }
}
