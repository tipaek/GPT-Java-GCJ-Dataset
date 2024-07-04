import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int b = sc.nextInt();

        while (t > 0) {
            StringBuilder s = new StringBuilder();
            for (int x = 1; x <= b; x++) {
                System.out.println(x);
                System.out.flush();
                s.append(sc.next());
            }

            System.out.println(s.toString());
            System.out.flush();

            String ans = sc.next();
            if (ans.equals("N")) {
                break;
            }

            t--;
        }
    }
}