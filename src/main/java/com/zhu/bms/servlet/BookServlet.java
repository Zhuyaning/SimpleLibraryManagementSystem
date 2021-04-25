package com.zhu.bms.servlet;


import com.zhu.bms.domain.Book;
import com.zhu.bms.domain.Directory;
import com.zhu.bms.queryobject.QueryBookObject;
import com.zhu.bms.result.ResultObject;
import com.zhu.bms.service.BookService;
import com.zhu.bms.service.DirectoryService;
import com.zhu.bms.service.impl.BookServiceImpl;
import com.zhu.bms.service.impl.DirectoryServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/19
 *   Time: 17:21
 */

@WebServlet("/book")
public class BookServlet extends HttpServlet {

    DirectoryService directoryService = new DirectoryServiceImpl();
    BookService bookService = new BookServiceImpl();
    /***
     * 转发
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if (req.getSession().getAttribute("username") == null){
            req.getRequestDispatcher("user?action=login").forward(req,resp);
        }

        if("delete".equals(action)){
            delete(req,resp);
        }
        else if("query".equals(action)){
            query(req,resp);
        }
        else if ("save".equals(action)){
            saveAndUpdate(req,resp);
        }
        else if ("save1".equals(action)){
            saveAndUpdateImpl(req,resp);
        }else if ("main".equals(action)){
            myMain(req,resp);
        }
    }

    /***
     * 主页的结构部分
     * @param req
     * @param resp
     */
    private void myMain(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Object MyUsername = req.getSession().getAttribute("username");
            req.setAttribute("MyUsername",MyUsername);
            req.getRequestDispatcher("/WEB-INF/views/main.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /***
     * 删除的实现
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Long aLong = Long.valueOf(id);
        bookService.delete(aLong);
        resp.sendRedirect("/book?action=query");
    }

    /***
     * 关键字查询的实现
     * @param req
     * @param resp
     */
    public void query(HttpServletRequest req, HttpServletResponse resp){

        QueryBookObject queryBookObject = new QueryBookObject();

        String pageSize = req.getParameter("pageSize");
        if(pageSize != null && !("".equals(pageSize))){
            queryBookObject.setPageSize(Integer.valueOf(pageSize));
        }

        String currentPage = req.getParameter("currentPage");
        if (currentPage != null && !("".equals(currentPage))){
            queryBookObject.setCurrentPage(Integer.valueOf(currentPage));
        }

        queryBookObject.setBookName(req.getParameter("bookName"));
        queryBookObject.setAuthorName(req.getParameter("authorName"));
        queryBookObject.setDirId(req.getParameter("dirId"));

            ResultObject result = bookService.queryByKeyWords(queryBookObject);
            if(result.getTotalCount() >0 ){
                req.setAttribute("result",result);
            }else {
                try {
                    req.getRequestDispatcher("/WEB-INF/views/error.jsp").forward(req,resp);
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            List<Directory> directories = directoryService.queryAll();
            req.setAttribute("directories",directories);

            req.setAttribute("qo",queryBookObject);//回显

            try {
                req.getRequestDispatcher("/WEB-INF/views/query.jsp").forward(req,resp);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }

    /***
     * 修改和新增的页面跳转
     * @param req
     * @param resp
     */
    public void saveAndUpdate(HttpServletRequest req, HttpServletResponse resp){
        String id = req.getParameter("id");

        if(id != null){    //代表修改操作
            Long id1 = Long.valueOf(id);
            Book bookOne = bookService.queryById(id1);
            req.setAttribute("bookOne",bookOne);
        }

        List<Directory> directories = directoryService.queryAll();
        req.setAttribute("directories",directories);

        try {
            req.getRequestDispatcher("/WEB-INF/views/input.jsp").forward(req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /***
     * 修改和新增的实现
     * @param req
     * @param resp
     */
    public void saveAndUpdateImpl(HttpServletRequest req, HttpServletResponse resp){

        String id = req.getParameter("id");//书的id
        String sn = req.getParameter("sn");//书的缩写
        String name = req.getParameter("name");//书的名字
        String author = req.getParameter("author");//作者
        String price = req.getParameter("price");//书的价格
        String dirId = req.getParameter("dirId");//书的类别的id

        Book book = new Book();

        if (!"".equals(id) && id != null){
            book.setId(Long.valueOf(id));
        }
        if (!"".equals(sn) && sn != null){
            book.setSn(sn);
        }
        if (!"".equals(name) && name != null){
            book.setName(name);
        }
        if (!"".equals(author) && author != null){
            book.setAuthor(author);
        }
        if (!"".equals(price) && price != null){
            BigDecimal big_price = new BigDecimal(price);
            book.setPrice(big_price);
        }
        if (!"".equals(dirId) && dirId != null){
            Directory directory = new Directory();
            directory.setId(Long.valueOf(dirId));
            book.setDirectory(directory);
        }

        if (!"".equals(req.getParameter("id")) &&req.getParameter("id") != null){
            bookService.update(book);
        }else {
            System.out.println(book);
            bookService.save(book);
        }

        try {
            resp.sendRedirect("book?action=query");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
