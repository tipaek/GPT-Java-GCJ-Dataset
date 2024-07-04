import java.io.*;
import java.util.*;
public class Solution {
    static int[][]tri;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        tri = new int[501][501];
        for (int i = 1; i < 501; i++) {
            tri[i][1]=1;
            tri[i][i]=1;
        }
        for (int i = 0; i < T; i++) {
            System.out.println("Case #"+(i+1)+": ");
            solve(in);
        }
    }
    public static void solve(Scanner in){
        int num = in.nextInt();
        ArrayList<point>path = new ArrayList<>();
        //boolean[][]added = new boolean[500][500];
        int sum = 1;
        int r = 1;
        int k = 0;
        path.add(new point(1,1));
        while(true){
            r++;
            k++;
            sum+=pascal(r,k);
            if(sum>=num){
                sum-=pascal(r,k);
                break;
            }
            path.add(new point(r,k));
        }
        r-=2;
        k--;
        while(sum!=num){
            r++;
            k++;
            sum++;
            path.add(new point(r,k));
        }
        for (point point : path) {
            System.out.println(point.r + " " + point.k);
        }


    }
    public static int pascal(int r, int k){
        if(tri[r][k]!=0){
            return tri[r][k];
        }
        tri[r][k] = pascal(r-1,k-1)+pascal(r-1,k);
        return tri[r][k];
    }
    static class point{
        int r,k;
        public point(int r1, int k1){
            r = r1;
            k = k1;
        }
    }
}
