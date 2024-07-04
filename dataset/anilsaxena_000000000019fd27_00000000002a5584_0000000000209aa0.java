import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;

    private static int N, K;
    private static boolean [][] rows, columns;
    private static int[] indexSequence;

    private static void solveProblem(InputStream instr) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(instr)));
        int testCount = sc.nextInt();
        for (int t = 1; t <= testCount; t++) {
            N = sc.nextInt();
            K = sc.nextInt();
            Object result = solveTestCase();
            System.out.println("Case #" + t + ": " + result);
        }
    }

    private static List<List<Integer>> rowValues;

    private static Object solveTestCase() {

        List<Integer> indexes = new ArrayList<>();
        indexSequence = new int[N * N];
        for(int i = 0; i < N * N; i++) {
            indexes.add(i);
        }
        int seq = 0;
        for(int i = 0; i < N; i++){
            indexSequence[seq++] = N * i + i;
            indexes.remove(Integer.valueOf(N * i + i));
        }
        // Collections.shuffle(indexes);
        for(int index: indexes){
            indexSequence[seq++] = index;
        }

        rowValues = new ArrayList<>();
        for(int i = 0; i < N; i++){
            List<Integer> rowData = new ArrayList<>();
            for(int j = 0; j < N; j++){
                rowData.add(1 + (i + j) % N);
            }
           // Collections.shuffle(rowData);
            rowValues.add(rowData);
        }
        boolean answer = false;
        int[][] grid = null;
        for(int d = 0; d < N; d++) {
            grid = new int[N][N];
            rows = new boolean[N][N + 1];
            columns = new boolean[N][N + 1];
            fillDiagonal(grid, d);
            answer = solveGrid(grid, N);
            if(answer){
                break;
            }
        }

        String result = "";
        if(answer){
            result+= "POSSIBLE\n";
            result+= printGrid(grid);
        }else{
            result+= "IMPOSSIBLE";
        }
        return result;
    }

    private static Random rand = new Random();

    private static boolean solveGrid(int[][] grid, int seq){
        if(seq >= N * N){
            return true;
        }

        int index = indexSequence[seq];
        //System.out.println(index);
    //    System.out.println("---------------- "+ index + "\n"+ printGrid(grid));
        int row = index / N;
        int col = index % N;
        if(grid[row][col] != 0){
            return solveGrid(grid, seq+1);
        }
        // int seed = rand.nextInt(N);
        List<Integer> rowData = rowValues.get(row);
        for(int r = 0; r < rowData.size(); r++){
            // int value = col % 2 ==  0 ? value1 : (N + 1 - value1);
            int value = rowData.get(r);
            boolean ok = true;
            if(rows[row][value] || columns[col][value]){
                continue;
            }

            if(row == col) {
                int sum = 0;
                int valueCount = 0;
                for (int i = 0; i < N; i++) {
                    if(grid[i][i] != 0) {
                        sum += grid[i][i];
                        valueCount++;
                    }
                }
                sum+= value;
                valueCount++;
                if(sum > K) {
                    ok = false;
                    continue;
                }else if(valueCount == N && sum != K){
                    ok = false;
                    continue;
                }
            }
            if(ok){
               // rowData.remove(r);
                grid[row][col] = value;
                rows[row][value] = true;
                columns[col][value] = true;
                boolean result = solveGrid(grid, seq+1);
                if(result){
                    return true;
                }else{
                 //   rowData.add(0, value);
                    grid[row][col] = 0;
                    rows[row][value] = false;
                    columns[col][value] = false;
                }
            }
        }
        return false;
    }

    private static int findNext(boolean[][] rows, int rowNum, int valueStart){
        for(int i = valueStart + 1; i < N; i++){
            if(!rows[rowNum][i]){
                return i;
            }
        }
        return 0;
    }

    private static void fillDiagonal(int[][] grid, int seed){
        int lower = K / N;
        int reminder = K - lower * N;


        for(int i = 0; i <N; i++){
            int value = lower;
            if(i >= (N - reminder)){
                value = value + 1;
            }
            setGridValue(grid, i, i, value);
        }
        for(int i = 1; i < seed; i++) {
            if (grid[i][i] > 1 && grid[i + 1][i + 1] < N) {
                setGridValue(grid, i, i, grid[i][i] - 1);
                setGridValue(grid, i + 1, i + 1, grid[i][i] + 1);
            }
        }
    }

    private static void setGridValue(int[][] grid, int row, int col, int value){
        grid[row][col] = value;
        rows[row][value] = true;
        columns[col][value] = true;
    }

    private static void removeGridValue(int[][] grid, int row, int col, int value){
        grid[row][col] = 0;
        rows[row][value] = false;
        columns[col][value] = false;
    }

    private static String printGrid(int[][] grid){
        List<String> tokens = new ArrayList<>();
        for(int[] row: grid){
            tokens.add(joinValues(row, " "));
        }
        return joinValues(tokens, "\n");
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
        // generateTestCases(100);
        long currTime = System.currentTimeMillis();
        if (debug) {
            solveProblem(new FileInputStream(new File("input.in")));
            System.out.println("Time: " + (System.currentTimeMillis() - currTime));
        } else {
            solveProblem(System.in);
        }
    }
}
