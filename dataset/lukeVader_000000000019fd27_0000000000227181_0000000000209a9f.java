import java.util.*;

public class Solution{


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        for(int k = 0; k < t; k++) {
            String s = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            int degree = 0;
            char curr = s.charAt(0);
            degree = (Integer.parseInt(String.valueOf(curr)));
            for (int j = 0; j < degree; j++) {
                sb.append('(');
            }

            for (int i = 0; i < s.length() - 1; i++) {
                sb.append(s.charAt(i));
                degree -= Integer.parseInt(String.valueOf(s.charAt(i + 1)));
                if (degree < 0) {
                    for (int j = 0; j < -1 * degree; j++) {
                        sb.append('(');
                    }
                }
                if (degree > 0) {
                    for (int j = 0; j < degree; j++) {
                        sb.append(')');
                    }
                }
                degree = Integer.parseInt(String.valueOf(s.charAt(i + 1)));
            }
            sb.append(s.charAt(s.length() - 1));
            degree = Integer.parseInt(String.valueOf(s.charAt(s.length() - 1)));
            for (int j = 0; j < degree; j++) {
                sb.append(')');
            }
            System.out.println("Case #" + (k+1) + ": " + sb.toString());

        }

    }
}