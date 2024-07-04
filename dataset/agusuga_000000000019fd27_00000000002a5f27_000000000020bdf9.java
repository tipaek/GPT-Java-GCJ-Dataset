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
            ArrayList<Point> pairs = new ArrayList();
            
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
                
                Point pair = new Point(start, end);
                pairs.add(pair);
            }
            
            Collections.sort(activities, new Comparator<Point>() 
            {
                public int compare(Point x1, Point x2) {
                int result = Double.compare(x1.getY(), x2.getY());
                if ( result == 0 ) {
                // both X are equal -> compare Y too
                result = Double.compare(x1.getX(), x2.getX());
                } 
                return result;
                }
            });
            
            String schedule = new String();
            
            int CameronBusy = -1;
            int JamieBusy = -1;
            
            for (int j = 0; j < activities.size(); j++)
            {
                // Start time at front
                if ((int)activities.get(j).getX() == 0)
                {
                    if (CameronBusy == -1)
                    {
                        CameronBusy = (int)activities.get(j).getY();
                        schedule += 'C';
                    }
                    
                    if (JamieBusy == -1)
                    {
                        JamieBusy = (int)activities.get(j).getY();
                        schedule += 'J';
                    }
                    
                    if (CameronBusy == -1 && JamieBusy == -1)
                    {
                        schedule = "IMPOSSIBLE";
                        break;
                    }
                }
                // End time at front
                if (activities.get(j).getX() == 1)
                {
                    if (CameronBusy != -1)
                    {
                        for (int k = 0; k < pairs.size(); k++)
                        {
                            if ((int)pairs.get(k).getY() == (int)activities.get(j).getY())
                            {
                                if (CameronBusy == (int)pairs.get(k).getX())
                                {
                                    CameronBusy = -1;
                                }                                 
                            }
                        }
                    }
                    
                    if (JamieBusy != -1)
                    {
                        for (int k = 0; k < pairs.size(); k++)
                        {
                            if ((int)pairs.get(k).getY() == (int)activities.get(j).getY())
                            {
                                if (JamieBusy == (int)pairs.get(k).getX())
                                {
                                    JamieBusy = -1;
                                }                                 
                            }
                        }
                    }
                }
            }
            
            System.out.println("Case #" + (i + 1) + ": " + schedule);
        }
    }
}