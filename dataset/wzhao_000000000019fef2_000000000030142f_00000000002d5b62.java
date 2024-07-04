import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter output = new PrintWriter(System.out);
        int T = Integer.parseInt(input.readLine());
        for(int t = 0; t < T; t++){
            output.print("Case #" + (t+1) + ": ");
            StringTokenizer st = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if((x+y)%2==0){
                output.println("IMPOSSIBLE");
                continue;
            }
            else if(Math.abs(x)+Math.abs(y)==1){
                if(x==1) output.println("E");
                if(x==-1) output.println("W");
                if(y==1) output.println("N");
                if(y==-1) output.println("S");
                continue;
            }
            long sum = Math.abs(x)+Math.abs(y);
            long iterations = 0;
            long num = 1;
            while(num<sum){
                iterations++;
                num*=2;
            }
            long total = (1<<iterations) - 1;
            long d = total - (x + y);
            d>>=1;
            String ret = "";
            for(int i = 0; i < iterations; i++){
                long a = 1<<i;
                if((d&a) != 0) a *= -1;
                a = a/Math.abs(a);
                if(x%2!=0){
                    if(a<0) ret += "W";
                    else ret += "E";
                    x -= a;
                }
                else{
                    if(a<0) ret += "S";
                    else ret += "N";
                    y -= a;
                }
                x/=2;
                y/=2;
            }
            output.println(ret);
        }
        output.flush();
        output.close();
    }
}