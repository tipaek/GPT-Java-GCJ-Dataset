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
            int[] dx = {0,1,-1,0,0};
            int[] dy = {0,0,0,1,-1};
            int MINR = 500000000;
            int MAXR = MINR*2;
            int hitx = 0;
            int hity = 0;
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
            int L = 0;
            int R = MAXR;
            //Check right
            while(L<R)
            {
                int MID = (L+R)/2;
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
            int rightd = L+hitx;
            L = 0;
            R = MAXR;
            //Check left
            while(L<R)
            {
                int MID = (L+R)/2;
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
            int leftd = hitx-L;
            L = 0;
            R = MAXR;
            //Check up
            while(L<R)
            {
                int MID = (L+R)/2;
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
            int upd = L+hity;
            L = 0;
            R = MAXR;
            //Check down
            while(L<R)
            {
                int MID = (L+R)/2;
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
            int downd = hity-L;
            int avgx = (rightd+leftd)/2;
            int avgy = (upd+downd)/2;
            int[] dx2 = {0,1,-1,0,0,1,1,-1,-1};
            int[] dy2 = {0,0,0,1,-1,1,-1,1,-1};
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