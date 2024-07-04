
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author namhcn
 */
public class Solution {

    private static final boolean DEBUG = false;

    public static int[][] calcBallatsq(int size) {
        int[][] ballatsq = new int[size][size];

        ballatsq[0][0] = 1;
        ballatsq[0][1] = 2;

        for (int i = 2, j = size; i < size; i += 2, j--) {
            ballatsq[0][i] = j;
        }

        for (int i = 3, j = 3; i < size; i += 2, j++) {
            ballatsq[0][i] = j;
        }

        //Initial values are generated, now we need to create the remaining rows using circular shift			
        for (int col = 0; col < size; col++) {
            for (int row = 1; row < size; row++) {
                ballatsq[row][col] = 1 + (ballatsq[row - 1][col]) % size;
            }
        }

        //print
//        for (int i = 0; i < size; i++) {
//            for (int j = 0; j < size; j++) {
//                System.out.print(ballatsq[i][j] + ((j == size - 1) ? "" : ","));
//            }
//            System.out.println();
//        }
//        System.out.println();
        return ballatsq;
    }
    public static int ROWNUM;
    public static int SUMROW;
    public static boolean IS_OK = false;
    public static int testNumber;
    public static Map<String, Integer> map = new HashMap<>();
    public static int[][] ballatsq;

    public static void main(String[] args) throws FileNotFoundException {

        initMap();

        //long beginTime = System.nanoTime();
        InputStream is = DEBUG ? new FileInputStream("resources/input.in") : System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int index = 1; index <= testCount; index++) {
                testNumber = index;
                ROWNUM = scanner.nextInt();
                SUMROW = scanner.nextInt();
                ballatsq = calcBallatsq(ROWNUM);
                String str = "";
                for (int i = 0; i < ROWNUM; i++) {
                    str += (char) (i + 33) + "";
                }
                permutation("", str);
                if (!IS_OK) {
                    System.out.println("Case #" + testNumber + ": IMPOSSIBLE");
                }
                IS_OK=false;
            }
        }
        //System.err.println("Done in " + ((System.nanoTime() - beginTime) / 1e9) + " seconds.");
    }

    private static void permutation(String prefix, String str) {
        int n = str.length();
        if (n == 0 && !IS_OK) {
            String[] strIndexs = prefix.split("");
            int sum = 0;
            for (int i = 0; i < ROWNUM; i++) {
                sum += ballatsq[map.get(strIndexs[i])][i];
            }
            if (sum == SUMROW) {
                System.out.println("Case #" + testNumber + ": POSSIBLE");
                IS_OK = true;
                for (int i = 0; i < ROWNUM; i++) {
                    int index = map.get(strIndexs[i]);
                    for (int j = 0; j < ROWNUM; j++) {
                        System.err.print(ballatsq[index][j]);
                        if (j != ROWNUM) {
                            System.err.print(" ");
                        }
                    }
                    System.err.println();

                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i + 1, n));
            }
        }
    }

    public static void initMap() {
        for (int i = 33; i < 126; i++) {
            char ch = (char) i;
            map.put(ch + "", i - 33);
        }
    }

}
