import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import java.math.*;
import java.util.*;
import java.io.*;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.io.OutputStreamWriter;

public class Solution{
    static Scanner sc;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int t = sc.nextInt();
        int b = sc.nextInt();
        //System.out.println("t: " + t + " b: " + b);
        for(int casenum = 1; casenum <= t; casenum++) {
            System.out.println("Starting test case: " + casenum);
            if(!qualhelper(b)) break;
        }
    }
    
    public static boolean qualhelper(int b){
        //System.out.println("inside qualhelper");
        if(b<=10){
            StringBuilder sb = new StringBuilder();
            PrintWriter writer  = new PrintWriter(System.out); 
            for(int k=1; k<=b; k++){
                writer.write(k);
                writer.flush();
                //System.out.println(k);
                //System.out.flush();
                int val = readInt();
                sb.append(val);
                //System.out.println("Value at "+ k +" is " + val);
            }
            writer.write(sb.toString());
            writer.flush();
            //System.out.println(sb.toString());
            //System.out.flush();
            String res = readString();
            //System.out.println("Outcome is " + res);
            return res == "Y";
        }
        return false;
    }
    public static int readInt(){
        int i = sc.nextInt();
        return i;
    }
    public static String readString(){
        String s = sc.next();
        return s;
    }
}
