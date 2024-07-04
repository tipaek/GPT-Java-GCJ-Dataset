import java.util.Scanner;

public class Solution {

    public static void solve(int A, int B, Scanner sc) {
        if (A == B && A == 999999995) {
            // This block is intentionally left empty in the original code
        } else {
            String res = sc.nextLine();
            while (!res.isEmpty()) {
                // The original code seems incomplete here
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < T; i++) {
            if (A == B && A == 999999995) {
                String res = "";
                boolean found = false;
                boolean exit = false;

                for (int j = 0; j < 11; j++) {
                    for (int k = 0; k < 11; k++) {
                        System.out.println((j - 5) + " " + (k - 5));
                        res = sc.nextLine();

                        if (res.equals("CENTER")) {
                            found = true;
                            break;
                        } else if (!res.equals("WRONG")) {
                            exit = true;
                            break;
                        }
                    }
                    if (found || exit) break;
                }
                if (exit) break;
            } else {
                String res = "";
                while (!res.equals("WRONG")) {
                    System.out.println("0 0");
                    res = sc.nextLine();
                }
                break;
            }
        }
    }
}