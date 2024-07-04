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

Collections.sort(taskList,((task1,task2)->task1.start-task2.start));

Queue<Task> queue = new PriorityQueue<>((task1,task2)->task1.end-task2.end);
StringBuilder sb = new StringBuilder();
boolean c = false;
boolean j = false;
for(int i=0;i<taskList.size();i++){

Task task = taskList.get(i);
if(queue.size()==0){
    c =  true;
    task.assignee = "C";
queue.offer(task);

}else{

int prevEnd = queue.peek().end;
int currentStart = task.start;
if(currentStart>=prevEnd){
Task t = queue.poll();
if(t.assignee=="C"){
task.assignee = "C";
c=true;
}else{
task.assignee = "J";
j=true;
}
}
if(task.assignee==null){
    task.assignee = c==true?"J":"C";
}
queue.offer(task);
}

if(queue.size()>2){
sb = new StringBuilder("IMPOSSIBLE");
break;
}
sb.append(task.assignee);


}

System.out.println("Case #"+cases+": "+sb.toString());

testcases--;
}

}

    
    
}