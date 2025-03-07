import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();

        for(int i=1;i<=t;i++){
            int n = scan.nextInt();

            Task[] schedule = new Task[n];
            for(int j=0;j<n;j++){
                int s = scan.nextInt();
                int e = scan.nextInt();
                Task task = new Task(s,e);
                schedule[j] = task;
            }

            for(int j=0; j<n;j++){
                Task task = schedule[j];
                for(int k=0;k<n;k++){
                    if(k==j) continue;
                    else{
                        Task temp = schedule[k];
                        if(task.isOverlap(temp)){
                            task.addOverlap(temp);
                        }
                    }
                }
            }
            boolean imp = false;
            for(int j=0;j<n;j++){
                Task task = schedule[j];
                if(!task.isAssigned()){
                    task.setName("C");
                    if(task.getOlCount() > 0 ){

                        if(task.overOverLap()){
                            imp = true;
                            break;
                        }

                        LinkedList<Task> ol = task.getOverlap();
                        for(Task te : ol){
                            if(!te.isAssigned()){
                                te.setName("J");
                            }
                        }
                    }
                } else if(task.getOlCount() > 0){

                    if(task.overOverLap()){
                        imp = true;
                        break;
                    }
                    LinkedList<Task> ol = task.getOverlap();
                    for(Task te : ol){
                        if(!te.isAssigned()){
                            if(task.getName().equals("C")){
                                te.setName("J");
                            }
                            else{
                                te.setName("C");
                            }
                        }
                    }
                }
                if(imp) break;
            }
            if(imp){
                System.out.printf("\nCase #%d: IMPOSSIBLE", i);
            }else{
                System.out.printf("\nCase #%d: ",i);
                for(int j=0;j<n;j++){
                    System.out.print(schedule[j].getName());
                }
            }
        }
    }
    public static class Task{
        int start;
        int end;
        int olCount;
        LinkedList<Task> overlap;
        boolean assigned;
        String name;
        Task(int start, int end){
            this.start = start;
            this.end = end;
            olCount = 0;
            overlap = new LinkedList<>();
        }
        public boolean isOverlap(Task task){
            if((task.getStart() > start && task.getStart() < end) || (task.getEnd() > start && task.getEnd() < end) || (start >task.getStart() && start < task.getEnd()) || (end >task.getStart() && end < task.getEnd()) || (task.getStart() == start && task.getEnd() == end)){
                return true;
            }
            return false;
        }
        public boolean overOverLap(){
            for(Task e1 : overlap){
                for(Task e2 : overlap){
                    if(!e1.equals(e2)) {
                        if (e1.isOverlap(e2)) return true;
                    }
                }
            }
            return false;
        }

        public void addOverlap(Task task){
            overlap.addLast(task);
            olCount++;
        }
        public int getStart(){
            return start;
        }
        public int getEnd(){
            return end;
        }
        public void setName(String s){
            name = s;
            assigned = true;
        }
        public String getName(){
            return name;
        }
        public boolean isAssigned(){
            return assigned;
        }
        public int getOlCount(){
            return olCount;
        }
        public LinkedList<Task> getOverlap(){
            return overlap;
        }
    }
}
