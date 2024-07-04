import java.io.*;
import java.util.*;

public class Solution {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(reader.readLine());
            String[][] patterns = new String[N][];
            int[][] startStop = new int[N][2];
            boolean[] valid = new boolean[N];
            Arrays.fill(valid, true);

            for (int j = 0; j < N; j++) {
                StringTokenizer st = new StringTokenizer(reader.readLine());
                String tempTotal = st.nextToken();
                List<String> tempList = new ArrayList<>();
                StringBuilder temp = new StringBuilder();

                for (int k = 0; k < tempTotal.length(); k++) {
                    char c = tempTotal.charAt(k);
                    if (c == '*') {
                        if (temp.length() > 0) {
                            tempList.add(temp.toString());
                            temp.setLength(0);
                        }
                        tempList.add("*");
                    } else {
                        temp.append(c);
                    }
                }
                if (temp.length() > 0) {
                    tempList.add(temp.toString());
                }

                patterns[j] = tempList.toArray(new String[0]);
                startStop[j][0] = 0;
                startStop[j][1] = patterns[j].length - 1;
            }

            boolean possible = true;
            boolean done = false;
            List<String> outputString = new ArrayList<>();
            boolean side = false;
            int middle = 0;

            while (!done) {
                int longestAt = 0;
                int maxFound = 0;
                boolean allNotValid = true;

                for (int j = 0; j < N; j++) {
                    if (valid[j]) {
                        String current = side ? patterns[j][startStop[j][1]] : patterns[j][startStop[j][0]];
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
                        if (side) {
                            startStop[j][1]--;
                        } else {
                            startStop[j][0]++;
                        }
                        if (startStop[j][0] > startStop[j][1]) {
                            valid[j] = false;
                        }
                    }
                } else {
                    String maxResult = side ? patterns[longestAt][startStop[longestAt][1]] : patterns[longestAt][startStop[longestAt][0]];

                    for (int j = 0; j < N; j++) {
                        if (valid[j]) {
                            String current = side ? patterns[j][startStop[j][1]] : patterns[j][startStop[j][0]];
                            if (!current.equals("*")) {
                                if ((side && !maxResult.endsWith(current)) || (!side && !maxResult.startsWith(current))) {
                                    done = true;
                                    possible = false;
                                    break;
                                } else {
                                    if (side) {
                                        startStop[j][1]--;
                                    } else {
                                        startStop[j][0]++;
                                    }
                                    if (startStop[j][0] > startStop[j][1]) {
                                        valid[j] = false;
                                    }
                                }
                            }
                        } else {
                            done = true;
                            possible = false;
                            break;
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

            System.out.print("Case #" + (i + 1) + ": ");
            if (possible) {
                for (String s : outputString) {
                    System.out.print(s);
                }
            } else {
                System.out.print("*");
            }
            System.out.println();
        }

        reader.close();
    }
}