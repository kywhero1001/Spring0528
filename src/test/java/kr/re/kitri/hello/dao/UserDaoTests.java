package kr.re.kitri.hello.dao;

import kr.re.kitri.hello.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class UserDaoTests {

    @Autowired
    private UserDao userDao;

    @Test
    public void testInsertUser(){
        User user = new User("kim", "amugae", 30);
        userDao.insertUser(user); // 사용자 데이터 INSERT가 이뤄지는지 확인
    }
    @Test
    public void testSelectAllUsers(){
        List<User> users = userDao.selectAllUsers();
        Assertions.assertTrue(users.size() > 0); // Assertion은 결과값이 해당 값임을 보장한다는 내용임 assertTrue -> 무조건참
        // 조회 결과가 0개보다 크면 성공으로 설정
    }
    @Test
    public void testSelectUserByUserId(){
        String userId = "kang";
        User user = userDao.selectUserByUserId(userId);
        Assertions.assertEquals("yoo", user.getName());
    }
}
