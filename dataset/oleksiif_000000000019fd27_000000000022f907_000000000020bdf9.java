public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for (int caseIndex = 1; caseIndex <= T; caseIndex++) {
            int N = in.nextInt();
            StringBuilder output = new StringBuilder();
            int cameronOccupied = 0;
            int jamieOccupied = 0;
            boolean isPossible = true;
            Integer[][] activities = new Integer[N][2];
            for (int i = 0; i < N; i++) {
                activities[i][0] = in.nextInt();
                activities[i][1] = in.nextInt();
            }
            Arrays.sort(activities, Comparator.comparing(a -> a[0]));

            for (int i = 0; i < N && isPossible; i++) {
                int start = activities[i][0];
                int finish = activities[i][1];
                if (start >= cameronOccupied) {
                    cameronOccupied = finish;
                    output.append("C");
                } else if (start >= jamieOccupied) {
                    jamieOccupied = finish;
                    output.append("J");
                } else {
                    output.setLength(0);
                    output.append("IMPOSSIBLE");
                    isPossible = false;
                }
            }
            System.out.println(String.format("Case #%s: %s", caseIndex, output));
        }
    }
}