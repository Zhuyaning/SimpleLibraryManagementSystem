package com.zhu.bms.servlet;

import com.zhu.bms.domain.Directory;
import com.zhu.bms.domain.User;
import com.zhu.bms.service.UserService;
import com.zhu.bms.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/24
 *   Time: 17:19
 */
@WebServlet("/user")
public class UserServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) {

       String action = req.getParameter("action");

       if ("login".equals(action)){
           myLogin(req,resp);
       }else if ("loginImpl".equals(action)){
           myLoginImpl(req,resp);
       }else if("logout".equals(action)){
           myLogOut(req,resp);
       }else if("query".equals(action)){
           query(req,resp);
       }else if("save".equals(action)){
           save(req,resp);
       }else if("saveImpl".equals(action)){
           saveImpl(req,resp);
       }else if("delete".equals(action)){
           deleteUser(req,resp);
       }
    }

    private void deleteUser(HttpServletRequest req, HttpServletResponse resp) {
        String uid = req.getParameter("uid");
        if(uid != null && uid != ""){
            Long u_id = Long.valueOf(uid);
            UserService userService= new UserServiceImpl();
            userService.deleteUser(u_id);
            try {
                resp.sendRedirect("user?action=query");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void saveImpl(HttpServletRequest req, HttpServletResponse resp) {

        String uid = req.getParameter("uid");

        User user = new User();

        if (uid != null && uid != ""){
            user.setUid(Long.valueOf(uid));
        }

        user.setUsername(req.getParameter("username"));

        user.setPassword(req.getParameter("password"));

        if (uid != null && uid != ""){//表示为修改
            UserService userService = new UserServiceImpl();
            userService.updateUser(user);
        }else {//表示新增
            UserService userService = new UserServiceImpl();
            userService.register(user);
        }
        try {
            resp.sendRedirect("/user?action=query");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void save(HttpServletRequest req, HttpServletResponse resp) {

        String uid = req.getParameter("uid");

        if(uid != null && uid != ""){//表示修改
            Long u_id = Long.valueOf(uid);

            UserService userService= new UserServiceImpl();
            User user = userService.query(u_id);
            req.setAttribute("user",user);
        }
        try {
            req.getRequestDispatcher("/WEB-INF/views/userAdd.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void query(HttpServletRequest req, HttpServletResponse resp) {

        UserService userService= new UserServiceImpl();
        List<User> userList = userService.queryAllUser();
        req.setAttribute("userList",userList);

        try {
            req.getRequestDispatcher("/WEB-INF/views/user.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void myLogOut(HttpServletRequest req, HttpServletResponse resp) {

        req.getSession().removeAttribute("username");
        myLogin(req,resp);
    }

    private void myLogin(HttpServletRequest req, HttpServletResponse resp) {
        try {
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void myLoginImpl(HttpServletRequest req, HttpServletResponse resp) {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        UserService userService = new UserServiceImpl();
        User loginUser = userService.login(user);

        if(loginUser.getPassword().equals(user.getPassword())){
            req.getSession().setAttribute("username",username);
            try {
                resp.sendRedirect("book?action=main");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



}
