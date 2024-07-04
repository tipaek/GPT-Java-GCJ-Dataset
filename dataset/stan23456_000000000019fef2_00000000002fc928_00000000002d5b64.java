import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(br.readLine());
        //System.out.println(7);
        //System.out.println(8);
        for(int i=1;i<=t;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()); int c = Integer.parseInt(st.nextToken());
            System.out.println("Case #"+i+": "+ ((r-1)*(c-1)));
            int ct = 0;
            for(int x = r-1; x>=1; x--){
                for(int y=0;y<=c-2;y++){
                    System.out.println((r*(c-1)-ct)+" "+x);
                    ct++;
                }
            }

        }


    }
}