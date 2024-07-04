
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
            int N = sc.nextInt();
            int matrix[][] = new int[N][N];
            for(int i=0;i<N;i++)
            {
                for(int j=0;j<N;j++)
                {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int trace = 0;
            for(int i=0;i<N;i++)
                trace = trace + matrix[i][i];
            
            int rowCount=0;
            for(int i=0;i<N;i++)
            {
                int count[] = new int[N+1];
                for(int j=0;j<N;j++)
                {
                    count[matrix[i][j]]++;
                    if(count[matrix[i][j]]>1)
                    {
                        rowCount++;
                        break;
                    }
                }
            }
            
            int columnCount=0;
            for(int j=0;j<N;j++)
            {
                int count[] = new int[N+1];
                for(int i=0;i<N;i++)
                {
                    count[matrix[i][j]]++;
                    if(count[matrix[i][j]]>1)
                    {
                        columnCount++;
                        break;
                    }
                }
            }
            
            pw.println("Case #"+(z+1)+": "+trace+" "+rowCount+" "+columnCount);
            pw.flush();
            
        }

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
