import java.util.*;
import java.io.*;

class Schedule implements Comparable<Schedule>{
    int startTime;
    int endTime;
    public Schedule(int s, int e){
        startTime = s;
        endTime = e;
    }
    @Override
    public int compareTo(Schedule schedule){
        return this.startTime-schedule.startTime;
    }
}

class Solution{
    
    public static void main(String args[])throws IOException{
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int c = 0;
        while(t--!=0){
            int n = sc.nextInt();
            Schedule[] schedules = new Schedule[n];
            for(int i=0; i<n; i++){
                int start = sc.nextInt();
                int end = sc.nextInt();
                schedules[i] = new Schedule(start, end);
            }
            Arrays.sort(schedules);
            
            StringBuilder sb = new StringBuilder();
            int jamieEnd=0, cameronEnd=0;
            boolean flag = false;
            for(int i=0; i<n; i++){
                if(jamieEnd <= schedules[i].startTime){
                    sb.append('J');
                    jamieEnd = schedules[i].endTime;
                }
                else if(cameronEnd <= schedules[i].startTime){
                    sb.append('C');
                    cameronEnd = schedules[i].endTime;
                }
                else{
                    flag=true;
                    break;
                }
            }
            System.out.print("Case #"+(c++)+": ");
            if(flag==true){
                System.out.println("IMPOSSIBLE");
            }
            else{
                System.out.println(sb.toString());
            }
        }
        
    }
}