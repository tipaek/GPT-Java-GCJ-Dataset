import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numOfTest = Integer.parseInt(input.nextLine());
        for (int caseIndex = 0; caseIndex < numOfTest; caseIndex++) {
            int numOfActive = Integer.parseInt(input.nextLine());
            List<Pair> activities = new ArrayList<>();
            for (int i = 0; i < numOfActive; i++) {
                String[] tmp = input.nextLine().split(" ");
                activities.add(new Pair(Long.parseLong(tmp[0]), Long.parseLong(tmp[1])));
            }
            solve(caseIndex + 1, numOfActive, activities);
        }
    }

    private static void solve(int caseIndex, int numOfActive, List<Pair> activities) {

        List<Pair> cCares = new ArrayList<>();
        List<Pair> jCares = new ArrayList<>();
        StringBuilder solution = new StringBuilder();
        for (Pair activity : activities) {
            if (possibleAssign(cCares, activity)) {
                solution.append("C");
                continue;
            }
            if (possibleAssign(jCares, activity)) {
                solution.append("J");
                continue;
            }
            solution = new StringBuilder("IMPOSSIBLE");
            break;
        }

        System.out.println(String.format("Case #%s: %s", caseIndex, solution.toString()));
    }

    private static boolean possibleAssign(List<Pair> takeCare, Pair activity) {
        takeCare.add(activity);
        if (takeCare.size() == 1) {
            return true;
        }

        takeCare.sort((o1, o2) -> (int) (o1.start - o2.start));
        long pe = takeCare.get(0).end;
        for (int i = 1; i < takeCare.size(); i++) {
            if (pe > takeCare.get(i).start) {
                takeCare.remove(activity);
                return false;
            }
            pe = takeCare.get(i).end;
        }
        return true;
    }

    private static class Pair {
        public long start;
        public long end;

        public Pair(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
}