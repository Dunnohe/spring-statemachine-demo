package io.github.dunnohe.statemachine.simpletransition.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.util.EnumSet;

@Configuration
public class StateMachineConfiguration {

    @Configuration
    @EnableStateMachine(name = "myStateMachine")
    public static class EventsStateMachineConfiguration
            extends EnumStateMachineConfigurerAdapter<States, Events> {

        @Override
        public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
            states.withStates().initial(States.CREATE).states(EnumSet.allOf(States.class));
        }

        @Override
        public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
            transitions.withExternal().source(States.CREATE).target(States.UPDATE).event(Events.EDIT);
        }
    }
}