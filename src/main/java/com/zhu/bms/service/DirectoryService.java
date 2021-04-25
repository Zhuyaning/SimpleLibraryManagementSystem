package com.zhu.bms.service;

import com.zhu.bms.domain.Directory;
import com.zhu.bms.queryobject.QueryDirectoryObject;
import com.zhu.bms.result.ResultObject;

import java.util.List;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/19
 *   Time: 17:07
 */

public interface DirectoryService {

    /***
     * 保存一个图书类别
     * @param directory
     */
    void save(Directory directory);

    /***
     * 根据id删除图书类别
     * @param id
     */
    void delete(Long id);

    /***
     * 修改一个图书类别
     * @param directory
     */
    void update(Directory directory);

    /***
     * 根据id查询图书类
     * @param id
     * @return 图书类别对象
     */
    Directory queryById(Long id);

    /***
     *查询所有
     * @return 图书类别对象List
     */
    List<Directory> queryAll();

    /***
     * 根据关键词查询
     * @param queryDirectoryObject
     * @return 图书类别对象List
     */
    ResultObject queryByKeyWords(QueryDirectoryObject queryDirectoryObject);

}
