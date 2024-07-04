import java.util.Scanner;

public class Solution
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numberOfTestCases = scanner.nextLine();
        for (int i = 0; i < Integer.parseInt(numberOfTestCases); i++) {
            int noOfActivities = Integer.parseInt(scanner.nextLine());
            Character [] assigned = new Character[noOfActivities];
            boolean [] isAssigned= new boolean[noOfActivities];
            for (int j =0;j<assigned.length;j++)
            {
                assigned[j] = 'N';
                isAssigned[j] = false;
            }
            int [] startTimes = new int[noOfActivities];
            int [] endTimes = new int[noOfActivities];
            for (int k = 0; k < noOfActivities ; k++) {
                String[] activityTimes = scanner.nextLine().split(" ");
                startTimes[k] = Integer.parseInt(activityTimes[0]);
                endTimes[k]  = Integer.parseInt(activityTimes[1]);
            }
            boolean impossibleFlag = false;
            for (int firstActivity = 0; firstActivity < noOfActivities -1; firstActivity++) {
                //act1
                if(impossibleFlag == true){
                    break;
                }
                int startTimeA = startTimes[firstActivity];
                int endTimeA  = endTimes[firstActivity];
                for (int secondActivity = firstActivity+1; secondActivity < noOfActivities; secondActivity++) {
                    //act1
                    int startTimeB = startTimes[secondActivity];
                    int endTimeB  = endTimes[secondActivity];
                    if (!(startTimeB >= endTimeA || endTimeB <=startTimeA)){
                        //overlap
                        boolean isFirstAssigned = isAssigned[firstActivity];
                        boolean isSecondAssigned = isAssigned[secondActivity];
                        if (isFirstAssigned == false && isSecondAssigned == false)
                        {
                            assigned[firstActivity] = 'C';
                            assigned[secondActivity] = 'J';
                            isAssigned[firstActivity] = true;
                            isAssigned[secondActivity] = true;
                        }
                        else if (isSecondAssigned == false)
                        {

                            if (assigned[firstActivity] == 'C')
                            {
                                assigned[secondActivity] = 'J';
                            }
                            else{
                                assigned[secondActivity] = 'C';
                            }
                            isAssigned[secondActivity] = true;
                        }
                        else if (assigned[firstActivity] == assigned[secondActivity])
                        {
                            impossibleFlag = true;
                            break;

                        }
                    }

                }

            }
            String assignee = "";
            for (int o =0; o<assigned.length ; o++)
            {
                if ( impossibleFlag == true)
                {
                    assignee = "IMPOSSIBLE";
                    break;
                }else if (assigned[o] == 'N' ){
                    assigned[o]= 'C';

                }
                assignee = assignee+assigned[o];
            }
            System.out.println("case #" + (i+1) +":"+ " " +assignee);

        }
    }
}

