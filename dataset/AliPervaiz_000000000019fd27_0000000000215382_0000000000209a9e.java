import java.util.*;
import java.io.*;
public class Main
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
            boolean[] ar = new boolean[B+1];
            int sameI = -1;
            int changedI = -1;
            for(int i = 1; i <= B/2; i++)
            {
                out.println(i);
                out.flush();
                ar[i] = Integer.parseInt(input.readLine())==1;
                out.println(B-i+1);
                out.flush();
                ar[B-i+1] = Integer.parseInt(input.readLine())==1;
                if(ar[i]==ar[B-i+1]) sameI = i;
                else changedI = i;
            }
            boolean flipSames = false;
            boolean flipChanges = false;
            if(sameI!=-1)
            {
                out.println(sameI);
                out.flush();
                boolean v = Integer.parseInt(input.readLine())==1;
                if(ar[sameI]!=v) flipSames = true;
            }
            if(changedI!=-1)
            {
                out.println(changedI);
                out.flush();
                boolean v = Integer.parseInt(input.readLine())==1;
                if(ar[changedI]!=v) flipChanges = true;
            }
            for(int i = 1; i <= B; i++)
            {
                if(ar[i]==ar[B-i+1]&&flipSames||ar[i]!=ar[B-i+1]&&flipChanges) out.print(!ar[i] ? 1 : 0);
                else out.print(ar[i] ? 1 : 0);
            }
            out.println();
            out.flush();
            String ans = input.readLine();
            if(ans.equals("N")) break;
        }
        out.flush();
        out.close();
    }
}