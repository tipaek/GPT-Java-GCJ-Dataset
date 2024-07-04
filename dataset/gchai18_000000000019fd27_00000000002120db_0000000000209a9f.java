import java.util.*;
import java.io.*;


public class Solution
{
    public static void main (String[] args) throws IOException
    {
        BufferedReader f = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(f.readLine());
        for (int j=1; j<=t; j++) {
            System.out.print("Case #" + j + ": ");
            String str = f.readLine();
            int l = str.length();
            int[] s = new int[l];
            for (int i=0; i<l; i++)
            {
                s[i] = str.charAt(i)-'0';
            }
            Stack<Integer> st = new Stack<Integer>();
            st.push(0);
            for (int i=0; i<l; i++)
            {
                int x = st.peek();
                if (st.empty() || s[i]>x)
                {
                    for (int k=x+1; k<=s[i]; k++)
                    {
                        System.out.print("(");
                    }
                }

                while (s[i]<x)
                {
                    for (int k=x; k>s[i]; k--)
                    {
                        System.out.print(")");
                    }
                    st.pop();
                    x = st.peek();
                }
                st.push(s[i]);
                System.out.print(s[i]);
            }
            if (!st.isEmpty())
            {
                int x = st.pop();
                for (int i=0; i<x; i++)
                {
                    System.out.print(")");
                }
            }

            System.out.println();
        }
    }
}