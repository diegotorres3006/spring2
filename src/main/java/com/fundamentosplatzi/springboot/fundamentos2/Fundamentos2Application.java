package com.fundamentosplatzi.springboot.fundamentos2;

import com.fundamentosplatzi.springboot.fundamentos2.bean.Been;
import com.fundamentosplatzi.springboot.fundamentos2.bean.MyBean;
import com.fundamentosplatzi.springboot.fundamentos2.bean.MyBeanWithProperties;
import com.fundamentosplatzi.springboot.fundamentos2.bean.MyBeenWithDependency;
import com.fundamentosplatzi.springboot.fundamentos2.component.ComponentDependency;
import com.fundamentosplatzi.springboot.fundamentos2.pojo.UserPojo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Fundamentos2Application implements CommandLineRunner {

    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeenWithDependency myBeenWithDependency;

    private Been been;

    private MyBeanWithProperties myBeanWithProperties;

    private UserPojo userPojo;
    private final Log LOGGER = LogFactory.getLog(Fundamentos2Application.class);


    public Fundamentos2Application(@Qualifier("componentTwoImplement") ComponentDependency componentDependency, MyBean myBean, MyBeenWithDependency myBeenWithDependency, Been been, MyBeanWithProperties myBeanWithProperties,UserPojo userPojo){
        this.componentDependency =componentDependency;
        this.myBean = myBean;
        this.myBeenWithDependency = myBeenWithDependency;
        this.been= been;
        this.myBeanWithProperties=myBeanWithProperties;
        this.userPojo=userPojo;
    }
    public static void main(String[] args) {
        SpringApplication.run(Fundamentos2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        componentDependency.saludar();
        myBean.print();
        myBeenWithDependency.printWithDependency();
        been.hola();
        System.out.println(myBeanWithProperties.function());
        System.out.println(userPojo.getEmail()+"-"+userPojo.getPassword()+"-"+userPojo.getAge());

        try{
            int value =10/0;
            LOGGER.debug("Mi valor es " + value);
        }catch (Exception e){
            LOGGER.error("Esto es un error al dividir po cero"+e.getMessage());
        }
    }
}
