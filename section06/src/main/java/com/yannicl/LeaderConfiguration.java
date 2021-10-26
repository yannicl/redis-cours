package com.yannicl;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.leader.Candidate;
import org.springframework.integration.leader.DefaultCandidate;
import org.springframework.integration.support.leader.LockRegistryLeaderInitiator;
import org.springframework.integration.support.locks.LockRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.UUID;

@Configuration
@EnableScheduling
public class LeaderConfiguration {

    @Bean
    public Candidate createCandidate() {
        return new DefaultCandidate(UUID.randomUUID().toString(), "cluster-leader");
    }

    @Bean
    public LockRegistryLeaderInitiator createLockRegistryLeaderInitiator(LockRegistry lockRegistry, Candidate candidate) {
        return new LockRegistryLeaderInitiator(lockRegistry, candidate);
    }


}
