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
                //System.out.println("time: " + j + ": " + numOfActivites);
                if(numOfActivites > 2)
                {
                    isImp = true;
                    break;
                }
            }
            if(isImp) {
                //System.out.println("IMPOSSIBLE");
                answer[i] = "IMPOSSIBLE";
                continue;
            }
            String temp = "";
            int CisDoingAct = -1;
            int JisDoingAct = -1;
            int Cends = -1;
            int Jends = -1;
            boolean CisWorking = false;
            boolean JisWorking = false;
            String[] okey = new String[N];
            for(int j=0;j<=1440;j++)
            {
                if(j == Jends)
                {
                    Jends = -1;
                    JisWorking = false;
                    okey[JisDoingAct] = "J";
                    JisDoingAct = -1;
                }
                if(j == Cends)
                {
                    Cends = -1;
                    CisWorking = false;
                    okey[CisDoingAct] = "C";
                    CisDoingAct = -1;
                }
                for(int k=0;k<N;k++)
                {
                    if(j >= activities[k][0] && j < activities[k][1])
                    {
                        if(k == JisDoingAct || k == CisDoingAct)
                            continue;
                        if(CisWorking)
                        {
                            JisWorking = true;
                            Jends = activities[k][1];
                            JisDoingAct = k;
                        }
                        else
                        {
                            CisWorking = true;
                            Cends = activities[k][1];
                            CisDoingAct = k;
                        }
                    }
                }
            }
            String a = "";
            for(int[] arr : original)
            {
                for(int j=0;j<N;j++)
                {
                    if(activities[j][0] == arr[0] && activities[j][1] == arr[1])
                        a += okey[j];
                }
            }
            answer[i] = a;
        }
        for(int i=0;i<T;i++)
            System.out.println("Case #" + (i+1) + ": " + answer[i]);
    }
}