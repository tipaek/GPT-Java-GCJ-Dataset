import java.io.*;
import java.util.*;
public class Solution{
    public static void main(String[] args) throws IOException {
        long t = getLong();
        for(int i = 1; i <= t; i++){
            System.out.print("Case #" + i + ": ");
            long l = getLong();
            long r = getLong();

            long a = Math.min(l, r);
            long b = Math.max(l, r);

           /** 
            * long n = (long) Math.floor(Math.sqrt(2 * (b - a) + 0.25d) - 0.5d);
            b -= n * (n + 1) / 2; 
           n++;

           double sp = 0.5d - n/4;
           long n2 = (long) Math.floor(Math.sqrt(b * 0.5d - sp * sp) + sp);
           long max = n + 2 * (n2 - 1);
           if((n2) * n + 2 * n2 * (n2 - 1) > b){
               max = n - 1;
           }
           else{
            b -= (n2) * n + 2 * n2 * (n2 - 1);
           }
          

           n++;
           sp = 0.5d - n/4;
           long n3 = (long) Math.floor(Math.sqrt(a * 0.5d - sp * sp) + sp);
           long max2 = n + 2 * (n3 - 1);
           if((n3) * n + 2 * n3 * (n3 - 1) > a){
               max = ;
           }
           else{
            a -= (n3) * n + 2 * n3 * (n3 - 1);
           }
        
           if(l < r){
               l = a;
               r = b;
           }
           else{
               l = b;
               r = a;
           }

           System.out.println(Math.max(Math.min(max, max2), n -2) + " " + l + " " + r);
        }*/ 
            
            long n = 1;
            while(Math.max(l, r) >= n){
                if(l >= r){
                    l -= n;
                }
                else{
                    r -= n;
                }
                n++;
            }

            System.out.println((n - 1) + " " + l + " " + r);
    }
}
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static long getLong() throws IOException{
        int c = skipSpace();
        boolean isNeg = (char) c == '-';
        long out = 0;
        if(isNeg)
          c = input.read();
        do {
          out *= 10;
          out += c - '0';
          c = input.read();
        } while (c <= '9' && c >= '0');
        return (isNeg)? -out: out;
      }
    public static int skipSpace() throws IOException{
        int s = input.read();
        while(s == ' ' || s == '\n' || s == '\r') {
          s = input.read();
        }
        return s;
      }
}