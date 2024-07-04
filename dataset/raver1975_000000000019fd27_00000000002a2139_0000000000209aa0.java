import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        //Scanner in = null;
        //try {
        //    in = new Scanner(new File("in.txt"));
        //} catch (FileNotFoundException e) {
        //    e.printStackTrace();
        //}
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt();
            int trace = in.nextInt();

//            HashSet<Integer> traces = new HashSet<>();

            List<Integer>[] lists = new List[4];
            lists[0] = Arrays.asList(2, 4);
            lists[1] = Arrays.asList(3, 6, 9);
            lists[2] = Arrays.asList(4,6, 7, 8, 9, 10, 11, 12, 13, 14,16);
            lists[3] = Arrays.asList(5,8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22,25);
//            lists[3] = Arrays.asList(5, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 25);

            //cerate latin square
            int[][] square = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    square[i][j] = (((i + 1) + (j)) % n) + 1;
                }
            }

            int b = 0;
            if (!lists[n - 2].contains(trace)) {
                System.out.println("Case #" + tt + ": " + "IMPOSSIBLE");
            } else {
                while ((b = calcTrace(square)) != trace) {
//                    if (!lists[n-2].contains(b)){
//                        System.out.println("new Trace!"+n+"\t"+b);
//                        System.exit(0);
//                    }
                    int orientation = (int) (Math.random() * 3);
                    switch (orientation) {
                        case 0:
                            swapRows(square);
                            break;
                        case 1:
                            swapCols(square);
                            break;
                        case 2:
                            relabel1(square);
                            break;
                    }
                }
                System.out.println("Case #" + tt + ": " + "POSSIBLE");
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        System.out.print(square[n-i-1][j]);
                        if (j < n - 1) {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();

                }
            }
//            Integer[] out=traces.toArray(new Integer[0]);
//            Arrays.sort(out);
//            System.out.println(n + "\t" + Arrays.toString(out));
        }
    }

    static int[] colTemp;

    private static void swapCols(int[][] square) {
        int n = square.length;
        int a = 0;
        int b = 0;
        while (a == b) {
            a = (int) (Math.random() * n);
            b = (int) (Math.random() * n);
        }
        colTemp = new int[n];
        for (int i = 0; i < n; i++) {
            colTemp[i] = square[a][i];
            square[a][i] = square[b][i];
            square[b][i] = colTemp[i];
        }

    }

    private static void swapRows(int[][] square) {
        int n = square.length;
        int a = 0;
        int b = 0;
        while (a == b) {
            a = (int) (Math.random() * n);
            b = (int) (Math.random() * n);
        }
        colTemp = new int[n];
        for (int i = 0; i < n; i++) {
            colTemp[i] = square[i][a];
            square[i][a] = square[i][b];
            square[i][b] = colTemp[i];
        }
    }

    public static int calcTrace(int[][] square) {
        int sum = 0;
        for (int i = 0; i < square.length; i++) {
            sum += square[square.length-i-1][i];
        }
        return sum;
    }

    public static void relabel1(int[][] square) {
        ArrayList<Integer> set = new ArrayList<>();
        for (int i = 0; i < square.length; i++) {
            set.add(i + 1);
        }
        Collections.shuffle(set);

        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square.length; j++) {
                square[j][i] = set.get(square[j][i] - 1);
            }
        }
    }
}
