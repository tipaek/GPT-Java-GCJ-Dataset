import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

        int T = sc.nextInt();
        sc.nextLine(); // Consume the newline left by nextInt()

        for (int tt = 1; tt <= T; tt++) {
            String rowStr = sc.nextLine();
            int[] arr = new int[rowStr.length()];
            for (int i = 0; i < rowStr.length(); i++) {
                arr[i] = Character.getNumericValue(rowStr.charAt(i));
            }

            Map<Integer, Integer> map = new HashMap<>();
            Set<Integer> set = new HashSet<>();
            for (int num : arr) {
                set.add(num);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }

            int[] arrSort = set.stream().mapToInt(Integer::intValue).toArray();
            Arrays.sort(arrSort);

            StringBuilder s = new StringBuilder();
            for (int i = arrSort.length - 1; i >= 0; i--) {
                int cur = arrSort[i];
                if (cur == arrSort[arrSort.length - 1]) {
                    s.append("(".repeat(cur));
                }
                if (cur != 0) {
                    s.append(String.valueOf(cur).repeat(map.get(cur)));
                    s.append(')');
                }
            }

            if (map.containsKey(0)) {
                s.append("0".repeat(map.get(0)));
            }

            int left = 0, right = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') left++;
                if (s.charAt(i) == ')') right++;
            }
            s.append(")".repeat(left - right));

            System.out.println("Case #" + tt + ": " + s.toString());
        }

        out.close();
    }
}