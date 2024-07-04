import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tsize = scanner.nextInt();
        for (int t = 0; t < tsize; t++) {
            String result = "";
            int size = scanner.nextInt();
            int[] slot = new int[2];
            List<Timeslot> list = new ArrayList<Timeslot>();
            for (int i = 0; i < size; i++) {
                int s = scanner.nextInt();
                int e = scanner.nextInt();
                list.add(new Timeslot(s, e));
            }
            list.sort(null);
            
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).start >= slot[0]) {
                    result += "C";
                    slot[0] = list.get(i).end;
                } else if (list.get(i).start >= slot[1]) {
                    result += "J";
                    slot[1] = list.get(i).end;
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #"+(t+1)+": "+result);            
        }
    }
    public static class Timeslot implements Comparable<Timeslot>{
        int start;
        int end;
        public Timeslot(int s, int e) {
            start = s;
            end = e;
        }
        
        public int compareTo(Timeslot other) {
            if (this.start == other.start) {
                return this.end - other.end;
            }
            return this.start - other.start;
        }
    }
}