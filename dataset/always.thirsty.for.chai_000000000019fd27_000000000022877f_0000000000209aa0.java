import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int tt = t;
        while(t-->0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            if(k%n==0 && k/n<=n){
                System.out.println("Case #"+(tt-t)+": POSSIBLE");
                int start = k/n;
                for(int i=0;i<n;i++){
                    start = start==0?n:start;
                    int startin = start;
                    for(int j=0;j<n;j++){
                        startin = startin>n?1:startin;
                        if(j==n-1){
                            System.out.print(startin);
                        }
                        else
                            System.out.print(startin+" ");
                        startin++;
                    }
                    System.out.println();
                    start--;
                }
            }
            else{
                System.out.println("Case #"+(tt-t)+": IMPOSSIBLE");
            }
        }
    }
}