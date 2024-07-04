import java.util.*;

public class Solution {
    Scanner scanner = new Scanner(System.in);

    private void assign() {
        int test = scanner.nextInt();
        for (int z = 0; z < test; z++) {
            int n = scanner.nextInt();
            String[] div = new String[n];
            Interval[] in = new Interval[n];
            for (int i = 0; i < n; i++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                in[i] = new Interval(start, end, i);
                div[i] = "";
            }
            int cam = 0;
            int jam = 0;
            boolean possible = true;
            Arrays.sort(in);
            for (int i = 0; i < n; i++) {
                if (in[i].start >= cam) {
                    cam = in[i].end;
                    div[in[i].id] = "C";
                } else if (in[i].start >= jam) {
                    jam = in[i].end;
                    div[in[i].id] = "J";
                } else {
                    possible = false;
                    break;
                }
            }
            int number = z + 1;
            System.out.println();
            System.out.print("Case #" + number + ": ");
            if (possible) {
                for (int i = 0; i < n; i++) {
                    System.out.print(div[i]);
                }
            } else {
                System.out.print("IMPOSSIBLE");
            }
        }
    }

    public static void main(String[] args) {
        Solution partner = new Solution();
        partner.assign();
    }
}

class Interval implements Comparable<Interval> {
    int start;
    int end;
    int id;

    public Interval(int start, int end, int id) {
        this.start = start;
        this.end = end;
        this.id = id;
    }

    public int compareTo(Interval comp) {
        return this.start - comp.start;
    }
}