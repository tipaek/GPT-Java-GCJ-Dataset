import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int n = scanner.nextInt();
            int[][] intervals = new int[n][2];
            
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    intervals[j][k] = scanner.nextInt();
                }
            }

            List<Integer> numbers = Arrays.asList(65, 12, 44, 23, 78, 43, 22, 18, 90, 6, 45, 0, 11, 33, 24, 56, 32, 10, 55, 39, 11, 188);
            int sum = numbers.stream().mapToInt(Integer::intValue).sum();
            int min = Collections.min(numbers);
            
            //System.out.println(min);
            //System.out.println(sum);
            
            List<Activity> activitiesList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                activitiesList.add(new Activity(intervals[j][0], intervals[j][1], j));
            }

            activitiesList.sort(Comparator.comparingInt((Activity a) -> a.start)
                                          .thenComparingInt(a -> a.end)
                                          .thenComparingInt(a -> a.index));

            int cEnd = 0, jEnd = 0;
            boolean impossible = false;
            String[] result = new String[n];
            
            for (Activity activity : activitiesList) {
                if (activity.start < cEnd && activity.start < jEnd) {
                    impossible = true;
                    break;
                } else if (activity.start >= cEnd) {
                    result[activity.index] = "C";
                    cEnd = activity.end;
                } else {
                    result[activity.index] = "J";
                    jEnd = activity.end;
                }
            }
            
            System.out.print("Case #" + (i + 1) + ": ");
            if (impossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                for (String res : result) {
                    System.out.print(res);
                }
                System.out.println();
            }
        }
        scanner.close();
    }
}

class Activity {
    int start, end, index;
    
    Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }
}