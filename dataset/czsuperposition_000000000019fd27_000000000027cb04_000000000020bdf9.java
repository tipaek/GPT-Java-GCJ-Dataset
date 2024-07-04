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
            for(int j=0;j<N;j++)
            {
                activities[j][0] = scanner.nextInt();
                activities[j][1] = scanner.nextInt();
            }
            int[][] original = activities.clone();
            Arrays.sort(activities, (a,b) -> a[0] - b[0]);
            int start = activities[0][0];
            boolean isImp = false;
            for(int j=start;j<=1440;j++)
            {
                int numOfActivites = 0;
                for(int k=0;k<N;k++)
                {
                    if(activities[k][0] <= j && activities[k][1] > j)
                        numOfActivites++;
                }
                if(numOfActivites > 2)
                {
                    isImp = true;
                    break;
                }
            }
            if(isImp) {
                answer[i] = "IMPOSSIBLE";
                continue;
            }
            String temp = "C";
            int Cends = activities[0][1];
            int Jends = -1;
            int currentActivity = 0;
            boolean CisWorking = true;
            boolean JisWorking = false;
            for(int j=start;j<=1440;j++)
            {
                if(j == Cends)
                {
                    CisWorking = false;
                    Cends = 0;
                }
                if(j == Jends)
                {
                    JisWorking = false;
                    Jends = 0;
                }
                for(int k=currentActivity+1;k<N;k++)
                {
                    if(activities[k][0] <= j && activities[k][1] > j)
                    {
                        if(CisWorking)
                        {
                            Jends = activities[k][1];
                            temp += "J";
                            JisWorking = true;
                        }
                        else
                        {
                            temp += "C";
                            Cends = activities[k][1];
                            CisWorking = true;
                        }
                        currentActivity = k;
                    }
                }
            }
            String a = "";
            for(int[] arr : original)
            {
                for(int j=0;j<N;j++)
                {
                    if(activities[j][0] == arr[0] && activities[j][1] == arr[1])
                        a += temp.substring(j,j+1);
                }
            }
            answer[i] = a;
        }
        for(int i=0;i<T;i++)
            System.out.println("Case #" + (i+1) + ": " + answer[i]);
    }
}