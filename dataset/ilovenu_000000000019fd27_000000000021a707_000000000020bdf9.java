
import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        Solution p = new Solution();

        int numTest = Integer.valueOf(line);
        for (int i = 0; i < numTest; i++) {
            String each = br.readLine();
            int numSchedule = Integer.valueOf(each);
            List<List<Integer>> array = new ArrayList<>();
            for (int j = 0; j < numSchedule; j++) {
                String[] schedule = br.readLine().split(" ");
                List<Integer> eachSchedule = new ArrayList<>();
                eachSchedule.add(Integer.valueOf(schedule[0]));
                eachSchedule.add(Integer.valueOf(schedule[1]));
                eachSchedule.add(j);
                array.add(eachSchedule);
            }
            p.schedule(array, i+1);
        }
    }

    private void schedule(List<List<Integer>> array, int num) {
        Collections.sort(array, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                if (o1.get(0) == o2.get(0)) {
                    return o1.get(2) < o2.get(2) ? -1: 1;
                }
                return o1.get(0) < o2.get(0) ? -1: 1;
            }
        });

        List<List<Integer>> first = new ArrayList<>();
        List<List<Integer>> second = new ArrayList<>();
        String output = "Case #" + num +": ";
        for (int i = 0; i < array.size(); i++) {
            List<Integer> current = array.get(i);
            if (first.size() == 0 || first.get(first.size() - 1).get(1) <= current.get(0)) {
                first.add(current);
            }
            else {
                if (second.size() > 0 && second.get(second.size() - 1).get(1) > current.get(0)) {
                    output += "IMPOSSIBLE";
                    System.out.println(output);
                    return;
                }
                second.add(current);
            }
        }

        char[] outputArray = new char[array.size()];
        for (int i = 0; i < first.size(); i++) {
            int index = first.get(i).get(2);
            outputArray[index] = 'C';
        }
        for (int i = 0; i < second.size(); i++) {
            int index = second.get(i).get(2);
            outputArray[index] = 'J';
        }
        output += new String(outputArray);
        System.out.println(output);
    }

}

//
// 1 6  2 5  3 4  100 301  150 250
//
//
// 1 100   100 301
// 2 5  99 150  150 250