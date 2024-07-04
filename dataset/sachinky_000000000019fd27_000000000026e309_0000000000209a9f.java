/*package whatever //do not write package name here */

import java.io.*;

import java.util.*;

class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int tc = Integer.parseInt(sc.nextLine());
        for(int t=1;t<=tc;t++){
            String num = sc.nextLine();
            int op = 0;
            StringBuilder out = new StringBuilder();
            for(int i=0;i<num.length();i++){
                int digit = num.charAt(i)-'0';
                int count = digit - op;
                if(count > 0)
                {
                    op += count;
                    for(int c=0;c<count;c++)
                        out.append('(');
                    // out.append(digit);
                }
                else if(count < 0)
                {
                    count = op-digit;
                    op -= count;
                    for(int c=0;c<count;c++)
                        out.append(')');
                    // out.append(digit)
                }
                out.append(digit);
                // System.out.println(num.charAt(i));
            }
            if(op==1)
                out.append(')');
            System.out.println("Case #"+t+": "+out);
        }
    }
}