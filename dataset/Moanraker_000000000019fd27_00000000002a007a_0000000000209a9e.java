import java.io.IOException;
import java.util.Scanner;

public class Solution {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws IOException {
        int T = sc.nextInt(), B = sc.nextInt();
        if (B > 10) {
            System.exit(1);
        }
        for (int i = 1; i <= T; i++) {
            oneRun(i, B);
        }
    }

    private static void oneRun(int num, int B) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= B; i++) {
            System.out.println(i);
            sb.append(sc.nextInt());
        }

        System.out.println(sb.toString());
        String response = sc.next();
        if (response.equals("N")) {
            System.exit(1);
        }
    }
}