import java.util.*;

import javax.lang.model.util.ElementScanner6;

public class Solution {
    public static long getStart(long z){
        long start = 1L;
        long temp = 1l;
        while(temp < z){
            start *= 2L;
            temp += start;
            
        }
        return(start);
    }
    public static int abs(int x){
        if(x > 0){
            return x;
        }
        else{
            return( x * -1);
        }
    }
    public static void main(String[] args)  {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            int x1 = x;
            int y1 = y;
            long z = new Long(x);
            if(x < 0){
                z *= -1L;
                x1 *= -1;
            }
            if(y < 0){
                z -= new Long(y);
                y1 *= -1;
            }
            else
                z += new Long(y);
            long r = z % 2L;
            long c = 0L;
            //System.out.println(z);
            
            if(r != c){
                String ans = "";
                long start = getStart(z);
               // System.out.println(start);
                while(true){
                    if(x1 == 0 && y1 == 0){
                        break;
                    }
                    ///System.out.println(x1 + " "+ y1);
                    if(abs(x1) > abs(y1)){
                        if(x1 > 0){
                            x1 -= start;
                            ans += 'E';
                        }
                        else{
                            x1 += start;
                            ans += 'W';
                        }
                    }else{
                        if(y1 > 0){
                            y1 -= start;
                            ans += 'N';
                        }
                        else{
                            y1 += start;
                            ans += 'S';
                        }
                    }
                   
                     start /= 2L;
                }
                StringBuilder sb = new StringBuilder(ans);
                sb.reverse();
                ans = new String(sb);
               // System.out.println(sb);
                if(x >= 0 && y >= 0){
                    System.out.println("Case #"+i+": "+ans);
                }else if(x < 0 && y >= 0){
                    int len = ans.length();
                    String temp1 = "";
                    for(int k = 0;k < len;k++){
                        if(ans.charAt(k) == 'E')
                            temp1 += 'W';
                        else if(ans.charAt(k) == 'W')
                            temp1 += 'E';
                        else 
                            temp1 += ans.charAt(k);
                    }
                    System.out.println("Case #"+i+": "+temp1);
                }else if(x >= 0 && y < 0){
                    int len = ans.length();
                    String temp1 = "";
                    for(int k = 0;k < len;k++){
                        if(ans.charAt(k) == 'N')
                            temp1 += 'S';
                        else if(ans.charAt(k) == 'S')
                            temp1 += 'N';
                        else 
                            temp1 += ans.charAt(k);
                    }
                    System.out.println("Case #"+i+": "+temp1);
                }else{
                    int len = ans.length();
                    String temp1 = "";
                    for(int k = 0;k < len;k++){
                        if(ans.charAt(k) == 'E')
                            temp1 += 'W';
                        else if(ans.charAt(k) == 'W')
                            temp1 += 'E';
                        else if(ans.charAt(k) == 'N')
                            temp1 += 'S';
                        else
                            temp1 += 'N';
                    }
                    System.out.println("Case #"+i+": "+temp1);
                }
            }
            else{
                System.out.println("Case #"+i+": IMPOSSIBLE");
            }
            
        }
        in.close();
    }
}