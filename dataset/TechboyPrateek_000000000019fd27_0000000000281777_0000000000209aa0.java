import java.util.*;
import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
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

    static int ans[][]= new int[100][100];
    static boolean ok=false;
    static int trace=0;
    public static void solve(int n){
        for (int i=1; i<=n && !ok; ++i) {
            for (int j=1; j<=n && !ok; ++j) {
                if (ans[i][j]==0) {
                    for (int l=1; l<=n && !ok; ++l) {
                        boolean flg = false;
                        for (int k=1; k<=n && !flg; ++k)
                            if (ans[i][k] == l) flg = true;
                        for (int k=1; k<=n && !flg; ++k)
                            if (ans[k][j] == l) flg = true;
                        if (flg) continue;
                        ans[i][j] = l;
                        solve(n);
                        ans[i][j] = 0;
                    }
                    return;
                }
            }
        }
        if (ok) return;
        int sum = 0;
        for (int i=1; i<=n; ++i)
            sum += ans[i][i];
        
        if ((sum-trace)!=0) return;
        System.out.print("POSSIBLE");
        System.out.println();
        for(int i=1;i<=n;++i){
            for(int j=1;j<=n;++j){
                if(j>1){
                    System.out.print(" ");
                }
                System.out.print(ans[i][j]);
            }
            System.out.println();
        }
        ok=true;
    }
    public static void main(String args[]) {
        FastReader sc= new FastReader();
        int tc=sc.nextInt();
        for(int test=1;test<=tc;++test){
            int n;
            n=sc.nextInt();
            trace=sc.nextInt();
            for(int i=1;i<=n;++i){
                for(int j=1;j<=n;++j){
                    ans[i][j]=0;
                }
            }
            ok=false;
            System.out.print("Case #"+test+": ");
            solve(n);
            if(!ok){
                System.out.print("IMPOSSIBLE");
                System.out.println();
            }
        }
    }
}