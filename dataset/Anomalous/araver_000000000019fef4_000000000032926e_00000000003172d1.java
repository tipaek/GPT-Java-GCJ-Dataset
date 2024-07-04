import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Solution {

    private static final boolean FROM_FILE = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;

        try {
            if (FROM_FILE) {
                br = new BufferedReader(new FileReader("C2020R1CPC.in"));
                File file = new File("C2020R1CPC.out");
                if (!file.exists()) {
                    file.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            } else {
                br = new BufferedReader(new InputStreamReader(System.in));
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            int tests = Integer.parseInt(br.readLine());

            for (int i = 0; i < tests; i++) {
                String[] firstLine = br.readLine().split("\\s+");
                int n = Integer.parseInt(firstLine[0]);
                int d = Integer.parseInt(firstLine[1]);

                String[] secondLine = br.readLine().split("\\s+");
                Long[] sl = new Long[secondLine.length];
                
                for (int k = 0; k < secondLine.length; k++) {
                    sl[k] = Long.valueOf(secondLine[k]);
                }

                Arrays.sort(sl, Collections.reverseOrder());

                String answer = "";
                if (d == 2) {
                    if (n == 1) {
                        answer = "1";
                    } else {
                        boolean foundEqual = false;
                        for (int k = 0; k < sl.length - 1; k++) {
                            if (sl[k].equals(sl[k + 1])) {
                                answer = "0";
                                foundEqual = true;
                                break;
                            }
                        }
                        if (!foundEqual) {
                            answer = "1";
                        }
                    }
                } else if (d == 3) {
                    if (n == 1) {
                        answer = "2";
                    } else if (n == 2) {
                        if (sl[1].equals(sl[0] - sl[1])) {
                            answer = "1";
                        } else {
                            answer = "2";
                        }
                    } else {
                        boolean foundTripleEqual = false;
                        for (int k = 0; k < sl.length - 2; k++) {
                            if (sl[k].equals(sl[k + 1]) && sl[k + 1].equals(sl[k + 2])) {
                                answer = "0";
                                foundTripleEqual = true;
                                break;
                            }
                        }

                        if (!foundTripleEqual) {
                            boolean foundDoubleEqual = false;
                            for (int k = 1; k < sl.length - 1; k++) {
                                if (sl[k].equals(sl[k + 1])) {
                                    answer = "1";
                                    foundDoubleEqual = true;
                                    break;
                                }
                            }
                            if (!foundDoubleEqual) {
                                boolean foundDouble = false;
                                for (int k = 0; k < sl.length - 1; k++) {
                                    for (int k2 = k + 1; k2 < sl.length; k2++) {
                                        if (sl[k] - sl[k2] == sl[k2]) {
                                            answer = "1";
                                            foundDouble = true;
                                            break;
                                        }
                                    }
                                    if (foundDouble) break;
                                }
                                if (!foundDouble) {
                                    answer = "2";
                                }
                            }
                        }
                    }
                }
                bw.write("Case #" + (i + 1) + ": " + answer + "\n");
                bw.flush();
            }
        } finally {
            if (br != null) br.close();
            if (bw != null) bw.close();
        }
    }
}