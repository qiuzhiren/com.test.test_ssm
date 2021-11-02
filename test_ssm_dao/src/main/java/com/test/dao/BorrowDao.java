package com.test.dao;


import com.test.domain.Borrow;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import java.util.List;

public interface BorrowDao {

    @Select("select * from borrow_record")
    List<Borrow> findAll() throws Exception;

    @Select("select * from borrow_record where usersName=#{usersName}")
    List<Borrow> findAllByUser(@Param("usersName")String usersName) throws Exception;

    @Insert("insert into borrow_record(`booksId`,`usersName`,`borrowTime`,`returnTime`,`status`) values(#{booksId},#{usersName},#{borrowTime},#{returnTime},#{status})")
    void addBorrow(Borrow borrow) throws Exception;

    @Update("update borrow_record set status=#{status} where booksId=#{booksId} and usersName=#{usersName}")
    void  addReturn(@Param("booksId") Integer booksId, @Param("usersName")String usersName,@Param("status") Integer status)throws Exception;

    @Select("select * from borrow_record where usersName=#{usersName} and  booksId=#{booksId}")
    Borrow findByUserAndBookId(@Param("usersName")String usersName,@Param("booksId") Integer booksId)throws Exception;
}
