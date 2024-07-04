import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution 
{
    static class Activity
    {
        int start;
        int end;
        public Activity(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
        
    }
    
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);    
        int t = sc.nextInt();
        StringBuilder msb = new StringBuilder();
        sc.nextLine();
        for(int count = 1; count <= t; count++)
        {
            int start = -1, end = -1;
            ArrayList<Activity> activities = new ArrayList<>();
            int n = sc.nextInt();
            for(int  i = 0; i < 2*n; i++)
            {
                if(i%2 == 0)
                    start = sc.nextInt();
                else
                {
                    end = sc.nextInt();
                    activities.add(new Activity(start, end));
                }
            }
            msb.append("Case #" + count +": ");
            msb.append( maxActivities(activities ) ); 
            msb.append("\n");
        }
        sc.close();
        System.out.print(msb);
    }
    public static StringBuilder maxActivities(ArrayList<Activity> activities)
    {
        StringBuilder sb = new StringBuilder("CJ");
        
        //sort the activities in inc order of 
        Collections.sort(activities, (o1,o2) -> o1.end- o2.end);
        
        Activity car = activities.get(0);
        Activity jam = activities.get(1);
        
        int size = activities.size();
        for(int i = 2; i < size; i++)
        {
            Activity cur = activities.get(i);
            if(cur.start > car.end)
            {
                sb.append("C");
                car = cur;
            }
            else if(cur.start > jam.end)
            {
                sb.append("J");
                jam = cur;
            }
            else
            {
                sb.setLength(0);
                sb.append("IMPOSSIBLE");
                return sb;
            }
        }
        return sb;
    }
}
