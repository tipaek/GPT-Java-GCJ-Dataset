import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();
        for (int i = 1; i <= t; ++i) {
            String n = in.nextLine();
            String n2 = n;
            int m = Integer.parseInt(n);
            int length=n.length();
            int offset=0;
            for(int j=0;j<length;j++){
                int posi= Integer.parseInt(n2.charAt(j)+"");
                for(int k=1;k<=posi;k++){
                    if(j==0){
                        n="("+n;
                    }else if(j==length+offset-1){
                        n= n.substring(0,length+offset-1)+"("+n.substring(length+offset-1,length+offset);
                    }else
                    {
                     n=n.substring(0,j+offset)+"("+n.substring(j+offset,length+offset);
                    }

                    offset=n.length()-length;
                }
                
                for(int k=1;k<=posi;k++){
                    if(j==0){
                        n=n.substring(0,j+offset+1)+")"+n.substring(j+offset+1,offset+length);
                    }else if(j==length+offset-1){
                        n= n+")";
                    }else
                    {
                    n=n.substring(0,j+offset+1)+")"+n.substring(j+offset+1,length+offset);
                    }
                    offset=n.length()-length;
                }
                offset=n.length()-length;


            }

            System.out.println("Case #" + i + ": " + n);
        }
    }
}