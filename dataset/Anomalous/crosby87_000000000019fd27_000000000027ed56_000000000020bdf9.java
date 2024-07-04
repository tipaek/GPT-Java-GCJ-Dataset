import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    
    public static class Event {
        int start;
        int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static boolean isOverlap(int start1, int end1, int start2, int end2) {
        return (start1 < end2 && end1 > start2);
    }

    public static ArrayList<String> generateBinaryStrings(int n) {
        ArrayList<String> result = new ArrayList<>();
        result.add("");
        for (int i = 0; i < n; i++) {
            ArrayList<String> temp = new ArrayList<>();
            for (String str : result) {
                temp.add(str + "0");
                temp.add(str + "1");
            }
            result = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {
            int N = sc.nextInt();
            Event[] events = new Event[N];

            for (int i = 0; i < N; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                events[i] = new Event(start, end);
            }

            ArrayList<String> binaryStrings = generateBinaryStrings(N);
            boolean foundSolution = false;

            for (String binaryString : binaryStrings) {
                ArrayList<Integer> jamieEvents = new ArrayList<>();
                ArrayList<Integer> cameronEvents = new ArrayList<>();
                boolean isJamieValid = true;
                boolean isCameronValid = true;

                for (int i = 0; i < binaryString.length(); i++) {
                    if (binaryString.charAt(i) == '0') {
                        jamieEvents.add(i);
                    } else {
                        cameronEvents.add(i);
                    }
                }

                for (int i = 0; i < jamieEvents.size(); i++) {
                    for (int j = i + 1; j < jamieEvents.size(); j++) {
                        if (isOverlap(events[jamieEvents.get(i)].start, events[jamieEvents.get(i)].end,
                                      events[jamieEvents.get(j)].start, events[jamieEvents.get(j)].end)) {
                            isJamieValid = false;
                            break;
                        }
                    }
                    if (!isJamieValid) break;
                }

                for (int i = 0; i < cameronEvents.size(); i++) {
                    for (int j = i + 1; j < cameronEvents.size(); j++) {
                        if (isOverlap(events[cameronEvents.get(i)].start, events[cameronEvents.get(i)].end,
                                      events[cameronEvents.get(j)].start, events[cameronEvents.get(j)].end)) {
                            isCameronValid = false;
                            break;
                        }
                    }
                    if (!isCameronValid) break;
                }

                if (isJamieValid && isCameronValid) {
                    System.out.print("Case #" + t + ": ");
                    for (char c : binaryString.toCharArray()) {
                        System.out.print(c == '0' ? 'J' : 'C');
                    }
                    System.out.println();
                    foundSolution = true;
                    break;
                }
            }

            if (!foundSolution) {
                System.out.println("Case #" + t + ": IMPOSSIBLE");
            }
        }
    }
}