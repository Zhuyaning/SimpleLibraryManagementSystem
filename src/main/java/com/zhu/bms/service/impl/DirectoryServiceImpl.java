package com.zhu.bms.service.impl;

import com.zhu.bms.domain.Book;
import com.zhu.bms.domain.Directory;
import com.zhu.bms.mapper.DirectoryMapper;
import com.zhu.bms.mapper.impl.DirectoryMapperImpl;
import com.zhu.bms.queryobject.QueryDirectoryObject;
import com.zhu.bms.result.ResultObject;
import com.zhu.bms.service.DirectoryService;

import java.util.List;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/19
 *   Time: 17:11
 */

public class DirectoryServiceImpl implements DirectoryService {

    DirectoryMapper directoryMapper = new DirectoryMapperImpl();

    @Override
    public void save(Directory directory) {
        directoryMapper.save(directory);
    }

    @Override
    public void delete(Long id) {
        directoryMapper.delete(id);
    }

    @Override
    public void update(Directory directory) {
        directoryMapper.update(directory);
    }

    @Override
    public Directory queryById(Long id) {
      return directoryMapper.queryById(id);
    }

    @Override
    public List<Directory> queryAll() {
        return directoryMapper.queryAll();
    }

    @Override
    public ResultObject queryByKeyWords(QueryDirectoryObject queryDirectoryObject) {

        ResultObject resultObject = new ResultObject();

        Integer totalCount = directoryMapper.queryCount(queryDirectoryObject);//查询总条数数

        if (totalCount == 0){//如果查询出总条数为0，那么直接返回空的结果。
            return resultObject;
        }else{
            List<Directory> bookList = directoryMapper.queryByKeyWords(queryDirectoryObject);//查询数据

            resultObject.setResultDate(bookList);//书籍数据

            resultObject.setTotalCount(totalCount);//设置总数据条数

            resultObject.setPageSize(queryDirectoryObject.getPageSize());//设置页面每页显示条数

            resultObject.setCurrentPage(queryDirectoryObject.getCurrentPage());//设置当前页

            return resultObject;//有结果的返回。
        }
    }
}
