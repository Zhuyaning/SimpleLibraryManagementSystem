package com.zhu.bms.mapper.impl;

import com.zhu.bms.domain.Book;
import com.zhu.bms.queryobject.QueryBookObject;
import com.zhu.bms.mapper.BookMapper;
import com.zhu.bms.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/19
 *   Time: 15:51
 */

public class BookMapperImpl implements BookMapper {

        @Override
        public void save(Book book) {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookMapper.save(book);
            sqlSession.commit();
        }

        @Override
        public void delete(Long id) {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookMapper.delete(id);
            sqlSession.commit();
        }

        @Override
        public void update(Book book) {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            bookMapper.update(book);
            sqlSession.commit();
        }

        @Override
        public Book queryById(Long id) {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            Book book = bookMapper.queryById(id);
            return book;
        }

        @Override
        public List<Book> queryAllBook() {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            List<Book> bookList = bookMapper.queryAllBook();
            return bookList;
        }

        @Override
        public List<Book> queryByKeyWords(QueryBookObject queryBookObject) {
            SqlSession sqlSession = MybatisUtil.getSqlSession();
            BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
            List<Book> bookList = bookMapper.queryByKeyWords(queryBookObject);
            return bookList;
        }

    @Override
    public Integer queryCount(QueryBookObject queryBookObject) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        Integer integer = bookMapper.queryCount(queryBookObject);
        return integer;
    }
}
