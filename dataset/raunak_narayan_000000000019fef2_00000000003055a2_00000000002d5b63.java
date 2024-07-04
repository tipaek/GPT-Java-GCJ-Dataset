import java.io.*;
import java.util.*;

class Solution {

    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    static final String FILENAME = "A-large";
    static final String IN = FILENAME + ".in";
    static final String OUT = FILENAME + ".out";
    PrintStream out = System.out;

    int A,B,R;
    boolean hit;
    int x1,y1,x2,y2,x3,y3;

    static final int M = 1000000000;
    private void run() throws Exception {
        int t = in.nextInt();
        A  =in.nextInt();
        B = in.nextInt();
        for (int i = 1; i <= t; i++) {
            solve(i);
        }

        in.close();
        out.close();
    }

    public static void main(String args[]) throws Exception {
        new Solution().run();
    }

    long mul;
    Stack<Integer> values;

    private void solve(int t) {
        R = A;
        hit = false;
        int i = 0,j = 0;
        for( i = R;i < 2*M;i += 2*R)
        {
            for( j = R;j < 2*M;j += 2*R)
            {
                ask(i,j);
                if(hit)
                    break;
            }    
            if(hit)
                break;   
        }

        findone_pont(i,j);
        findsecond_point(x1,y1);
        findThird_point();
        
        int x = (x3 + x1)/2;
        int y = (y3 + y1)/2;
        x = M - x;
        y = M - y;

        // out.print("Case #" + t + ": " );
        out.print(x+" "+y);
        if(!in.next().equals("CENTER"))
            System.exit(0);

        out.println();
    }

    void findone_pont(int i,int j)
    {
        int low = 0,high = j;
        while(low < high)
        {
            int mid = (low + high)/2;
            String verd = ask2(i,mid);
            if(verd.equals("MISS"))
                low = mid;
            else if(verd.equals("HIT")) 
            {
                if(ask2(i,mid-1).equals("HIT") && ask2(i,mid+1).equals("MISS")) 
                    {x1 = i;y1 = mid; break;}
                high = mid-1;    
            }  
                
        }
    }

    void findsecond_point(int i,int j)
    {
        int low = 0,high = i;
        while(low < high)
        {
            int mid = (low + high)/2;
            String verd = ask2(mid,y1);
            if(verd.equals("MISS"))
                low = mid;
            else if(verd.equals("HIT")) 
            {
                if(ask2(mid+1,j).equals("HIT") && ask2(mid-1,j).equals("MISS")) 
                    {x2 = mid;y2 = y1; break;}
                high = mid-1;    
            }  
                
        }
    }

    void findThird_point()
    {
        int low = y2,high = 2*M;
        while(low < high)
        {
            int mid = (low + high)/2;
            String verd = ask2(x2,mid);
            if(verd.equals("MISS"))
                high = mid;
            else if(verd.equals("HIT")) 
            {
                if(ask2(x2,mid-1).equals("HIT") && ask2(x2,mid+1).equals("MISS")) 
                    {x3 = x2;y3 = mid; break;}
                low = mid+1;    
            }  
                
        }
    }

    void ask(int x,int y)
    {
        out.print((M-x)+" "+(M-y));
        out.println();
        String s = in.next();
        if(s.equals("HIT"))
            hit = true;
    }

    String ask2(int x,int y)
    {
        out.print((M-x)+" "+(M-y));
        out.println();
        return in.next();
    }
   
}
