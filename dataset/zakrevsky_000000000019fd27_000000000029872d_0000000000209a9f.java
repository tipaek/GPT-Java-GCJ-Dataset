import java.io.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(new File("a.in")))));
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int t = 1; t <= T; t++) {
            char[] s = scanner.nextLine().toCharArray();
            int[] n = new int[s.length + 2];
            for (int i = 0; i < s.length; i++) {
                n[i + 1] = s[i] - '0';
            }
            StringBuilder r = new StringBuilder();
            for (int i = 1; i < n.length; i++) {
                int o = n[i] - n[i - 1];
                for (int j = 0; j < o; j++) {
                    r.append('(');
                }
                for (int j = 0; j < -o; j++) {
                    r.append(')');

                }
                if (i != n.length - 1) {
                    r.append(n[i]);
                }
            }
            System.out.println("Case #" + t + ": " + r.toString());
        }
    }
}
