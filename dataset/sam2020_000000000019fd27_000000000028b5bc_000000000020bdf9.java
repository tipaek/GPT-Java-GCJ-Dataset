import java.util.*;

class Schedule {
    int start;
    int end;
    char user;
    int index;

    public Schedule(int a, int b, char c, int i) {
        start = a;
        end = b;
        user = c;
        index = i;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = sc.nextInt();

        int counter = 1;

        while(testCases-- > 0) {
            int size = sc.nextInt();
            Schedule[] intervals = new Schedule[size];

            for(int i = 0; i < size; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                Schedule s = new Schedule(x, y, 'C', i);
                intervals[i] = s;
            }

            Arrays.sort(intervals, (obj1, obj2) -> obj1.start - obj2.start);
            PriorityQueue<Schedule> queue = new PriorityQueue<Schedule>((obj1, obj2) -> obj1.end - obj2.end);
            
            queue.add(intervals[0]);
            StringBuilder users = new StringBuilder(size);
            for(int i = 0; i < size; i++) {
                users.append("C");
            }
            users.setCharAt(queue.peek().index, queue.peek().user);
            
            for(int i = 1; i < intervals.length; i++){
                Schedule interval = intervals[i];
                if(interval.start >= queue.peek().end){
                    users.setCharAt(interval.index, queue.peek().user);
                    interval.user = queue.peek().user;
                    queue.poll();
                    queue.add(interval);
                }
                else {
                    char c = queue.peek().user;
                    if(c == 'C') {
                        users.setCharAt(interval.index, 'J');
                        interval.user = 'J';
                    }
                    else {
                        users.setCharAt(interval.index, 'C');
                        interval.user = 'C';
                    }
                    queue.add(interval);
                }
            }
            if(queue.size() <= 2) {
                System.out.println("Case #"+counter+": "+users.toString());
            }
            else {
                System.out.println("Case #"+counter+": IMPOSSIBLE");
            }
            counter++;
        }
    }
}