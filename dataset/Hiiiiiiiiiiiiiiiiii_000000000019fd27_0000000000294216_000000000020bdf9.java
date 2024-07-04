import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        for(int i=1; i <= tc; i++) {
            int size = sc.nextInt();
            int[][] nums = new int[size][2];
            Stack<int[]> cstack = new Stack<>();
            Stack<int[]> jstack = new Stack<>();
            Map<int[], Integer> map = new HashMap<>();
            String result = "";

            for(int j=0; j < size; j++) {
                nums[j][0] = sc.nextInt();
                nums[j][1] = sc.nextInt();

                map.put(nums[j], j);
            }

            int[][] sorted = nums.clone();

            java.util.Arrays.sort(sorted, new java.util.Comparator<int[]>() {
                public int compare(int[] a, int[] b) {
                    return Double.compare(a[0], b[0]);
                }
            });

            result = search(sorted, cstack, jstack, map);

            System.out.println("Case #" + i + ": " + result);
        }
    }

    public static String search(int[][] sorted, Stack<int[]> cstack, Stack<int[]> jstack,
                              Map<int[], Integer> map) {
        String result = "";
        char person = 'J';
        boolean impo = false;

        char[] chars = new char[sorted.length];
        for(int i=0; i < sorted.length; i++) {
            chars[map.get(sorted[i])] = person;

            if(i < sorted.length - 1 && sorted[i][1] > sorted[i+1][0]) {
                if(person == 'J') {
                    jstack.push(sorted[i]);
                    person = 'C';

                    if (!cstack.isEmpty() && cstack.peek()[1] > sorted[i + 1][0]) {
                        impo = true;
                        break;
                    }
                } else {
                    cstack.push(sorted[i]);
                    person = 'J';

                    if (!jstack.isEmpty() && jstack.peek()[1] > sorted[i + 1][0]) {
                        impo = true;
                        break;
                    }
                }
            } else {
                if(person == 'J') {
                    jstack.push(sorted[i]);
                } else {
                    cstack.push(sorted[i]);
                }
            }
        }

        if(impo) {
            result = "IMPOSSIBLE";
        } else {
            result = String.valueOf(chars);
        }

        return result;
    }

}
