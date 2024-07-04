import java.util.*;
import java.io.*;
public class Solution
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine().trim());
        for(int i=1; i<=t; i++)
        {
            int n = Integer.parseInt(br.readLine().trim());
            String str[];
            StringBuilder ans = new StringBuilder("");
            Interval[] original = new Interval[n];
            for(int j=0; j<n; j++)
            {
                str = br.readLine().trim().split("\\s+");
                original[j] = new Interval(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
            }
            Interval[] ar = original.clone();
            Arrays.sort(ar);
            boolean JamieFree = true, CameronFree = true;
            int JamieEnd = 0, CameronEnd = 0;
            for(int j=0; j<n; j++)
            {
                if(ar[j].start>=JamieEnd)
                {
                    JamieFree = true;
                    JamieEnd = 0;
                }
                if(ar[j].start>=CameronEnd)
                {
                    CameronFree = true;
                    CameronEnd = 0;
                }
                if(JamieFree)
                {
                    ar[j].person = 'J';
                    // ans.append("J");
                    JamieEnd = ar[j].end;
                    JamieFree = !JamieFree;
                }
                else if(CameronFree)
                {
                    ar[j].person = 'C';
                    // ans.append("C");
                    CameronEnd = ar[j].end;
                    CameronFree = !CameronFree;
                }
                else
                {
                    ans = new StringBuilder("IMPOSSIBLE");
                    break;
                }
            }
            if(!ans.toString().equals("IMPOSSIBLE"))
            {
                for(int j=0; j<n; j++)
                    ans.append(original[j].person);
            }
            bw.write("Case #"+i+": "+ans.toString()+"\n");
        }
        
        br.close();
        bw.close();
    }
}

class Interval implements Comparable<Interval>
{
    int start, end;
    char person;
    Interval(int start, int end)
    {
        this.start = start;
        this.end = end;
    }
    public int compareTo(Interval i)
    {
        return this.start - i.start;
    }
}