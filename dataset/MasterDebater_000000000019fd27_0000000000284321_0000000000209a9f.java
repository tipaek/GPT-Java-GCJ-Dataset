import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args)throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new PrintStream(System.out));

        int t=Integer.parseInt(in.readLine());
        for(int test=1;test<=t;test++){
            char[]arr=in.readLine().toCharArray();
            out.print("Case #"+test+": ");
            int bracketDelta=0;
            for(int i=0;i<arr.length;i++){
                for(;bracketDelta<(int)arr[i]-'0' && bracketDelta!=(int)arr[i]-'0';bracketDelta++){
                    out.print("(");
                }
                for(;bracketDelta>(int)arr[i]-'0' && bracketDelta!=(int)arr[i]-'0';bracketDelta--){
                    out.print(")");
                }
                out.print(arr[i]);
            }
            for(int j=0;j<bracketDelta;j++){
                out.print(")");
            }
            out.println();

        }

        in.close();
        out.close();
    }
}