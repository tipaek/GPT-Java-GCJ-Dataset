import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for (int t = 0; t < T; t++) {
            String S = sc.nextLine();
            StringBuilder ret = new StringBuilder();
            int oldVal = 0;
            for (int i = 0; i < S.length(); i++) {
                int val = (int) S.charAt(i);
                if (oldVal == 0 && val == 1) {
                    ret.append("(").append(val);
                } else if (oldVal == 1 && val == 0) {
                    ret.append(")").append(val);
                } else {
                    ret.append(val);
                }
                oldVal = val;
            }
            System.out.println("Case #" + t + 1 + ": " + ret);
        }
    }
}