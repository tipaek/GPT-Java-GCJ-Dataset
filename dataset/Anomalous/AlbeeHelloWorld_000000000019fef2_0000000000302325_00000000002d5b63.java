import java.util.*;
import java.io.*;

public class Solution {
    static boolean isTest = false;

    public static void main(String[] args) throws Exception {
        Scanner scan = getScanner();
        int T = scan.nextInt();
        int A = scan.nextInt();
        int B = scan.nextInt();
        scan.nextLine(); // Consume the remaining newline

        System.out.println(T);

        for (int i = 0; i < T; i++) {
            boolean isFound = false;
            for (int x = -5; x <= 5; x++) {
                for (int y = -5; y <= 5; y++) {
                    System.out.println(x + " " + y);
                    String verdict = scan.nextLine();
                    if ("CENTER".equals(verdict)) {
                        isFound = true;
                        break;
                    }
                }
                if (isFound) {
                    break;
                }
            }
        }
    }

    static Scanner getScanner() throws Exception {
        if (isTest) {
            return new Scanner(new File("input.txt"));
        } else {
            return new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }
    }

    static void debug(String s) {
        if (isTest) {
            System.out.println(s);
        }
    }
}