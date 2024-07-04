import java.util.Scanner;

public class Solution {

    static Scanner sc;

    public static void main(String[] args) {
        sc = new Scanner(System.in);

        final int testCaseCount = sc.nextInt();

        for (int i = 1; i <= testCaseCount; i++) {
            System.out.println("Case #" + i + ": " + process());
        }
    }

    private static String process() {
        int u = sc.nextInt();
        String d = "";

        for (int i = 0; i < 10000; i++) {
            int qi = sc.nextInt();
            String ri = sc.nextLine().trim();

            if (qi == d.length() + 1 && !d.contains(ri)) {
                if (qi == 10) {
                    d = ri.substring(ri.length() - 1) + d;
                } else {
                    d = d + ri;
                }
            }

            if (d.length() >= 10) {
                break;
            }
        }
        return d;
    }
}
