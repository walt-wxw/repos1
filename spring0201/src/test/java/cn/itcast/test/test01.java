package cn.itcast.test;

import cn.itcast.config.Config;
import cn.itcast.config.ConfingA;
import cn.itcast.config.ConfingB;
import cn.itcast.domain.Book;
import cn.itcast.service.BookService;
import cn.itcast.service.impl.BookServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = Config.class)
public class test01 {
    @Resource(name="bookServiceImpl")
    private BookService bs;
    @Test
    public void test(){
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        //AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
        //BookServiceImpl bs = ac.getBean("bookServiceImpl1", BookServiceImpl.class);
        //
        //Book book = bs.findById(8);
        //System.out.println(book.getBookname());
        //bs.update(29,222.2);


        BookService bs = ac.getBean("bookServiceImpl1", BookService.class);
        bs.trans();
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        BookServiceImpl bs = ac.getBean("bookServiceImpl1", BookServiceImpl.class);
        bs.trans();
    }

}
