import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            String s = sc.next();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                int ci = c - '0';
                if (i == 0) {
                    for (int j = 1; j <= ci; j++) {
                        sb.append('(');
                    }
                    sb.append(c);
                } else {
                    int pci = ci - (s.charAt(i - 1) - '0');
                    if (pci < 0) {
                        for (int j = 1; j <= Math.abs(pci); j++) {
                            sb.append(')');
                        }
                    } else if (pci > 0) {
                        for (int j = 1; j <= Math.abs(pci); j++) {
                            sb.append('(');
                        }
                    }
                    sb.append(c);
                }
            }
            for (int j = 1; j <= s.charAt(s.length() - 1) - '0'; j++) {
                sb.append(')');
            }
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }

}
