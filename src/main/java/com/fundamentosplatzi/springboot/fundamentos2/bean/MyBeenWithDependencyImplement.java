package com.fundamentosplatzi.springboot.fundamentos2.bean;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class MyBeenWithDependencyImplement implements MyBeenWithDependency {
    private final Log LOGGER = LogFactory.getLog(MyBeenWithDependencyImplement.class);
    private MyOperation myOperation;

    public MyBeenWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        LOGGER.info("Ingreso al método printWithDependency");
        int numero =1;
        LOGGER.debug("El número enviado como parametro a la dependencia operation es:"+numero);
        System.out.println(myOperation.sum(numero));
        System.out.println("Hola desde la implementación de un been con dependencia");
    }
}
