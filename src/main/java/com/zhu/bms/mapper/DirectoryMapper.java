package com.zhu.bms.mapper;

import com.zhu.bms.domain.Directory;
import com.zhu.bms.queryobject.QueryBookObject;
import com.zhu.bms.queryobject.QueryDirectoryObject;
import com.zhu.bms.result.ResultObject;

import java.util.List;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/19
 *   Time: 15:08
 */

public interface DirectoryMapper {
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
     *根据关键词查询书籍类别
     * @return 图书类别对象List
     */
     List<Directory> queryByKeyWords(QueryDirectoryObject queryDirectoryObject);

    /***
     * 查询总条数
     * @param queryDirectoryObject
     * @return 对应书籍类别总条数
     */
     Integer queryCount(QueryDirectoryObject queryDirectoryObject);

    /***
     * 查询所有类别
     * @return
     */
     List<Directory> queryAll();
}
