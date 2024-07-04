import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution 
{
    static class Activity
    {
        public int start;
        public int end;
        public int index;
        
        public Activity(int s, int e, int i)
        {
            start = s;
            end = e;
            index = i;
        }
    }
    
    static class ActivitySort implements Comparator<Activity>
    {
        public int compare(Activity a, Activity b)
        {
            return a.start - b.start;
        }
    }
    
    public static void main(String[] args) throws IOException 
    {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(input.readLine());
        
        for(int currCase = 1; currCase <= T; currCase++)
        {
            int numAct = Integer.parseInt(input.readLine());        
            ArrayList<Activity> activities = new ArrayList<>();
            
            for(int i = 0; i < numAct; i++)
            {
                String[] vals = input.readLine().split(" ");
                activities.add(new Activity(Integer.parseInt(vals[0]), Integer.parseInt(vals[1]), i));
            }
            
            activities.sort(new ActivitySort());
            
            for(int i = 0; i < activities.size(); i++)
            {
                //System.out.println(activities.get(i).start + " " + activities.get(i).end);
            }
            
            Activity C = null;
            Activity J = null;
            char[] result = new char[numAct];
            boolean possible = true;
            
            for(int i = 0; i < activities.size(); i++)
            {
                if(C == null || C.end <= activities.get(i).start)
                {
                    C = activities.get(i);
                    result[C.index] = 'C';
                }else if(J == null || J.end <= activities.get(i).start)
                {
                    J = activities.get(i);
                    result[J.index] = 'J';
                }else
                {
                    possible = false;
                    break;
                }
            }
            
            if(possible)
                System.out.println("Case #" + currCase + ": " + new String(result));
            else
                System.out.println("Case #" + currCase + ": IMPOSSIBLE");
        }
    }
}
