import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Harry on 4/10/20.
 */
public class Solution {
    static int[][] dirs = new int[][]{{-1,-1}, {-1,0}, {0,-1},{0,1},{1,0}, {1,1}};
    static long[][] val = new long[502][502];
    public static void main(String[] agrs) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        calc();

//        for(int r=1; r<10; r++){
//            for(int k=1; k<=r; k++){
//                System.out.print(val[r][k]+",");
//            }
//            System.out.println();
//        }

        for(int t=1; t<=T; t++){
            int N = scanner.nextInt();
            boolean[][] visited = new boolean[502][502];
            List<int[]> path = new ArrayList<>();
            path.add(new int[]{1,1});
            long target = N-1;
            int step = 1;
            visited[1][1] = true;
            List<int[]> res = dfs(1, 1, target, path, step, visited);
            System.out.println("Case #"+t+":");
            int sum = 0;
            for(int[] cur : res){
                System.out.println(cur[0]+" "+cur[1]);
                sum += val[cur[0]][cur[1]];
            }
        }

    }

    public static List<int[]> dfs(int r, int k, long target, List<int[]> path, int step, boolean[][] visited){
//        System.out.println("!"+r+","+k+","+target);
        if(target<0 || step>500){
            return null;
        }
        if(target==0){
//            System.out.println("!!!!");
            return path;
        }

        for(int[] dir : dirs){
            int nextR = r+dir[0];
            int nextK = k+dir[1];
            if(isLegal(nextR, nextK) && !visited[nextR][nextK]){
                visited[nextR][nextK] = true;
                path.add(new int[]{nextR, nextK});
//                System.out.println("?"+nextR+","+nextK+","+val[nextR][nextK]);
                List<int[]> res = dfs(nextR, nextK, target-val[nextR][nextK], path, step+1, visited);
                if(res!=null){
                    return res;
                }
                visited[nextR][nextK] = false;
                path.remove(path.size()-1);
            }
        }
        return null;
    }

    public static boolean isLegal(int r, int k){
        return r>=1 && k>=1 && k<=r;
    }

    public static void calc(){
        val[1][1] = 1;
        for(int r=2; r<=501; r++){
            for(int k=1; k<=r; k++){
                val[r][k] = (k-1>=0 ? val[r-1][k-1] : 0) + (k<=r-1 ? val[r-1][k] : 0);
            }
        }
    }
}
