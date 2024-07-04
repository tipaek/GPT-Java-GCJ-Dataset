import java.io.BufferedInputStream;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedInputStream(System.in));

        int numCases = in.nextInt();
        in.nextLine();
        for(int currCase = 0; currCase < numCases; currCase++) {

            String line = in.nextLine();

            StringBuilder out = new StringBuilder();
            int n = 0;

            for(int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);

                if(ch == '(') {
                    n++;
                } else if(ch == ')') {
                    n--;
                } else {
                    int val = ch - '0';
                    while(n > val) {
                        out.append(')');
                        n--;
                    }
                    while(n < val) {
                        out.append('(');
                        n++;
                    }
                }
                out.append(ch);
            }
            while(n > 0) {
                out.append(')');
                n--;
            }

            System.out.printf("Case #%d: %s%n", currCase + 1, out.toString());

        }



    }


}