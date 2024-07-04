import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        class MyTask{
            int startTime;
            int endTime;
            String assignedPerson;

            public MyTask(int startTime, int endTime){
                this.startTime = startTime;
                this.endTime = endTime;
            }
        }

        boolean DEBUG = false;

        InputStream is = DEBUG ? new FileInputStream("test1.in") : System.in;
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(is)));



        int T = in.nextInt();
        for (int i = 1; i <= T; i++) {
            int numberOfTasks = in.nextInt();
            HashMap<String, Integer> worker = new HashMap<String, Integer>();
            worker.put("C", -1);
            worker.put("J", -1);


            ArrayList<MyTask> tasks = new ArrayList<MyTask>();
            for (int j=0;j<numberOfTasks;j++){
                int taskStartTime = Integer.parseInt(in.next());
                int taskEndTime = Integer.parseInt(in.next());


                tasks.add(new MyTask(taskStartTime, taskEndTime));

            }

            //Sort all tasks ascending on there finishing time
            tasks.sort(Comparator.comparingInt(myTask -> myTask.endTime));

            //assign person to task
            String result = "";
            MyTask prevTask = null;
            boolean twoTasksAtTheSameTime = false;
            boolean firstIteration = true;
            for (MyTask currentTask : tasks){
                if (firstIteration){
                    firstIteration = false;
                    result = result + "C";
                    worker.put("C", currentTask.endTime);
                } else {
                    if (prevTask.endTime <= currentTask.startTime){
                        result = result + "C";
                        twoTasksAtTheSameTime = false;
                        worker.put("C", currentTask.endTime);
                    } else {
                        if (twoTasksAtTheSameTime){
                            if (worker.get("C") <= currentTask.startTime){
                                result = result + "C";
                                worker.put("C", currentTask.endTime);
                                prevTask = currentTask;
                                continue;
                            } else {
                                result = "IMPOSSIBLE";
                                break;
                            }
                        }
                        twoTasksAtTheSameTime = true;
                        result = result + "J";
                        worker.put("J", currentTask.endTime);
                    }
                }
                prevTask = currentTask;
            }


            System.out.println("Case #" + i + ": " + result);
        }

        in.close();
    }
}