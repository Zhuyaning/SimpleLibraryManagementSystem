package com.zhu.bms.mapper.impl;

import com.zhu.bms.domain.Directory;
import com.zhu.bms.mapper.DirectoryMapper;
import com.zhu.bms.queryobject.QueryDirectoryObject;
import com.zhu.bms.utils.MybatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/19
 *   Time: 16:03
 */

public class DirectoryMapperImpl implements DirectoryMapper {

    @Override
    public void save(Directory directory) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DirectoryMapper directoryMapper = sqlSession.getMapper(DirectoryMapper.class);
        directoryMapper.save(directory);
        sqlSession.commit();

    }

    @Override
    public void delete(Long id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DirectoryMapper directoryMapper = sqlSession.getMapper(DirectoryMapper.class);
        directoryMapper.delete(id);
        sqlSession.commit();

    }

    @Override
    public void update(Directory directory) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DirectoryMapper directoryMapper = sqlSession.getMapper(DirectoryMapper.class);
        directoryMapper.update(directory);
        sqlSession.commit();

    }

    @Override
    public Directory queryById(Long id) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DirectoryMapper directoryMapper = sqlSession.getMapper(DirectoryMapper.class);
        Directory directory = directoryMapper.queryById(id);

        return directory;
    }

    @Override
    public List<Directory> queryByKeyWords(QueryDirectoryObject queryDirectoryObject) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DirectoryMapper directoryMapper = sqlSession.getMapper(DirectoryMapper.class);
        List<Directory> directoryList = directoryMapper.queryByKeyWords(queryDirectoryObject);
        return directoryList;
    }

    @Override
    public Integer queryCount(QueryDirectoryObject queryDirectoryObject) {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DirectoryMapper directoryMapper = sqlSession.getMapper(DirectoryMapper.class);
        Integer count = directoryMapper.queryCount(queryDirectoryObject);
        return count;
    }

    @Override
    public List<Directory> queryAll() {
        SqlSession sqlSession = MybatisUtil.getSqlSession();
        DirectoryMapper directoryMapper = sqlSession.getMapper(DirectoryMapper.class);
        List<Directory> directoryList = directoryMapper.queryAll();
        return directoryList;
    }
}
