import java.util.*;
import java.io.*;
/**
 * CODEJAM20_2
 */
class Solution {

    static class FastReader 
        { 
            BufferedReader br; 
            StringTokenizer st; 
      
            public FastReader() 
            { 
                br = new BufferedReader(new
                         InputStreamReader(System.in)); 
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

    public static void main(String[] args) {
        FastReader sc=new FastReader();
        int t=sc.nextInt();
        for(int w=1;w<=t;w++){
            String s=sc.nextLine();
            int count=0;
            String ans="";
            for(int i=0;i<s.length();i++){
                int p=Character.getNumericValue(s.charAt(i));
                if(p>count){
                    for(int j=count;j<p;j++){
                        ans+="(";
                        count++;
                    }
                }
                if(p==count)
                    ans+=p;
                if(i<s.length()-1){    
                    p=Character.getNumericValue(s.charAt(i+1));
                    if(p<count){
                        for(int j=count;j>p;j--){
                            ans+=")";
                            count--;
                        }
                    }
                }
                else{
                    for(int j=count;j>0;j--){
                        ans+=")";
                        count--;
                    }
                }
                
            }
            
            System.out.println("Case #"+w+": "+ans);
        }
    }
}