import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tsize = scanner.nextInt();
        for (int t = 0; t < tsize; t++) {
            int size = scanner.nextInt();
            char[] result = new char[size];
            int[] slot = new int[2];
            String error = "";
            List<Timeslot> list = new ArrayList<Timeslot>();
            for (int i = 0; i < size; i++) {
                int s = scanner.nextInt();
                int e = scanner.nextInt();
                list.add(new Timeslot(s, e, i));
            }
            list.sort(null);
            
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).start >= slot[0]) {
                    result[list.get(i).index] = 'C';
                    slot[0] = list.get(i).end;
                } else if (list.get(i).start >= slot[1]) {
                    result[list.get(i).index] = 'J';
                    slot[1] = list.get(i).end;
                } else {
                    result = "IMPOSSIBLE".toCharArray();
                    break;
                }
            }
            System.out.println("Case #"+(t+1)+": "+ String.valueOf(result));
        }
    }
    public static class Timeslot implements Comparable<Timeslot>{
        int start;
        int end;
        int index;
        public Timeslot(int s, int e, int i) {
            start = s;
            end = e;
            index = i;
        }
        
        public int compareTo(Timeslot other) {
            if (this.start == other.start) {
                return this.end - other.end;
            }
            return this.start - other.start;
        }
    }
}