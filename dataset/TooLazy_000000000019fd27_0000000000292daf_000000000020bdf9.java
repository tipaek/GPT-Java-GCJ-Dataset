import java.io.*;
import java.util.*;
class Solution{
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int testCase = scanner.nextInt();
        int no = 0;
        while(no < testCase){
            int N = scanner.nextInt();
            no++;
            PriorityQueue<Schedule> schedule = new PriorityQueue<Schedule>(cmp);
            for(int i = 0;i < N;i++){
                schedule.add(new Schedule(scanner.nextInt(), scanner.nextInt()));
            }
            Schedule[] s = new Schedule[schedule.size()];
            s = schedule.toArray(s);
            StringBuilder builder = bingo(0,0,s, new StringBuilder(),0);
            if(builder.length() == 0) System.out.println("Case #"+no+": "+ "IMPOSSIBLE");
            else
                System.out.println("Case #"+no+": "+ builder.toString());
        }
    }
    
    public static StringBuilder bingo(int ava_c, int ava_j, Schedule[] schedule, StringBuilder builder,int index){
      //System.out.println("Bingo"+ava_c+" "+ava_j+" "+builder+" "+schedule.length);
        if(index == schedule.length) return builder;
        Schedule cur = schedule[index];
        if(ava_c <= cur.start_time){
            StringBuilder temp = bingo(cur.end_time,ava_j,schedule,builder.append('C'), index+1);
            if(temp.length() != 0) return temp;
            else
              builder.deleteCharAt(builder.length()-1);
        }
        if(ava_j <= cur.start_time){
            StringBuilder temp = bingo(ava_c,cur.end_time,schedule,builder.append('J'), index+1);
            if(temp.length() != 0) return temp;
            else
              builder.deleteCharAt(builder.length()-1);
        }
        return new StringBuilder();
    }
    
    private static class Schedule{
        public int start_time;
        public int end_time;
        public Schedule(int start_time, int end_time){
            this.start_time = start_time;
            this.end_time = end_time;
        }
    }
    
    private static Comparator<Schedule> cmp = new Comparator<Schedule>(){
        public int compare(Schedule s1, Schedule s2){
            int ss1 = s1.start_time;
            int ss2 = s2.start_time;
            int es1 = s1.end_time;
            int es2 = s2.end_time;
            if(ss1 == ss2) return es1 - es2;
            else
                return ss1 - ss2;
        }
    };
}