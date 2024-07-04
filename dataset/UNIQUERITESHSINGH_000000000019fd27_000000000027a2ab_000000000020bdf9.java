
import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int tc = 1; tc <= t; tc++)
        {
            boolean isImpossible = false;
            int N = in.nextInt();
            List<Activities> activityList = new ArrayList<>();
            for(int i=0;i<N; i++)
            {
                int sequenceNumber = i+1;
                int min = in.nextInt();
                int max = in.nextInt();
                List<Integer> overlapped = new ArrayList<>();
                for(Activities activity : activityList)
                {
                    if(min>activity.min && min <activity.max || max > activity.min && max<activity.max)
                    {
                        activity.overlapsWith.add(sequenceNumber);
                        overlapped.add(activity.sequenceNo);
                    }
                }
                activityList.add(new Activities(sequenceNumber, min, max, overlapped));
            }

            for(Activities activity : activityList)
            {
               if(activity.assignedTo == null)
                {
                    if(!activity.canJdo && !activity.canCdo)
                    {
                        isImpossible = true;
                        break;
                    }
                    else if(activity.canCdo)
                    {
                        activity.assignedTo = 'C';
                        activity.canJdo=false;
                        if (activity.overlapsWith.size() > 0)
                        {
                            List<Integer> overlappingIds = activity.overlapsWith;
                            for(Integer ids : overlappingIds)
                            {
                                Activities ac = activityList.get(ids - 1);
                                ac.setCanCdo(false);
                            }
                        }
                    }
                    if(activity.canJdo)
                    {
                        activity.assignedTo = 'J';
                        activity.canCdo=false;
                        if (activity.overlapsWith.size() > 0)
                        {
                            List<Integer> overlappingIds = activity.overlapsWith;
                            for(Integer ids : overlappingIds)
                            {
                                Activities ac = activityList.get(ids - 1);
                                ac.setCanJdo(false);
                            }
                        }
                    }
                }
            }
            if(isImpossible)
                System.out.println("Case #" + tc + ": " + "IMPOSSIBLE");
            else
            {
                StringBuilder sequence = new StringBuilder();
                for(Activities activity : activityList)
                {
                    if(activity.assignedTo==null)
                    {
                        int a = 5/0;
                    }
                    sequence.append(activity.assignedTo);
                }
                System.out.println("Case #" + tc + ": " + sequence);
            }

        }

    }

    static class Activities
    {
        int sequenceNo ;
        int min;
        int max;
        List<Integer> overlapsWith;
        Character assignedTo;
        Boolean canJdo = true;
        Boolean canCdo = true;

        void setAssignedTo(Character assignedTo) {
            this.assignedTo = assignedTo;
        }

        public int getSequence() {
            return sequenceNo;
        }

        public int getStart() {
            return min;
        }

        public int getEnd() {
            return max;
        }

        public void setCanJdo(Boolean canJdo) {
            this.canJdo = canJdo;
        }

        Activities(int sequence, int start, int end, List<Integer> overlapsWith)
        {
            this.sequenceNo = sequence;
            this.min = start;
            this.max = end;
            this.overlapsWith = overlapsWith;
        }

        public void setCanCdo(Boolean canCdo) {
            this.canCdo = canCdo;
        }

    }
}
