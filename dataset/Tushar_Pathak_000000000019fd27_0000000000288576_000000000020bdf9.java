import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    static class Person {
        public int startTime;
        public int endTime;
        public boolean isEmpty = true;
    }

    static class Task {
        public int startTime;
        public int endTime;
        public String assignedTo = "";

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }

        @Override
        public String toString() {

            return startTime + " " + endTime;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        int testTask = 1;

        while (testTask <= test) {

            StringBuilder builder = new StringBuilder();

            int dailyTask = Integer.parseInt(br.readLine());

            List<Task> tasks = new ArrayList<>();

            Person jamie = new Person();
            Person cameron = new Person();

            while (dailyTask > 0) {

                List<Integer> input = Arrays.stream(br.readLine().split(" ")).map(str -> Integer.parseInt(str)).collect(Collectors.toList());

                Task task =  new Task();
                task.startTime = input.get(0);
                task.endTime = input.get(1);

                tasks.add(task);

                -- dailyTask;
            }

            List<Task> sortedTasks = tasks.stream().sorted(Comparator.comparingInt(Task::getStartTime).thenComparingInt(Task::getEndTime)).collect(Collectors.toList());

            for(int i = 0; i < sortedTasks.size(); ++ i) {

                Task task = sortedTasks.get(i);

                if(!cameron.isEmpty) {

                    if(cameron.endTime <= task.startTime) {
                        cameron.isEmpty = true;
                    }else if(!jamie.isEmpty) {

                        if(jamie.endTime <= task.startTime) {
                            jamie.isEmpty = true;
                        }
                    }
                }

                if(cameron.isEmpty) {

                    cameron.startTime = task.startTime;
                    cameron.endTime = task.endTime;
                    cameron.isEmpty = false;

                    Task newTask = tasks.stream().filter(taskName -> taskName.equals(task)).findFirst().get();
                    newTask.assignedTo = "C";
                }else if(jamie.isEmpty) {

                    jamie.startTime = task.startTime;
                    jamie.endTime = task.endTime;
                    jamie.isEmpty = false;

                    Task newTask = tasks.stream().filter(taskName -> taskName.equals(task)).findFirst().get();
                    newTask.assignedTo = "J";
                }else {

                    builder = new StringBuilder("IMPOSSIBLE");
                    break;
                }

            }

            if(builder.length() == 0) {

                for(int i = 0; i < tasks.size(); ++ i) {

                    builder.append(tasks.get(i).assignedTo);
                }
            }

            System.out.println("Case #" + testTask + ": " + builder.toString());

            ++ testTask;
        }

    }

}
