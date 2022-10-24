package com.example.task.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Clan {
    private long id;
    private String name;
    private int gold;
}
