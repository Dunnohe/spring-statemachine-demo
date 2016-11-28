package io.github.dunnohe.statemachine.simpletransition.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.StaticListableBeanFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SyncTaskExecutor;
import org.springframework.scheduling.concurrent.ConcurrentTaskScheduler;
import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.listener.StateMachineListenerAdapter;

import java.util.EnumSet;

@Configuration
public class SimpleStateMachineConfiguration {

    @Autowired
    private SimpleTransitionApp simpleTransitionApp;

    @Configuration
    @EnableStateMachine(name = "myStateMachine")
    public static class SimpleEventsStateMachineConfiguration
            extends EnumStateMachineConfigurerAdapter<States, Events> {

        @Override
        public void configure(StateMachineConfigurationConfigurer<States, Events> config)
                throws Exception {
            //todo important to start state machine
            config.withConfiguration().autoStartup(true)
                    /*.beanFactory(new StaticListableBeanFactory())
                    .taskExecutor(new SyncTaskExecutor())
                    .taskScheduler(new ConcurrentTaskScheduler())*/
                    .listener(new StateMachineListenerAdapter<States, Events>());
        }


        @Override
        public void configure(StateMachineStateConfigurer<States, Events> states) throws Exception {
            states.withStates().initial(States.CREATE).states(EnumSet.allOf(States.class));
        }

        @Override
        public void configure(StateMachineTransitionConfigurer<States, Events> transitions) throws Exception {
            /*transitions.withExternal().source(States.CREATE).target(States.UPDATE).event(Events.EDIT).action(new Action<States, Events>() {
                @Override
                public void execute(StateContext<States, Events> context) {
                    System.err.println("param:" + context.getExtendedState().getVariables());
                }
            });*/

            //timer transition
            transitions
                    .withExternal()
                        .source(States.CREATE).target(States.NOTSTART).event(Events.PUBLISH).and()
                    .withExternal()
                        .source(States.NOTSTART).action(new Action<States, Events>() {
                            @Override
                            public void execute(StateContext<States, Events> context) {
                                System.err.println("[code action] exec auto task");
                            }
                        }).timer(1000);
        }
    }
}