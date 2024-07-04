import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = sc.nextInt();
        for (int k=1;k<=t;k++) {
            int a=sc.nextInt();
            int b=sc.nextInt();
            if(a==b &&a==(int)1E9-5){
                try{
                    for(int i=-5;i<=5;i++)
                        for(int j=-5;j<=5;j++){
                            System.out.println(i+" "+j);
                            String c=sc.next();
                            if(c.equals("CENTER"))
                                throw new IOException();
                        }
                    
                }
                catch(Exception e){
                    continue;
                }
            }
            
            // System.out.println("Case #"+k+": "+sp);
            //process(r,b,c);
        }
    }
    }