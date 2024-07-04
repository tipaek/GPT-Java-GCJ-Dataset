import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1 ; t <= T ; t++){
            int N = sc.nextInt();
            TimeInterval[] timeIntervals = new TimeInterval[N];
            TimeInterval[] copy = new TimeInterval[N];
            for(int i = 0 ; i < N ; i++){
                int Si = sc.nextInt();
                int Ei = sc.nextInt();
                timeIntervals[i] = new TimeInterval(Si, Ei, i);
            }
            System.out.print("Case #" + t + ": ");
            Arrays.sort(timeIntervals);
            int cEndTime = Integer.MIN_VALUE;
            int jEndTime = Integer.MIN_VALUE;
            boolean flag = false;
            for(int i = 0 ; i < N ; i++){
                if(flag == true)
                    break;
                int taskEndTime = timeIntervals[i].getEnd();
                int taskStartTime = timeIntervals[i].getStart();
                if(i == 0){
                    timeIntervals[i].setAssingedTo('C');
                    cEndTime = taskEndTime;
                    continue;
                }
                if(cEndTime <= taskStartTime){
                    timeIntervals[i].setAssingedTo('C');
                    cEndTime = taskEndTime;
                }else if(jEndTime <= taskStartTime){
                    timeIntervals[i].setAssingedTo('J');
                    jEndTime = taskEndTime;
                }else{
                    timeIntervals[i].setAssingedTo('I');
                    flag = true;
                }
            }
            if(flag == true){
                System.out.print("IMPOSSIBLE");
            }else{
                StringBuilder sb = new StringBuilder(N);
                char[] ans = new char[N];
                for(int i = 0 ; i < N ; i++){
                    ans[timeIntervals[i].getPos()] = timeIntervals[i].getAssingedTo();
                }
                System.out.print(new String(ans));
            }
            System.out.println();
        }
    }
}

class TimeInterval implements Comparable<TimeInterval>{
    private int start;
    private int end;
    private char assingedTo;
    private int pos;

    public TimeInterval(int start, int end, int pos){
        this.start = start;
        this.end = end;
        this.pos = pos;
    }

    public int getStart(){return this.start;}
    public int getEnd(){return this.end;}
    public int getPos(){return this.pos;}
    public String toString(){
        return "(" + this.start + " " + this.end + ")";
    }
    public void setAssingedTo(char s){this.assingedTo = s;}
    public char getAssingedTo(){return this.assingedTo;}

    public int compareTo(TimeInterval that){
        if(this.start < that.start){
            return -1;
        }else if(this.start > that.start){
            return +1;
        }else{
            if(this.end < that.end){
                return -1;
            }else if(this.end > that.end){
                return +1;
            }else{
                return 0;
            }
        }
    }
}