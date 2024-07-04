import java.util.*;

public class Solution {

    public static void main(String[] args) {
        solve(Solution::solveParentingPartnering);
        System.exit(0);
    }

    private static void solve(Function<Scanner, String> solveLine) {
        Scanner in = new Scanner(System.in);
        int testCases = in.nextInt();

        for (int i = 0; i < testCases; i++) {
            System.out.println("Case #" + (i + 1) + ": " + solveLine.apply(in));
        }
    }

    private static String solveParentingPartnering(Scanner in) {
        List<Work> solutions = new ArrayList<>();
        solutions.add(new Work());
        int n = in.nextInt();
        
        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            List<Work> newSolutions = new ArrayList<>();
            
            for (Work solution : solutions) {
                if (solution.failed) continue;
                
                if (canDoWork(start, end, solution.cHours)) {
                    if (canDoWork(start, end, solution.jHours)) {
                        Work newWork = new Work(solution);
                        newSolutions.add(newWork);
                        newWork.schedule.append("J");
                        newWork.jHours.add(start);
                        newWork.jHours.add(end);
                    }
                    solution.cHours.add(start);
                    solution.cHours.add(end);
                    solution.schedule.append("C");
                } else if (canDoWork(start, end, solution.jHours)) {
                    if (canDoWork(start, end, solution.cHours)) {
                        Work newWork = new Work(solution);
                        newSolutions.add(newWork);
                        newWork.schedule.append("C");
                        newWork.cHours.add(start);
                        newWork.cHours.add(end);
                    }
                    solution.schedule.append("J");
                    solution.jHours.add(start);
                    solution.jHours.add(end);
                } else {
                    solution.failed = true;
                }
            }
            solutions.addAll(newSolutions);
        }
        
        return solutions.stream()
                        .filter(s -> !s.failed)
                        .map(w -> w.schedule.toString())
                        .findFirst()
                        .orElse("IMPOSSIBLE");
    }

    private static boolean canDoWork(int start, int end, List<Integer> works) {
        for (int i = 0; i < works.size(); i += 2) {
            int wStart = works.get(i);
            int wEnd = works.get(i + 1);
            if ((start >= wStart && start < wEnd) || (end > wStart && end <= wEnd) || (start <= wStart && end >= wEnd)) {
                return false;
            }
        }
        return true;
    }

    private static class Work {
        StringBuilder schedule;
        List<Integer> cHours;
        List<Integer> jHours;
        boolean failed;

        Work() {
            schedule = new StringBuilder();
            cHours = new ArrayList<>();
            jHours = new ArrayList<>();
            failed = false;
        }

        Work(Work other) {
            schedule = new StringBuilder(other.schedule);
            cHours = new ArrayList<>(other.cHours);
            jHours = new ArrayList<>(other.jHours);
            failed = other.failed;
        }
    }
}