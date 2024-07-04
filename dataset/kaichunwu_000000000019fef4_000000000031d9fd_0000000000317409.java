import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int time = Integer.valueOf(in.readLine());
        for(int i = 0;i < time;++i) {
            String[] firstMultipleInput = in.readLine().replaceAll("\\s+$", "").split(" ");
            int n = Integer.parseInt(firstMultipleInput[0]);
            int m = Integer.parseInt(firstMultipleInput[1]);
            String s = firstMultipleInput[2];
            
            System.out.println("Case #"+(i+1)+": "+solve(n,m,s));
        }
    }
    private static String solve(int n,int m,String s) {
        int[] start = new int[]{n,m};
        // int[] pos = new int[]{0,0};
        Queue<int[]> next = new LinkedList<>();
        next.offer(start);
        int step = 0;
        int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
        while(step<s.length()) {
            int sz = next.size();
            int[] ad;
            if(s.charAt(step)=='N') {
                ad = new int[]{0,1};
            }else if(s.charAt(step)=='S') {
                ad = new int[]{0,-1};
            }else if(s.charAt(step)=='E') {
                ad = new int[]{1,0};
            }else {
                ad = new int[]{-1,0};
            }
            while(sz-->0) {
                int[] pos = next.poll();
                pos[0]+=ad[0];
                pos[1]+=ad[1];
                int min = Math.abs(pos[0])+Math.abs(pos[1]);
                if(min==0) return ""+(step+1);
                Set<int[]> set = new HashSet<>();
                set.add(pos);
                for(int i = 0;i < 4;++i) {
                    int dis = Math.abs(pos[0]+dir[i][0])+Math.abs(pos[1]+dir[i][1]);
                    if(dis==0) return ""+(step+1);
                    if(dis<min) {
                        set.clear();
                        set.add(new int[]{pos[0]+dir[i][0],pos[1]+dir[i][1]});
                        min = dis;
                    }else if(dis==min) {
                        set.add(new int[]{pos[0]+dir[i][0],pos[1]+dir[i][1]});
                    }
                }
                for(int[] nx : set) next.offer(nx);
            }
            step++;
        }
        return "IMPOSSIBLE";
    }
}