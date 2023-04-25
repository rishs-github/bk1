/* 
 * HPBSC, Hewlett-Packard (Schweiz) GmbH, Copyright (c) 2017
 * created 23.03.2017 by franczat
 */
package com.hp.bsc.testing.jmssender;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestConncurent
{

    public static void main(String[] args) throws InterruptedException
    {
        int threadPool = 50;
        ExecutorService executorService = Executors.newFixedThreadPool(threadPool);

        for (int i = 0; i < threadPool; i++)
        {
            executorService.submit(new Runnable()
            {
                public void run()
                {
                    try
                    {
                        SenderClient.main(new String[]{"STATUS", "LOCAL", "test.xml"});
                    }
                    catch (Exception e)
                    {
                        throw new RuntimeException(e);
                    }

                }
            });
        }

        executorService.awaitTermination(1, TimeUnit.MINUTES);

    }

}
