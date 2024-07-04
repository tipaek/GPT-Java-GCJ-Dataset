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
            ArrayList<Schedule> ss = new ArrayList<>();
            for(int i = 0;i < N;i++){
              Schedule cur = new Schedule(scanner.nextInt(),scanner.nextInt(),i);
              int j = 0;
              while(j < ss.size() && ss.get(j).start_time <= cur.start_time){
                j++;
              }
              ss.add(j, cur);
            }
            Schedule[] s = new Schedule[N];
            s = ss.toArray(s);
            StringBuilder builder1 = bingo(0,0,s, new StringBuilder(),0);
            if(builder1.length() == 0) System.out.println("Case #"+no+": "+ "IMPOSSIBLE");
            else{
              //System.out.println(builder1);
              char[] temp = new char[N];
            for(int i = 0;i < N;i++){
              temp[ss.get(i).index] = builder1.charAt(i);
            }
            StringBuilder builder = new StringBuilder();
            for(int i = 0;i < N;i++){
              builder.append(temp[i]);
            }
                System.out.println("Case #"+no+": "+ builder.toString());
            }
        }
    }
    
    public static StringBuilder bingo(int ava_c, int ava_j, Schedule[] schedule, StringBuilder builder,int index){
      //System.out.println("Bingo "+ava_c+" "+ava_j+" "+builder+" "+schedule.length);
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
        public int index;
        public Schedule(int start_time, int end_time, int index){
            this.start_time = start_time;
            this.end_time = end_time;
            this.index = index;
        }
    }
}