import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    private static Scanner scanner;

    private static Comparator<Activity> byStart = Comparator.comparing(Activity::getSTART_TIME);
    private static Comparator<Activity> byEnd = Comparator.comparing(Activity::getEND_TIME);

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        esab();
    }

    private static void esab() {
        int N;
        int T = scanner.nextInt();
        int B = scanner.nextInt();
        int array[] = new int[B];
        int i;
        String result;
        for (int t = 1; t <= T; t++) {
            i = 0;
            for (int j = 1; j <= B; j++) {
                System.out.println(j);
                array[j - 1] = scanner.nextInt();
            }
            for (int digit : array) {
                System.out.print(digit);
            }
            System.out.println();
            result = scanner.nextLine();
            if(result == "N")
                break;
        }
    }
}