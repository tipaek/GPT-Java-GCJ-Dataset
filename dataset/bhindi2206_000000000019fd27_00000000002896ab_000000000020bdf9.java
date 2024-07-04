import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;



public class Solution{
    public static class Task implements Comparable<Task>{
        public Integer start;
        public Integer end;
        public Integer index;
        public Character user;
        //public int get 
        
        @Override
        public int compareTo(Task o) {
            return this.start.compareTo(o.start);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int noOfTests = sc.nextInt();
        int t = 0;
        while(t++<noOfTests){
            int n = sc.nextInt();
            List<Task> tasks = new ArrayList<Task>();
            int i=0;
            for(i=0;i<n;i++){
                Task task = new Task();
                task.start = sc.nextInt();
                task.end  = sc.nextInt();
                task.index = i;
                tasks.add(task);
            }
            Collections.sort(tasks);
            
            int CValue = 0, JValue = 0, prev = 0, curr = 0;
            String str = "C";
            String prevUser = "C", currUser = "";
            CValue = tasks.get(0).end;
            boolean didChange;
            for(i=1;i<n;i++){
                didChange = false;
                prev = tasks.get(i-1).end;
                curr = tasks.get(i).start;
                if(prevUser == "C"){
                    if(prev<=curr && CValue<=prev){
                        //System.out.println("A");
                        didChange = true;
                        currUser = "C";
                        CValue = tasks.get(i).end;
                    }
                    else if(prev>curr && JValue<=prev){
                        //System.out.println("B");
                        didChange = true;
                        currUser = "J";
                        JValue = tasks.get(i).end;
                    }
                }
                else if(prevUser == "J"){
                    if(prev<=curr && JValue<=prev){
                        //System.out.println("C");
                        didChange = true;
                        currUser = "J";
                        JValue = tasks.get(i).end;
                    }
                    else if(prev>curr && CValue<=prev){
                        //System.out.println("D");
                        didChange = true;
                        currUser = "C";
                        CValue = tasks.get(i).end;
                    }
                }
                if(didChange)
                    str+=currUser;
                prevUser = currUser;
            }
            char[] str2 = new char[n];
            if(str.length() == n){
                for(i=0;i<n;i++){
                    str2[tasks.get(i).index] = str.charAt(i);
                }
                System.out.println("Case #"+t+": "+String.valueOf(str2));
                
            }
            else
                System.out.println("Case #"+t+": IMPOSSIBLE");
        
            
        }
    }
}