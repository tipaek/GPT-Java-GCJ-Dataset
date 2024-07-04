import java.util.Scanner;

public class Solution {
    public static void solve10(Scanner input) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            String response = input.next();
            s.append(response);
        }
        System.out.println(s);
        if (s.toString().equals("Y") || s.toString().equals("N")) {
            return;
        }
    }

    public static void solve20(Scanner input) {
        // No implementation needed as per original code
    }

    public static void solve100(Scanner input) {
        // No implementation needed as per original code
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            if (B == 10) {
                solve10(input);
            } else if (B == 20) {
                solve20(input);
            } else {
                solve100(input);
            }
        }
    }
}