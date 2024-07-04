


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
            StringBuilder ans = new StringBuilder();
            int n = in.nextInt();
            int an[] = new int[n];
            ArrayList<int[]> a = new ArrayList<>();
            for(int i=0;i<n;i++){
                a.add(new int[]{in.nextInt(),in.nextInt(),i});
            }
            Collections.sort(a,(x,y)->x[0]-y[0]);
            int c = 0;
            int j = 1;
            an[a.get(0)[2]] = 0;
            an[a.get(1)[2]] = 1;
            boolean set = true;

            for(int i=2;i<n;i++){
                int st = a.get(i)[0];
//                System.out.println(st);
                if(st>=a.get(c)[1]){
                    an[a.get(c)[2]] = 0;
                    c = i;
                }
                else if(st>=a.get(j)[1]){
                    an[a.get(j)[2]] = 1;
                    j = i;
                }
                else {
                    set = false;
                    break;
                }
            }

            if(!set){
                ans.append("IMPOSSIBLE");
            }
            else {
                for(int i=0;i<n;i++){
                    if(an[i]==1)ans.append("J");
                    else ans.append("C");
                }
            }

            System.out.println("Case #" + tt + ": " +ans.toString());
        }
    }
}

