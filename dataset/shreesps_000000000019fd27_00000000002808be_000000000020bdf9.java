import java.util.*;

public class Solution {

    private static String outputString = "Case #%d: %s";

    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        int testCases = Integer.parseInt(in.nextLine());
        List<List<ActivityInterval>> activityIntervals = new ArrayList<>();
        for(int i=0;i<testCases;i++) {
            int records = Integer.parseInt(in.nextLine());
            List<ActivityInterval> intervalList = new ArrayList<>();
            for(int count =0;count<records;count++) {
                String input = in.nextLine();
                String [] values = input.split(" ");

                ActivityInterval activityInterval = new ActivityInterval();
                activityInterval.setStart(Integer.parseInt(values[0]));
                activityInterval.setEnd(Integer.parseInt(values[1]));
                intervalList.add(activityInterval);
            }
            activityIntervals.add(intervalList);
        }

        int testCase = 1;
        for(List<ActivityInterval> intervals : activityIntervals) {
            //intervals.sort(new SortByActivityInterval());
            boolean [] executor = new boolean[2];
            executor[0] = true;
            executor[1] = true;

            List<TimeByActivityState> timeByActivityStates = new ArrayList<>();
            int [] tasks = new int[intervals.size()];
            Arrays.fill(tasks, -1);
            int count = 0;
            for(ActivityInterval activityInterval : intervals) {
                TimeByActivityState startActivity = new TimeByActivityState();
                startActivity.setTime(activityInterval.getStart());
                startActivity.setState('S');
                startActivity.setIndex(count);

                TimeByActivityState endActivity = new TimeByActivityState();
                endActivity.setTime(activityInterval.getEnd());
                endActivity.setState('E');
                endActivity.setIndex(count);

                timeByActivityStates.add(startActivity);
                timeByActivityStates.add(endActivity);
                count++;
            }
            timeByActivityStates.sort(new SortByTimeByActivityState());

            StringBuilder stringBuilder = new StringBuilder();
            for(TimeByActivityState timeByActivityState : timeByActivityStates) {
                if(timeByActivityState.getState() == 'S') {
                    if(!isExecutorAvailable(executor)) {
                        stringBuilder = new StringBuilder();
                        stringBuilder.append("IMPOSSIBLE");
                        break;
                    }else {
                        int index = findAvailableExecutor(executor);
                        executor[index] = false;
                        //stringBuilder.append(executorName(index));
                        tasks[timeByActivityState.getIndex()] = index;
                    }
                } else {
                    int index = tasks[timeByActivityState.getIndex()];
                    executor[index] = true;
                }
            }
            if(!"IMPOSSIBLE".equals(stringBuilder.toString())) {
                for (int task : tasks) {
                    stringBuilder.append(executorName(task));
                }
            }
            System.out.println(String.format(outputString, testCase, stringBuilder.toString()));
            testCase++;
        }

    }

    static String executorName(int index) {
        if(index == 0) {
            return "C";
        }else {
            return "J";
        }
    }

    static boolean isExecutorAvailable(boolean [] executor) {
        for(boolean value : executor) {
            if(value) {
                return true;
            }
        }
        return false;
    }

    static int findAvailableExecutor(boolean [] executor) {
        for(int i=0;i<executor.length;i++) {
            if(executor[i]) {
                //executor[i] = false;
                return i;
            }
        }
        return -1;
    }

    static class SortByTimeByActivityState implements Comparator<TimeByActivityState> {

        public int compare(TimeByActivityState a, TimeByActivityState b)
        {
            if(a.getTime() == b.getTime()) {
                return a.getState() == 'E' ? 1 : 0;
            }
            return a.getTime() - b.getTime();
        }
    }

    static class TimeByActivityState {
        private int time;
        private char state;
        private int index;

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public char getState() {
            return state;
        }

        public void setState(char state) {
            this.state = state;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    static class ActivityInterval {
        private int start;
        private int end;

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }
}