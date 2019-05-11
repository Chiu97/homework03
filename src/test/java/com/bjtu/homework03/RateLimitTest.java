package com.bjtu.homework03;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

import static java.lang.Thread.currentThread;

public class RateLimitTest {
    private final static RateLimiter limiter = RateLimiter.create(0.5);

    public static void main(String[] args)
    {
        ExecutorService service = Executors.newFixedThreadPool(10);
        IntStream.range(0,10).forEach(i ->{
            service.submit(RateLimitTest::testLimiter);
        });
    }
    private static void testLimiter(){
        System.out.println(currentThread() + "waiting " + limiter.acquire());
    }
}
