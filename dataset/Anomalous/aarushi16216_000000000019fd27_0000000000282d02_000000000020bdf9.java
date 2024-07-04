import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int k = 1; k <= t; k++) {
            int numTasks = sc.nextInt();
            int[] startTime = new int[numTasks];
            int[] originalStartTime = new int[numTasks];
            int[] endTime = new int[numTasks];

            HashMap<Integer, ArrayList<Integer>> hmap = new HashMap<>();
            for (int i = 0; i < numTasks; i++) {
                startTime[i] = sc.nextInt();
                originalStartTime[i] = startTime[i];
                endTime[i] = sc.nextInt();

                hmap.computeIfAbsent(startTime[i], k1 -> new ArrayList<>()).add(endTime[i]);
            }

            Arrays.sort(startTime);
            Arrays.sort(endTime);

            int freeJ = -1;
            int freeC = -1;

            int startIndex = 0;
            int endIndex = 0;

            StringBuilder str = new StringBuilder();
            boolean impossible = false;

            while (startIndex < numTasks && endIndex < numTasks) {
                if (startTime[startIndex] < endTime[endIndex]) {
                    if (freeJ == -1) {
                        str.append("J");
                        freeJ = startTime[startIndex];
                    } else if (freeC == -1) {
                        str.append("C");
                        freeC = startTime[startIndex];
                    } else {
                        impossible = true;
                        break;
                    }
                    startIndex++;
                } else {
                    boolean found = false;
                    if (freeJ != -1) {
                        ArrayList<Integer> arr = hmap.get(freeJ);
                        if (arr.contains(endTime[endIndex])) {
                            freeJ = -1;
                            found = true;
                        }
                    }
                    if (!found && freeC != -1) {
                        ArrayList<Integer> arr = hmap.get(freeC);
                        if (arr.contains(endTime[endIndex])) {
                            freeC = -1;
                        }
                    }
                    endIndex++;
                }
            }

            if (impossible) {
                str = new StringBuilder("IMPOSSIBLE");
            } else {
                HashMap<Integer, ArrayList<Character>> order = new HashMap<>();
                for (int i = 0; i < str.length(); i++) {
                    order.computeIfAbsent(startTime[i], k1 -> new ArrayList<>()).add(str.charAt(i));
                }

                StringBuilder temp = new StringBuilder();
                int index = 0;
                while (index < originalStartTime.length) {
                    ArrayList<Character> arr = order.get(originalStartTime[index]);
                    for (char ch : arr) {
                        temp.append(ch);
                    }
                    while (index + 1 < originalStartTime.length && originalStartTime[index + 1] == originalStartTime[index]) {
                        index++;
                    }
                    index++;
                }
                str = temp;
            }

            System.out.println("Case #" + k + ": " + str.toString());
        }
        sc.close();
    }
}