import java.io.PrintStream;
import java.util.Scanner;


public class Solution {

    private static Scanner in;
    private static PrintStream out;


    private static final String CASE_N = "Case #";
    private static final String COLON_SPACE = ": ";

    public static void main(String[] args) throws Throwable {
        in = new Scanner(System.in);
//        in = new Scanner(new FileInputStream("./src/main/resources/codejam/year2020/round1b/B/B.in"));
        out = System.out;
        //out = new PrintStream(new FileOutputStream("A_RobotProgrammingStrategy.out"));

        int T = in.nextInt();
        int A = in.nextInt();
        int B = in.nextInt();

        for (int t = 1; t <= T; t++) {
            solveSmall(A, B);
        }
        out.flush();
    }

    static final int MAX = 1_000_000_000;

    static final int[][] potential_centers = new int[][] {
            {0,0},
            {-500_000_000, -500_000_000},
            {-500_000_000, +500_000_000},
            {+500_000_000, -500_000_000},
            {+500_000_000, +500_000_000}
    };

    static int attempt;
    static final int attemptLimit = 300;


    private static void solveSmall(int minR, int maxR) {
        int diff = (MAX - minR + 1);
        attempt = 0;

        for (int x = -diff; x <= +diff; x++) {
            for (int y = -diff; y <= +diff; y++) {
                String result = exchange(x, y);

                if (isCenter(result)) return; // got it by chance
            }
        }

        // should not have reached this point
        System.exit(3);

//        int x, y;
//
//        // find a initial center
//        for (int i = 0; i < potential_centers.length; i++) {
//            x = potential_centers[i][0];
//            y = potential_centers[i][1];
//
//            String result = exchange(x, y);
//
//            if (isCenter(result)) return; // got it by chance
//
//            if (isHit(result)) {
//                break;
//            }
//        }



    }

//
//    private static void solve(int minR, int maxR) {
//        attempt = 0;
//
//        int x, y;
//
//        // find a initial center
//        for (int i = 0; i < potential_centers.length; i++) {
//            x = potential_centers[i][0];
//            y = potential_centers[i][1];
//
//            String result = exchange(x, y);
//
//            if (isCenter(result)) return; // got it by chance
//
//            if (isHit(result)) {
//                break;
//            }
//        }
//
//
//
//    }

    private static String exchange(int x, int y) {
        write(x,y);
        return read();
    }

    static boolean isCenter(String str) {
        return "CENTER".equals(str);
    }

    static boolean isHit(String str) {
        return "HIT".equals(str);
    }

    static boolean isMiss(String str) {
        return "HIT".equals(str);
    }

    private static String read() {
        String answer = in.next();
        if (answer.equals("WRONG")) {
            System.exit(1); // exit with error if wrong is received
        }
        return answer;
    }

    static void write(int x, int y) {
        if (attempt >= 300) {
            System.exit(2); // exit with error - could not solve within constraints
        }

        out.print(x);
        out.print(' ');
        out.print(y);
        out.println();
    }

}
