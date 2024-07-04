import java.util.LinkedList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = Integer.parseInt(scan.nextLine());

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
                            temp.addOverlap(task);
                        }
                    }
                }
            }
             boolean imp = false;
            for(int j=0;j<n;j++){
                Task task = schedule[j];
                if(!task.isAssigned()){
                    task.setName("C");
                    if(task.getOlCount() > 0 && task.getOlCount() < 3){

                        if(task.overOverLap()){
                            imp = true;
                            break;
                        }

                        LinkedList<Task> ol = task.getOverlap();
                        for(Task te : ol){
                            if(te.getName() == null){
                                te.setName("J");
                            }

                        }
                    }else if(task.getOlCount() >= 3){
                        imp = true;
                    }
                    System.out.println();
                }
                else {
                    if(task.getOlCount() > 0 && task.getOlCount() < 3){

                        if(task.overOverLap()){
                            imp = true;
                            break;
                        }
                        LinkedList<Task> ol = task.getOverlap();
                        for(Task te : ol){
                            if(te.getName() == null){
                                if(task.getName() == "C"){
                                    te.setName("J");
                                }
                                else{
                                    te.setName("C");
                                }
                            }
                        }
                    }else if(task.getOlCount() >= 3){
                        imp = true;
                    }
                }
                if(imp) break;
            }
            if(imp){
                System.out.printf("Case #%d: IMPOSSIBLE\n", i);
            }else{
                System.out.printf("Case #%d: ",i);
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
            name = null;
            overlap = new LinkedList<>();
        }
        public boolean isOverlap(Task task){
            if((task.getStart() > start && task.getStart() < end) || (task.getEnd() > start && task.getEnd() < end)){
                for(Task e : overlap){
                    if(e.equals(task)){
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        public boolean overOverLap(){
            for(Task e1 : overlap){
                for(Task e2 : overlap){
                    if(!e1.equals(e2)){
                        if((e1.getStart() > e2.getStart() && e1.getStart() < e2.getEnd()) || (e1.getEnd() > e2.getStart() && e1.getEnd() < e2.getEnd())) return true;
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
        public void setAssigned(Boolean b){
            assigned = b;
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
