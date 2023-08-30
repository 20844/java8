package com.py._13并行流与串行流;

import java.util.concurrent.RecursiveTask;

public class ForkJoinCalc extends RecursiveTask<Long> {
    private long start;
    private long end;

    public ForkJoinCalc(long start, long end) {
        this.start = start;
        this.end = end;
    }

    private static final long THRESHOLD = 10000;
    @Override
    protected Long compute() {
        long length = end - start;
        if (length <= THRESHOLD){
            long sum = 0;
            for (long i = start; i <= end; i++) {
                sum+=i;
            }
            return sum;
        }else {
            long middle = (start + end) / 2;
            ForkJoinCalc left = new ForkJoinCalc(start, middle);
            left.fork();//拆分子任务，同时压入线程队列

            ForkJoinCalc right = new ForkJoinCalc(middle+1, end);
            right.fork();//拆分子任务，同时压入线程队列

            return left.join()+right.join();

        }
    }

}
