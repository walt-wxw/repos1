package cn.itcast.dao;

import cn.itcast.domain.Book;
import org.springframework.stereotype.Repository;


@Repository
public interface BookDao {
    Book findById(int id);
    void update(int id,double price);
}
