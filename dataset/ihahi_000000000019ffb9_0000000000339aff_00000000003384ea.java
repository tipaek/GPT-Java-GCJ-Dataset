import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = sc.nextInt();
        for(int t=1;t<=T;t++){
            System.out.print("Case #" + t + ": ");
            solve(sc);
        }
    }
    private static void solve(Scanner sc){
        long L = sc.nextLong();
        long R = sc.nextLong();
        long now=1;
        while(canServe(now, L, R)){
            if(L < R){
                R -= now;
            }else{
                L -= now;
            }
            now++;
        }
        System.out.println(now-1 + " " +  L + " " + R);
    }

    private static boolean canServe(long now, long L, long R){
        if(L < R){
            return R >= now;
        }else{
            return L >= now;
        }
    }
}
