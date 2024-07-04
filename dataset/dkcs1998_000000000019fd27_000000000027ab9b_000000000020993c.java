/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 *
 * @author User
 */
class CJ_2020_Qualifier_1 
{
    static class FastReader {
        
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
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

    static class Var {

        int a, b;

        Var(int x, int y) {
            a = x;
            b = y;
        }
    }
    
    static class Comp implements Comparator<Var> {

        public int compare(Var o1, Var o2) {
            if (o1.b < o2.b) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int t = sc.nextInt();
        int kt=1;
        while(kt<=t)
        {
            int n=sc.nextInt();
            int a[][]=new int[n][n];
            
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                    a[i][j]=sc.nextInt();
            }
            int sum=0;
            for(int i=0;i<n;i++)
                sum+=a[i][i];
            
            int countR=0,countC=0;
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> hs=new HashSet();                
                for(int j=0;j<n;j++)
                {
                    if(hs.contains(a[i][j]))
                    {
                        ++countR;
                        break;
                    }
                    hs.add(a[i][j]);
                }
            }
            for(int i=0;i<n;i++)
            {
                HashSet<Integer> hs=new HashSet();                
                for(int j=0;j<n;j++)
                {
                    if(hs.contains(a[j][i]))
                    {
                        ++countC;
                        break;
                    }
                    hs.add(a[j][i]);
                }
            }
            
            System.out.println("Case #"+kt+":" +sum+" "+countR+" "+countC);
            ++kt;
        }
        
    }
    
}
