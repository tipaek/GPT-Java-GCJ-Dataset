/**
 * Author: Rohan Arora(codiinggeek)
 */

import java.io.*;
import java.util.*;

public class Solution {
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

        public static void main(String[] args) {
            try {
                FastReader s = new FastReader();
                int t = s.nextInt();
                for(int q=1;q<=t;q++)
                {
                    int n=s.nextInt();
                    int arr[][]=new int[2][n];
                    int arr1[][]=new int[2][n];
                    
                    for(int i=0;i<n;i++)
                    {
                        arr[0][i]=s.nextInt();
                        arr[1][i]=s.nextInt();

                        arr1[0][i]=arr[0][i];
                        arr1[1][i]=arr[1][i];
                    }
                    
                    for(int i=0;i<n;i++)
                    {
                        for(int j=i;j<n;j++)
                        {
                            if(arr[0][i]>arr[0][j])
                            {
                                int u = arr[0][i];
                                arr[0][i] = arr[0][j];
                                arr[0][j] = u;
                                u = arr[1][i];

                                arr[1][i] = arr[1][j];
                                arr[1][j] = u;
                            }
                        }
                    }
                    
                    char ar[]=new char[n];
                    char ar1[]=new char[n];
                    int c= arr[1][0];
                    int j = 0;
                    ar[0]='C';
                    int i = 0;
                    for(i=1;i<n;i++)
                    {
                        if(arr[0][i]>=c)
                        {
                            c=arr[1][i];
                            ar[i]='C';
                        }
                        else if(arr[0][i]>=j)
                        {
                            j=arr[1][i];
                            ar[i]='J';
                        }
                        else
                            break;
                    }

                    boolean check[] = new boolean[n];
                    for(int k=0;k<n;k++)
                        check[k]=false;
                    if(i==n)
                    {
                        for(int x=0;x<n;x++)
                        {
                            for(int y=0;y<n;y++)
                            {
                                if(arr1[0][x]==arr[0][y] && arr1[1][x]==arr[1][y] && check[y]==false)
                                {
                                    check[y]=true;
                                    ar1[x]=ar[y];
                                    break;
                                }
                            }
                        }
                        System.out.print("Case #"+q+": ");
                        for(int k=0;k<n;k++)
                            System.out.print(ar1[k]);
                        System.out.println("");
                    }
                    else
                        System.out.println("Case #"+q+": IMPOSSIBLE");
                }
            }
            catch(Exception e)
            {
                return;
            }
    }
}
