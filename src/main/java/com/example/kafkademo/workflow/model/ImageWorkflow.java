package com.example.kafkademo.workflow.model;

import com.example.kafkademo.constants.WorkflowConstants;

import java.util.ArrayList;
import java.util.LinkedList;

public class ImageWorkflow implements Workflow{

    private ImageWorkflow workflow;
    private LinkedList<String> states = new LinkedList<String>();

    @Override
    public void init() {
         workflow = new ImageWorkflow();

        states.addAll(new ArrayList<String>() {{
            add(WorkflowConstants.MESSAGE_READ);
            add(WorkflowConstants.MESSAGE_VALIDATED);
            add(WorkflowConstants.MESSAGE_PREPARED);
            add(WorkflowConstants.API_CALL_MADE);
            add(WorkflowConstants.API_RESPONSE_TRANSFORMED);
            add(WorkflowConstants.MESSAGE_PUBLISHED);
        }});

        workflow.setState(State.builder()
                .stateName(WorkflowConstants.MESSAGE_READ)
                .stateStatus(true).stateData(new Object())
                .build());
    }

    @Override
    public void setState(State state) {
        this.workflow.setState(state);
    }

    @Override
    public State promoteState() {
        State currentState = this.workflow.getState();
        if(!currentState.getStateName().equalsIgnoreCase(WorkflowConstants.MESSAGE_PUBLISHED)){
            String nextStateName = states.get(states.indexOf(currentState) + 1);
            currentState = State.builder().stateName(nextStateName).stateStatus(false).stateData(new Object()).build();
        }
        return currentState;
    }

    @Override
    public Object getStateData() {
        return this.workflow.getStateData();
    }

    @Override
    public State getState() {
        return this.workflow.getState();
    }

    @Override
    public void setStateData(Object object) {
        this.workflow.setStateData(object);
    }

    @Override
    public void setStateStatus(Boolean stateStatus) {
        this.workflow.setStateStatus(stateStatus);
    }
}
