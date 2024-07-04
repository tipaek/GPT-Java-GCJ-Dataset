import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = scanner.nextInt();
        for(int t = 1; t <= testCases; t++) {
            String output = null;
            int n = scanner.nextInt();
            int[] start = new int[n];
            int[] end = new int[n];
            char[] scheduleArray = new char[n];
            for (int i = 0; i < n; i++) {
                start[i] = scanner.nextInt();
                end[i] = scanner.nextInt();
            }
            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    scheduleArray[i] = 'C';
                } else {
                    Set<Character> characters = new HashSet<>();
                    for (int j = i; j > 0; j--) {
                        if ((start[i] > start[j - 1] && start[i] < end[j - 1]) || (end[i] > start[j - 1] && end[i] < end[j - 1])) {
                            characters.add(scheduleArray[j - 1]);
                            if (characters.size() > 1) {
                                break;
                            }
                        }
                    }
                    if (characters.size() > 1) {
                        output = "IMPOSSIBLE";
                        break;
                    } else if (characters.isEmpty()){
                        scheduleArray[i] = scheduleArray[i - 1] == 'C' ? 'J' : 'C';
                    } else {
                        scheduleArray[i] = characters.contains('C') ? 'J' : 'C';
                    }
                    characters.clear();
                }
            }
            if (null == output) {
                output = String.valueOf(scheduleArray);
            }
            System.out.println("Case #" + t + ": " + output);
        }
    }
}