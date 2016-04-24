package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.hibernate.model.Student;

public class HibernateTest {

    @Test
    public void testStudent() {
        // 实例化对象，添加数据
        Student student = new Student();
        student.setAge(21);
        student.setName("JensenWang");
        
        // 加载配置文件
        Configuration config = new Configuration();
        config.configure();
        // 获取SessionFactory
        SessionFactory sf = config.buildSessionFactory();
        // 获取session对象
        Session session = sf.openSession();
        // 开启事务
        Transaction ts = session.beginTransaction();
        // 保存
        session.save(student);
        // 提交事务
        ts.commit();
        // 关闭
        session.close();
        sf.close();
    }

}