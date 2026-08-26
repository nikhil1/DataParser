package com.example.datafileparser;


import com.example.datafileparser.presentation.controllers.AppErrorController;
import com.example.datafileparser.presentation.controllers.CSVController;
import com.example.datafileparser.presentation.controllers.HomeController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

public class ControllerTest {

    private HomeController homeController;
    private CSVController csvController;
    private AppErrorController appErrorController;
    private Model model;


    @BeforeEach
    public void setUp(){
        homeController = new HomeController();
        csvController = new CSVController();
        appErrorController = new AppErrorController();
        model = mock(Model.class);
    }

    @Test
    public void testIndexReturnsString() throws IOException {
        Object returnType = homeController.index(model);
        assertSame(returnType.getClass(), String.class);
    }

    @Test
    public void testIndexHasCorrectTemplate() throws IOException {
        String template = homeController.index(model);
        assertEquals("index", template);
    }

    @Test
    public void testIndexHasGetAnnotation(){
        Method [] methods = homeController.getClass().getDeclaredMethods();
        for (Method method : methods) {
            Assertions.assertNotNull(method.getAnnotation(GetMapping.class), method.getName()+": is not annotated with GET mapping");
        }
    }

    @Test
    public void testCSVControllerMethodsReturnStrings(){
        Method[] methods = csvController.getClass().getDeclaredMethods();
        for (Method method : methods) {
            Assertions.assertSame(String.class, method.getReturnType(), method.getName()+": does not return templates");
        }
    }

    @Test
    public void testErrorControllerIsAnErrorController(){
        Assertions.assertTrue(ErrorController.class.isAssignableFrom(appErrorController.getClass()));
    }

    @Test
    public void testErrorControllerReturnsCorrectTemplate(){
        Assertions.assertEquals("error", appErrorController.handleError());
    }

    @Test
    public void testErrorControllerHasCorrectMapping(){
        Assertions.assertNotNull(appErrorController.getClass().getDeclaredMethods()[0].getAnnotation(RequestMapping.class),"Error controller has no mapping");
    }



}
