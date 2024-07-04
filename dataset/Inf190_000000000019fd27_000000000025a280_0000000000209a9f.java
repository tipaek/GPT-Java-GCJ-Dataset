import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tCount = sc.nextInt();
        sc.nextLine();
        for (int t = 1; t <= tCount; t++) {
            String s = sc.nextLine();
            StringBuilder result = new StringBuilder();
            int n = s.length();

            // Converting to int array
            int[] arr = new int[n];
            for (int i = 0; i < n; i++)
                arr[i] = Character.getNumericValue(s.charAt(i));

            // Storing positions of all numbers
            Map<Integer, List<Integer>> position = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int num = Character.getNumericValue(s.charAt(i));
                List<Integer> list = position.getOrDefault(num, new ArrayList<>());
                list.add(i);
                position.put(num, list);
            }

            // Getting distinct elements in asc sort order
            int[] distinct = new int[position.size()];
            int start = 0;
            for (Map.Entry<Integer, List<Integer>> entry : position.entrySet()) {
                distinct[start] = entry.getKey();
                start++;
            }
            Arrays.sort(distinct);

            // Determining the position of the brackets
            int[] prev = new int[n], after = new int[n];
            int[] bCount = new int[n];

            for (int num : distinct) {
                if (num <= 0)
                    continue;
                List<Integer> indices = position.get(num);
                int prevPos = -1;
                int nextPos = -1;
                for (int index : indices) {
                    int diff = arr[index] - bCount[index];

                    if (index >= prevPos && index <= nextPos)
                        continue;
                    prevPos = index;
                    nextPos = index + 1;
                    while (prevPos >= 0 && arr[prevPos] >= arr[index]) {
                        bCount[prevPos] += diff;
                        prevPos--;
                    }
                    prevPos++;
                    prev[prevPos] += diff;
                    while (nextPos < n && arr[nextPos] >= arr[index]) {
                        bCount[nextPos] += diff;
                        nextPos++;
                    }
                    nextPos--;
                    after[nextPos] += diff;
                }
            }

            // Generating the final result string
            for (int i = 0; i < n; i++) {
                if (prev[i] > 0) {
                    for (int j = 0; j < prev[i]; j++)
                        result.append("(");
                }
                result.append(arr[i]);
                if (after[i] > 0) {
                    for (int j = 0; j < after[i]; j++)
                        result.append(")");
                }
            }

            System.out.println("Case #" + t + ": " + result.toString());
        }
        sc.close();
    }
}