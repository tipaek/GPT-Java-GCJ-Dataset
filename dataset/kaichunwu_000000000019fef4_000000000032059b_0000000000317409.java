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
        Arr start = new Arr(n,m);
        // int[] pos = new int[]{0,0};
        Queue<Arr> next = new LinkedList<>();
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
            int min = Integer.MAX_VALUE;
            Set<Arr> set = new HashSet<>();
            while(sz-->0) {
                Arr pos = next.poll();
                // System.out.println(pos[0]+" "+pos[1]);
                pos.x+=ad[0];
                pos.y+=ad[1];
                int dis = Math.abs(pos.x)+Math.abs(pos.y);
                if(dis<min) {set.clear();set.add(pos);min = dis;}
                else if(dis==min) set.add(pos);
                if(dis==0) return ""+(step+1);
                for(int i = 0;i < 4;++i) {
                    dis = Math.abs(pos.x+dir[i][0])+Math.abs(pos.y+dir[i][1]);
                    if(dis==0) return ""+(step+1);
                    if(dis<min) {
                        set.clear();
                        set.add(new Arr(pos.x+dir[i][0],pos.y+dir[i][1]));
                        min = dis;
                    }else if(dis==min) {
                        set.add(new Arr(pos.x+dir[i][0],pos.y+dir[i][1]));
                    }
                }
            }
            for(Arr nx : set) next.offer(nx);
            step++;
        }
        return "IMPOSSIBLE";
    }
}
class Arr {
    int x;
    int y;
    Arr(int x,int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public int hashCode() {
        return x*2001+y;
    }
    @Override
    public boolean equals(Object o) {
        if(o instanceof Arr) {
            Arr a = (Arr) o;
            return a.x==this.x&&a.y==this.y;
        }
        return false;
    }
}