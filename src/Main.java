import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var start = LocalTime.now();

        var sites = List.of("site1", "site2", "site3");

        var QuoteListFutures = FlightService
                .getQuotes(sites)
                .map(future -> future.thenAccept(System.out::println))
                .collect(Collectors.toList());

        CompletableFuture
                .allOf(QuoteListFutures.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    var end = LocalTime.now();
                    var duration = Duration.between(start, end);
                    System.out.println("Retrieved all quotes in " + duration.toMillis() + " milli seconds.");
                });

        sleepForTest();
    }

    private static void sleepForTest() {
        // sleep thread to output the result in the console
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}