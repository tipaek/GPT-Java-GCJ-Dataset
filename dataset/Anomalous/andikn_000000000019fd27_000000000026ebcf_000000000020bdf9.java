import java.util.*;

public class Solution {
   public static boolean overlaps(int[] a, int[] b) {
      return Math.max(a[0], b[0]) < Math.min(a[1], b[1]);
   }

   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();

       for (int t = 1; t <= testCases; t++) {
           int n = scanner.nextInt();
           int[] schedule = new int[n];
           boolean impossible = false;

           List<int[]> intervals = new ArrayList<>();
           for (int i = 0; i < n; i++) {
               int start = scanner.nextInt();
               int end = scanner.nextInt();
               intervals.add(new int[]{start, end, i});
           }

           intervals.sort((a, b) -> {
               if (a[0] != b[0]) {
                   return a[0] - b[0];
               }
               return b[1] - a[1];
           });

           TreeMap<Integer, Integer> activeIntervals = new TreeMap<>();
           for (int[] interval : intervals) {
               int start = interval[0];
               int end = interval[1];
               int index = interval[2];

               Iterator<Map.Entry<Integer, Integer>> iterator = activeIntervals.entrySet().iterator();
               while (iterator.hasNext()) {
                   Map.Entry<Integer, Integer> entry = iterator.next();
                   if (entry.getKey() <= start) {
                       iterator.remove();
                   }
               }

               Set<Integer> availableLabels = new HashSet<>(Arrays.asList(0, 1));
               for (int label : activeIntervals.values()) {
                   availableLabels.remove(label);
               }

               if (availableLabels.isEmpty()) {
                   impossible = true;
                   break;
               }

               int assignedLabel = availableLabels.iterator().next();
               schedule[index] = assignedLabel;
               activeIntervals.put(end, assignedLabel);
           }

           System.out.print("Case #" + t + ": ");
           if (impossible) {
               System.out.println("IMPOSSIBLE");
           } else {
               for (int i = 0; i < n; i++) {
                   System.out.print(schedule[i] == 0 ? "C" : "J");
               }
               System.out.println();
           }
       }
       scanner.close();
   }
}