package com.yannicl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.locks.LockRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.locks.Lock;

@RestController
public class UserController {

    @Autowired
    LockRegistry lockRegistry;

    @GetMapping("api/hello")
    public String getHello() {

        Lock lock = lockRegistry.obtain("user-registry-lock");
        lock.lock();
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

        return "Hello You!";
    }

}
