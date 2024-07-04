
/**
 *
 * @author Tanmay Deshpande (KIT College Of Engineering, Kolhapur)
 */
import java.io.*;
import java.util.*;

public class Solution
{
    public static void main(String ar[]) throws Throwable
    {
        int T,z;
        MyScanner sc = new MyScanner(); 	// use it just like normal scanner object.
        PrintWriter pw = new PrintWriter(System.out);  //use it as pw.print() or pw.println();
        
        T=sc.nextInt();
        
        for(z=0;z<T;z++)
        {
            String ip = sc.nextLine();
            String arr[] = ip.split(" ");
            
            int X = Integer.parseInt(arr[0]);
            int Y = Integer.parseInt(arr[1]);
            String M = arr[2];
             int ans = Integer.MAX_VALUE;
            int min = 0;
            boolean flag = false;
            
            for(int i =0; i<M.length();i++)
            {
                min++;
                char C = M.charAt(i);
                if(C == 'N')
                {
                   Y++; 
                }
                if(C == 'S')
                {
                    Y--;
                }
                if(C == 'E')
                {
                    X++;
                }
                if(C == 'W')
                {
                    X--;
                }
                if(Math.abs(X) + Math.abs(Y) <=min)
                {
                    flag = true;
                    if(i < ans)
                        ans = i+1;
                }
            }
            
            System.out.print("Case #"+(z+1)+": ");
            if(flag==false)
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
