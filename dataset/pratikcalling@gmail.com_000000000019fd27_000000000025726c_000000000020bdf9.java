
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    enum ALLOCATION {C,J};

    public static void main(String[] args) {
        Solution sol=new Solution();
        sol.compute();
    }

    public void compute() {

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = in.nextInt();
        for (int caseNo = 1; caseNo <= cases; ++caseNo) {
            int activities = in.nextInt();
            int[][] matrix = new int[activities][activities];

            in.nextLine();
            Set<Schedule> schedules=new TreeSet<>(new Comparator<Schedule>() {
                @Override
                public int compare(Schedule s1, Schedule s2) {

                    int startTimeCompareIndex=s1.startTime().compareTo(s2.startTime());
                    int orderCompareIndex=s1.order().compareTo(s2.order());

                    return startTimeCompareIndex!=0?startTimeCompareIndex:orderCompareIndex;
                }
            });

            // Assign schedules
            for(int activityNo=0;activityNo<activities;activityNo++) {
                String line=in.nextLine();
                String[] lineNumbers=line.split(" ");

                int startTime=Integer.valueOf(lineNumbers[0]);
                int endTime=Integer.valueOf(lineNumbers[1]);

                schedules.add(new Schedule(startTime,endTime,activityNo));
            }

            int allocationIndex=0;
            List<Schedule> ongoingSchedules=new ArrayList<>();
            ALLOCATION allocation=ALLOCATION.C;
            boolean isPossible=true;

            for(Schedule schedule:schedules) {

                Iterator<Schedule> ongoingSchedulesIter = ongoingSchedules.iterator();;

                while (ongoingSchedulesIter.hasNext()) {
                    Schedule ongoingSchedule = ongoingSchedulesIter.next();
                    if (ongoingSchedule != null && ongoingSchedule.endTime() <= schedule.startTime()) {
                        ongoingSchedulesIter.remove();
                    }
                }

                // Check if person is going to be over-assigned
                if(ongoingSchedules.size()>1) {
                    isPossible=false;
                    break;
                }
                else {
                    allocationIndex=ongoingSchedules.isEmpty()?allocationIndex:(ongoingSchedules.get(0).allocation().ordinal()+1)%2;
                    allocation= ALLOCATION.values()[allocationIndex];
                    schedule.allocation(allocation);
                }

                ongoingSchedules.add(schedule);
            }

            if(!isPossible) {
                System.out.println("Case #" + caseNo + ": IMPOSSIBLE");
            }
            else {

                Set<Schedule> schedulesInOrder = new TreeSet<>(new Comparator<Schedule>() {
                    @Override
                    public int compare(Schedule s1, Schedule s2) {
                        return s1.order().compareTo(s2.order());
                    }
                });

                schedulesInOrder.addAll(schedules);

                StringBuffer sb=new StringBuffer();

                for (Schedule schedule : schedulesInOrder) {
                    sb.append(schedule.allocation().toString());
                }

                System.out.println("Case #" + caseNo + ": "+sb.toString());
            }

        }
    }

    private class Schedule {
        private Integer startTime;
        private Integer endTime;
        private Integer order;
        private ALLOCATION allocation;

        public Schedule(int startTime,int endTime,int order) {
            this.startTime=startTime;
            this.endTime=endTime;
            this.order=order;
        }

        public Integer startTime() {
            return startTime;
        }

        public Integer endTime() {
            return endTime;
        }

        public Integer order() {
            return order;
        }

        public ALLOCATION allocation() {
            return allocation;
        }

        public void allocation(ALLOCATION allocation) {
            this.allocation=allocation;
        }

        @Override
        public int hashCode() {
            return order;
        }

        @Override
        public boolean equals(Object anotherObject) {

            if(anotherObject instanceof Schedule) {
                return this.order().equals(((Schedule)anotherObject).order());
            }

            return false;
        }

        public String toString() {
            return startTime()+" "+endTime()+" ("+order()+") - "+allocation;
        }
    }
}