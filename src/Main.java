import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        var service = new FlightService();
        service
                .getQuotes()
                .map(future -> future.thenAccept(System.out::println))
                .collect(Collectors.toList());

        // sleep thread to output the result in the console
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}