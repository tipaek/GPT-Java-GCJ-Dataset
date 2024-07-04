import java.util.*;    
import java.io.*;
import java.awt.Point;
import java.util.ArrayList;



public class Solution 
{
    Comparator<Point> comp = new Comparator<Point>()
    {
        public int compare(Point o1, Point o2)
        {
           return new Integer(o1.x).compareTo(o2.x);
        }
    };

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
            
            while (activities.size() > 0)
            {
                
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