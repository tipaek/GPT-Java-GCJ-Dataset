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
            ArrayList<Point> activities = new ArrayList();
            
            // Collect all the activities
            for (int j = 0; j < numActivity; j++)
            {
                int start = in.nextInt();
                int end = in.nextInt();
                // Start Point
                Point startPoint = new Point(0, start);
                // End Point
                Point endPoint = new Point(1, end);
                activities.add(startPoint);
                activities.add(endPoint);
            }
            
            // Sort times
            activities.sort(Comparator.comparing(Point::getY));
            
            /*
            // Scheduling
            ArrayList<Point> Cameron = new ArrayList<Point>();
            ArrayList<Point> Jamie = new ArrayList<Point>();
            */
            
            String schedule = new String();
            
            boolean CameronBusy = false;
            boolean JamieBusy = false;
            
            while (activities.size() > 0)
            {
                // Start time at front
                if (activities.get(0).getX() == 0)
                {
                    if (!CameronBusy)
                    {
                        CameronBusy = true;
                        schedule += 'C';
                        activities.remove(0);
                    }
                    else if (!JamieBusy)
                    {
                        JamieBusy = true;
                        schedule += 'J';
                        activities.remove(0);
                    }
                    else
                    {
                        schedule = "IMPOSSIBLE";
                        break;
                    }
                }
                // End time at front
                else if (activities.get(0).getX() == 1)
                {
                    if (CameronBusy)
                    {
                        CameronBusy = false;
                        activities.remove(0);
                    }
                    else if (JamieBusy)
                    {
                        JamieBusy = false;
                        activities.remove(0);
                    }
                }
            }

            /*
            for (int j = 0; j < numActivity; j++)
            {
                boolean assigned = false;
                boolean possible = false;
                
                // Cameron check
                assigned = TimeCheck(Cameron, activities[j]);
                if (!assigned)
                    possible = TimeCheck(Jamie, activities[j]);
                else
                    schedule += 'C';
                    
                // Jamie check
                if (!assigned && !possible)
                {
                    schedule = "IMPOSSIBLE";
                    break;
                }
                else if (possible)
                    schedule += 'J';
            }
            */
            
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