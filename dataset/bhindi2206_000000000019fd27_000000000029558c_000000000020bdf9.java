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
            //for(Task task:tasks){
              //  System.out.println(task.start + ":" + task.end);
        //    }
            int prev = 0, curr = 0;
            String str = "J";
            String prevUser = "J", currUser = "";
            int Jstart = 0, Jend = 0, Cstart=0, Cend = 0, left = 0, right = 0;
            //JValue = tasks.get(0).end;
            Jstart = tasks.get(0).start;
            Jend   = tasks.get(0).end;
            boolean didChange;
            for(i=1;i<n;i++){
                didChange = false;
                left = tasks.get(i).start;
                right = tasks.get(i).end;
                //System.out.println(Jstart);
                //System.out.println(Jend);
                //System.out.println(Cstart);
                //System.out.println(Cend);
                if(prevUser == "J"){
                    if(left>= Jend || right <=Jstart){
                        currUser = "J";
                        Jstart = left;
                        Jend = right;
                        didChange = true;
                    }
                    else if((left< Jend || right>Jstart) && (left>= Cend || right <= Cstart)){ 
                        currUser = "C";
                        Cstart = left;
                        Cend = right;
                        didChange = true;
                    }
                    
                }
                else if(prevUser == "C"){
                    if(left>= Cend || right <= Cstart){
                        currUser = "C";
                        Cstart = left;
                        Cend = right;
                        didChange = true;
                        
                    }
                    else if((left< Cend || right>Cstart) && (left>= Jend || right <=Jstart)){
                        //System.out.println("Hi");
                        currUser = "J";
                        Jstart = left;
                        Jend = right;
                        didChange = true;
                    }
                }
                
                /*if(prevUser == "C"){
                    if(prev<=curr && CValue<=prev){
                        System.out.println("A");
                        didChange = true;
                        currUser = "C";
                        CValue = tasks.get(i).end;
                    }
                    else if(prev>=curr && JValue<=prev){
                        System.out.println("B");
                        didChange = true;
                        currUser = "J";
                        JValue = tasks.get(i).end;
                    }
                }
                else if(prevUser == "J"){
                    if(prev<=curr && JValue<=prev){
                        System.out.println("C");
                        didChange = true;
                        currUser = "J";
                        JValue = tasks.get(i).end;
                    }
                    else if(prev>=curr && CValue<=prev){
                        System.out.println("D");
                        didChange = true;
                        currUser = "C";
                        CValue = tasks.get(i).end;
                    }
                }*/
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