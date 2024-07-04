import java.awt.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution 
{
    static ArrayList<Integer> arrList[];
    static boolean vg[];
    static boolean c[];
    static boolean dert(Point p, Point q)
    {
        return (p.y > q.x && p.y < q.y)||(p.x > q.x && p.x < q.y)||(q.x > p.x && q.x < p.y)||(q.y > p.x && q.y < p.y)||(p.x == q.x && q.y == p.y);
    }
    static boolean AllSet(int v)
    {
        c[v] = true;
        for (int u : arrList[v]) 
        {
            if (c[u])
            {
                if (vg[u]!=!vg[v])
                {
                    return false;
                }
            } 
            else
            {
                vg[u] = !vg[v];
                if (!AllSet(u))
                {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i=0;i<t;i++) 
        {
            StringBuilder sb = new StringBuilder();
            int n = sc.nextInt();
            sb.append("Case #"+(i+1)+": ");
            Point vfj[] =new Point[n];
            arrList = new ArrayList[n];
            c = new boolean[n];
            vg = new boolean[n];
            for (int j=0;j<n;j++) 
            {
                arrList[j] = new ArrayList<Integer>();
            }
            for (int j=0;j<n;j++) 
            {
                vfj[j] = new Point(sc.nextInt(),sc.nextInt());
            }
            for (int j=0;j<n;j++)
            {
                for (int k= j+1;k<n;k++) 
                {
                    if ( dert(vfj[j], vfj[k]) ) 
                    {
                        arrList[j].add(k);
                        arrList[k].add(j);
                    }
                }
            }
            boolean bhu = true;
            for (int j=0;j<n;j++) 
            {
                if ( c[j] ) 
                {
                    continue;
                }
                if (!AllSet(j)) 
                {
                    bhu = false;
                }
            }
            if (!bhu) sb.append("IMPOSSIBLE");
            else 
            {
                for (int j=0;j<n;j++) 
                {
                    if ( vg[j] ) sb.append('C');
                    else sb.append('J');
                }
            }
            sb.append("\n");
            System.out.print(sb.toString());
        }
    }
}