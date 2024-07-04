import java.util.*;
import java.io.*;

class Schedule implements Comparable<Schedule>{
    int startTime;
    int endTime;
    int loc;
    public Schedule(int s, int e, int l){
        startTime = s;
        endTime = e;
        loc = l;
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
                schedules[i] = new Schedule(start, end, i);
            }
            Arrays.sort(schedules);
            
            char[] arr=new char[n];
            int jamieEnd=0, cameronEnd=0;
            boolean flag = false;
            for(int i=0; i<n; i++){
                if(cameronEnd <= schedules[i].startTime){
                    arr[schedules[i].loc] = 'C';
                    cameronEnd = schedules[i].endTime;
                }
                else if(jamieEnd <= schedules[i].startTime){
                    arr[schedules[i].loc] = 'J';
                    jamieEnd = schedules[i].endTime;
                }
                else{
                    flag=true;
                    break;
                }
            }
            System.out.print("Case #"+(++c)+": ");
            if(flag==true){
                System.out.println("IMPOSSIBLE");
            }
            else{
                System.out.println(String.valueOf(arr));
            }
        }
        
    }
}