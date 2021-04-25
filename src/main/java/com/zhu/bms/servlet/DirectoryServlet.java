package com.zhu.bms.servlet;

import com.zhu.bms.domain.Directory;
import com.zhu.bms.queryobject.QueryDirectoryObject;
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

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/20
 *   Time: 16:51
 */

@WebServlet("/directory")
public class DirectoryServlet extends HttpServlet{

    //导入两个service
    DirectoryService directoryService = new DirectoryServiceImpl();
    BookService bookService = new BookServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");

        if ("list".equals(action)){
            list(req,resp);
        }
        else if("delete".equals(action)){
            delete(req,resp);
        }
        else if ("save".equals(action)){
            saveAndUpdate(req,resp);
        }
        else if ("save1".equals(action)){
            saveAndUpdateImpl(req,resp);
        }
    }

    /***
     * 查询关键字并显示类别管理主页面
     * @param req
     * @param resp
     */
    public void list(HttpServletRequest req, HttpServletResponse resp) {

        QueryDirectoryObject queryDirectoryObject = new QueryDirectoryObject();

        String keyWords = req.getParameter("keyWords");
        String pageSize = req.getParameter("pageSize");
        String currentPage = req.getParameter("currentPage");

        System.out.println(keyWords);
        System.out.println(pageSize);
        System.out.println(currentPage);

        if(!"".equals(keyWords) && keyWords != null){
            queryDirectoryObject.setKeyWords(keyWords);
        }
        if(!"".equals(pageSize) && pageSize != null){
            queryDirectoryObject.setPageSize(Integer.valueOf(pageSize));
        }
        if(!"".equals(currentPage) && currentPage != null){
            queryDirectoryObject.setCurrentPage(Integer.valueOf(currentPage));
        }

        System.out.println(queryDirectoryObject);

        ResultObject result = directoryService.queryByKeyWords(queryDirectoryObject);

        if(result.getTotalCount() > 0){
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
        req.setAttribute("qo",queryDirectoryObject);//参数回显

        try {
            req.getRequestDispatcher("/WEB-INF/views/directory.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * 按照id删除一个图书类别
     * @param req
     * @param resp
     */
    public void delete(HttpServletRequest req, HttpServletResponse resp){

        String id = req.getParameter("id");
        if(id != null && id != "" ){
            Long d_id = Long.valueOf(id);
            directoryService.delete(d_id);
        }
        try {
            resp.sendRedirect("/directory?action=list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * 跳转到修改或者新增页面
     * @param req
     * @param resp
     */
    public void saveAndUpdate(HttpServletRequest req, HttpServletResponse resp){

        String id = req.getParameter("id");

        if(id != null && id != ""){//表示修改
            Long u_id = Long.valueOf(id);
            Directory directory = directoryService.queryById(u_id);
            req.setAttribute("directory",directory);
        }
        try {
            req.getRequestDispatcher("/WEB-INF/views/dirlist.jsp").forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /***
     * 执行新增或者修改操作
     * @param req
     * @param resp
     */
    public void saveAndUpdateImpl(HttpServletRequest req, HttpServletResponse resp){
        String id = req.getParameter("id");

        Directory directory = new Directory();

        if (id != null && id != ""){
            directory.setId(Long.valueOf(id));
        }

        directory.setName(req.getParameter("name"));
        directory.setDescribes(req.getParameter("describes"));

        if (id != null && id != ""){//表示为修改
            directoryService.update(directory);
        }else {//表示新增
            directoryService.save(directory);
        }
        try {
            resp.sendRedirect("/directory?action=list");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
