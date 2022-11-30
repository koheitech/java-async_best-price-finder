public class Main {
    public static void main(String[] args) {
        var service = new FlightService();
        service
            .getQuote("site1")
            .thenAccept(System.out::println);

        // sleep thread to output the result in the console
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}