import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(input.readLine());
        int T = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        while(T-->0)
        {
            int[] ar = new int[B+1];
            int sameI = -1;
            int changedI = -1;
            for(int i = 1; i <= B/2; i++)
            {
                out.println(i);
                out.flush();
                ar[i] = Integer.parseInt(input.readLine());
                out.println(B-i+1);
                out.flush();
                ar[B-i+1] = Integer.parseInt(input.readLine());
                if(ar[i]==ar[B-i+1]) sameI = i;
                else changedI = i;
            }
            boolean flipSames = false;
            boolean flipChanges = false;
            if(sameI!=-1)
            {
                out.println(sameI);
                out.flush();
                int v = Integer.parseInt(input.readLine());
                if(ar[sameI]!=v) flipSames = true;
            }
            if(changedI!=-1)
            {
                out.println(changedI);
                out.flush();
                int v = Integer.parseInt(input.readLine());
                if(ar[changedI]!=v) flipChanges = true;
            }
            for(int i = 1; i <= B; i++)
            {
                if(ar[i]==ar[B-i+1]&&flipSames||ar[i]!=ar[B-i+1]&&flipChanges) out.print(1-ar[i]);
                else out.print(ar[i]);
            }
            out.println();
            out.flush();
            String ans = input.readLine();
        }
        out.flush();
        out.close();
    }
}