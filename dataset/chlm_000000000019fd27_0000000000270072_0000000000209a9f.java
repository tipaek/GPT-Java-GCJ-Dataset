import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        scan.nextLine();


        for (int i = 1; i <= t; i++) { 
            String ans = "";
            String str = scan.nextLine();

            int opening = 0;

            for (int j = 0; j < str.length(); j++) {
                int n = str.charAt(j) - '0';
                if (n > opening) {
                    int diff = n - opening;
                    for (int k = 0; k < diff; k++) {
                        ans += "(";
                    }
                    opening += diff;
                }

                if (n < opening) {
                    int diff = opening - n;
                    for (int k = 0; k < diff; k++) {
                        ans += ")";
                    }
                    opening -= diff;
                }

                ans += (char) (n + '0');
            }

            for (int k = 0; k < opening; k++) {
                ans += ")";
            }

            System.out.format("Case #%d: %s\n", i, ans);
        }
        scan.close();
    }
}