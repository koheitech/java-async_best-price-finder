import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class FlightService {
    public CompletableFuture<Quote> getQuote(String site) {
        return CompletableFuture.supplyAsync(() -> {

            System.out.println("Getting a quote from " + site);

            // sleep the current thread for 3 sec in order to simulate the remote process
            // that fetching price of the Quote remotely
            sleepFor(3000);

            var random = new Random();
            double price = 100 + random.nextInt(10);

            return new Quote(site, price);
        });
    }

    private void sleepFor(int millisec) {
        try {
            Thread.sleep(millisec);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
