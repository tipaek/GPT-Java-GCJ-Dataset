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
            boolean isImp = false;
            int CisDoingAct = -1;
            int JisDoingAct = -1;
            int Cends = -1;
            int Jends = -1;
            boolean CisWorking = false;
            boolean JisWorking = false;
            String[] okey = new String[N];
            for(int j=0;j<=1440;j++)
            {
                if(isImp)
                    break;
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
                    if(k == JisDoingAct || k == CisDoingAct)
                        continue;
                    if(j >= activities[k][0] && j < activities[k][1])
                    {
                        if(CisWorking && JisWorking)
                        {
                            answer[i] = "IMPOSSIBLE";
                            isImp = true;
                            break;
                        }
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
            if(isImp)
                continue;
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