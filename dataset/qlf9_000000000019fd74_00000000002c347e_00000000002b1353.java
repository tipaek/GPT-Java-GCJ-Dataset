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
            if(n < 20){
                for(int i = 0; i < n; i++){
                    out.println((i+1) + " 1");
                }
                continue;
            }
            out.println("1 1\n2 1\n3 2\n4 2\n4 1");
            n-=8;
            int i = 4;
            while(true){
                if(n == i){
                    out.println((i+1) + " 2");
                    break;
                }else if(n == i+1){
                    out.println((i+1) + " 1");
                    out.println((i+1) + " 2");
                    break;
                }
                out.println((i+1) + " 1");
                n--;
                i++;
            }

        }


        out.close();
    }
}
