import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(f.readLine());
        int tt = t;
        while(t --> 0){
            int n = Integer.parseInt(f.readLine());
            out.println("Case #" + (tt-t) + ":");
            if(n == 1){
                out.println("1 1");
                continue;
            }
            if (n == 2) {
                out.println("1 1");
                out.println("1 2");
                continue;
            }
            if(n % 2 == 0){
                for(int i = 0; i < n/2; i++){
                    out.println((i+1) + " 1");
                }
                out.println(((n/2)+1) + " 2");
            }else{
                for(int i = 0; i < n/2; i++){
                    out.println((i+1) + " 1");
                }
                out.println(((n/2)+1) + " 1");
                out.println(((n/2)+1) + " 2");
            }
        }


        out.close();
    }
}
