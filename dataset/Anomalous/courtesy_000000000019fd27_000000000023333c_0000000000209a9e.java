import java.io.*;
import java.util.*;

public class Solution {

    public static Scanner scanner = new Scanner(System.in);
    public static PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static void main(String[] args) throws IOException {
        int T = scanner.nextInt();
        for (int cs = 1; cs <= T; cs++) {
            int B = scanner.nextInt();
            int[] A = new int[B];
            if (B == 10) {
                for (int i = 1; i <= B; i++) {
                    writer.println(i);
                    writer.flush();
                    A[i - 1] = scanner.nextInt();
                }
                for (int i = 0; i < B; i++) {
                    writer.print(A[i]);
                }
                writer.println();
                writer.flush();
                String s = scanner.next();
                if (s.equals("N")) {
                    return;
                }
                continue;
            }

            List<Group> groups = new ArrayList<>();
            for (int i = 0; i < B / 10; i++) {
                Group group = new Group();
                for (int j = i * 5 + 1; j <= (i + 1) * 5; j++) {
                    writer.println(j);
                    writer.flush();
                    int d1 = scanner.nextInt();

                    writer.println(B - j + 1);
                    writer.flush();
                    int d2 = scanner.nextInt();

                    if (d1 == d2) {
                        if (d1 == 0) group.s0.add(j);
                        else group.s1.add(j);
                    } else {
                        if (d1 == 0) group.d0.add(j);
                        else group.d1.add(j);
                    }
                }
                groups.add(group);
            }

            Group finalGroup = new Group();
            int queryCount = 0;

            for (Group group : groups) {
                if (group.s0.size() > 0) {
                    queryCount++;
                    writer.println(group.s0.get(0));
                    writer.flush();
                    int d1 = scanner.nextInt();
                    if (d1 == 0) {
                        finalGroup.s0.addAll(group.s0);
                        finalGroup.s1.addAll(group.s1);
                    } else {
                        finalGroup.s0.addAll(group.s1);
                        finalGroup.s1.addAll(group.s0);
                    }
                } else if (group.s1.size() > 0) {
                    queryCount++;
                    writer.println(group.s1.get(0));
                    writer.flush();
                    int d1 = scanner.nextInt();
                    if (d1 == 0) {
                        finalGroup.s0.addAll(group.s1);
                        finalGroup.s1.addAll(group.s0);
                    } else {
                        finalGroup.s0.addAll(group.s0);
                        finalGroup.s1.addAll(group.s1);
                    }
                }
            }

            while (queryCount < 10) {
                queryCount++;
                writer.println(1);
                writer.flush();
                int d1 = scanner.nextInt();
            }

            queryCount = 0;
            for (Group group : groups) {
                if (group.d0.size() > 0) {
                    queryCount++;
                    writer.println(group.d0.get(0));
                    writer.flush();
                    int d1 = scanner.nextInt();
                    if (d1 == 0) {
                        finalGroup.d0.addAll(group.d0);
                        finalGroup.d1.addAll(group.d1);
                    } else {
                        finalGroup.d0.addAll(group.d1);
                        finalGroup.d1.addAll(group.d0);
                    }
                } else if (group.d1.size() > 0) {
                    queryCount++;
                    writer.println(group.d1.get(0));
                    writer.flush();
                    int d1 = scanner.nextInt();
                    if (d1 == 0) {
                        finalGroup.d0.addAll(group.d1);
                        finalGroup.d1.addAll(group.d0);
                    } else {
                        finalGroup.d0.addAll(group.d0);
                        finalGroup.d1.addAll(group.d1);
                    }
                }
            }

            while (queryCount < 10) {
                queryCount++;
                writer.println(1);
                writer.flush();
                int d1 = scanner.nextInt();
            }

            int s = 0, d = 0;
            if (finalGroup.s0.size() > 0) {
                writer.println(finalGroup.s0.get(0));
                writer.flush();
                s = scanner.nextInt();
            } else if (finalGroup.s1.size() > 0) {
                writer.println(finalGroup.s1.get(0));
                writer.flush();
                s = 1 - scanner.nextInt();
            }
            if (finalGroup.d0.size() > 0) {
                writer.println(finalGroup.d0.get(0));
                writer.flush();
                d = scanner.nextInt();
            } else if (finalGroup.d1.size() > 0) {
                writer.println(finalGroup.d1.get(0));
                writer.flush();
                d = 1 - scanner.nextInt();
            }

            for (Integer id : finalGroup.s0) {
                A[id - 1] = s;
                A[B - id] = s;
            }
            for (Integer id : finalGroup.s1) {
                A[id - 1] = 1 - s;
                A[B - id] = 1 - s;
            }
            for (Integer id : finalGroup.d0) {
                A[id - 1] = d;
                A[B - id] = 1 - d;
            }
            for (Integer id : finalGroup.d1) {
                A[id - 1] = 1 - d;
                A[B - id] = d;
            }

            for (int i = 0; i < B; i++) {
                writer.print(A[i]);
            }
            writer.println();
            writer.flush();
            if (scanner.next().equals("N")) {
                return;
            }
        }
    }

    static class Group {
        List<Integer> s0, s1, d0, d1;

        Group() {
            s0 = new ArrayList<>();
            s1 = new ArrayList<>();
            d0 = new ArrayList<>();
            d1 = new ArrayList<>();
        }
    }
}