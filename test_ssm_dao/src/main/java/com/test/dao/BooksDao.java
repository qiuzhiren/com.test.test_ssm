package com.test.dao;

import com.test.domain.Books;
import com.test.domain.BooksSetting;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface BooksDao {
    @Select("select * from books")
    List<Books> findAll() throws Exception;

    @Select("select * from books where id=#{booksId}")
    Books findById(Integer booksId) throws Exception;
//(`name`,`author`,`press`,`press_time`,`category`,`reserve_num`,`price`,`ISBN`,`desc`)
    @Insert("insert into books(`name`,`author`,`press`,`press_time`,`category`,`reserve_num`,`price`,`ISBN`,`desc`) values(#{name},#{author},#{press},#{press_time},#{category},#{reserve_num},#{price},#{ISBN},#{desc})")
    void addBooks(Books books) throws Exception;

    @Insert("insert into books(`name`,`author`,`press`,`press_time`,`category`,`reserve_num`,`price`,`ISBN`,`desc`) values(#{name},#{author},#{press},#{press_time},#{category},#{reserve_num},#{price},#{ISBN},#{desc})")
    void addBooksSetting (BooksSetting booksSetting) throws Exception;

    @Update("update books set `name`=#{name},`author`=#{author},`press`=#{press},`press_time`=#{press_time},`category`=#{category},`reserve_num`=#{reserve_num},`price`=#{price},`ISBN`=#{ISBN},`desc`=#{desc}  where id =#{id}")
    void updateBooks(Books books)throws Exception;

    @Delete("delete from books where id=#{id}")
    void deleteBooks(Integer booksId)throws Exception;

    @Update("update books set `reserve_num` =#{reserve_num} where id =#{booksId} " )
    void borrowBooks(@Param("booksId")Integer booksId,@Param("reserve_num")Integer reserve_num)throws Exception;



}
