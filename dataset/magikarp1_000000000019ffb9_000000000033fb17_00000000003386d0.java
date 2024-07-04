import java.io.*;
import java.util.*;

public class Solution{
    public static int gcd(int a, int b){
        if(b == 0)
            return a;
        if(a == 0)
            return b;
        return gcd(b, a%b);
    }
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int trial = 1; trial <= t; trial++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            HashSet<int[]> points = new HashSet<int[]>();
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int[] temp = new int[2];
                temp[0] = Integer.parseInt(st.nextToken());
                temp[1] = Integer.parseInt(st.nextToken());
                points.add(temp);
            }
            HashMap<Long,HashSet<int[]>> slopes = new HashMap<Long,HashSet<int[]>>();
            for(int[] a: points){
                for(int[] b: points){
                    if(a[0] >= b[0] && (a[0] != b[0] || a[1] != b[1])){
                        int[] temp = new int[2];
                        int div = gcd(a[0]-b[0],Math.abs(a[1]-b[1]));
                        temp[0] = (a[0] - b[0])/div;
                        temp[1] = (a[1]-b[1])/div;
                        long coord = (long)temp[0]*2000000001 + temp[1];
                        if(slopes.keySet().contains(coord)){
                            slopes.get(coord).add(a);
                            slopes.get(coord).add(b);
                        }
                        else{
                            HashSet<int[]> stuff = new HashSet<int[]>();
                            stuff.add(a);
                            stuff.add(b);
                            slopes.put(coord,stuff);
                        }
                    }
                }
            }
            int max = 0;
            for(long l : slopes.keySet()){
                max = Math.max(max,slopes.get(l).size());
            }
            System.out.println("Case #" + trial + ": " + Math.min(N,max+2));
        }
    }
}