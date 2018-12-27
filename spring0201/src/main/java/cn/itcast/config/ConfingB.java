package cn.itcast.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import sun.tools.java.ClassPath;

import javax.sql.CommonDataSource;
import javax.sql.DataSource;

public class ConfingB {
    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;
    @Bean("druid")
    public DataSource getDataSource1(){
        try {
            DruidDataSource dds = new DruidDataSource();
            dds.setDriverClassName(driver);
            dds.setUrl(url);
            dds.setUsername(username);
            dds.setPassword(password);
            return dds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Bean("c3p0")
    public DataSource getDataSource2(){
        try {
            ComboPooledDataSource cpds = new ComboPooledDataSource();
            cpds.setDriverClass(driver);
            cpds.setJdbcUrl(url);
            cpds.setUser(username);
            cpds.setPassword(password);
            return cpds;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
