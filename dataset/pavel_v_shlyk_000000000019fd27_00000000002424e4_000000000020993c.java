// package codejam.q_2020;

import java.util.Scanner;

public class Solution {

    public static void main (String[] args) throws Exception {


//        String s = "3\n" +
//                "4\n" +
//                "1 2 3 4\n" +
//                "2 1 4 3\n" +
//                "3 4 1 2\n" +
//                "4 3 2 1\n" +
//                "4\n" +
//                "2 2 2 2\n" +
//                "2 3 2 3\n" +
//                "2 2 2 3\n" +
//                "2 2 2 2\n" +
//                "3\n" +
//                "2 1 3\n" +
//                "1 3 2\n" +
//                "1 2 3";

        String s = "1\n" +
                "2\n" +
                "1 2\n" +
                "2 1\n";

//        StringBuffer sb = new StringBuffer("1\n" +
//                "100000 100000\n");
//        Random r = new Random();
//        for (int i=0; i<100000; ++i) {
//            int C = r.nextInt(1000000000);
//            C = Math.abs(C);
//            sb.append(" " + C);
////            System.out.print(C + " ");
//        }
//        String s = sb.toString();


        int T;
        Scanner scan = new Scanner(System.in);
//        Scanner scan = new Scanner(s);

        long time = System.currentTimeMillis();

        T = scan.nextInt();
        for (int t=1; t<=T; ++t) {
            int N = scan.nextInt();

            int sum=0;
            int[] columnsCount = new int[N];
            int[] rowsCount = new int[N];
            int[][] rows = new int[N][];
            int[][] columns = new int[N][];
            for (int i=0; i<N; ++i) {
                rows[i] = new int[N+1];
                columns[i] = new int[N+1];
            }
            for (int r=0; r<N; ++r) {
                for (int c=0; c<N; ++c) {
                    int v = scan.nextInt();
                    if (r==c) sum += v;
                    if (rows[r][v]==1) rowsCount[r]=1;
                    if (columns[c][v]==1) columnsCount[c]=1;
                    rows[r][v]=1; columns[c][v]=1;
                }
            }

            int colsSum=0, rowsSum=0;
            for (int i=0; i<N; ++i) {
                colsSum += columnsCount[i];
                rowsSum += rowsCount[i];
            }

            System.out.println("Case #"+t+": " + sum + " " + rowsSum + " " + colsSum);
        }
    }
}
