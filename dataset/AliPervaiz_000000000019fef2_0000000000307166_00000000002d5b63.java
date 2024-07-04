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
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        while(T-->0)
        {
            long[] dx = {0,1,-1,0,0};
            long[] dy = {0,0,0,1,-1};
            long MINR = 500000000;
            long MAXR = MINR*2;
            long hitx = 0;
            long hity = 0;
            for(int d = 0; d < 5; d++)
            {
                out.println(dx[d]*MINR + " " + dy[d]*MINR);
                out.flush();
                String s = input.readLine();
                if(s.equals("HIT"))
                {
                    hitx = dx[d]*MINR;
                    hity = dy[d]*MINR;
                    break;
                }
            }
            long L = 0;
            long R = MAXR;
            //Check right
            while(L<R)
            {
                long MID = (L+R)/2;
                if(hitx+(long)MID>2000000000)
                {
                    R = MID-1;
                    continue;
                }
                out.println(hitx+MID + " " + hity);
                out.flush();
                String s = input.readLine();
                if(s.equals("MISS")||s.equals("WRONG")) R = MID-1;
                else L = MID;
            }
            long rightd = L+hitx;
            L = 0;
            R = MAXR;
            //Check left
            while(L<R)
            {
                long MID = (L+R)/2;
                if(hitx-(long)MID<-2000000000)
                {
                    R = MID-1;
                    continue;
                }
                out.println(hitx-MID + " " + hity);
                out.flush();
                String s = input.readLine();
                if(s.equals("MISS")||s.equals("WRONG")) R = MID-1;
                else L = MID;
            }
            long leftd = hitx-L;
            L = 0;
            R = MAXR;
            //Check up
            while(L<R)
            {
                long MID = (L+R)/2;
                if(hity+(long)MID>2000000000)
                {
                    R = MID-1;
                    continue;
                }
                out.println(hitx + " " + (hity+MID));
                out.flush();
                String s = input.readLine();
                if(s.equals("MISS")||s.equals("WRONG")) R = MID-1;
                else L = MID;
            }
            long upd = L+hity;
            L = 0;
            R = MAXR;
            //Check down
            while(L<R)
            {
                long MID = (L+R)/2;
                if(hity-(long)MID<-2000000000)
                {
                    R = MID-1;
                    continue;
                }
                out.println(hitx + " " + (hity-MID));
                out.flush();
                String s = input.readLine();
                if(s.equals("MISS")||s.equals("WRONG")) R = MID-1;
                else L = MID;
            }
            long downd = hity-L;
            long avgx = (rightd+leftd)/2;
            long avgy = (upd+downd)/2;
            long[] dx2 = {0,1,-1,0,0,1,1,-1,-1};
            long[] dy2 = {0,0,0,1,-1,1,-1,1,-1};
            out:for(int dir = 1; dir <= 2; dir++)
            {
                for(int d = 0; d < dx2.length; d++)
                {
                    out.println(avgx+dx2[d]*dir + " " + (avgy+dy2[d]*dir));
                    out.flush();
                    String s = input.readLine();
                    if(s.equals("CENTER"))
                    {
                        break out;
                    }
                }
            }   
            
        }
        out.flush();
        out.close();
    }
}