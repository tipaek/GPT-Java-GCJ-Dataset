import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Array;
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int t,b;
        t=Integer.parseInt(st.nextToken());b=Integer.parseInt(st.nextToken());
        while(t-- > 0)
        {
            String s="";
            for(int i=1;i<=10;i++)
            {
                pw.println(i);
                pw.flush();
                st = new StringTokenizer(br.readLine());
                int n=Integer.parseInt(st.nextToken());
                s+=""+n;
            }
            pw.println(s);
            pw.flush();
            st = new StringTokenizer(br.readLine());
            String ans;
            ans=st.nextToken();
        }
    }
}