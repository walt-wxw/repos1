package cn.itcast.service.impl;

import cn.itcast.dao.BookDao;
import cn.itcast.domain.Book;
import cn.itcast.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookServiceImpl implements BookService {

    //@Autowired
    //@Qualifier("bookDaoImpl")
    //以上两个注解(@Autowired,@Qualifier)与下面的@Resource的注解实现的功能是一样的,
    //都是自动注入,并指定注入对象
    //@Resource(name="bookDaoImpl")
    //private BookDao bookDao;

    //第二种方法 set注入
    private BookDao bookDao;
    public void setBookDao(BookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public Book findById(int id) {
        return bookDao.findById(id);
    }

    @Override
    public void update(int id, double price) {
        bookDao.update(id,price);
    }

    @Override
    public void trans() {
        System.out.println(1);
        Book book1 = bookDao.findById(1);
        Book book2 = bookDao.findById(2);
        bookDao.update(book1.getId(),book1.getPrice() - 1);
        //int i = 1/0;
        bookDao.update(book2.getId(),book2.getPrice() + 1);
        System.out.println(2);
    }
}
