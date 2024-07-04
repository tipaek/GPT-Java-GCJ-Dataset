import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Solution solution = new Solution();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            Time[] times = new Time[n];
            for (int j = 0; j < n; j++) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                times[j] = new Time(start, end, j);
            }

            Arrays.sort(times);
            Time cameron = new Time(0, 0, -1);
            Time james = new Time(0, 0, -1);
            List<Role> roles = new ArrayList<>();
            cameron = times[0];
            roles.add(new Role(times[0].index, 'C'));

            boolean impossible = false;
            for (int j = 1; j < n; j++) {
                if (times[j].start >= cameron.end) {
                    roles.add(new Role(times[j].index, 'C'));
                    cameron = times[j];
                } else if (times[j].start >= james.end) {
                    roles.add(new Role(times[j].index, 'J'));
                    james = times[j];
                } else {
                    System.out.println("Case #" + (i + 1) + ": IMPOSSIBLE");
                    impossible = true;
                    break;
                }
            }

            if (!impossible) {
                Collections.sort(roles);
                StringBuilder result = new StringBuilder();
                for (Role role : roles) {
                    result.append(role.character);
                }
                System.out.println("Case #" + (i + 1) + ": " + result.toString());
            }
        }
    }

    static class Time implements Comparable<Time> {
        int start;
        int end;
        int index;

        public Time(int start, int end, int index) {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(Time other) {
            return Integer.compare(this.start, other.start);
        }
    }

    static class Role implements Comparable<Role> {
        int index;
        char character;

        public Role(int index, char character) {
            this.index = index;
            this.character = character;
        }

        @Override
        public int compareTo(Role other) {
            return Integer.compare(this.index, other.index);
        }
    }
}