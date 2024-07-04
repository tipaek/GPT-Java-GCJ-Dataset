import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Solution {
    private static boolean debug = false;

    private static int N, K;
    private static Slot[] slots;

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

    private static Object solveTestCase() {
        int[][] grid = new int[N][N];
        /*
        int floor = K / N;
        int sum = floor * N;
        for(int i = 0; i < N; i++){
            grid[i][i] = floor;
        }
        int index = 0;
        while(sum < K){
            if(grid[index][index] == N){
                index++;
            }
            grid[index][index] ++;
            sum++;
        }
        */

        boolean answer = solveGrid(grid, 0);
        String result = "";
        if(answer){
            result+= "POSSIBLE\n";
            result+= printGrid(grid);
        }else{
            result+= "IMPOSSIBLE";
        }
        return result;
    }

    private static boolean solveGrid(int[][] grid, int index){
        //System.out.println("---------------- "+ index + "\n"+ printGrid(grid));
        if(index >= N * N){
            return true;
        }
        int row = index / N;
        int col = index % N;
        if(grid[row][col] != 0){
            return solveGrid(grid, index+1);
        }
        for(int value = 1; value <= N; value++){
            boolean ok = true;
            for(int j = 0; j < N; j++){
                if(grid[row][j] == value){
                    ok = false;
                    break;
                }

                if(grid[j][col] == value){
                    ok = false;
                    break;
                }
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
                if(valueCount == N && sum != K){
                    ok = false;
                }
            }
            if(ok){
                grid[row][col] = value;
                boolean result = solveGrid(grid, index+1);
                if(result){
                    return true;
                }else{
                    grid[row][col] = 0;
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

    private static class Slot{
        String assignment;
        int start, end;
        Set<Slot> childen = new HashSet<>();
        public Slot(int start, int end){
            this.start = start;
            this.end = end;
        }

        /*  @Override
          public int compareTo(Slot o) {
              if(start == o.start){
                  if(end == o.end){
                      return super.hashCode() - o.hashCode();
                  }else{
                      return o.end - end;
                  }
              }
              return start - o.start;
          }
  */
        @Override
        public String toString(){
            return start + "-" + end;
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

    public static void generateTestCases(int count){
        Random rand = new Random();
        StringBuilder builder = new StringBuilder();
        builder.append(count + "\n");
        for(int i = 0; i < count; i++){
            int N = 2 + rand.nextInt(9);
            builder.append(N + "\n");
            int start = 0;
            for(int j = 0; j < N; j++) {
                start = start + rand.nextInt(5);
                int end = start + 1 + rand.nextInt(5);
                builder.append(start + " " + end);
                builder.append("\n");
            }
        }
        try {
            FileWriter writer = new FileWriter("input.in");
            writer.write(builder.toString());
            writer.close();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

}
