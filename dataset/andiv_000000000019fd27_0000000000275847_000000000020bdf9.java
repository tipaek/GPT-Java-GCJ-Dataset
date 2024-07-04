import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int totalTests = scanner.nextInt();

        boolean wasPrevNextLine = false;

        for (int i = 1; i <= totalTests; i++) {
            if(!wasPrevNextLine) scanner.nextLine();
            int  N = scanner.nextInt();
            Interval[] intervals = new Interval[N];

            for(int j=0; j<N; j++){
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                intervals[j] = new Interval(start, end, j);
                scanner.nextLine();
            }
            wasPrevNextLine = true;
            String result = solve(intervals);
            System.out.println("Case #"+i+": " + result);
        }

    }


    public static String solve(Interval[] intervals){
        StringBuilder result = new StringBuilder();

        Arrays.sort(intervals, (a, b)->Integer.compare(a.start, b.start));
        int max = 0;
        char first = 'C', second = 'J';
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));
        Map<Character, Interval> map = new HashMap<>();

        for(int i=0; i<intervals.length; i++){
            if(!minHeap.isEmpty() && minHeap.peek().end <= intervals[i].start){
                Interval inter = minHeap.poll();
                map.remove(inter.getCh());
            }

            minHeap.offer(intervals[i]);
            char operator;
            if(!map.containsKey('C')){
                operator = 'C';
                intervals[i].setCh(operator);
                map.put('C', intervals[i]);
            }
            else if(!map.containsKey('J')){
                operator = 'J';
                intervals[i].setCh(operator);
                map.put('J', intervals[i]);
            }
            else{
                return "IMPOSSIBLE";
            }

            max = Math.max(max, minHeap.size());
            if(max > 2) return "IMPOSSIBLE";
        }

        Arrays.sort(intervals, (a, b)->Integer.compare(a.number, b.number));
        for(Interval interval : intervals){
            result.append(interval.getCh());
        }

        return result.toString();
    }

}

class Interval {
    public int start, end, number;
    char ch;

    public Interval(int start, int end, int num){
        this.start = start;
        this.end = end;
        this.number = num;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public void setCh(char ch) {
        this.ch = ch;
    }

    public char getCh() {
        return ch;
    }
}