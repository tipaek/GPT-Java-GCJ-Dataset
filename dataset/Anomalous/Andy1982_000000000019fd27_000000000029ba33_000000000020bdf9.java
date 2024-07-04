import java.util.*;

class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int noOfTestCases = input.nextInt();
        List<List<String>> listOfInput = new ArrayList<>();

        for (int i = 0; i < noOfTestCases; i++) {
            int dimension = input.nextInt();
            input.nextLine();
            List<String> list = new ArrayList<>();
            for (int j = 0; j < dimension; j++) {
                list.add(input.nextLine());
            }
            listOfInput.add(list);
        }

        for (int i = 0; i < listOfInput.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + findSchedule(listOfInput.get(i)));
        }
    }

    private static String findSchedule(List<String> list) {
        int[][] schedule = new int[list.size()][2];
        int[][] originalSchedule = new int[list.size()][2];
        char[] parents = {'C', 'J'};
        Map<Integer, Character> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            String[] arr = list.get(i).split(" ");
            schedule[i][0] = Integer.parseInt(arr[0]);
            schedule[i][1] = Integer.parseInt(arr[1]);
            originalSchedule[i][0] = schedule[i][0];
            originalSchedule[i][1] = schedule[i][1];
        }

        Arrays.sort(schedule, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        StringBuilder sb = new StringBuilder();
        pq.add(schedule[0][1]);
        int turn = 0;
        map.put(schedule[0][1], parents[turn]);

        for (int i = 1; i < schedule.length; i++) {
            if (schedule[i][0] >= pq.peek()) {
                int value = pq.poll();
                char ch = map.get(value);
                pq.add(schedule[i][1]);
                map.put(schedule[i][1], ch);
                turn = (ch == 'C') ? 0 : 1;
            } else {
                if (pq.size() >= 2) {
                    return "IMPOSSIBLE";
                }
                turn = 1 - turn;
                pq.add(schedule[i][1]);
                map.put(schedule[i][1], parents[turn]);
            }
        }

        for (int[] interval : originalSchedule) {
            sb.append(map.get(interval[1]));
        }

        return sb.toString();
    }
}