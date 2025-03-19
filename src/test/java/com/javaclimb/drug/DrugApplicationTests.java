package com.javaclimb.drug;

import com.javaclimb.drug.entity.User;
import com.javaclimb.drug.service.Impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DrugApplicationTests {
    @Autowired
    private UserServiceImpl iuserService;



    @Test
    void contextLoads() {
        User user = new User();
        user.setUsername("admin");
        User user1 = iuserService.queryUserByUsername(user);
       if (user1 != null){
           System.out.println("user1 = " + user1.getPassword());
       }
    }

}
