package io.github.dunnohe.statemachine.simpletransition.demo;

import org.springframework.messaging.Message;
import org.springframework.statemachine.ExtendedState;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.annotation.EventHeaders;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;

import java.util.Map;

/**
 * Created by lianghe on 16/11/26.
 * action handler
 */
@WithStateMachine(name = "myStateMachine")
public class ActionHandler {

    @OnTransition(source = { "CREATE" }, target = { "UPDATE" })
    public void editAction(@EventHeaders Map<String, Object> headers,
                           ExtendedState extendedState,
                           StateMachine<String, String> stateMachine,
                           Message<String> message,
                           Exception e) {

        System.err.println("receive :" + headers);
        System.err.println("receive :" + extendedState);
        System.err.println("receive :" + stateMachine);
        System.err.println("receive :" + message);
    }
}
