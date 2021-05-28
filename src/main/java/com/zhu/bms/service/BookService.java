package com.zhu.bms.service;

import com.zhu.bms.domain.Book;
import com.zhu.bms.queryobject.QueryBookObject;
import com.zhu.bms.result.ResultObject;

import java.util.List;

/***
 *   Created by IntelliJ IDEA.
 *   User: ZhuYaning
 *   Date: 2021/4/19
 *   Time: 17:06
 */

public interface BookService {

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
     * @return 书的对象
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
    ResultObject queryByKeyWords(QueryBookObject queryBookObject);

}
