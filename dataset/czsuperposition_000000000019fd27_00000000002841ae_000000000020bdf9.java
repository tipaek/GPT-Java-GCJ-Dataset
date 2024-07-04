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
            boolean isImpossible = false;
            int CisDoingAct = -1;
            int JisDoingAct = -1;
            int Cends = -1;
            int Jends = -1;
            ArrayList<Integer> doneActivities = new ArrayList<>();
            boolean CisWorking = false;
            boolean JisWorking = false;
            String[] okey = new String[N];
            for(int time=0;time<=1440;time++)
            {
                if(isImpossible)
                    break;
                if(time == Jends)
                {
                    JisWorking = false;
                    okey[JisDoingAct] = "J";
                }
                if(time == Cends)
                {
                    CisWorking = false;
                    okey[CisDoingAct] = "C";
                }
                for(int k=0;k<N;k++)
                {
                    if(doneActivities.contains(k))
                        continue;
                    if(time >= activities[k][0] && time <= activities[k][1])
                    {
                        if(CisWorking && JisWorking)
                        {
                            answer[i] = "IMPOSSIBLE";
                            isImpossible = true;
                            break;
                        }
                        doneActivities.add(k);
                        if(CisWorking)
                        {
                            JisWorking = true;
                            Jends = activities[k][1];
                            JisDoingAct = k;
                            if(activities[k][0] == activities[k][1]) {
                                JisWorking = false;
                                okey[JisDoingAct] = "J";
                            }
                        }
                        else
                        {
                            CisWorking = true;
                            Cends = activities[k][1];
                            CisDoingAct = k;
                            if(activities[k][0] == activities[k][1]) {
                                CisWorking = false;
                                okey[CisDoingAct] = "C";
                            }
                        }
                    }
                }
            }
            if(isImpossible)
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