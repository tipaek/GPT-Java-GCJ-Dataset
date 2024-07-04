import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;

    private static int R, C;
    private static int[][] A;

    private static void solveProblem(InputStream instr) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(instr)));
        int testCount = sc.nextInt();
        for (int t = 1; t <= testCount; t++) {
            R = sc.nextInt();
            C = sc.nextInt();
            A = new int[R + 2][C + 2];
            for(int i = 1; i <= R; i++){
                for(int j = 1; j <= C; j++){
                    A[i][j] = sc.nextInt();
                }
            }

            Object result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static Object solveTestCase() {
        long answer = 0;
        while(true){
            List<int[]> elems = new ArrayList<>();
            long roundSum = 0;
            for(int i = 1; i <= R; i++){
                for(int j = 1; j <= C; j++){
                    if(A[i][j] == 0){
                        continue;
                    }

                    roundSum+= A[i][j];
                    int sum = 0;
                    int count = 0;
                    int left = findNextLeft(i, j);
                    if(left  != 0){
                        sum+= left;
                        count++;
                    }

                    int right = findNextRight(i, j);
                    if(right  != 0){
                        sum+= right;
                        count++;
                    }

                    int up = findNexUp(i, j);
                    if(up  != 0){
                        sum+= up;
                        count++;
                    }

                    int down = findNexDown(i, j);
                    if(down  != 0){
                        sum+= down;
                        count++;
                    }
                    if(count > 0){
                        double avg = ( sum * 1.0) / count;
                        if(A[i][j] < avg){
                            elems.add(new int[]{i, j});
                            printDebug("Elimninate: " + i + "-" + j);
                        }
                    }
                }

            }
            printDebug("Round Sum: "+ roundSum);
            answer += roundSum;

            if(elems.size() == 0){
                break;
            }
            for(int[] el: elems){
                A[el[0]][el[1]] = 0;
            }
        }
        return answer;
    }

    private static int findNextLeft(int row, int col){
        col--;
        while(col >= 0){
            if(A[row][col] > 0){
                return A[row][col];
            }
            col--;
        }
        return 0;
    }



    private static int findNextRight(int row, int col){
        col++;
        while(col < C){
            if(A[row][col] > 0){
                return A[row][col];
            }
            col++;
        }
        return 0;
    }

    private static int findNexUp(int row, int col){
        row--;
        while(row >= 0){
            if(A[row][col] > 0){
                return A[row][col];
            }
            row--;
        }
        return 0;
    }

    private static int findNexDown(int row, int col){
        row++;
        while(row < R){
            if(A[row][col] > 0){
                return A[row][col];
            }
            row++;
        }
        return 0;
    }

    private static String joinValues(List<? extends Object> list, String delim) {
        return list.stream().map(Object::toString).collect(Collectors.joining(delim));
    }

    private static String joinValues(int[] arr, String delim) {
        List<Object> list = new ArrayList<>();
        for (Object value : arr) {
            list.add(value);
        }
        return list.stream().map(Object::toString).collect(Collectors.joining(delim));
    }

    private static int[] readInts(Scanner sc, int N) {
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    public static void printDebug(Object str) {
        if (debug) {
            System.out.println("DEBUG: " + str);
        }
    }

    public static void main(String[] args) throws Exception {
        long currTime = System.currentTimeMillis();
        if (debug) {
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Time: " + (System.currentTimeMillis() - currTime));
        } else {
            solveProblem(System.in);
        }
    }

}
