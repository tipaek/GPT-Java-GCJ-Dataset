import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

public class Solution {
    public static void main(String[] args){
        FastScanner sc = new FastScanner(); // fast scanner 
        PrintWriter out = new PrintWriter(System.out);
            int test = sc.nextInt();
            for(int tc=1;tc<=test;tc++)
            {
              int n = sc.nextInt();
              int arr[][] = new int[n][n];
              int trace =0;
              for(int i=0;i<n;i++)
              {
                for(int j=0;j<n;j++)
                {
                  if(i==j)
                  {
                    int x = sc.nextInt();
                    arr[i][j] =x;
                    trace+=x;
                  }
                  else
                    arr[i][j]=sc.nextInt();
                }
              }
              int rowx=0;
              int colx=0;
              // row count
              for(int col =0;col<n;col++)
              {
                Map<Integer,Integer> hmap = new HashMap<>();
                boolean flag=false;
                for(int row=0;row<n;row++)
                {
                  if(hmap.containsKey(arr[row][col])==true)
                  {
                      flag = true;
                      hmap.put(arr[row][col],hmap.get(arr[row][col])+1);
                  }
                  else
                    hmap.put(arr[row][col],1);
                }
                if(flag ==true)
                  rowx++;
              }
              // col count
            for(int row =0;row<n;row++)
              {
                Map<Integer,Integer> hmap = new HashMap<>();
                boolean flag=false;
                for(int col=0;col<n;col++)
                {
                  if(hmap.containsKey(arr[row][col])==true)
                  {
                      flag = true;
                      hmap.put(arr[row][col],hmap.get(arr[row][col])+1);
                  }
                  else
                    hmap.put(arr[row][col],1);
                }
                if(flag ==true)
                  colx++;
              }
              out.println("Case #"+tc+": "+trace+" "+colx+" "+rowx);

            }
            


        out.flush();
        
    } // end main mehtod
    
    public static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(String s) {
            try {
                br = new BufferedReader(new FileReader(s));
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String nextToken() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(nextToken());
        }

        long nextLong() {
            return Long.parseLong(nextToken());
        }

        double nextDouble() {
            return Double.parseDouble(nextToken());
        }
    }
}