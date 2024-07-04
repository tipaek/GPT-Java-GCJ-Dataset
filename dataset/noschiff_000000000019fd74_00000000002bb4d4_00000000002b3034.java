import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.valueOf(scanner.nextLine());
            String[] patterns = new String[N];
            for (int j = 0; j < N; j++) {
                patterns[j] = scanner.nextLine().replace("*", "x");
            }
            String a = solve(patterns);
            System.out.println("Case #" + (i + 1) + ": " + a);

        }

    }

    private static String solve(String[] patterns) {
        String start = "";
        String end = "";

        for (String pattern : patterns) {
            String[] SPLIT = pattern.split("x");
            String[] halvesOfP = new String[2];
            halvesOfP[0] = SPLIT[0];
            if (SPLIT.length > 1) {
                halvesOfP[1] = SPLIT[1];
            } else {
                halvesOfP[1] = "";
            }

            boolean startsMatch = true;
            boolean endsMatch = true;
            if (start.length() > 0 && halvesOfP[0].length() > 0) {
                startsMatch = start.charAt(0) == halvesOfP[0].charAt(0);
            }
            if (end.length() > 0 && halvesOfP[1].length() > 0) {
                endsMatch = end.charAt(end.length() - 1) == halvesOfP[1].charAt(halvesOfP[1].length() - 1);
            }

            boolean startGood = start.contains(halvesOfP[0]) && startsMatch;
            boolean endGood = end.contains(halvesOfP[1]) && endsMatch;

            if (startGood && endGood) {
                continue;
            }

            boolean modifyStart = halvesOfP[0].contains(start) && startsMatch;
            boolean modifyEnd = halvesOfP[1].contains(end) && endsMatch;
            //System.out.println(Arrays.toString(halvesOfP));
            //System.out.println(start + " " + end);
            //System.out.println(modifyStart + " " + modifyEnd);
            if (modifyEnd && modifyStart) {
                start = halvesOfP[0];
                end = halvesOfP[1];
            } else if (modifyStart && endGood) {
                start = halvesOfP[0];
            } else if (modifyEnd && startGood) {
                end = halvesOfP[1];
            } else {
                return "*";
            }
        }
        return start + end;
    }
}
