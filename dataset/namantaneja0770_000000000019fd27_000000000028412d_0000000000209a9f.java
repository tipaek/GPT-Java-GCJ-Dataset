import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.BufferedOutputStream;

public class Solution{

    static class FastReader 
    { 
        BufferedReader br; 
        StringTokenizer st; 
  
        public FastReader() 
        { 
            br = new BufferedReader(new InputStreamReader(System.in)); 
        } 
  
        String next() 
        { 
            while (st == null || !st.hasMoreElements()) 
            { 
                try
                { 
                    st = new StringTokenizer(br.readLine()); 
                } 
                catch (IOException  e) 
                { 
                    e.printStackTrace(); 
                } 
            } 
            return st.nextToken(); 
        } 
  
        int nextInt() 
        { 
            return Integer.parseInt(next()); 
        } 
  
        long nextLong() 
        { 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble() 
        { 
            return Double.parseDouble(next()); 
        } 
  
        String nextLine() 
        { 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
    }
    public static PrintWriter out;
    public static void printArr(int[] arr){
        for(int i = 0;i<arr.length;i++){
            out.print(arr[i] + " ");
        }
        out.println();
    }
    public static void main(String[] args){
        FastReader s = new FastReader();
        out=new PrintWriter (new BufferedOutputStream(System.out));
        int t = s.nextInt();
        for(int u = 1;u<=t;u++){
            String str = s.next();
            StringBuilder sb = new StringBuilder();
            int stepUp = 0;
            for(int i = 0;i<str.length();i++){
                if(Integer.parseInt(String.valueOf(str.charAt(i)))>stepUp){
                    int x = (Integer.parseInt(String.valueOf(str.charAt(i)))-stepUp);
                    for(int j = 0;j<x;j++){
                        // System.out.println("stepup " + stepUp);
                        // System.out.println(j);
                        sb.append('(');
                        stepUp++;
                    }
                }else if(Integer.parseInt(String.valueOf(str.charAt(i)))<stepUp){
                    int x = (stepUp-Integer.parseInt(String.valueOf(str.charAt(i))));
                    for(int j = 0;j<x;j++){
                        sb.append(')');
                        stepUp--;
                    }
                }else{
                    //
                }
                sb.append(str.charAt(i));
            }
            while(stepUp>0){
                sb.append(')');
                stepUp--;
            }
            System.out.println("Case #" + u + ": " + sb.toString());
        }
        // out.close();
    }

}