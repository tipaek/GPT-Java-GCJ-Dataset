import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = in.nextInt();
        for (int x = 0; x < t; x++) {
            int n = in.nextInt();
            int d = in.nextInt();
            long[] slices = new long[n];

            for(int i = 0; i < n; i++){
                slices[i] = in.nextLong();
            }
            int ans = 0;
            if(d==2){
                if(unique(slices)==1) ans = 1;
                else ans = 0;
            }
            if(d==3){
                int count = unique(slices);
                if(count==1){
                    if(doubleexists(slices)) ans = 1;
                    else ans = 2;
                } else if(count == 2){
                    ans = 1;
                } else{
                    ans = 0;
                }
            }

            System.out.println("Case #" + (x + 1) + ": "+ans);
        }
    }

    static int unique(long[] slices){
        int ret = -1;
        for(int i = 0; i < slices.length; i++){
            int counter = 0;
            for(int j = i; j < slices.length; j++){
                if(slices[j]==slices[i]) counter++;
            }
            if(counter>0) ret = Math.max(counter, ret);
        }
        return ret;
    }

    static boolean doubleexists(long[] slices){
        for(int i = 0; i < slices.length; i++){
            int counter = 0;
            for(int j = 0; j < slices.length; j++){
                if(slices[j]==slices[i]*2) return true;
            }
        }
        return false;
    }
}

