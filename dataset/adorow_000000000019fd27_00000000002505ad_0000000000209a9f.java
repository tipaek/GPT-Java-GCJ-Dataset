import java.io.PrintStream;
import java.util.Scanner;


public class Solution {

    private static Scanner in;
    private static PrintStream out;


    private static final String CASE_N = "Case #";
    private static final String COLON_SPACE = ": ";

    public static void main(String[] args) throws Throwable {
        in = new Scanner(System.in);
//        in = new Scanner(new FileInputStream("./src/main/resources/codejam/year2020/qualification/B/B2.in"));
        out = System.out;
        //out = new PrintStream(new FileOutputStream("A_RobotProgrammingStrategy.out"));

        int T = in.nextInt();

        int[] Sd = new int[101];
        StringBuilder y = new StringBuilder(1001);

        for (int t = 1; t <= T; t++) {
            y.setLength(0);

            String S = in.next();
            for (int i = 0; i < S.length(); i++) {
                Sd[i] = (S.charAt(i) - '0');
            }

            int curdepth = 0;
//            int ix = 0;

            for (int i = 0; i < S.length(); i++) {
                char ch = S.charAt(i);
                int depth = Sd[i];

                if (depth == curdepth) {

                    y.append(ch);
                } else if (depth > curdepth) {
                    int increase = depth - curdepth;
                    for (int j = 0; j < increase; j++) {
                        y.append('(');
                    }
                    curdepth = depth;

                    y.append(ch);
                } else {// depth < curdepth
                    int decrease = curdepth - depth;
                    for (int j = 0; j < decrease; j++) {
                        y.append(')');
                    }

                    curdepth = depth;
                    y.append(ch);
                }
            }

            // balance the end
            while (curdepth > 0) {
                curdepth--;
                y.append(')');
            }

            out.print(CASE_N);
            out.print(t);
            out.print(COLON_SPACE);

            out.print(y.toString());

            out.println();
        }
        out.flush();
    }

}
