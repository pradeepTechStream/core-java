package com.logger.example;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CommandingClass {

    static Logger logger = Logger.getLogger(CommandingClass.class.getName());

    public static void main(String[] args) {
        final ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        final HelloWorld obj = (HelloWorld) context.getBean("helloWorld");
        obj.getMessage();

        CommandingClass.logger.debug("This is debug message");
        CommandingClass.logger.info("This is info message");
        CommandingClass.logger.warn("This is warn message");
        CommandingClass.logger.fatal("This is fatal message");
        CommandingClass.logger.error("This is error message");

    }

}
