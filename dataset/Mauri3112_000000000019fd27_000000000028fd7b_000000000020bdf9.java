import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));


        int t = in.nextInt();


        for(int test = 1 ; test<=t; test++){
        int act = in.nextInt();

        List<Task> tasks = new ArrayList<>();
        List<Integer> items = new ArrayList<>();
            for(int activ = 1;activ<=act;activ++){
             int beginn = in.nextInt();
             int end = in.nextInt();
             Task task = new Task(beginn, end);
             tasks.add(task);
             items.add(beginn);
             items.add(end);
            }
            
           boolean imposible = false;
            for(int time: items){
                int count = 0;
                for(Task task: tasks){
                    if(task.isInBetween(time)){
                        count++;
                    }
                }
                if(count >2){
                    imposible = true;
                }
            }

            String result = "";
            if(!imposible){
                List<Task> cTasks = new ArrayList<>();
                for (Task task:tasks){
                    if (cTasks.isEmpty()){
                        cTasks.add(task);
                        result+="C";
                    } else{
                        boolean canDoTask = true;
                        for (Task cTask:cTasks){
                            if (cTask.colideTaks(task)) canDoTask = false;
                        }
                        if (canDoTask){
                            cTasks.add(task);
                            result+="C";
                        } else {
                            result+="J";
                        }
                    }
                }
                
            } else{
                result = "IMPOSSIBLE";
            }
            System.out.println("Case #"+test+": " +result);
        }
    }




    static class Task{
        int begin;
        int end;

        public Task(int begin, int end){
            this.begin = begin;
            this.end = end;
        }

        public boolean isInBetween(int i){
            if (i >= begin && i < end) {
                return true;
            }
            return false;
        }
        
        public boolean colideTaks(Task task){
            return isInBetween(task.begin) || isInBetween(task.end) && task.end != end;
        }
    }
}