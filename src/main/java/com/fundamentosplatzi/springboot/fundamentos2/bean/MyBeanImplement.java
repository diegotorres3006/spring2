package com.fundamentosplatzi.springboot.fundamentos2.bean;

public class MyBeanImplement implements  MyBean{
    @Override
    public void print() {
        System.out.println("Hola desde mi implementación propia del been");
    }
}
