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
            boolean[] ar = new boolean[B+1];
            int[] sameI = new int[B/10];
            int[] changedI = new int[B/10];
            boolean[] flipSames = new boolean[B/10];
            boolean[] flipChanges = new boolean[B/10];
            Arrays.fill(sameI,-1);
            Arrays.fill(changedI,-1);
            for(int i = 1; i <= B/2; i++)
            {
                out.println(i);
                out.flush();
                ar[i] = Integer.parseInt(input.readLine())==1;
                out.println(B-i+1);
                out.flush();
                ar[B-i+1] = Integer.parseInt(input.readLine())==1;
                if(ar[i]==ar[B-i+1]) sameI[(i-1)/5] = i;
                else changedI[(i-1)/5] = i;
            }
            for(int i = 0; i < sameI.length; i++)
            {
                if(sameI[i]==-1)
                {
                    out.println(1);
                    out.flush();
                    input.readLine();
                    continue;
                }
                out.println(sameI[i]);
                out.flush();
                boolean v = Integer.parseInt(input.readLine())==1;
                if(ar[sameI[i]]!=v) flipSames[i] = true;
            }
            for(int i = 0; i < sameI.length; i++)
            {
                if(changedI[i]==-1)
                {
                    out.println(1);
                    out.flush();
                    input.readLine();
                    continue;
                }
                out.println(changedI[i]);
                out.flush();
                boolean v = Integer.parseInt(input.readLine())==1;
                if(ar[changedI[i]]!=v) flipChanges[i] = true;
            }
            for(int i = 0; i < sameI.length; i++)
            {
                if(sameI[i]==-1) continue;
                out.println(sameI[i]);
                out.flush();
                boolean v = Integer.parseInt(input.readLine())==1;
                if(ar[sameI[i]]!=v&&flipSames[i]==false||ar[sameI[i]]==v&&flipSames[i]==true)
                {
                    for(int j = 0; j < flipSames.length; j++) flipSames[j] = !flipSames[j];
                }
                break;
            }
            for(int i = 0; i < sameI.length; i++)
            {
                if(changedI[i]==-1) continue;
                out.println(changedI[i]);
                out.flush();
                boolean v = Integer.parseInt(input.readLine())==1;
                if(ar[changedI[i]]!=v&&flipChanges[i]==false||ar[changedI[i]]==v&&flipChanges[i]==true)
                {
                    for(int j = 0; j < flipSames.length; j++) flipChanges[j] = !flipChanges[j];
                }
                break;
            }
            String wow = "";
            String wow2 = "";
            for(int i = 1; i <= B/2; i++)
            {
                if(ar[i]==ar[B-i+1]&&flipSames[(i-1)/5]||ar[i]!=ar[B-i+1]&&flipChanges[(i-1)/5])
                {
                    wow += (!ar[i] ? 1 : 0);
                    wow2 = (!ar[B-i+1] ? 1 : 0) + wow2;
                }
                else
                {
                    wow += (ar[i] ? 1 : 0);
                    wow2 = (ar[B-i+1] ? 1 : 0) + wow2;
                }
            }
            out.println(wow+wow2);
            out.flush();
            String ans = input.readLine();
            if(ans.equals("N")) break;
        }
        out.flush();
        out.close();
    }
}