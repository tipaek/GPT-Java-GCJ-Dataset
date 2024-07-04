import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        int totalMinutes = 24 * 60 + 2;

        for (int caseNum = 1; caseNum <= t; caseNum++) {
            int[] timeline = new int[totalMinutes];
            int n = sc.nextInt();
            Activity[] activities = new Activity[n];

            for (int i = 0; i < n; i++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                timeline[start]++;
                timeline[end]--;
                activities[i] = new Activity(start, end, i);
            }

            Arrays.sort(activities);

            boolean isPossible = true;
            for (int i = 1; i < totalMinutes; i++) {
                timeline[i] += timeline[i - 1];
                if (timeline[i] > 2) {
                    isPossible = false;
                    break;
                }
            }

            sb.append("Case #").append(caseNum).append(": ");

            if (isPossible) {
                char[] result = new char[n];
                char[] assignedChars = {'C', 'J'};
                int currentCharIndex = 0;

                for (int i = 0; i < n; i++) {
                    int start = activities[i].start;
                    int end = activities[i].end;
                    result[activities[i].index] = assignedChars[currentCharIndex];

                    for (int j = i + 1; j < n; j++) {
                        if (activities[j].start < end) {
                            result[activities[j].index] = assignedChars[1 - currentCharIndex];
                            i = j;
                        } else {
                            break;
                        }
                    }

                    currentCharIndex = 1 - currentCharIndex;
                }

                sb.append(new String(result));
            } else {
                sb.append("IMPOSSIBLE");
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}

class Activity implements Comparable<Activity> {
    int start, end, index;

    Activity(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Activity other) {
        return Integer.compare(this.start, other.start);
    }
}