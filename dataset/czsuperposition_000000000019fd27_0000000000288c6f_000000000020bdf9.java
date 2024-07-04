import java.util.*;

public class Solution {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        String[] answer = new String[T];
        for(int i=0;i<T;i++)
        {
            int N = scanner.nextInt();
            int[][] activities = new int[N][2];
            int maxEnd = Integer.MIN_VALUE;
            for(int j=0;j<N;j++)
            {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
                maxEnd = Math.max(maxEnd, activities[j][1]);
            }
            int[][] original = activities.clone();
            Arrays.sort(activities, (a,b) -> Integer.compare(a[0], b[0]));
            boolean isImpossible = false;
            int cCurrentActivity = -1;
            int jCurrentActivity = -1;
            int cEnd = -1;
            int jEnd = -1;
            ArrayList<Integer> doneActivities = new ArrayList<>();
            boolean cWorks = false;
            boolean jWorks = false;
            char[] sortedOrder = new char[N];
            for(int time=0;time<=maxEnd;time++)
            {
                if(time == jEnd)
                {
                    jWorks = false;
                    sortedOrder[jCurrentActivity] = 'J';
                }
                if(time == cEnd)
                {
                    cWorks = false;
                    sortedOrder[cCurrentActivity] = 'C';
                }
                for(int k=0;k<N;k++)
                {
                    if(!doneActivities.contains(k) && time == activities[k][0])
                    {
                        doneActivities.add(k);
                        if(cWorks && jWorks)
                        {
                            answer[i] = "IMPOSSIBLE";
                            isImpossible = true;
                            break;
                        }
                        if(cWorks)
                        {
                            jWorks = true;
                            jEnd = activities[k][1];
                            jCurrentActivity = k;
                        }
                        else
                        {
                            cWorks = true;
                            cEnd = activities[k][1];
                            cCurrentActivity = k;
                        }
                    }
                }
                if(isImpossible)
                    break;
            }
            if(isImpossible)
                continue;
            StringBuilder a = new StringBuilder();
            for(int[] arr : original)
            {
                for(int j=0;j<N;j++)
                {
                    if(activities[j][0] == arr[0] && activities[j][1] == arr[1])
                        a.append(sortedOrder[j]);
                }
            }
            answer[i] = a.toString();
        }
        for(int i=0;i<T;i++)
            System.out.println("Case #" + (i+1) + ": " + answer[i]);
    }
}