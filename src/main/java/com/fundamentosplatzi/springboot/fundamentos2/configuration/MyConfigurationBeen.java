package com.fundamentosplatzi.springboot.fundamentos2.configuration;

import com.fundamentosplatzi.springboot.fundamentos2.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBeen {
    @Bean
    public MyBean beanOperation(){
        return new MyBean2Implement();
    }
    @Bean
    public MyOperation beanOperationOperation(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeenWithDependency beanOperationOperationWithDependency(MyOperation myOperation){
        return new MyBeenWithDependencyImplement(myOperation);
    }

    @Bean
    public Been bean2() {return  new BeenImplement();}
}
