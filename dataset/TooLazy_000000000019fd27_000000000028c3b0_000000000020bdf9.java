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
            int ava_c = 0;
            int ava_j = 0;
            StringBuilder builder = new StringBuilder();
            boolean stop = false;
            while((!stop) && !schedule.isEmpty()){
                Schedule cur = schedule.poll();
                if(ava_c <= cur.start_time){
                    builder.append('C');
                    ava_c = cur.end_time;
                }
                else if(ava_j <= cur.start_time){
                    builder.append('J');
                    ava_j = cur.end_time;
                }
                else{
                    stop = true;
                }
            }
            if(stop) System.out.println("Case #"+no+": "+ "IMPOSSIBLE");
            else
                System.out.println("Case #"+no+": "+ builder.toString());
        }
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
            return s1.start_time - s2.start_time;
        }
    };
}