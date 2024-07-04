import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Arrays;
import java.util.TreeSet;
import java.util.StringTokenizer;


public class Solution
{
    public static void main(String[] stp) throws Exception
    {
        Scanner scan = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int t=Integer.parseInt(st.nextToken()),i;
        int ncase=1;
        while(t-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            String s=st.nextToken();
            StringBuilder sb=new StringBuilder();
            int d=0;
            for(i=0;i<s.length();i++)
            {
                char c=s.charAt(i);
                int cd=(int)(c-'0');
                while(d != cd)
                {
                    if(d > cd)
                    {
                        sb.append(')'); d--;
                    }
                    if(d < cd)
                    {
                        sb.append('('); d++;
                    }
                }
                sb.append(s.charAt(i));
            }
            while(d!=0) { sb.append(')'); d--; }
            pw.println("Case #"+ncase+": "+sb.toString());
            ncase++;
        }
        pw.flush();
    }




}