import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        for (int k = 1; k <= t; k++) {
            StringBuilder sb = new StringBuilder();
            String s = sc.nextLine();
            for (int i = 0; i < s.length(); i++) {
                int currNo = Integer.parseInt(s.charAt(i) + "");
                if (i == 0) {
                    for (int j = 0; j < currNo; j++) {
                        sb.append("(");
                    }
                    sb.append(currNo);
                }
                if (i == s.length() - 1) {
                    for (int j = 0; j < currNo; j++) {
                        sb.append(")");
                    }
                }
                if (i < s.length() - 1) {
                    int lookAhead = Integer.parseInt(s.charAt(i + 1) + "");
                    int diff = Math.abs(currNo - lookAhead);
                    if (currNo - lookAhead < 0) {
                        for (int j = 0; j < diff; j++) {
                            sb.append("(");
                        }
                    } else if (currNo - lookAhead > 0) {
                        for (int j = 0; j < diff; j++) {
                            sb.append(")");
                        }
                    }
                    sb.append(lookAhead);
                }
            }

            System.out.println("Case #" + k + ": " + sb);
        }
    }
}
