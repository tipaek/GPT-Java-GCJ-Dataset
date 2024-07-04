import java.util.*;    
import java.io.*;
import java.awt.Point;
import java.util.ArrayList;

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
            
            // Collect all the activities
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
                boolean possible = false;
                
                // Cameron check
                assigned = TimeCheck(Jamie, activities[j]);
                if (!assigned)
                    possible = TimeCheck(Cameron, activities[j]);
                else
                    schedule += 'C';
                    
                // Jamie check
                if (!assigned && !possible)
                {
                    schedule = "IMPOSSIBLE";
                    success = false;
                    break;
                }
                else if (possible)
                    schedule += 'J';
            }
            
            System.out.println("Case #" + (i + 1) + ": " + schedule);
        }
    }
    
    static boolean TimeCheck(ArrayList<Point> parent, Point proposed)
    {
        int propStart = (int)proposed.getX();
        int propStop = (int)proposed.getY();
        
        for (int i = 0; i < parent.size(); i++)
        {
            int setStart = (int)parent.get(i).getX();
            int setStop = (int)parent.get(i).getY();

            if (propStart == setStart)
                return false;
            else if (propStart < setStart && propStop > setStart)
                return false;
            else if (propStart > setStart && propStart < setStop)
                return false;
        }

        parent.add(proposed);
        return true;
    }
}