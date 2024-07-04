import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        final Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();
        for (int k = 1; k <= t; k++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= b; i++) {
                System.out.println(i);
                sb.append(in.nextInt());
            }
            in.nextLine();
            System.out.println(sb);
            String s = in.nextLine();
            if ("N".equals(s)) {
                return;
            }
        }
    }
}
