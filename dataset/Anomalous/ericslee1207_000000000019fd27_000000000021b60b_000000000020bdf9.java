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
            
            int cEndTime = 0;
            int jEndTime = 0;
            String result = "";
            HashMap<Chore, Character> assignments = new HashMap<>();
            
            for (Chore chore : sortedChores) {
                if (chore.start >= cEndTime) {
                    cEndTime = chore.end;
                    assignments.put(chore, 'C');
                } else if (chore.start >= jEndTime) {
                    jEndTime = chore.end;
                    assignments.put(chore, 'J');
                } else {
                    result = "IMPOSSIBLE";
                    break;
                }
            }
            
            int caseNumber = i + 1;
            if (result.equals("IMPOSSIBLE")) {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            } else {
                StringBuilder schedule = new StringBuilder();
                for (Chore chore : chores) {
                    schedule.append(assignments.get(chore));
                }
                System.out.println("Case #" + caseNumber + ": " + schedule.toString());
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