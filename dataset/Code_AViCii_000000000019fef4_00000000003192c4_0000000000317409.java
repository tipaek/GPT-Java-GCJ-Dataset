import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String[] args)throws IOException
	{
		Scanner sc=new Scanner(System.in);
// 		Scanner sc=new Scanner(new File("inp.txt"));
		
		int p,t,n,m,x,y,px,py,i;
        char ch;
        String path;
        ArrayList<Integer> utime,posstime;

		p=t=sc.nextInt();

		while(t-->0)
		{
            x=sc.nextInt();
            y=sc.nextInt();

            path=sc.next();
            m=path.length();

            px=x;py=y;
            utime=new ArrayList<Integer>();
            for(i=0;i<m;i++)
            {
                ch=path.charAt(i);
                if(ch=='S')
                    py--;
                else if(ch=='N')
                    py++;
                else if(ch=='E')
                    px++;
                else if(ch=='W')
                    px--;
                
                utime.add(manhattanDist(px,py,0,0));
            }
            posstime=new ArrayList<Integer>();
            for(i=0;i<m;i++)
            {
                if(utime.get(i)<=(i+1))
                    posstime.add(i+1);
            }
            
            if(posstime.size()>0)
                System.out.println("Case #"+(p-t)+": "+Collections.min(posstime));
            else
                System.out.println("Case #"+(p-t)+": IMPOSSIBLE");
		}
	}
    public static int manhattanDist(int x1,int y1,int x2,int y2)
    {
        return Math.abs(x1-x2)+Math.abs(y1-y2);
    }
}