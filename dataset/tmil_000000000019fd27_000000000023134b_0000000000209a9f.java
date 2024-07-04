
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nt = sc.nextInt();

        for (int tc = 1; tc <= nt; tc++) {
            String str = sc.next();
            StringBuilder sb = new StringBuilder();
            int nOpen = 0;
            for (int i = 0; i < str.length(); i++) {
                int num = str.charAt(i) - '0';
                if (nOpen > num) {
                    for (int j = 0; j < nOpen - num; j++) {
                        sb.append(')');
                    }
                    nOpen -= (nOpen - num);
                }
                else if (num > nOpen) {
                    for (int j = 0; j < num - nOpen; j++) {
                        sb.append('(');
                    }
                    nOpen += (num - nOpen);
                }
                sb.append(num);
            }
            for (int i = 0; i < nOpen; i++) {
                sb.append(')');
            }
            System.out.println("Case #" + tc + ": " + sb.toString());
        }
    }
}
