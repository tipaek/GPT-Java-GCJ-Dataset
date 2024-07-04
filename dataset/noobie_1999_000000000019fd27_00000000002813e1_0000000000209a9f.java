import java.io.*;
import java.util.*;

class Solution{
    public static void main(String[] args) throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine()), c_no = 1;
        while(t-->0){
            String str = in.readLine();
            int i = 0;
            System.out.print("Case #"+c_no+": ");
            int prev = 0, depth = 0, diff = 0;
            for(;i<str.length();i++){
                int curr = Integer.parseInt(String.valueOf(str.charAt(i)));
                diff = prev-curr;
                if(diff==0)
                    System.out.print(curr);
                else if(diff>0){
                    for(int j=0;j<diff;j++){
                        System.out.print(')');
                        depth--;
                    }
                    System.out.print(curr);
                }
                else if(diff<0){
                    /*while(depth-->0){
                        System.out.print(')');
                    }
                    for(int j=9;j<Math.abs(diff);j++){
                        System.out.print('(');
                        depth++;
                    }*/
                    for(int j=0;j<Math.abs(diff);j++){
                        System.out.print('(');
                        depth++;
                    }
                    System.out.print(curr);
                }
                prev = curr;
            }
            while(depth-->0)
                System.out.print(')');
            System.out.println();
            c_no++;
        }
    }
}