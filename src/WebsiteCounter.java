import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

public class WebsiteCounter {



    public static class VisitorStatistics {
        private long counter;
        private Map<String, Long> visitorCount = new HashMap<>();

        public synchronized void visit(String name) {
            counter++;
            Long oldCount = visitorCount.getOrDefault(name, 0L);
            long newCount = 1L;
            if (oldCount != null) {
                newCount += oldCount;
            }
            visitorCount.put(name, newCount);
        }

        public long totalVisits() {
            return counter;
        }

        public long visitsBy(String name) {
            return visitorCount.getOrDefault(name, 0L);
        }
    }
}
class VisitorStatisticsTest {

    private WebsiteCounter.VisitorStatistics visitorStatistics;

    @Before
    public void setUp() throws Exception {

        visitorStatistics = new WebsiteCounter.VisitorStatistics();
    }

    @Test
     void shouldIncrementCounterAndTrackUsers() throws Exception {

        visitorStatistics.visit("A");
        visitorStatistics.visit("B");
        visitorStatistics.visit("A");
        Assert.assertEquals("wrong number of total visits", 3, visitorStatistics.totalVisits());
        Assert.assertEquals("wrong number of visits by A", 2, visitorStatistics.visitsBy("A"));
        Assert.assertEquals("wrong number of visits by B", 1, visitorStatistics.visitsBy("B"));
    }

    @Test
    void shouldHandleConcurrentAccess() throws Exception {

        CountDownLatch latch = new CountDownLatch(1);
        Thread[] threads = new Thread[100];
        String name = "Visitor";
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                visitorStatistics.visit(name);
            });
            threads[i].start();
        }
        latch.countDown();
        for (Thread thread : threads) {
            thread.join();
        }
        Assert.assertEquals(threads.length, visitorStatistics.totalVisits());
        Assert.assertEquals(threads.length, visitorStatistics.visitsBy(name));
    }
}
