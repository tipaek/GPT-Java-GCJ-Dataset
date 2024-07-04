import java.util.*;
import java.io.*;
/**
 * CODEJAM20_1
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
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            Map<Integer,Boolean> mp=new HashMap<>();
            int rowCount=0;
            for(int i=0;i<n;i++){
                mp.clear();
                for(int j=0;j<n;j++){
                    a[i][j]=sc.nextInt();
                }
            }
            
            for(int i=0;i<n;i++){
                mp.clear();
                for(int j=0;j<n;j++){
                    if(mp.containsKey(a[i][j])){
                        rowCount++;
                        break;
                    }
                    else{
                        mp.put(a[i][j],true);
                    }
                }
            }

            int colCount=0;
            for(int i=0;i<n;i++){
                mp.clear();
                for(int j=0;j<n;j++){
                    if(mp.containsKey(a[j][i])){
                        colCount++;
                        break;
                    }
                    else{
                        mp.put(a[j][i],true);
                    }
                }
            }
            long trace=0;
            for(int i=0;i<n;i++){
                trace+=a[i][i];
            }
            System.out.println("Case #"+w+": "+trace+" "+rowCount+" "+colCount);
        }
    }
}