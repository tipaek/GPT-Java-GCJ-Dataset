
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    
    public static void main(String[] args) {
        Scanner in = new Scanner((Readable) new BufferedReader(new InputStreamReader(System.in)));
        int testCount = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        List<BigInteger[]> l = new ArrayList<>();
        in.nextLine();
        for(int testIndex = 0 ;testIndex < testCount ; testIndex++){
            int rowCount = in.nextInt();
            String answer = "";
            List<Task> taskList = new ArrayList<>();
            for(int rowIndex = 0 ; rowIndex < rowCount ; rowIndex++){
                Task task  = new Task();
                task.setIndex(rowIndex);
                task.setStartTime(in.nextInt());
                task.setEndTime(in.nextInt());
                taskList.add(task);
                
            }
            taskList.sort(new Comparator<Task>() {
                @Override
                public int compare(Task o1, Task o2) {
                    // TODO Auto-generated method stub
                    return o1.getStartTime() - o2.getStartTime();
                }
                
            });
            String[] ar = new String[rowCount];
            boolean impossible = false;
            Task t1 = null;
            Task t2 = null;
            for(Task t:taskList ){
                if(t2 == null){
                    if(t1 == null){
                        t.setAssignTo("J");
                    }else if(t.getStartTime() >= t1.getEndTime()){
                        t.setAssignTo(t1.getAssignTo());
                    }else{
                        t.setAssignTo("C");
                    }
                }else {
                    if( t.getStartTime() >=  t1.getEndTime() && !t1.getAssignTo().equals(t2.getAssignTo())){
                        t.setAssignTo(t1.getAssignTo());
                    }else if(t2.getEndTime() >= t.getStartTime() && !t2.getAssignTo().equals(t1.getAssignTo())){
                        t.setAssignTo(t2.getAssignTo());
                    }else{
                        if(t.getStartTime() < t1.getEndTime() &&  t.getStartTime() < t2.getEndTime()){
                            impossible = true;
                            break;
                            
                        }else {
                            t.setAssignTo(t2.getAssignTo().equals("C") ? "J":"C");
                            
                        }
                        
                    }
                    
                }
                ar[t.getIndex()] = t.getAssignTo();
                t2 = t1;
                t1 = t;
            }
            
            if(impossible){
                answer="IMPOSSIBLE";
            }else{
                for(String a :ar){
                    answer= answer.concat(a);
                }
                /* taskList.sort(new Comparator<Task>() {@Override
                    public int compare(Task o1, Task o2) {
                    // TODO Auto-generated method stub
                    return o1.getIndex() - o2.getIndex();
                }});
                for(Task t:taskList ){
                    answer= answer+t.getAssignTo();
                }*/
            }
            
            System.out.println("Case #"+(testIndex+1)+": "+answer);
        }
        
        
        
        /*  
        for(int i =0 ; i<l.size();i++){
            System.out.println("Case #"+(i+1)+": "+l.get(i)[0]+" "+l.get(i)[1]);
        }*/
        
        
        
    }
    
    
    
}
class Task {
    
    Task(){
        
    }
    private int index;
    private int startTime;
    private int endTime;
    private String assignTo;
    public int getIndex() {
        return index;
    }
    public int getStartTime() {
        return startTime;
    }
    public int getEndTime() {
        return endTime;
    }
    public void setIndex(int index) {
        this.index = index;
    }
    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }
    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }
    public String getAssignTo() {
        return assignTo;
    }
    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }
    
    
}