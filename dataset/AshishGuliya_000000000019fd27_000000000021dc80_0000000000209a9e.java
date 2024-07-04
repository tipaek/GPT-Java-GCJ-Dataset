import java.lang.reflect.Array;
import java.util.*;

public class Solution {

    private static Scanner scanner;

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
                System.out.flush();
                array[j - 1] = scanner.nextInt();
            }
            for (int digit : array) {
                System.out.print(digit);
            }
            System.out.println();
            System.out.flush();
            result = scanner.nextLine();
            if(result == "N")
                break;
        }
    }
}