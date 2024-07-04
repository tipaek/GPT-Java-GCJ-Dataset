import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
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
            sortedChores.sort((a, b) -> Integer.compare(a.start, b.start));
            
            int cEnd = 0;
            int jEnd = 0;
            boolean isPossible = true;
            HashMap<Chore, Character> assignments = new HashMap<>();
            
            for (Chore chore : sortedChores) {
                if (chore.start >= cEnd) {
                    cEnd = chore.end;
                    assignments.put(chore, 'C');
                } else if (chore.start >= jEnd) {
                    jEnd = chore.end;
                    assignments.put(chore, 'J');
                } else {
                    isPossible = false;
                    break;
                }
            }
            
            if (!isPossible) {
                System.out.println("IMPOSSIBLE");
            } else {
                StringBuilder result = new StringBuilder();
                for (Chore chore : chores) {
                    result.append(assignments.get(chore));
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