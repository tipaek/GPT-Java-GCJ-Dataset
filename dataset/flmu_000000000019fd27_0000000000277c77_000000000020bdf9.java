import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
        class MyTask{
            int position;
            int startTime;
            int endTime;
            String assignedPerson;

            public MyTask(int startTime, int endTime, int position){
                this.startTime = startTime;
                this.endTime = endTime;
                this.position = position;
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
            String result = "";


            ArrayList<MyTask> tasks = new ArrayList<MyTask>();
            int counter = 1;
            for (int j=0;j<numberOfTasks;j++){
                int taskStartTime = Integer.parseInt(in.next());
                int taskEndTime = Integer.parseInt(in.next());


                tasks.add(new MyTask(taskStartTime, taskEndTime, counter));
                counter++;

            }

            //Sort all tasks ascending on there finishing time
            tasks.sort(Comparator.comparingInt(myTask -> myTask.endTime));

            //assign person to task

            MyTask prevTask = null;
            boolean twoTasksAtTheSameTime = false;
            boolean firstIteration = true;
            for (MyTask currentTask : tasks){
                if (firstIteration){
                    firstIteration = false;
                    currentTask.assignedPerson = "C";
                    worker.put("C", currentTask.endTime);
                } else {
                    if (prevTask.endTime <= currentTask.startTime){
                        currentTask.assignedPerson = "C";
                        twoTasksAtTheSameTime = false;
                        worker.put("C", currentTask.endTime);
                    } else {
                        if (twoTasksAtTheSameTime){
                            if (worker.get("C") <= currentTask.startTime){
                                currentTask.assignedPerson = "C";
                                worker.put("C", currentTask.endTime);
                                twoTasksAtTheSameTime = false;
                                prevTask = currentTask;
                                continue;
                            } else {
                                result = "IMPOSSIBLE";
                                break;
                            }
                        }
                        twoTasksAtTheSameTime = true;
                        currentTask.assignedPerson = "J";
                        worker.put("J", currentTask.endTime);
                    }
                }
                prevTask = currentTask;
            }



            if (result.equals("IMPOSSIBLE")){
                System.out.println("Case #" + i + ": " + result);
            } else {
                tasks.sort(Comparator.comparingInt(myTask -> myTask.position));

                for (MyTask currentTask : tasks){
                    result = result + currentTask.assignedPerson;
                }

                System.out.println("Case #" + i + ": " + result);
            }


        }

        in.close();
    }
}