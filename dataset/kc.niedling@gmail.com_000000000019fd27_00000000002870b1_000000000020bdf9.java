import java.util.*;

//Google CodeJam Parenting Partnering Returns (7pts, 12pts) - problem description at bottom.
public class Solution {

    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {
        int tc = in.nextInt();
        for(int c = 1; c <= tc; c++) {
            int n = in.nextInt();
            ArrayList<Pair> list = new ArrayList<Pair>();
            for(int i = 0; i < n; i++) {
                Integer start = in.nextInt();
                Integer end = in.nextInt();
                Pair pair = new Pair(start, end); //Pair(start, end);
                list.add(pair);
            }
            ArrayList<Pair> sortedList = new ArrayList<Pair>(list);
            Collections.sort(sortedList, new Comparator<Pair>() {
                @Override
                public int compare(Pair p1, Pair p2) {
                    return p1.getKey().compareTo(p2.getKey());
                }
            });
            String result = solve(sortedList, list);
            System.out.println("Case #" + c + ": " + result);
        }
    }

    private static String solve(ArrayList<Pair> sortedList, ArrayList<Pair> list) {
        StringBuilder sb = new StringBuilder();
        ArrayList<Pair> cameronSchedule = new ArrayList<Pair>();
        ArrayList<Pair> jamieSchedule = new ArrayList<Pair>();

        boolean cameronHasTasks = false;
        boolean jamieHasTasks = false;
        for (int i = 0; i < sortedList.size(); i++) {
            Pair task = sortedList.get(i);
            //Case 0, give it to Cameron
            if (i == 0) {
                cameronSchedule.add(task);
                cameronHasTasks = true;
                continue;
            }

            int startTime = task.getKey();
            int endTime = task.getValue();

            boolean cameronTasksEndsInTime = cameronHasTasks && cameronSchedule.get(cameronSchedule.size() - 1).getValue() <= startTime;
            boolean jamieTasksEndsInTime = jamieHasTasks && jamieSchedule.get(jamieSchedule.size() - 1).getValue() <= startTime;

            //Case 1: cameron is free, give task to him
            if (cameronTasksEndsInTime) {
                cameronHasTasks = true;
                cameronSchedule.add(task);
            } else if (!jamieHasTasks || jamieTasksEndsInTime) {
                jamieHasTasks = true;
                jamieSchedule.add(task);
            } else {
                return "IMPOSSIBLE";
            }
        }

        //With each task assigned, sort it in order of original list
        ArrayList<Pair> duplicateTasks = new ArrayList<Pair>();
        for (int i = 0; i < list.size(); i++) {
            Pair task = list.get(i);
            if (cameronSchedule.contains(task) && jamieSchedule.contains(task) && duplicateTasks.contains(task)) {
                duplicateTasks.remove(task);
                sb.append('J');
            } else if (cameronSchedule.contains(task) && jamieSchedule.contains(task)) {
                duplicateTasks.add(task);
                sb.append('C');
            } else if (cameronSchedule.contains(task)) {
                sb.append('C');
            } else if (jamieSchedule.contains(task)) {
                sb.append('J');
            }
        }
        return sb.toString();
    }

    //Google didn't let me use javafx Pair class
    public static class Pair {
        Integer key;
        Integer value;
        public Pair(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
        public Integer getKey() {
            return key;
        }
        public Integer getValue() {
            return value;
        }
    }
}