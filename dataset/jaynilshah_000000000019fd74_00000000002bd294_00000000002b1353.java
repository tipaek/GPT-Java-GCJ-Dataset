


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int tt = 1; tt <= t; ++tt) {
            int n = in.nextInt();
            if(n<=500){
                System.out.println("Case #" + tt + ": ");
                for(int i=1;i<=n;i++){
                    System.out.println(i + " " + 1);
                }
            }
            else {
                System.out.println("Case #" + tt + ": ");
                System.out.println(1 + " " + 1);
                System.out.println(2 + " " + 1);
                System.out.println(3 + " " + 2);
                int count = n-4;
                int start = 0;
                for(int i=4;i<=n-2;i++){
                    if(count - i+1>=0){
                        System.out.println(i + " " + 2);
                        count -= i-1;
                        start = i;
                    }
                    else {
                        break;
                    }
                }
                while (count>0){
                    System.out.println(start + " " + 1);
                    start++;
                    count--;
                }
            }
        }
    }
}

