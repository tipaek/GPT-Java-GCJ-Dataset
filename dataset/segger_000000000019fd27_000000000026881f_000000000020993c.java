import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void mainTmp(String[] args) {
        /*
        Case #1: 4 0 0
        Case #2: 9 4 4
        Case #3: 8 0 2*/

        String data = "3\n" +
                "4\n" +
                "1 2 3 4\n" +
                "2 1 4 3\n" +
                "3 4 1 2\n" +
                "4 3 2 1\n" +
                "4\n" +
                "2 2 2 2\n" +
                "2 3 2 3\n" +
                "2 2 2 3\n" +
                "2 2 2 2\n" +
                "3\n" +
                "2 1 3\n" +
                "1 3 2\n" +
                "1 2 3";
        InputStream stdin = System.in;
        try {
            System.setIn(new ByteArrayInputStream(data.getBytes()));

            Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
            int T = Integer.parseInt(in.nextLine());
            //System.out.println("T: " + T);
            for (int i = 1; i <= T; ++i) {
                int N = Integer.parseInt(in.nextLine());
                int[][] matrix = new int[N][N];
                for (int j = 0; j < N; j++) {
                    String[] row = in.nextLine().split(" ");
                    for(int k = 0; k < row.length; k++) {
                        int nbr = Integer.parseInt(row[k]);
                        //System.out.println("nbr: " + nbr);
                        matrix[j][k] = nbr;
                    }
                }

                System.out.println("Case #" + i + ": " + result(N, matrix));
            }

        } finally {
            System.setIn(stdin);
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= T; ++i) {
            int N = Integer.parseInt(in.nextLine());
            int[][] matrix = new int[N][N];
            for (int j = 0; j < N; j++) {
                String[] row = in.nextLine().split(" ");
                for(int k = 0; k < row.length; k++) {
                    matrix[j][k] = Integer.parseInt(row[k]);
                }
            }

            System.out.println("Case #" + i + ": " + result(N, matrix));
        }
    }

    private static HashSet<Integer>[] emptySets(int N) {
        HashSet<Integer>[] sets = new HashSet[N];
        for(int i = 0; i < N; i++) {
            sets[i] = new HashSet<>();
        }
        return sets;
    }

    private static String result(int N, int[][] matrix) {
        int k = 0; // trace
        int r = 0; // rows
        int c = 0; // columns

        HashSet<Integer>[] cols = emptySets(N);
        boolean[] repeatCols = new boolean[N];
        for(int i = 0; i < N; i++) {
            HashSet<Integer> row = new HashSet<>();
            boolean repeatRow = false;
            for(int j = 0; j < N; j++) {
                int nbr = matrix[i][j];
                //System.out.print(nbr + " ");
                if (i == j) {
                    k += nbr;
                }

                if(!row.add(nbr)) {
                    repeatRow = true;
                }

                if(!cols[j].add(nbr)) {
                    repeatCols[j] = true;
                }
            }
            if (repeatRow) {
                r++;
            }
            //System.out.println();
        }
        for(int a = 0; a < N; a++) {
            if(repeatCols[a]) {
                c++;
            }
        }

        return k + " " + r + " " + c;
    }
}