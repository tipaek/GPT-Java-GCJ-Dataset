import java.io.IOException;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException {
        algooo();
    }

    static void algooo() {
        Scanner s = new Scanner(System.in);
        int T = Integer.valueOf(s.nextLine());

        for (int i = 1; i <= T; i++) {
            String number = s.nextLine();
            StringBuilder sb = new StringBuilder();
            int depth = 0;

            for (int j = 0; j < number.length(); j++) {
                int n = number.charAt(j) - '0';
                int change = n - depth;
                if(change == 0) {
                    sb.append(n);
                }
                else if(change < 0) {
                    sb.append(new String(new char[Math.abs(change)]).replace("\0", ")"));
                    sb.append(n);
                }
                else {
                    sb.append(new String(new char[Math.abs(change)]).replace("\0", "("));
                    sb.append(n);
                }
                depth = n;
                if(j == number.length() - 1 && depth != 0) {
                    sb.append(new String(new char[Math.abs(change)]).replace("\0", ")"));
                }
            }


            System.out.print(String.format("Case #%d: %s\n", i ,sb.toString()));
        }
    }
}