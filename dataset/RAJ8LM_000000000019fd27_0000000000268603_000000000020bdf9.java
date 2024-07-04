import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int countOfTestCases = scn.nextInt();

        for (int i = 1; i <= countOfTestCases; i++) {
            int numberOfJobs = scn.nextInt();

            ArrayList<WorkQueueEntry> entryListOfTasks = new ArrayList<>();
            for (int jobs = 1; jobs <= numberOfJobs; jobs++) {
                entryListOfTasks.add(new WorkQueueEntry(scn.nextInt(), scn.nextInt()));
            }

            System.out.println("Case #"+ i +": "+ taskAllocation(entryListOfTasks));

        }
    }

    private static String taskAllocation(ArrayList<WorkQueueEntry> taskList){
        PriorityQueue<WorkQueueEntry> jamieQueue = new PriorityQueue<>(2, new TaskComparator());
        PriorityQueue<WorkQueueEntry> cameronQueue = new PriorityQueue<>(2, new TaskComparator());
        String resultString = new String();
        if(taskList.size() == 0) {
            resultString = "IMPOSSIBLE";
            return resultString;
        }

        for(WorkQueueEntry task : taskList){

            if(jamieQueue.isEmpty()) {
                jamieQueue.add(task);
                resultString += 'J';
                continue;
            }
            else if(cameronQueue.isEmpty()){
                cameronQueue.add(task);
                resultString += 'C';
                continue;
            }
            
            if (task.startTime >= 1440 || task.endTime > 1440) {
                resultString = "IMPOSSIBLE";
                return resultString;
            }

            boolean taskOwnerFound = false;
            //  Comparing the start time of the task with Items in JamieQueue
            WorkQueueEntry[] jamieTasks = jamieQueue.toArray(new WorkQueueEntry[jamieQueue.size()]);
            for(int i = 0; i < jamieTasks.length; i++){

                if((i != jamieTasks.length - 1) && (task.startTime > jamieTasks[i].endTime))
                    continue;
                else if((i == jamieTasks.length - 1) && (task.startTime >= jamieTasks[i].endTime)){
                    jamieQueue.add(task);
                    resultString += 'J';
                    taskOwnerFound = true;
                    break;
                }
                else if(task.startTime < jamieTasks[i].startTime){
                    if(task.endTime <= jamieTasks[i].startTime){
                        //  No Overlap case
                        jamieQueue.add(task);
                        resultString += 'J';
                        taskOwnerFound = true;
                        break;
                    }else{
                        //  This is already an overlap
                        //  Let it go for Cameron
                        break;
                    }
                }
                else if(task.startTime >= jamieTasks[i].endTime){
                    if(task.endTime <= jamieTasks[i+1].startTime){
                        //  No problem in fitting this task here
                        jamieQueue.add(task);
                        resultString += 'J';
                        taskOwnerFound = true;
                        break;
                    }else if(task.endTime > jamieTasks[i+1].startTime){
                        break;
                    }
                }
            }
            if(taskOwnerFound)
                continue;
            else{
                //  Comparing the start time of tasks with Items in Cameron Queue
                WorkQueueEntry[] cameronTasks = cameronQueue.toArray(new WorkQueueEntry[cameronQueue.size()]);
                for(int i = 0; i < cameronTasks.length; i++){

                    if(( i != cameronTasks.length) && (task.startTime > cameronTasks[i].endTime))
                        continue;
                    else if((i == cameronTasks.length - 1) && (task.startTime >= cameronTasks[i].endTime)){
                        cameronQueue.add(task);
                        resultString += 'C';
                        taskOwnerFound = true;
                        break;
                    }
                    else if(task.startTime < cameronTasks[i].startTime){
                        if(task.endTime <= cameronTasks[i].startTime){
                            cameronQueue.add(task);
                            resultString += 'C';
                            taskOwnerFound = true;
                            break;
                        }else{
                            //  There is an overlap with Cameron as well.
                            //  And we have come here as there was an overlap with Jamie too
                            //  So this task is impossible
                            break;
                        }
                    }
                    else if(task.startTime >= cameronTasks[i].endTime){
                        if(task.endTime <= cameronTasks[i+1].startTime){
                            //  No problem in fitting this task here
                            cameronQueue.add(task);
                            resultString += 'J';
                            taskOwnerFound = true;
                            break;
                        }else if(task.endTime > cameronTasks[i+1].startTime){
                            break;
                        }
                    }
                }
                if(!taskOwnerFound){
                    resultString = "IMPOSSIBLE";
                    return resultString;
                }

            }

        }
        return resultString;
    }
}

class WorkQueueEntry{
    int startTime;
    int endTime;
    public WorkQueueEntry(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

class TaskComparator implements Comparator<WorkQueueEntry>{

    //  Increasing order of Start time
    @Override
    public int compare(WorkQueueEntry o1, WorkQueueEntry o2) {
        if(o1.startTime > o2.startTime)
            return 1;
        else if(o1.startTime < o2.startTime)
            return -1;
        else
            return 0;
    }
}
