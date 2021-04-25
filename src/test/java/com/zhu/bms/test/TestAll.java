package com.zhu.bms.test;

import com.zhu.bms.domain.Directory;
import com.zhu.bms.domain.User;
import com.zhu.bms.mapper.BookMapper;
import com.zhu.bms.mapper.DirectoryMapper;
import com.zhu.bms.mapper.impl.BookMapperImpl;
import com.zhu.bms.mapper.impl.DirectoryMapperImpl;
import com.zhu.bms.queryobject.QueryBookObject;
import com.zhu.bms.queryobject.QueryDirectoryObject;
import com.zhu.bms.result.ResultObject;
import com.zhu.bms.service.BookService;
import com.zhu.bms.service.UserService;
import com.zhu.bms.service.impl.BookServiceImpl;
import com.zhu.bms.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.List;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/19
 *   Time: 16:08
 */

public class TestAll {

    @Test
    public void BookMapperTest(){
      BookMapper bookMapper = new BookMapperImpl();
        QueryBookObject queryBookObject = new QueryBookObject();
        Integer integer = bookMapper.queryCount(queryBookObject);
        System.out.println(integer);
    }
    
    @Test
    public void bookServiceTest(){
        BookService bookService = new BookServiceImpl();
        QueryBookObject queryBookObject = new QueryBookObject();
        queryBookObject.setCurrentPage(3);
        ResultObject resultObject = bookService.queryByKeyWords(queryBookObject);
        System.out.println(resultObject);
    }
    @Test
    public void dirMapperTest(){
        DirectoryMapper directoryMapper = new DirectoryMapperImpl();
        List<Directory> directories = directoryMapper.queryByKeyWords(new QueryDirectoryObject());
        System.out.println(directories);
    }

    @Test
    public void UserServiceTest(){
        UserService userService = new UserServiceImpl();
        User user = new User();
        user.setUsername("朱亚宁");
        user.setPassword("123456");
        String register = userService.register(user);
        System.out.println(register);
    }
}
