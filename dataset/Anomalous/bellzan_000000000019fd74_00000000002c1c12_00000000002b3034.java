import java.io.*;
import java.util.*;

class Solution {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        
        for (int t = 0; t < T; t++) {
            N = Integer.parseInt(reader.readLine());
            String[][] patterns = new String[N][];
            int[][] startStop = new int[N][2];
            boolean[] valid = new boolean[N];
            Arrays.fill(valid, true);
            
            for (int i = 0; i < N; i++) {
                String[] parts = reader.readLine().split("\\*");
                patterns[i] = new String[parts.length * 2 - 1];
                for (int j = 0; j < parts.length; j++) {
                    patterns[i][j * 2] = parts[j];
                    if (j < parts.length - 1) {
                        patterns[i][j * 2 + 1] = "*";
                    }
                }
                startStop[i][0] = 0;
                startStop[i][1] = patterns[i].length - 1;
            }

            boolean possible = true;
            boolean done = false;
            boolean side = false; // false = left, true = right
            int middle = 0;
            ArrayList<String> outputString = new ArrayList<>();

            while (!done) {
                int longestAt = 0;
                int maxFound = 0;
                boolean allNotValid = true;

                for (int i = 0; i < N; i++) {
                    if (valid[i]) {
                        String current = side ? patterns[i][startStop[i][1]] : patterns[i][startStop[i][0]];
                        if (!"*".equals(current) && current.length() > maxFound) {
                            maxFound = current.length();
                            longestAt = i;
                        }
                        allNotValid = false;
                    }
                }

                if (allNotValid) {
                    possible = true;
                    done = true;
                } else if (maxFound == 0) {
                    for (int i = 0; i < N; i++) {
                        if (side) {
                            startStop[i][1]--;
                        } else {
                            startStop[i][0]++;
                        }
                        if (startStop[i][0] > startStop[i][1]) {
                            valid[i] = false;
                        }
                    }
                } else {
                    String maxResult = side ? patterns[longestAt][startStop[longestAt][1]] : patterns[longestAt][startStop[longestAt][0]];
                    for (int i = 0; i < N; i++) {
                        if (valid[i]) {
                            String current = side ? patterns[i][startStop[i][1]] : patterns[i][startStop[i][0]];
                            if (!"*".equals(current)) {
                                if ((side && !maxResult.endsWith(current)) || (!side && !maxResult.startsWith(current))) {
                                    possible = false;
                                    done = true;
                                    break;
                                }
                                if (side) {
                                    startStop[i][1]--;
                                } else {
                                    startStop[i][0]++;
                                }
                                if (startStop[i][0] > startStop[i][1]) {
                                    valid[i] = false;
                                }
                            }
                        }
                    }
                    if (possible) {
                        if (side) {
                            outputString.add(maxResult);
                        } else {
                            outputString.add(middle, maxResult);
                            middle++;
                        }
                    }
                }
                side = !side;
            }

            System.out.print("Case #" + (t + 1) + ": ");
            if (possible) {
                for (String s : outputString) {
                    System.out.print(s);
                }
                System.out.println();
            } else {
                System.out.println("*");
            }
        }
        reader.close();
    }
}