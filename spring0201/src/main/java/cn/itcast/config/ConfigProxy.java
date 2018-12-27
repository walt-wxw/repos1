package cn.itcast.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.SQLException;
@Component
@Aspect
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ConfigProxy {
    ///*private Connection connection;
    //public void setConnection(Connection connection) {
    //    this.connection = connection;
    //}*/

/*


    public void before(){
        System.out.println("before");
    }
    public void after(){
        try {
            System.out.println("after");

            //connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void thowing(){
        try {
            System.out.println("thowing");
            connection.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void end(){
        try {
            System.out.println("end");

            connection.commit();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

*/




    @Autowired
    Connection connection;
 /*   //切入点表达式
    @Pointcut("execution(* cn.itcast.service.impl.BookServiceImpl.*(..))")
    public void demo(){}*/
    //表达式调用
    @Around("execution(* cn.itcast.service.impl.*.*(..))")
    public Object get(ProceedingJoinPoint pjp) throws SQLException{

        Object proced = null;
        try {
            System.out.println("a");
            proced = pjp.proceed(pjp.getArgs());
            System.out.println("a1");
            connection.commit();
        } catch (Throwable throwable) {
            System.out.println("b");
            throwable.printStackTrace();
            connection.rollback();
        } finally {
            System.out.println("c");
            connection.close();
        }
        return proced;
    }


}
