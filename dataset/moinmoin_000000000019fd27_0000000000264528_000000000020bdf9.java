import java.util.*;

public class Solution {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int tests = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tc = 1 ; tc <= tests ; tc++) {

            int tasksCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            List<Job> taskList = new ArrayList<>();

            for (int i = 0 ; i < tasksCount ; i++) {
                Job task = new Job(scanner.nextInt(), scanner.nextInt());

                taskList.add(task);

                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            }

            try {
                assign(taskList);
                StringBuilder sb = new StringBuilder();
                taskList.stream()
                        .map(task -> task.assignee)
                        .forEach(sb::append);

                System.out.println("Case #" + tc + ": " + sb.toString());
            } catch (Exception e) {
                System.out.println("Case #" + tc + ": IMPOSSIBLE");
            }
        }

        scanner.close();
    }

    private static void assign(List<Job> taskList) {
        NavigableMap<Integer, String> availability = new TreeMap<>();
        availability.put(0, "CJ");

        taskList.stream()
                .sorted(Comparator.comparing(Job::getStartingTime))
                .forEach(task -> update(task, availability));
    }

    private static void update(Job task, NavigableMap<Integer, String> availability) {
        int startingTime = task.getStartingTime();
        int endingTime = task.getEndingTime();

        String availabilityAtStarting = availability.floorEntry(startingTime).getValue();
        switch (availabilityAtStarting) {
            case "C":
                task.assignee = 'C';
                availability.compute(startingTime, (k, v) -> "");
                break;

            case "J":
                task.assignee = 'J';
                availability.compute(startingTime, (k, v) -> "");
                break;

            case "CJ":
                task.assignee = 'C';
                availability.compute(startingTime, (k, v) -> "J");
                break;

            case "":
            default:
                throw new IllegalStateException("Can't assign task");
        }

        availability.subMap(startingTime, false, endingTime, false)
                .entrySet()
                .forEach(entry -> entry.setValue(entry.getValue().replace(Character.toString(task.assignee), "")));

        String availabilityAtEnding = availability.floorEntry(endingTime).getValue();
        switch (availabilityAtEnding) {
            case "C":
            case "J":
                availability.compute(endingTime, (k, v) -> "CJ");
                break;

            case "":
                availability.compute(endingTime, (k, v) -> Character.toString(task.assignee));
        }
    }

    private static class Job {
        private final int startingTime;
        private final int endingTime;

        char assignee;

        private Job(int startingTime, int endingTime) {
            this.startingTime = startingTime;
            this.endingTime = endingTime;
        }

        public int getStartingTime() {
            return startingTime;
        }

        public int getEndingTime() {
            return endingTime;
        }
    }

}
