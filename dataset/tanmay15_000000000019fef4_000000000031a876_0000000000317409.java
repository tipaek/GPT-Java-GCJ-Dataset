
/**
 *
 * @author Tanmay Deshpande (KIT College Of Engineering, Kolhapur)
 */
import java.io.*;
import java.util.*;

class Solution
{
    public static void main(String ar[]) throws Throwable
    {
        int T,z;
        MyScanner sc = new MyScanner(); 	// use it just like normal scanner object.
        PrintWriter pw = new PrintWriter(System.out);  //use it as pw.print() or pw.println();
        
        T=sc.nextInt();
        int ans = Integer.MAX_VALUE;
        for(z=0;z<T;z++)
        {
            int X = sc.nextInt();
            int Y =sc.nextInt();
            String M = sc.nextLine();
            sc.next();
          
            int min = 0;
            boolean flag = false;
            for(int i =0; i<M.length();i++)
            {
                min++;
                char C = M.charAt(i);
                if(C == 'N')
                {
                   X++; 
                }
                if(C == 'S')
                {
                    X--;
                }
                if(C == 'E')
                {
                    Y++;
                }
                if(C == 'W')
                {
                    Y--;
                }
                if(X + Y <=min)
                {
                    flag = true;
                    if(i < ans)
                        ans = i;
                }
            }
            
            System.out.print("Case #"+(z+1)+": ");
            if(flag)
                System.out.println("IMPOSSIBLE");
            else
                System.out.println(ans);
            
        }//T

    }
    
    // Fast input output stuff
    static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
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
}
