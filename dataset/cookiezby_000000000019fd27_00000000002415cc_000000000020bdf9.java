import java.util.*;

class Solution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int caseCount = Integer.valueOf(scanner.nextLine());
        for(int i = 0; i < caseCount; i++) {
            int activityCount = Integer.valueOf(scanner.nextLine());
            int[][] activities = new int[activityCount][2];
            for(int j = 0; j < activityCount; j++) {
                String[] times = scanner.nextLine().split(" ");
                activities[j][0] = Integer.valueOf(times[0]);
                activities[j][1] = Integer.valueOf(times[1]);
            }
            System.out.println(slove(activities, i + 1));
        }  
    }

    public static String slove(int[][] at, int index) {
        HashMap<String, Integer> map = new HashMap();
        for(int i = 0; i < at.length; i++) {
            String key = String.format("%d~%d", at[i][0], at[i][1]);
            map.put(key, i);
        }

        Comparator<int[]> comparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if(a[1] != b[1]) {
                    return a[1] - b[1];
                } else {
                    return a[0] - b[0];
                }
            }
        };
        Arrays.sort(at, comparator);

        int[] c = null;
        int[] j = null;
        char[] result = new char[at.length];
        for(int i = 0; i < at.length; i++) {
            String key = String.format("%d~%d", at[i][0], at[i][1]);
            if(c == null || at[i][0] >= c[1]) {
                c = at[i];
                result[map.get(key)] = 'C';
            } else if(j == null || at[i][0] >= j[1]) {
                j = at[i];
                result[map.get(key)] = 'J';
            } else {
                return String.format("Case #%d: IMPOSSIBLE", index);
            }
        }
        return String.format("Case #%d: %s",index, new String(result));
    }
}