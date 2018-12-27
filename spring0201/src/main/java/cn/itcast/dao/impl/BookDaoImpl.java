package cn.itcast.dao.impl;

import cn.itcast.dao.BookDao;
import cn.itcast.domain.Book;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Connection;

@Repository
public class BookDaoImpl implements BookDao{

    //public Query  Runner runner;
    /*@Autowired
    @Qualifier("getJdbcTemplate")
    public JdbcTemplate jdbcTemplate;*/

    public QueryRunner runner;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }
    /*public JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }*/

    private Connection connection;

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Book findById(int id) {
        try {
            return runner.query("select * from book where id = ?",new BeanHandler<>(Book.class),id);
            //return jdbcTemplate.queryForObject("select * from book where id = ?",new BeanPropertyRowMapper<Book>(Book.class),id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void update(int id, double price) {
        try {
            runner.update(connection,"update book set price = ? where id = ?",price,id);
            //jdbcTemplate.update("update book set price = ? where id = ?",price,id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
