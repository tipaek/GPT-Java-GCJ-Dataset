import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases = Integer.parseInt(sc.nextLine());
        
        for (int t = 1; t <= testCases; t++) {
            int tasksNo = Integer.parseInt(sc.nextLine());
            int[][] tasks = new int[tasksNo][2];
            List<String> result = new ArrayList<>(Collections.nCopies(tasksNo, "J"));

            for (int i = 0; i < tasksNo; i++) {
                String[] input = sc.nextLine().split(" ");
                tasks[i][0] = Integer.parseInt(input[0]);
                tasks[i][1] = Integer.parseInt(input[1]);
            }

            List<Integer> first = new LinkedList<>();
            List<Integer> second = new LinkedList<>();

            for (int i = 0; i < tasks.length; i++) {
                for (int j = 0; j < tasks.length; j++) {
                    if (tasks[i][0] < tasks[j][1] && tasks[i][0] > tasks[j][0]) {
                        first.add(i);
                        second.add(j);
                    }
                }
            }

            for (int i = 0; i < first.size(); i++) {
                int f = first.get(i);
                int s = second.get(i);
                if (result.get(Math.min(f, s)).equals("J")) {
                    result.set(Math.max(f, s), "C");
                } else if (result.get(Math.min(f, s)).equals("C")) {
                    result.set(Math.max(f, s), "J");
                }
            }

            System.out.print("Case #" + t + ": ");
            for (String s : result) {
                System.out.print(s);
            }
            System.out.println();
        }
    }
}