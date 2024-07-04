import java.util.*;

public class Solution{

class Task{
String assignee;    
int start;
int end;
public Task(int s,int e){

this.start = s;
this.end =e;

}
}
public static void main(String[] args){
Solution sc = new Solution();
sc.solve();

}

private void solve(){
    
Scanner sc = new Scanner(System.in);
int testcases = sc.nextInt();
int cases = 1;

while(testcases>0){

int n = sc.nextInt();
List<Task> taskList = new ArrayList<>(n); 
for(int i=0;i<n;i++){
int start = sc.nextInt();
int end = sc.nextInt();
Task task = new Task(start,end);
taskList.add(task);
}
List<Task> originalList = new ArrayList<>(taskList); 
Collections.sort(taskList,((task1,task2)->task1.start-task2.start));

Queue<Task> queue = new PriorityQueue<>((task1,task2)->task1.end-task2.end);
StringBuilder sb = new StringBuilder();

for(int i=0;i<taskList.size();i++){

Task task = taskList.get(i);
if(queue.size()==0){
    task.assignee = "C";
queue.offer(task);

}else{

int prevEnd = queue.peek().end;
int currentStart = task.start;
if(currentStart>=prevEnd){
Task t = queue.poll();
task.assignee = t.assignee=="C"?"C":"J";

}else{
    Task t = queue.peek();
    task.assignee = t.assignee=="C"?"J":"C";
}
queue.offer(task);
}

if(queue.size()>2){
sb = new StringBuilder("IMPOSSIBLE");
break;
}
}

if(!sb.toString().equals("IMPOSSIBLE")){
    
    for(int i=0;i<originalList.size();i++){
        sb.append(originalList.get(i).assignee);
    }
    
}

System.out.println("Case #"+cases+": "+sb.toString());

testcases--;
}

}

    
    
}