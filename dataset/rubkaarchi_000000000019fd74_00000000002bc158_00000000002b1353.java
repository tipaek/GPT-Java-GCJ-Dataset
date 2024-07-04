import java.util.*;
import java.io.*;
public class Solution  {

    private static Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    private static int[][] dp;
    public static void main(String[] args) {
        int caseNum = in.nextInt();
        dp = build();

        for(int i = 0; i < caseNum;i++) {
            int target = in.nextInt();
            calculate(i+1, target);
        }
    }

    private static void calculate(int caseNum, int target){

        HashMap<Integer, Integer> map = new HashMap<>();

        int end = calc(target, 0, 0, -1, map);

        Deque<int[]> deq = new ArrayDeque<>();

        while(end != -1) {
            deq.addFirst(dec(end));
            end = map.get(end);
        }

        System.out.println("Case #" + caseNum + ":");
        //int check = 0;
        while (deq.size() > 0) {
            int[] cur = deq.removeFirst();
            System.out.println(cur[0]+1 +" " + (cur[1]+1));
            //check += dp[cur[0]][cur[1]];
        }

        //System.out.println("CHECK: " + check);
    }

    private static int[] dec(int key) {
        int row = key / 1000;
        int col = key % 1000;

        return new int[]{row, col};
    }

    private static int calc(int target, int curRow, int curCol, int from, HashMap<Integer, Integer> map) {
        if(curRow >= 500 || curCol >= 500 || curRow < 0 || curCol < 0) return -1;
        if(dp[curRow][curCol] == 0) return -1;
        int key = getKey(curRow, curCol);
        if(map.containsKey(key)) return -1;

        int cur = dp[curRow][curCol];
        map.put(key, from);

        if(target == cur) {
            return key;
        }

        if(target < cur) return -1;

        map.put(key, from);

        int res = 0;

        res = calc(target-cur, curRow-1, curCol-1, key, map);
        if(res != -1) return res;

        res = calc(target-cur, curRow-1, curCol, key, map);
        if(res != -1) return res;

        res = calc(target-cur, curRow, curCol-1, key, map);
        if(res != -1) return res;

        res = calc(target-cur, curRow, curCol+1, key, map);
        if(res != -1) return res;

        res = calc(target-cur, curRow+1, curCol-1, key, map);
        if(res != -1) return res;

        res = calc(target-cur, curRow+1, curCol, key, map);
        if(res != -1) return res;

        map.remove(key);

        return -1;
    }

    private static int getKey(int row, int col) {
        return row * 1000 + col;
    }

    private static int[][] build() {
        int[][] res = new int[500][500];
        for(int i = 0; i < 500;i++) {
            res[i][0] = 1;
            res[i][i] = 1;
        }

        for(int i = 1; i < 500;i++) {
            for(int j = 1; j < 500; j++) {
               if(res[i-1][j] == 0) break;

               res[i][j] = res[i-1][j-1] + res[i-1][j];
            }
        }

        return res;
    }
}
