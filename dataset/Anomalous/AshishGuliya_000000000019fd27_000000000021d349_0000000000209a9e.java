import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    private static Scanner scanner;

    private static final Comparator<Activity> BY_START = Comparator.comparing(Activity::getSTART_TIME);
    private static final Comparator<Activity> BY_END = Comparator.comparing(Activity::getEND_TIME);

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        executeEsab();
    }

    private static void executeEsab() {
        int testCases = scanner.nextInt();
        int arrayLength = scanner.nextInt();
        int[] array = new int[arrayLength];

        for (int t = 1; t <= testCases; t++) {
            for (int j = 1; j <= arrayLength; j++) {
                System.out.println(j);
                array[j - 1] = scanner.nextInt();
            }
            for (int digit : array) {
                System.out.print(digit);
            }
            System.out.println();
            
            String result = scanner.next();
            if ("N".equals(result)) {
                break;
            }
        }
    }
}