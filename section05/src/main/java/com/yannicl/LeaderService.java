package com.yannicl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.leader.LockRegistryLeaderInitiator;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class LeaderService {

    @Autowired
    LockRegistryLeaderInitiator lockRegistryLeaderInitiator;


    public boolean isLeader() {
        return lockRegistryLeaderInitiator.getContext().isLeader();
    }

    @Scheduled(fixedDelay = 10000L)
    public void performLeaderJob() {
        if (isLeader()) {
            System.out.println("I'm performing the leader job ;) !");
        } else {
            System.out.println("No leadership job for me ;( !");
        }
    }

}
