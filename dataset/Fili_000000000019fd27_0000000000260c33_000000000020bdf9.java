import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int i = 1; i <= T; i++) {
            int N = scanner.nextInt();
            List<Pair> activities = new ArrayList<>();
            char[] schedule = new char[N];
            for(int j = 0; j < N; j++) {
                int S = scanner.nextInt();
                int E = scanner.nextInt();
                activities.add(new Pair(S, E, j));
            }
            activities.sort(Comparator.comparing(Pair::getEnd).thenComparing(Pair::getStart));
            int C = 0, J = 0, a;
            for(a = 0; a < activities.size(); a++) {
                if(activities.get(a).getStart() >= C) {
                    schedule[activities.get(a).getIndex()] = 'C';
                    C = activities.get(a).getEnd();
                }
                else if(activities.get(a).getStart() >= J) {
                    schedule[activities.get(a).getIndex()] = 'J';
                    J = activities.get(a).getEnd();
                }
                else {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    break;
                }
            }
            if(a == activities.size()) {
                System.out.print("Case #" + i + ": ");
                for (char c : schedule) {
                    System.out.print(c);
                }
                if(i != T) {
                    System.out.print("\n");
                }
            }
        }
    }
}

class Pair {
    int start;
    int end;
    int index;

    public Pair(int start, int end, int index) {
        this.start = start;
        this.end = end;
        this.index = index;
    }

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public int getIndex() {
        return index;
    }
}
