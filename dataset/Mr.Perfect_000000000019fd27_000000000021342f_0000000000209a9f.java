import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = Integer.parseInt(s.nextLine());
        for (int c = 1; c <= t; ++c) {
            String str = s.nextLine();
            int cur = 0;
            StringBuilder sb = new StringBuilder();
            for (char ch : str.toCharArray()) {
                int req = ch - '0';
                if (req > cur) {
                    while (req > cur) {
                        sb.append('(');
                        cur++;
                    }
                } else if (req < cur) {
                    while (req < cur) {
                        sb.append(')');
                        cur--;
                    }
                }
                sb.append(ch);
            }
            while (cur > 0) {
                sb.append(')');
                cur--;
            }
            System.out.println("Case #" + c + ": " + sb.toString());
        }
    }
}