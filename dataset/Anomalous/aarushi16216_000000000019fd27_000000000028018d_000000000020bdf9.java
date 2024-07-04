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

            HashMap<Integer, ArrayList<Integer>> startTimeMap = new HashMap<>();
            for (int i = 0; i < numTasks; i++) {
                startTime[i] = sc.nextInt();
                originalStartTime[i] = startTime[i];
                endTime[i] = sc.nextInt();

                startTimeMap.computeIfAbsent(startTime[i], k1 -> new ArrayList<>()).add(endTime[i]);
            }

            Arrays.sort(startTime);
            Arrays.sort(endTime);

            int freeJ = -1;
            int freeC = -1;
            int startIndex = 0;
            int endIndex = 0;
            StringBuilder schedule = new StringBuilder();
            boolean isImpossible = false;

            while (startIndex < numTasks && endIndex < numTasks) {
                if (startTime[startIndex] < endTime[endIndex]) {
                    if (freeJ == -1) {
                        schedule.append("J");
                        freeJ = startTime[startIndex];
                    } else if (freeC == -1) {
                        schedule.append("C");
                        freeC = startTime[startIndex];
                    } else {
                        isImpossible = true;
                        break;
                    }
                    startIndex++;
                } else {
                    if (freeJ != -1) {
                        ArrayList<Integer> arr = startTimeMap.get(freeJ);
                        if (arr.contains(endTime[endIndex])) {
                            freeJ = -1;
                        }
                    }

                    if (freeC != -1 && freeJ != -1) {
                        ArrayList<Integer> arr = startTimeMap.get(freeC);
                        if (arr.contains(endTime[endIndex])) {
                            freeC = -1;
                        }
                    }
                    endIndex++;
                }
            }

            if (isImpossible) {
                System.out.println("Case #" + k + ": IMPOSSIBLE");
            } else {
                HashMap<Integer, ArrayList<Character>> orderMap = new HashMap<>();
                for (int i = 0; i < schedule.length(); i++) {
                    orderMap.computeIfAbsent(startTime[i], k1 -> new ArrayList<>()).add(schedule.charAt(i));
                }

                StringBuilder finalSchedule = new StringBuilder();
                int index = 0;
                while (index < originalStartTime.length) {
                    ArrayList<Character> characters = orderMap.get(originalStartTime[index]);
                    while (index + 1 < originalStartTime.length && originalStartTime[index + 1] == originalStartTime[index]) {
                        index++;
                    }
                    for (char c : characters) {
                        finalSchedule.append(c);
                    }
                    index++;
                }

                System.out.println("Case #" + k + ": " + finalSchedule);
            }
        }
        sc.close();
    }
}