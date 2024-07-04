import java.io.*;
import java.util.*;
class Solution{
    public static void main(String args[]){
        FastReader sc=new FastReader();
        int t=sc.nextInt();
        int val = t;
        while(t-->0){
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for(int i = 0; i < n;i++){
                for(int j = 0;j<n;j++){
                    arr[i][j] = sc.nextInt();
                }
            }
            int i = 0,j=0;
            int sum = 0;
            while(i<n && j<n){
                sum += arr[i][j];
                i++;
                j++;
            }
            int row = 0;
            HashSet<Integer> hs = new HashSet<>();
            for(int[] x: arr){
                for(int y :x){
                    if(hs.add(y) == false){
                        row++;
                        break;
                    }
                }
                hs.clear();
            }
            hs.clear();
            int col = 0;
            for(int m = 0; m < n;m++){
                for(int h = 0;h<n;h++){
                    if(hs.add(arr[h][m]) == false){
                        col++;
                        break;
                    }
                }
                hs.clear();
            }
            System.out.println("Case #"+(val-t)+": "+sum+" "+row+" "+col);
        }
    }
}
class FastReader 
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