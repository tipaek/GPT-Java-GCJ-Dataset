import java.util.*;    
import java.io.*;
import java.awt.Point;

public class Solution 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();

        for (int i = 0; i < cases; i++)
        {
            int numActivity = in.nextInt();
            Point[] activities = new Point[numActivity];
            
            System.out.print("Case #" + (i + 1) + ": ");
            
            // Collect all the times
            for (int j = 0; j < numActivity; j++)
            {
                int start = in.nextInt();
                int end = in.nextInt();
                Point time = new Point(start, end);
                activities[j] = time;
            }
            
            // Scheduling
            ArrayList<Point> Cameron = new ArrayList<Point>();
            ArrayList<Point> Jamie = new ArrayList<Point>();
            
            boolean success = true;
            String schedule = new String();
            
            for (int j = 0; j < numActivity; j++)
            {
                boolean assigned = false;
                boolean possible = true;
                
                // Cameron check
                assigned = TimeCheck(Cameron, activities[j]);
                if (!assigned)
                    possible = TimeCheck(Jamie, activities[j]);
                else
                    schedule += 'C';
                    
                // Jamie check
                if(!possible)
                {
                    System.out.println("IMPOSSIBLE");
                    success = false;
                }
                else if (!assigned && possible)
                    schedule += 'J';
            }
            
            if (success)
                System.out.println(schedule);
        }
    }
    
    static boolean TimeCheck(ArrayList<Point> parent, Point proposed)
    {
        int propStart = (int)proposed.getX();
        int propStop = (int)proposed.getY();
        
        boolean open = true;
        
        for (int i = 0; i < parent.size(); i++)
        {
            int setStart = (int)parent.get(i).getX();
            int setStop = (int)parent.get(i).getY();
            
            /*
            if (propStart >= setStart && propStart < setStop)
                open = false;
            if (propStop > setStart && propStop <= setStop)
                open = false;
              */
              
            if (propStart <= setStart && propStop >= setStart)
                open = false;
            else if (propStart >= setStart && propStart < setStop)
                open = false;
        }
        
        if (open)
        {
            parent.add(proposed);
            return true;
        }
        else
            return false;
    }
}