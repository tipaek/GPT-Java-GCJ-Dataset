import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    private static final String IMPOSSIBLE = "IMPOSSIBLE";
    private static final String Cameron = "C";
    private static final String Jamie = "J";

    private static final int START_TIME_IDX = 0;
    private static final int END_TIME_IDX = 1;

    public static void main(String args[]) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testTotalCount = in.nextInt(); //first input
        for (int testCase = 1; testCase <= testTotalCount; testCase++) {
            int arrSize = in.nextInt(); //second input
            List<TimeTable> timeTableList = new ArrayList<>();
            for (int i = 0; i < arrSize; i++) {
                int startTime = in.nextInt();
                int endTime = in.nextInt();
                timeTableList.add(new TimeTable(i, startTime, endTime));
            }

            System.out.println(new String().format("Case #%s: %s", testCase, process(timeTableList)));
        }
    }

    public static String process(List<TimeTable> list) {
        Collections.sort(list, (TimeTable table1, TimeTable table2) -> {
            if (table1.getStartTime() > table2.getStartTime()) return 1;
            else if (table1.getStartTime() < table2.getStartTime()) return -1;
            else return 0;
        });

        int[] lastC = new int[2];
        int[] lastJ = new int[2];
        for (int i = 0; i < list.size(); i++) {
            if (lastC[END_TIME_IDX] <= list.get(i).getStartTime()) {
                list.get(i).setManagerName(Cameron);
                lastC[START_TIME_IDX] = list.get(i).getStartTime();
                lastC[END_TIME_IDX] = list.get(i).getEndTime();
            } else if (lastJ[END_TIME_IDX] <= list.get(i).getStartTime()) {
                list.get(i).setManagerName(Jamie);
                lastJ[START_TIME_IDX] = list.get(i).getStartTime();
                lastJ[END_TIME_IDX] = list.get(i).getEndTime();
            } else {
                return IMPOSSIBLE;
            }
        }

        Collections.sort(list, (TimeTable table1, TimeTable table2) -> {
            if (table1.getIndex() > table2.getIndex()) return 1;
            else if (table1.getIndex() < table2.getIndex()) return -1;
            else return 0;
        });

        return list.stream()
                .map((timeTable)->timeTable.getManagerName())
                .collect(Collectors.joining());
    }

    static class TimeTable {
        private int index;
        private int startTime;
        private int endTime;
        private String managerName;

        public TimeTable(int index, int startTime, int endTime) {
            this.index = index;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        public int getIndex() {
            return index;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        public String getManagerName() {
            return managerName;
        }

        public void setManagerName(String managerName) {
            this.managerName = managerName;
        }
    }
}
