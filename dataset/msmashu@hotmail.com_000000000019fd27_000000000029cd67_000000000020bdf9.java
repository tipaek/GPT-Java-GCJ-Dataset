import java.util.*;
import java.io.*;
 public class Solution {
 public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tcNumber = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= tcNumber; ++i) {
            int taskNum = in.nextInt();
            List<List<Integer>> intervals = new ArrayList<>();
            for(int j=0; j<taskNum; j++) {
                List<Integer> oneTask = new ArrayList<>();
                for(int k=0; k<2; k++) {
                    oneTask.add(in.nextInt());
                }
                oneTask.add(j);
                intervals.add(oneTask);
            }
            
            Collections.sort(intervals, new Comparator<List<Integer>>() {
            	@Override
            	public int compare(List<Integer> p1, List<Integer> p2) {
            		return p1.get(0) - p2.get(0);
            	}
            });
            
            char[] res = new char[taskNum];
            int end1 = 0;
            int end2 = 0;
            for(int k=0; k<taskNum; k++) {
                List<Integer> oneTask = intervals.get(k);
                if(oneTask.get(0) >= end1 && oneTask.get(0) >= end2) {
                    if(end1 > end2) {
                        res[oneTask.get(2)] = 'C';
                        end1 = oneTask.get(1);
                    } else {
                        res[oneTask.get(2)] = 'J';
                        end2 = oneTask.get(1);
                    }
                } else if(oneTask.get(0) >= end1) {
                    res[oneTask.get(2)] = 'C';
                    end1 = oneTask.get(1);
                } else if (oneTask.get(0) >= end2) {
                    res[oneTask.get(2)] = 'J';
                    end2 = oneTask.get(1);
                } else {
                    res = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + i + ": " + res.toString());
        }

  }
}