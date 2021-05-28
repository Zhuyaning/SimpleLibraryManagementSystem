package com.zhu.bms.service.impl;

import com.zhu.bms.domain.Book;
import com.zhu.bms.mapper.BookMapper;
import com.zhu.bms.mapper.impl.BookMapperImpl;
import com.zhu.bms.queryobject.QueryBookObject;
import com.zhu.bms.result.ResultObject;
import com.zhu.bms.service.BookService;

import java.util.List;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/19
 *   Time: 17:08
 */

public class BookServiceImpl implements BookService {

    BookMapper bookMapper = new BookMapperImpl();

    @Override
    public void save(Book book) {
        bookMapper.save(book);
    }

    @Override
    public void delete(Long id) {
        bookMapper.delete(id);
    }

    @Override
    public void update(Book book) {
        bookMapper.update(book);
    }

    @Override
    public Book queryById(Long id) {
        return bookMapper.queryById(id);
    }

    @Override
    public List<Book> queryAllBook() {
        return bookMapper.queryAllBook();
    }

    @Override
    public ResultObject queryByKeyWords(QueryBookObject queryBookObject) {

        ResultObject resultObject = new ResultObject();

        Integer totalCount = bookMapper.queryCount(queryBookObject);//查询总条数数

        if (totalCount == 0) {//如果查询出总条数为0，那么直接返回空的结果。
            return resultObject;
        } else {

            List<Book> bookList = bookMapper.queryByKeyWords(queryBookObject);//查询数据

            resultObject.setResultDate(bookList);//书籍数据

            resultObject.setTotalCount(totalCount);//设置总数据条数

            resultObject.setPageSize(queryBookObject.getPageSize());//设置页面每页显示条数

            resultObject.setCurrentPage(queryBookObject.getCurrentPage());//设置当前页

            return resultObject;//有结果的返回。
        }
    }
}
