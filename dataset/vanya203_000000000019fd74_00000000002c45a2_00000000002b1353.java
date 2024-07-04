import java.util.*;
import java.io.*;

public class Solution {

    public static int minDiff = Integer.MAX_VALUE;
    public static Stack<Boolean> bestBathNow = null;

    public static void main(String[] args) {
        Scanner cs = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = cs.nextInt();

        for (int i = 1; i <= T; ++i) {
            int sum = cs.nextInt();
            int[][] res = findPath(sum);

            System.out.printf("Case #%d:\n", i);
            for (int[] v : res){
                System.out.printf("%d %d\n", v[0], v[1]);
            }
        }
    }

    public static int[][] findPath(int sum) {

        int level = 1;
        int sumOnLevel = 1;
        int allSum = 0;
        while (allSum <= sum){
            allSum += sumOnLevel;
            sumOnLevel *= 2;
            level++;
        }

        Stack<Boolean> path = new Stack<>();
        path.push(true);

        minDiff = Integer.MAX_VALUE;
        bestBathNow = new Stack<>();
        
        findBestPath(path, 1, sum, 1, 1, level*2);
        Stack<int[]> fullList = new Stack<>();

        level = 1;
        sumOnLevel = 1;
        boolean leftToRight = true;
        for (boolean b: bestBathNow){
            boolean takeTheLine = true;
            if (leftToRight) {
                for (int k = 0; takeTheLine && k < level; k++) {
                    fullList.push(new int[]{level, k+1});
                    takeTheLine = b;
                }
            } else {
                for (int k = level - 1; takeTheLine && k >= 0; k--) {
                    fullList.push(new int[]{level, k+1});
                    takeTheLine = b;
                }
            }
            leftToRight = (b ? (!leftToRight) : leftToRight);
            sumOnLevel *= 2;
            level++;
        }
        for (int k = 0; k < minDiff; k++) {
            fullList.push(new int[]{level, leftToRight ? 1 : level});
            level++;
        }

        int[][] bb = new int[fullList.size()][2];
        for (int u = 0; u < bb.length; u++){
            bb[u] = fullList.get(u);
        }

        return bb;
    }

    private static  void findBestPath(Stack<Boolean> path, int nowSum, int targetSum, int sumOnLastLevel, int lastLevelId, int maxLEvelId) {
        if (nowSum > targetSum || lastLevelId >= maxLEvelId){
            return;
        }
        if (targetSum - nowSum < minDiff){
            minDiff = targetSum - nowSum;
            bestBathNow = copyMyList(path);
        }
        path.push(false);
        findBestPath(path, nowSum +1, targetSum, sumOnLastLevel*2, lastLevelId+1, maxLEvelId);
        path.pop();
        path.push(true);
        findBestPath(path, nowSum + sumOnLastLevel*2, targetSum, sumOnLastLevel*2,lastLevelId+1, maxLEvelId);
        path.pop();

    }

    private static Stack<Boolean> copyMyList(Stack<Boolean> path) {
        Stack<Boolean> res = new Stack<>();
        res.addAll(path);
        return res;
    }
}
