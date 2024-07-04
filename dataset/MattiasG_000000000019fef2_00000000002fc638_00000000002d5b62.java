import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            long tests = Long.parseLong(in.readLine());
            for (long test = 0; test < tests; test++) {
                String[] line = in.readLine().split(" ");
                long x = Long.parseLong(line[0]);
                long y = Long.parseLong(line[1]);

                List<Long> chosenXA = new ArrayList<>();
                List<Long> chosenXB = new ArrayList<>();
                List<Long> chosenYA = new ArrayList<>();
                List<Long> chosenYB = new ArrayList<>();

                boolean invertX = x < 0;
                boolean invertY = y < 0;
                x = Math.abs(x);
                y = Math.abs(y);
                long jumpsXA = (long) Math.floor(Math.log(x) / Math.log(2))+1;
                long base = (long) Math.pow(2, jumpsXA-1);
                long xx = x;
                for (long i = base; i > 0; i /= 2) {
                    if (xx - i >= 0) {
                        xx -= i;
                        chosenXA.add(i);
                    }
                }
                xx = base * 2 - x;
                long jumpsXB = jumpsXA + 1;
                chosenXB.add(base * 2);
                for (long i = (long) Math.pow(2, (long) Math.floor(Math.log(base * 2 - x) / Math.log(2))); i > 0; i /= 2) {
                    if (xx - i >= 0) {
                        xx -= i;
                        chosenXB.add(i);
                    }
                }

                long jumpsYA = (long) Math.floor(Math.log(y) / Math.log(2))+1;
                base = (long) Math.pow(2, jumpsYA-1);
                xx = y;
                for (long i = base; i > 0; i /= 2) {
                    if (xx - i >= 0) {
                        xx -= i;
                        chosenYA.add(i);
                    }
                }
                xx = base * 2 - y;
                long jumpsYB = jumpsYA + 1;
                chosenYB.add(base * 2);
                for (long i = (long) Math.pow(2, (long) Math.floor(Math.log(base * 2 - y) / Math.log(2))); i > 0; i /= 2) {
                    if (xx - i >= 0) {
                        xx -= i;
                        chosenYB.add(i);
                    }
                }
                StringBuilder string;

                Set<Long> sum = new HashSet<>();
                sum.addAll(chosenXA);
                sum.addAll(chosenYA);
                if (sum.size() == chosenXA.size() + chosenYA.size() && sum.size() == Math.max(jumpsXA, jumpsYA)) {
                    string = prlong(chosenXA, chosenYA, false, false, invertX, invertY);
                    if (string != null) {
                        System.out.printf("Case #%d: %s\n", test + 1, string.toString());
                        continue;
                    }
                }

                sum = new HashSet<>();
                sum.addAll(chosenXA);
                sum.addAll(chosenYB);
                if (sum.size() == chosenXA.size() + chosenYB.size() && sum.size() == Math.max(jumpsXA, jumpsYB)) {
                    string = prlong(chosenXA, chosenYB, false, true, invertX, invertY);
                    if (string != null) {
                        System.out.printf("Case #%d: %s\n", test + 1, string.toString());
                        continue;
                    }
                }

                sum = new HashSet<>();
                sum.addAll(chosenXB);
                sum.addAll(chosenYA);
                if (sum.size() == chosenXB.size() + chosenYA.size() && sum.size() == Math.max(jumpsXB, jumpsYA)) {
                    string = prlong(chosenXB, chosenYA, true, false, invertX, invertY);
                    if (string != null) {
                        System.out.printf("Case #%d: %s\n", test + 1, string.toString());
                        continue;
                    }
                }

                sum = new HashSet<>();
                sum.addAll(chosenXB);
                sum.addAll(chosenYB);
                if (sum.size() == chosenXB.size() + chosenYB.size() && sum.size() == Math.max(jumpsXB, jumpsYB)) {
                    string = prlong(chosenXB, chosenYB, true, true, invertX, invertY);
                    if (string != null) {
                        System.out.printf("Case #%d: %s\n", test + 1, string.toString());
                        continue;
                    }
                }

                    System.out.printf("Case #%d: %s\n", test + 1, "IMPOSSIBLE");

            }
        }
    }

    private static StringBuilder prlong(List<Long> chosenX, List<Long> chosenY, boolean invertButLastX, boolean invertButLastY, boolean invertX, boolean invertY) {
        char xChar = invertX ? 'W' : 'E';
        char yChar = invertY ? 'S' : 'N';
        char xCharI = invertX ? 'E' : 'W';
        char yCharI = invertY ? 'N' : 'S';
        Collections.reverse(chosenX);
        Collections.reverse(chosenY);
        StringBuilder builder = new StringBuilder();
        int x = 0;
        int y = 0;
        long current = 1;
        while (true) {
            while (x < chosenX.size() && chosenX.get(x) < current) {
                x++;
            }
            while (y < chosenY.size() && chosenY.get(y) < current) {
                y++;
            }
            if (x == chosenX.size() && y == chosenY.size()) {
                break;
            }
            if (x < chosenX.size() && chosenX.get(x) == current) {
                if (x != chosenX.size()-1 && invertButLastX)
                    builder.append(xCharI);
                else
                    builder.append(xChar);
            } else if (y < chosenY.size() && chosenY.get(y) == current) {
                if (y != chosenY.size()-1 && invertButLastY)
                    builder.append(yCharI);
                else
                    builder.append(yChar);
            } else {
                return null;
            }
            current*=2;
        }
        return builder;
    }
}