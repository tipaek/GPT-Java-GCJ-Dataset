import java.io.*;
import java.util.*;

class Solution {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine().trim());

        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(reader.readLine().trim());
            String[][] patterns = new String[N][];
            int[][] startStop = new int[N][2];
            boolean[] valid = new boolean[N];
            Arrays.fill(valid, true);

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                String pattern = st.nextToken();
                List<String> tempList = new ArrayList<>();
                int k = 0;
                while (k < pattern.length()) {
                    StringBuilder temp = new StringBuilder();
                    while (k < pattern.length() && pattern.charAt(k) != '*') {
                        temp.append(pattern.charAt(k));
                        k++;
                    }
                    tempList.add(temp.toString());
                    if (k < pattern.length()) {
                        tempList.add("*");
                        k++;
                    }
                }
                patterns[j] = tempList.toArray(new String[0]);
                startStop[j][0] = 0;
                startStop[j][1] = patterns[j].length - 1;
            }

            boolean possible = true;
            boolean done = false;
            boolean side = false; // false = left, true = right
            int middle = 0;
            List<String> outputString = new ArrayList<>();

            while (!done) {
                if (!side) { // left
                    int longestAt = 0;
                    int maxFound = 0;
                    boolean allNotValid = true;

                    for (int j = 0; j < N; j++) {
                        if (valid[j]) {
                            String current = patterns[j][startStop[j][0]];
                            if (!current.equals("*") && current.length() > maxFound) {
                                maxFound = current.length();
                                longestAt = j;
                            }
                            allNotValid = false;
                        }
                    }

                    if (allNotValid) {
                        possible = true;
                        done = true;
                    } else if (maxFound == 0) {
                        for (int j = 0; j < N; j++) {
                            startStop[j][0]++;
                            if (startStop[j][0] > startStop[j][1]) {
                                valid[j] = false;
                            }
                        }
                    } else {
                        String maxResult = patterns[longestAt][startStop[longestAt][0]];
                        for (int j = 0; j < N; j++) {
                            if (valid[j]) {
                                String current = patterns[j][startStop[j][0]];
                                if (!current.equals("*") && !maxResult.startsWith(current)) {
                                    done = true;
                                    possible = false;
                                    break;
                                } else {
                                    startStop[j][0]++;
                                    if (startStop[j][0] > startStop[j][1]) {
                                        valid[j] = false;
                                    }
                                }
                            } else {
                                done = true;
                                possible = false;
                                break;
                            }
                        }
                        if (possible) {
                            outputString.add(middle, maxResult);
                            middle++;
                        }
                    }
                } else { // right
                    int longestAt = 0;
                    int maxFound = 0;
                    boolean allNotValid = true;

                    for (int j = 0; j < N; j++) {
                        if (valid[j]) {
                            String current = patterns[j][startStop[j][1]];
                            if (!current.equals("*") && current.length() > maxFound) {
                                maxFound = current.length();
                                longestAt = j;
                            }
                            allNotValid = false;
                        }
                    }

                    if (allNotValid) {
                        possible = true;
                        done = true;
                    } else if (maxFound == 0) {
                        for (int j = 0; j < N; j++) {
                            startStop[j][1]--;
                            if (startStop[j][0] > startStop[j][1]) {
                                valid[j] = false;
                            }
                        }
                    } else {
                        String maxResult = patterns[longestAt][startStop[longestAt][1]];
                        for (int j = 0; j < N; j++) {
                            if (valid[j]) {
                                String current = patterns[j][startStop[j][1]];
                                if (!current.equals("*") && !maxResult.endsWith(current)) {
                                    done = true;
                                    possible = false;
                                    break;
                                } else {
                                    startStop[j][1]--;
                                    if (startStop[j][0] > startStop[j][1]) {
                                        valid[j] = false;
                                    }
                                }
                            } else {
                                done = true;
                                possible = false;
                                break;
                            }
                        }
                        if (possible) {
                            outputString.add(middle, maxResult);
                        }
                    }
                }
                side = !side; // Switch back and forth
            }

            System.out.print("Case #" + (i + 1) + ": ");
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