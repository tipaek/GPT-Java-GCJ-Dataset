import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();
        for (int i = 0; i < testcases; i++){
            int numberTasks = scanner.nextInt();
            scanner.nextLine();
            String[] tasks = new String [numberTasks];
            for (int j = 0; j < numberTasks; j++) {
                String s = scanner.nextLine();
                tasks[j] = s;
            }
            printSolution(i +1, tasks);
        }
        scanner.close();
    }


    public static void printSolution(int testCases, String[] tasks){
        System.out.println(calculate(tasks));
    }

    public static String calculate(String[] tasks){
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++){
            String[] temp = tasks[i].split(" ");
            taskList.add(new Task(Integer.parseInt(temp[0]), Integer.parseInt(temp[1])));
        }
        List<Task> sortedTaskList = taskList.stream().sorted((t, o) -> t.begin - o.begin).collect(Collectors.toList());


        return assignTasks(sortedTaskList);
    }

    public static String assignTasks(List<Task> sortedTaskList){
        int c = 0;
        int j = 0;
        StringBuffer sb = new StringBuffer();
        for(Task task : sortedTaskList){
            if(c <= task.begin){
                sb.append("C");
                c = task.end;
            }else if(j <= task.begin ){
                sb.append("J");
                j = task.end;
            } else{
                return "IMPOSSIBLE";
            }
        }

        return sb.toString();
    }


    public static class Task{
        int begin;
        int end;

        public Task(int begin, int end) {
            this.begin = begin;
            this.end = end;
        }
    }
}
