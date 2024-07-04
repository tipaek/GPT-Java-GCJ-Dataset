import java.io.FileInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

import static java.util.Arrays.sort;


public class Solution {

    private static Scanner in;
    private static PrintStream out;


    private static final String CASE_N = "Case #";
    private static final String COLON_SPACE = ": ";

    private static final String IMPOSSIBLE = "IMPOSSIBLE";



    public static void main(String[] args) throws Throwable {
        in = new Scanner(System.in);
//        in = new Scanner(new FileInputStream("./src/main/resources/codejam/year2020/qualification/C/C.in"));
        out = System.out;
        //out = new PrintStream(new FileOutputStream("A_RobotProgrammingStrategy.out"));

        Period[] periods = new Period[1001];

        int T = in.nextInt();


        for (int t = 1; t <= T; t++) {
            int N = in.nextInt();
            for (int i = 0; i < N; i++) {
                int s = in.nextInt();
                int e = in.nextInt();
                periods[i] = new Period(i, s, e);
            }

            out.print(CASE_N);
            out.print(t);
            out.print(COLON_SPACE);

            out.print(solution(periods, N));

            out.println();
        }
        out.flush();
    }

    static char Cameron = 'C';
    static char Jamie = 'J';

    static Comparator<Period> byStart = Comparator.comparing(p -> p.start);
    static Comparator<Period> byIndex = Comparator.comparing(p -> p.index);

    private static String solution(Period[] periods, int N) {
        int cEnds = 0;
        int jEnds = 0;

        sort(periods, 0, N, byStart);
        for (int i = 0; i < N; i++) {
            Period p = periods[i];
            if (cEnds <= p.start) {
                p.assigned = Cameron;
                cEnds = p.end;
            } else if (jEnds <= p.start) {
                p.assigned = Jamie;
                jEnds = p.end;
            } else {
                return IMPOSSIBLE;
            }
        }

        sort(periods, 0, N, byIndex);

        StringBuilder output = new StringBuilder(N);
        for (int i = 0; i < N; i++) {
            output.append(periods[i].assigned);
        }
        return output.toString();
    }



    static class Period {

        int index;
        int start;
        int end;
        char assigned;

        Period(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

    }

}
