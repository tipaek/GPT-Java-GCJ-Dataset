import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();
        for(int caseNum = 0;caseNum < k; caseNum++){
            int n = scan.nextInt();
            PriorityQueue<Time> queue = new PriorityQueue();
            Time[] order = new Time[n];
            for(int i = 0;i<n;i++){
                Time start = new Time(true, scan.nextInt(), null, null);
                Time end = new Time(false, scan.nextInt(), null, null);
                start.finish = end;
                queue.add(start);
                queue.add(end);
                order[i] = start;
            }
            boolean impossible = false;
            boolean Aworking = false;
            boolean Bworking = false;
            while(!queue.isEmpty()){
                Time task = queue.poll();
                if(task.start){
                    if(!Aworking){
                        task.finish.user = "C";
                        Aworking = true;
                    }
                    else if(Aworking && !Bworking){
                        task.finish.user = "J";
                        Bworking = true;
                    }
                    else{
                        impossible = true;
                        break;
                    }
                }
                else{
                    if(task.user.equals("C")){
                        Aworking = false;
                    }
                    if(task.user.equals("J")){
                        Bworking = false;
                    }
                }
            }
            System.out.print("Case #" + (caseNum + 1) + ": ");
            if(!impossible) {
                String solution = "";
                for (Time t : order) {
                    solution += t.finish.user;
                }
                System.out.println(solution);
            }
            else{
                System.out.println("IMPOSSIBLE");
            }

        }

    }

    static class Time implements Comparable<Time>{
        boolean start;
        int time;
        Time finish;
        String user;

        public Time(boolean start, int time, Time finish, String user){
            this.start = start;
            this.time = time;
            this.finish = finish;
            this.user = user;
        }

        public int compareTo(Time t){
            if(time == t.time) {
                if (!t.start && start) {
                    return 1;
                } else if (t.start && !start) {
                    return -1;
                }
            }
            return time - t.time;
        }


    }
}
