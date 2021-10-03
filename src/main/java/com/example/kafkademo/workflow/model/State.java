package com.example.kafkademo.workflow.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class State {
    private String stateName;
    private boolean stateStatus;
    private Object stateData;
}
