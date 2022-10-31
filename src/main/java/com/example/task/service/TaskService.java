package com.example.task.service;

import com.example.task.TaskIds;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class TaskService {

    @Autowired
    @Qualifier("clanServiceImpl")
    private final ClanService clanService;

    void completeTask(long taskId, long userId, long clanId, int gold) {
        if (taskId == TaskIds.addGoldId) {
            clanService.addGoldToClan(userId, clanId, gold);
        }
    }


}
