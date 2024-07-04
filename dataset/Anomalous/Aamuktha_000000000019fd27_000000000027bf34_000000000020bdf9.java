import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int t = 0; t < testCases; t++) {
            int numberOfIntervals = scanner.nextInt();
            int[] startTimes = new int[numberOfIntervals + 1];
            int[] endTimes = new int[numberOfIntervals + 1];

            for (int i = 1; i <= numberOfIntervals; i++) {
                startTimes[i] = scanner.nextInt();
                endTimes[i] = scanner.nextInt();
            }
        }
    }
}