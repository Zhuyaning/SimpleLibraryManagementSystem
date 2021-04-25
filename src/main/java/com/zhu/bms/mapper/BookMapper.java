package com.zhu.bms.mapper;

import com.zhu.bms.domain.Book;
import com.zhu.bms.queryobject.QueryBookObject;

import java.util.List;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/19
 *   Time: 11:32
 */

public interface BookMapper {
    /***
     * 保存一本书
     * @param book book对象
     */
    void save(Book book);

    /***
     * 删除一本书
     * @param id
     */
    void delete(Long id);

    /***
     * 修改一本书
     * @param book 新的书对象
     */
    void update(Book book);

    /***
     * 按照书的id查询书籍
     * @param id 书的id
     * @return  书的对象
     */
    Book queryById(Long id);

    /***
     * 查询所有的书
     * @return
     */
    List<Book> queryAllBook();

    /***
     * 关键字查询
     * @param queryBookObject 关键词对象
     * @return 根据关键词查询到的书List
     */
    List<Book> queryByKeyWords(QueryBookObject queryBookObject);

    /***
     * 分页查询功能的查询总数据条数。
     * @return
     */
    Integer queryCount(QueryBookObject queryBookObject);
}
