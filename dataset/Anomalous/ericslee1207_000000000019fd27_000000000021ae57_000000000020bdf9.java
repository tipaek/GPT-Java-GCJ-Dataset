import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class ChoresScheduler {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        
        for (int i = 0; i < t; i++) {
            int n = scanner.nextInt();
            ArrayList<Chore> chores = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int start = scanner.nextInt();
                int end = scanner.nextInt();
                chores.add(new Chore(start, end));
            }

            ArrayList<Chore> sortedChores = new ArrayList<>(chores);
            sortedChores.sort((a, b) -> a.start - b.start);

            int cEnd = 0;
            int jEnd = 0;
            boolean possible = true;
            HashMap<Chore, Character> assignment = new HashMap<>();

            for (Chore chore : sortedChores) {
                if (chore.start >= cEnd) {
                    cEnd = chore.end;
                    assignment.put(chore, 'C');
                } else if (chore.start >= jEnd) {
                    jEnd = chore.end;
                    assignment.put(chore, 'J');
                } else {
                    possible = false;
                    break;
                }
            }

            if (!possible) {
                System.out.println("IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (Chore chore : chores) {
                    result.append(assignment.get(chore));
                }
                System.out.println(result.toString());
            }
        }
    }

    private static class Chore {
        int start;
        int end;

        public Chore(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}