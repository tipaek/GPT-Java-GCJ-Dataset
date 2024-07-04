import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Test {
    static  class Task{
        int startTime;
        int endTime;

        Task(int startTime,int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int t = sc.nextInt();
       int c =1;
       while(c < t+1){
           int N = sc.nextInt();
           List<Task> list = new ArrayList<>();
           while(--N >= 0){
               int startTime = sc.nextInt();
               int endTime = sc.nextInt();
               list.add(new Task(startTime,endTime));
           }
           String res="C";
           int i;
           boolean flag = true;
           for(i = 1; i < list.size()-1; i++){
               Task prev = list.get(i-1);
               Task curr = list.get(i);
               Task next = list.get(i+1);
               if(curr.startTime < prev.endTime){
                   if(res.charAt(i-1) == 'J'){
                       res+="C";
                   }
                   else{
                       res+="J";
                   }
                   if(next.startTime < curr.endTime && next.startTime < prev.endTime){
                       System.out.println("Case #"+(c)+": "+"IMPOSSIBLE");
                       flag  = false;
                       break;
                   }
               }
               else if(curr.startTime == prev.endTime){
                   res+=res.charAt(i-1);
               }
               else{
            	   res+=res.charAt(i-1);
               }
           }
           Task new_prev = list.get(i-1);
           Task new_curr = list.get(i);
           
        		   
           if(res.charAt(i-1) == 'J' && new_curr.startTime >= new_prev.endTime){
               res+="J";
           }
           else if(res.charAt(i-1) == 'J' && new_curr.startTime < new_prev.endTime){
               res+="C";
           }
           else if(res.charAt(i-1) == 'C' && new_curr.startTime >= new_prev.endTime){
               res+="C";
           }
           else {
        	   res+="J";
           }
           if (flag) {
               System.out.println("Case #"+(c)+": "+res);
           }
        c++;
       }
    }
}

