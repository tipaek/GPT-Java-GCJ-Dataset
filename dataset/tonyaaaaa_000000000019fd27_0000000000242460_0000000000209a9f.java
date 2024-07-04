import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scan.nextInt();
        for (int test = 1; test <= tests; test++) {
            List<Group> groups = splitIntoGroups(scan.next());
            for (int i = 9; i > 0; i--) {
                List<Group> newGroups = new ArrayList<>();
                Group prev = null;
                for (Group g : groups) {
                    if (g.value == i) {
                        g.s = "(" + g.s + ")";
                        g.value--;
                    }
                    if (prev == null) {
                        prev = g;
                    }
                    else if (g.value == prev.value) {
                        prev = prev.mergeWith(g);
                    } else {
                        newGroups.add(prev);
                        prev = g;
                    }
                }
                newGroups.add(prev);
                groups = newGroups;
            }

            System.out.println("Case #" + test + ": " + groups.get(0).s);
        }
    }

    private static List<Group> splitIntoGroups(String s) {
        char prev = 'A';
        int i = 0;
        List<Group> groups = new ArrayList<>();
        Group g = null;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c != prev) {
                g = new Group(c - '0', String.valueOf(c));
                groups.add(g);
            } else {
                g.s += c;
            }
            prev = c;
            i++;
        }
        return groups;
    }

    static class Group {
        int value;
        String s;
        public Group(int value, String s) {
            this.value = value;
            this.s = s;
        }
        public Group mergeWith(Group that) {
            return new Group(value, s + that.s);
        }
    }
}
