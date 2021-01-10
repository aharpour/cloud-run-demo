package com.aharpour.cloud.run.demo.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Service
@Getter
public class InstanceIdService {

    private final int id;

    public InstanceIdService() {
        id = ThreadLocalRandom.current().nextInt();
    }
}
