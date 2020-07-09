package com.zhangbin.dao;

import com.zhangbin.pojo.User;
import com.zhangbin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * 认认真真敲代码，开开心心每一天
 *
 * @Date 2020/7/9-9:26
 */
public class UserDaoTest {

    @Test
    public void test01(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        List<User> userList = mapper.getUserList();

        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();

    }

    @Test
    public void test02(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapperInteFace mapper = sqlSession.getMapper(UserMapperInteFace.class);
        List<User> user = mapper.getUser();
        for (User user1 : user) {
            System.out.println(user1);
        }


        sqlSession.close();
    }
}
