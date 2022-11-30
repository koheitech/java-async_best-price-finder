import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class FlightService {
    public static Stream<CompletableFuture<Quote>> getQuotes() {
        var sites = List.of("site1", "site2", "site3");
        return sites
                .stream()
                .map(FlightService::getQuote);
    }

    public static CompletableFuture<Quote> getQuote(String site) {
        return CompletableFuture.supplyAsync(() -> {
            var random = new Random();

            System.out.println("Getting a quote from " + site);

            // sleep the current thread for 3 sec in order to simulate the remote process
            // that fetching price of the Quote remotely
            sleepFor(1000 + random.nextInt(2000));

            double price = 100 + random.nextInt(10);

            return new Quote(site, price);
        });
    }

    private static void sleepFor(int delay) {
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
