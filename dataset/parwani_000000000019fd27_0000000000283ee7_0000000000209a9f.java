import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Solution {

    public static void main(String args[]) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int test = Integer.parseInt(br.readLine());
            for(int t=0;t<test;t++) {
                String in = br.readLine();
                balance(in,t+1);
            }
        }
        catch (Exception e){

        }
    }
    public static void balance(String in , int t) {


        StringBuffer sb = new StringBuffer();
        int open = 0;

        open = Integer.parseInt(String.valueOf(in.charAt(0)));
        for(int i=0;i<Integer.parseInt(String.valueOf(in.charAt(0)));i++) {
            sb.append("(");
        }
        sb.append(String.valueOf(in.charAt(0)));
        for(int i=1;i<in.length();i++) {
            if(Integer.parseInt(String.valueOf(in.charAt(i-1))) > Integer.parseInt(String.valueOf(in.charAt(i)))) {
                int diff = Integer.parseInt(String.valueOf(in.charAt(i-1))) - Integer.parseInt(String.valueOf(in.charAt(i)));
                for(int j=0;j<diff;j++) {
                    sb.append(")");
                }
                sb.append(in.charAt(i));
                open-=diff;
            }
            else if(Integer.parseInt(String.valueOf(in.charAt(i-1))) < Integer.parseInt(String.valueOf(in.charAt(i)))) {
                int diff = Integer.parseInt(String.valueOf(in.charAt(i))) - Integer.parseInt(String.valueOf(in.charAt(i-1)));
                for(int j=0;j<diff;j++) {
                    sb.append("(");
                }
                sb.append(in.charAt(i));
                open+=diff;
            }
            else {
                sb.append(in.charAt(i));
            }
        }
        for(int i=0;i<open;i++) {
            sb.append(")");
        }
        System.out.println("Case #"+t+": "+sb.toString());
    }


}