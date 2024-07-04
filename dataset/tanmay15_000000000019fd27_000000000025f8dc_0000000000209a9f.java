
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

        for(z=0;z<T;z++)
        {
            String s = sc.nextLine();
            StringBuilder str = new StringBuilder(s);
            int openBrackets=0;
            
            for(int position=0; position<str.length(); position++)
            {
                char x = str.charAt(position);
                int d  = Integer.parseInt(x+"");
                if(d>=openBrackets)
                {
                    int diff = d - openBrackets;
                    for(int j=0;j<diff;j++)
                    {
                        str.insert(position, '(');
                    }
                    position = position + diff;
                    openBrackets = openBrackets + diff;
                }
                else
                {
                    int diff = openBrackets - d;
                    for(int j=0;j<diff;j++)
                    {
                        str.insert(position, ')');
                    }
                    position = position + diff;
                    openBrackets = openBrackets - diff;
                }
                
            }
            int len = str.length()-1;
            for(int b = 0; b<openBrackets;b++)
            {
                str.append(')');
            }
            pw.println(str);
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
