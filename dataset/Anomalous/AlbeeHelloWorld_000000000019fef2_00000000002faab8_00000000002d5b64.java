import java.util.*;
import java.io.*;

public class Solution {
    static boolean isTest = false;
    static int n;
    static StringBuilder out;

    public static void main(String[] args) throws Exception {
        Scanner scanner = getScanner();
        int T = Integer.parseInt(scanner.nextLine());
        
        for (int i = 0; i < T; i++) {
            int R = scanner.nextInt();
            int S = scanner.nextInt();
            scanner.nextLine(); // Consume the newline
            n = 0;
            out = new StringBuilder();
            calculate(R, S);
            System.out.println("Case #" + (i + 1) + ": " + n);
            System.out.println(out);
        }
    }

    static void calculate(int R, int S) {
        if (R == 1) return;
        n += S - 1;
        for (int i = 0; i < S - 1; i++) {
            out.append((R * S - R - i) + " " + (R - 1) + "\n");
        }
        calculate(R - 1, S);
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