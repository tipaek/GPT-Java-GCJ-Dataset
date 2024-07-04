import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Task{
    Integer start;
    Integer end;
    Integer id;
    String owner;

    public Task(Integer start, Integer end) {
        this.start = start;
        this.end = end;
    }

    public Task() {
    }

    public Task(Integer start, Integer end, Integer id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", start=" + start +
                ", end=" + end +
                ", owner='" + owner + '\'' +
                '}';
    }
}
public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            List<Task> tasks = new ArrayList<>();
            for (int j=0; j<n; j++){
                int start= in.nextInt();
                int end= in.nextInt();
                Task task = new Task(start,end,j);
                tasks.add(task);
            }
            String solution = solve(tasks);

            System.out.printf("Case #%d: %s\n", i,solution);
        }
    }

    private static String solve(List<Task> tasks) {
        Collections.sort(tasks, (o1,o2)->o1.start-o2.start);

        Task Cameron = new Task();
        Task Jamie = new Task();
//        System.out.println(tasks);
        String res ="";
        List<Task> resList = new ArrayList<>();
        if(tasks.size()>=1){
            resList.add(tasks.get(0));
            Cameron = tasks.get(0);
            resList.get(resList.size()-1).setOwner("C");
            res+="C";
        }
        if(tasks.size()>=2){
            Jamie = tasks.get(1);
            resList.add(tasks.get(1));
            resList.get(resList.size()-1).setOwner("J");
            res+="J";
        }

        for (int i=2;i<tasks.size(); i++){
            if(Cameron.end<=tasks.get(i).start){
                Cameron = tasks.get(i);
                resList.add(tasks.get(i));
                resList.get(resList.size()-1).setOwner("C");
                res+="C";
            }else if(Jamie.end<=tasks.get(i).start){
                Jamie = tasks.get(i);
                resList.add(tasks.get(i));
                resList.get(resList.size()-1).setOwner("J");
                res+="J";
            }else {
                return "IMPOSSIBLE";
            }
        }
//        Collections.sort(resList,(o1,o2)->o1.id-o2.id);
        resList.sort((o1,o2)->o1.id-o2.id);
//        System.out.println(resList);

        String res2="";
        for (Task task:resList){
            res2+=task.owner;
        }

        return res2;

    }

}
