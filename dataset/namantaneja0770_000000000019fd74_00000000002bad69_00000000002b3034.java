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
            int n = s.nextInt();
            Boolean ok = true;
            StringBuilder sb = new StringBuilder();
            String[] arr = new String[n];
            for(int i = 0;i<n;i++){
                arr[i] = s.next();
            }
            for(int i = 0;i<n;i++){
                String str = arr[i];
                if(i==0){
                    sb.append(str.substring(1, str.length()));
                }else{
                    int j = str.length()-1;
                    int k = sb.length()-1;
                    Boolean flag = true;
                    while(j>0 && k>=0){
                        char c=sb.charAt(k);
                        // System.out.println(c);
                        // System.out.println(str.charAt(j));
                        if(str.charAt(j)!=c){
                            flag = false;
                            // System.out.println("hi");
                            break;
                        }else{
                            --j;
                            --k;
                        }
                    }
                    if(!flag){
                        ok = false;
                        break;
                    }
                    if(j>0){
                        // System.out.println(j);
                        sb.reverse();
                        StringBuilder temp = new StringBuilder();
                        temp.append(str.substring(1, j+1));
                        temp.reverse();
                        sb.append(temp);
                        sb.reverse();
                    }
                }      
            }
            if(!ok){
                System.out.println("Case #" + u + ": *");
                continue;
            }else{
                System.out.println("Case #" + u + ": " + sb.toString());
            }
        }
        out.close();
    }

}