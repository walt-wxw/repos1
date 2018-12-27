package cn.itcast.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class ConfingA {

    @Bean
    public JdbcTemplate getJdbcTemplate(@Qualifier("c3p0") DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }


    @Bean
    public String getStr(){
        String str = "abc";
        return str;
    }
}
