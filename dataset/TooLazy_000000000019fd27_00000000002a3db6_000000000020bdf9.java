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
            int ava_c = 0;
            int ava_j = 0;
            //StringBuilder builder1 = bingo(0,0,s, new StringBuilder(),0);
            StringBuilder builder1 = new StringBuilder();
            for(int i = 0;i < N;i++){
              if(ava_c <= s[i].start_time){
                builder1.append('C');
                ava_c = s[i].end_time;
              }
              else if(ava_j <= s[i].start_time){
                builder1.append('J');
                ava_j = s[i].end_time;
              }
              else{
                builder1 = new StringBuilder();
                break;
              }
            }
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