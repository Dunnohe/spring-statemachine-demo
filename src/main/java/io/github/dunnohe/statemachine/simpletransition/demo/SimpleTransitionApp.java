package io.github.dunnohe.statemachine.simpletransition.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.stereotype.Component;

/**
 * Created by lianghe on 16/11/26.
 * 启动类
 */
@WithStateMachine(name = "myStateMachine")
public class SimpleTransitionApp {

    public enum VarType {
        EDITID, EDITCONTENT
    }

    @Autowired
    StateMachine<States, Events> stateMachine;

    public void edit(int editId, String editContent) {
        stateMachine.getExtendedState().getVariables().put(VarType.EDITID, editId);
        stateMachine.getExtendedState().getVariables().put(VarType.EDITCONTENT, editContent);
        stateMachine.sendEvent(Events.EDIT);
    }
}
