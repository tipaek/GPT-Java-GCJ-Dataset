import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
    private static long [] trace;
    private static long[] rowDuplicate;
    private static long[] columnDuplicate;
    private static int[][] matrix;

    public static void main(String[] args) throws IOException {
        try {
            createMatrix();
        }catch(NullPointerException e){
            e.printStackTrace();
        }
        //System.out.println("100");
        //System.out.println("100");
        //Random random = new Random();
        //for(int k=0; k< 100; k++){
        //for(int i=0; i < 100; i++) {
        //for (int j = 0; j < 100; j++) {
        //int randomNum = ThreadLocalRandom.current().nextInt(2, 100);
        //  System.out.print(randomNum +" ");
        //}
        //  System.out.println();
        //}
        //System.out.println("100");
        //}
    }

    public static void createMatrix() throws IOException {
        /*int numOfCores = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(numOfCores + 1);*/

        int testCase;
        int size;
        //System.out.println("Inside Create");
        //BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        //Scanner in = new Scanner(System.in);
        testCase = Integer.parseInt(in.nextLine().trim());
        trace = new long[testCase];
        rowDuplicate = new long[testCase];
        columnDuplicate = new long[testCase];
        for (int i = 0; i < testCase; i++) {
            size = Integer.parseInt(in.nextLine().trim());
            //System.out.println("Create : " + size);
            matrix = new int[size][size];
            for (int j = 0; j < size; j++) {
                //BufferedReader bi = new BufferedReader(new InputStreamReader(System.in));
                //System.out.println("BufferedReader  :  " + in == null);
                String row = null;
                int k = 0;
                row = in.nextLine();
                //System.out.println("row  : "  + row == null);
                StringTokenizer tmp = new StringTokenizer(row.trim(), " ");

                //System.out.println("tmp  : "  + tmp == null);
                while (tmp.hasMoreElements()) {
                    matrix[j][k] = Integer.parseInt(tmp.nextToken());

                    k++;
                    //System.out.println("i = " + i + "  j = " + j + "  k  = " + k + "  size = " + size);
                    if(k == size)
                        break;
                }
            }
            trace[i] = getTrace(size);
            rowDuplicate[i] = duplicateRow(size);
            columnDuplicate[i] = duplicateColumn(size);
            /*int index = i;
            Runnable task = new Runnable() {
                @Override
                public void run() {

                }
            };
            pool.execute(task);*/
        }
        /*pool.shutdown();
        while (!pool.isTerminated()) ;*/
        for (int i = 0; i < testCase; i++) {
            System.out.println("Case #" + (i + 1) + ": " + trace[i] + " " + rowDuplicate[i] + " " + columnDuplicate[i]);
        }
    }

    private static long getTrace(int size) {
        long sum = 0;
        for (int i = 0; i < size; i++) {
            sum = sum + matrix[i][i];
        }
        return sum;
    }

    private static int duplicateRow(int size) {
        Set<Integer> set = new HashSet<>();
        int totalRowDuplicate = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boolean isUnique = set.add(matrix[i][j]);
                if (!isUnique) {
                    totalRowDuplicate = totalRowDuplicate + 1;
                    break;
                }
            }
            set.clear();
        }
        return totalRowDuplicate;
    }

    private static int duplicateColumn(int size) {
        Set<Integer> set = new HashSet<>();
        int totalColumnDuplicate = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                boolean isUnique = set.add(matrix[j][i]);
                if (!isUnique) {
                    totalColumnDuplicate = totalColumnDuplicate + 1;
                    break;
                }
            }
            set.clear();
        }
        return totalColumnDuplicate;
    }
}
