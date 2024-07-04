import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            String[] patterns = new String[n];
            sc.nextLine();

            for (int j = 0; j < n; j++) {
                patterns[j] = sc.nextLine().substring(1);
            }

            String result = patterns[0];
            for (int j = 1; j < n; j++) {
                result = mergePatterns(result, patterns[j]);
                if (result.equals("*")) {
                    break;
                }
            }

            System.out.println("Case #" + (i + 1) + ": " + result);
        }
        sc.close();
    }

    private static String mergePatterns(String a, String b) {
        String longer = a.length() >= b.length() ? a : b;
        String shorter = a.length() < b.length() ? a : b;

        if (longer.contains(shorter)) {
            return longer;
        } else {
            return "*";
        }
    }
}