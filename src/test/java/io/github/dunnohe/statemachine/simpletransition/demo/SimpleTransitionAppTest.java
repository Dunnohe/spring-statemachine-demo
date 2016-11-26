package io.github.dunnohe.statemachine.simpletransition.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * Created by lianghe on 16/11/26.
 * test code
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:/spring/applicationContext.xml"})
public class SimpleTransitionAppTest extends AbstractJUnit4SpringContextTests  {

    @Autowired
    private SimpleTransitionApp simpleTransitionApp;

    @Test
    public void testEdit() throws Exception {
        simpleTransitionApp.edit(1, "aaa");
        System.err.println("success!");
    }
}