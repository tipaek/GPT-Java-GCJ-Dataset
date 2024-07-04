import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // number of test cases
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt();
            StringBuilder answer = new StringBuilder("C"); // C first
            String imposs = "";
            int[][] mat = new int[n][2];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 2; k++) {
                    mat[j][k] = in.nextInt();
                }
            }

            ArrayList<Integer> Cam = new ArrayList<>(); // ArrayList for C
            Cam.add(0);
            ArrayList<Integer> Jam = new ArrayList<>(); // ArrayList for J

            for (int x = 1; x < n; x++) {
                boolean assigned = false;
                for (int k = 0; k < Cam.size(); k++) {
                    if (mat[x][0] >= mat[Cam.get(k)][0] && mat[x][0] < mat[Cam.get(k)][1]) {
                        if (Jam.isEmpty()) {
                            answer.append("J");
                            Jam.add(x);
                            assigned = true;
                            break;
                        } else {
                            boolean conflict = false;
                            for (int m = 0; m < Jam.size(); m++) {
                                if (mat[x][0] >= mat[Jam.get(m)][0] && mat[x][0] < mat[Jam.get(m)][1]) {
                                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                                    imposs = "IMPOSSIBLE";
                                    conflict = true;
                                    break;
                                }
                            }
                            if (!conflict) {
                                answer.append("J");
                                Jam.add(x);
                                assigned = true;
                                break;
                            }
                        }
                    }
                    if (mat[x][1] > mat[Cam.get(k)][0] && mat[x][1] <= mat[Cam.get(k)][1]) {
                        if (Jam.isEmpty()) {
                            answer.append("J");
                            Jam.add(x);
                            assigned = true;
                            break;
                        } else {
                            boolean conflict = false;
                            for (int m = 0; m < Jam.size(); m++) {
                                if (mat[x][1] > mat[Jam.get(m)][0] && mat[x][1] <= mat[Jam.get(m)][1]) {
                                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                                    conflict = true;
                                    break;
                                }
                            }
                            if (!conflict) {
                                answer.append("J");
                                Jam.add(x);
                                assigned = true;
                                break;
                            }
                        }
                    }
                    if (!assigned && k + 1 == Cam.size()) {
                        if (mat[x][0] < mat[Cam.get(k)][0] || mat[x][0] >= mat[Cam.get(k)][1]) {
                            answer.append("C");
                            Cam.add(x);
                            assigned = true;
                            break;
                        }
                    }
                }
            }

            if (!imposs.equals("IMPOSSIBLE")) {
                System.out.println("Case #" + i + ": " + answer);
            }
        }
    }
}