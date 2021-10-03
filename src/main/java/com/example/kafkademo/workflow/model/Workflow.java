package com.example.kafkademo.workflow.model;

public interface Workflow {
    void init();
    void setState(State state);
    State promoteState();
    Object getStateData();
    State getState();
    void setStateData(Object object);
    void setStateStatus(Boolean stateStatus);

}
