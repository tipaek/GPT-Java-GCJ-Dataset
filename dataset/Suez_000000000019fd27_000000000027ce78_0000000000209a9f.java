import java.util.Scanner;

class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int t=0; t<T; t++) {
            char[] s = in.next().toCharArray();
            StringBuilder output = new StringBuilder();

            int nesting = 0;
            for(int i =0; i<s.length; i++) {
                int digit = s[i]-'0';

                if (digit > nesting){
                    int more = digit - nesting;
                    for (int j=0; j<more; j++) {
                        output.append("(");
                    }
                    nesting += more;
                } else if (digit == nesting) {
                } else {
                    int less = nesting - digit;
                    for (int j=0; j<less; j++) {
                        output.append(")");
                    }
                    nesting -= less;
                }
                output.append(digit);
            }
            for (int j=0; j<nesting; j++) {
                output.append(")");
            }
            System.out.println(String.format("Case #%s: %s", t+1, output.toString()));
        }
    }
}
