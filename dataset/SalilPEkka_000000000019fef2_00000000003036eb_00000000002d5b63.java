import java.awt.*;
import java.util.*;

public class Solution {
    static Scanner ob = new Scanner(System.in);
    static int xf,yf;
    static class Point
    {
        int x;
        int y;

        public Point(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

    };
    static void lineLineIntersection(Point A, Point B, Point C, Point D)
    {
        // Line AB represented as a1x + b1y = c1
        int a1 = B.y - A.y;
        int b1 = A.x - B.x;
        int c1 = a1*(A.x) + b1*(A.y);

        // Line CD represented as a2x + b2y = c2
        int a2 = D.y - C.y;
        int b2 = C.x - D.x;
        int c2 = a2*(C.x)+ b2*(C.y);

        int determinant = a1*b2 - a2*b1;

        if (determinant == 0)
        {
            // The lines are parallel. This is simplified
            // by returning a pair of FLT_MAX
            //return new Point(999999999, 999999999);
        }
        else
        {
             xf = (b2*c1 - b1*c2)/determinant;
             yf = (a1*c2 - a2*c1)/determinant;

            //return new Point(x, y);
        }
    }
    // Driver code
    public static void main(String args[]) {
        int xarr[] = {100000000, 999999995, 999999940, 500000000};
        int yarr[] = {100000000, 999999995, 999999940, 500000000};
        int t = ob.nextInt();

        for (int it = 1; it <= t; it++) {
            int a = ob.nextInt();
            int b = ob.nextInt();
            int f = 0; int x=0,y=0 ;
            ho:
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.println(xarr[i] + " " + yarr[j]);
                    String w = ob.next();
                    if (w.equalsIgnoreCase("HIT")) {
                        x = xarr[i];
                        y = yarr[j];
                        break ho;
                    }
                }
            }
                int le1 = edge(x,y,0,0,a,b);
                int re1=edge(x,y,1,0,a,b);
                int x1=x;
                int y1=y;
                ho:
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                        System.out.println(xarr[j] + " " + yarr[i]);
                        String w = ob.next();
                        if (w.equalsIgnoreCase("HIT")) {
                            x = xarr[j];
                            y = yarr[i];
                            break ho;
                        }
                    }
                }
            int le2 = edge(x,y,0,1,a,b);
            int re2=edge(x,y,0,1,a,b);
            int mid1=(le1+re1)/2;
            int x2=x;
            int y2=y;
            int mid2=(le2+re2)/2;
            int tx=le1-re1;
            Point p1 = new Point(mid1, y1);
            Point q1 = new Point(mid1-a, y1-a);
            Point p2 = new Point(x2, mid2);
            Point q2 = new Point(x2-b, mid2-b);
            lineLineIntersection(p1,q1,p2,q2);

            System.out.println(xf + " " + yf);
            String w = ob.next();
            if (w.equalsIgnoreCase("CENTER")==false) {
                 p1 = new Point(mid1, y1);
                 q1 = new Point(mid1+a, y1+a);
                 p2 = new Point(x2, mid2);
                 q2 = new Point(x2+b, mid2+b);
                lineLineIntersection(p1,q1,p2,q2);

                System.out.println(xf + " " + yf);

            }


        }
    }

    static public int edge(int x,int y,int lr,int xy,int a,int b)
    {
        int ans=0;
        if(lr==0)//left
        {
            if(xy==0)//x
            {
                int f=0;

                    int le=x-b;


               // int mid=(le+x)/2;
                 return divide(le,x,xy,y);

            }
            else
            {
                int re=y-a;
                return divide(re,x,xy,y);
            }

        }
        else
        {
            if(xy==0)//x
            {
                int f=0;

                int le=a-x;


                // int mid=(le+x)/2;
                return divide(le,x,xy,y);

            }
            else
            {
                int re=b-y;
                return divide(re,x,xy,y);
            }
        }
    }
    public static  int divide(int l,int r,int xy,int rxy)
    {
        int mid=0;
        if(l<r)
        {
            if(r-l==0)
                return l;

            mid=(l+r)/2;
            if(xy==0)
            {
                System.out.println(mid+" "+rxy);
                String w=ob.next();
                if(w.equalsIgnoreCase("MISS"))
                    divide(mid,r,xy,rxy);
                else if (w.equalsIgnoreCase("HIT"))
                {
                    divide(l,mid,xy,rxy);
                }


            }

        }
        return 0;
    }



}
