import java.util.*;
import java.io.*;

public class Solution {
    private static int T;
    private static List<String> noPara;

    public static void main(String[] args) {
        readInput('W');

        for (int i = 0; i < T; i++) {
            StringBuilder sb = new StringBuilder();
            String cur = noPara.get(i);
            boolean prevOne = false;

            for (int j = 0; j < cur.length(); j++) {
                char c = cur.charAt(j);
                if (c == '0') {
                    if (prevOne) {
                        sb.append(")");
                    }
                    sb.append("0");
                    prevOne = false;
                } else {
                    if (!prevOne) {
                        sb.append("(");
                    }
                    sb.append("1");
                    prevOne = true;
                }
            }

            if (prevOne) {
                sb.append(")");
            }
            System.out.println("Case #" + (i + 1) + ": " + sb.toString());
        }
    }

    private static void readInput(char mode) {
        BufferedReader in = null;
        try {
            if (mode == 'E') {
                in = new BufferedReader(new FileReader("input.txt"));
            } else {
                in = new BufferedReader(new InputStreamReader(System.in));
            }

            T = Integer.parseInt(in.readLine());
            noPara = new ArrayList<>();

            for (int i = 0; i < T; i++) {
                noPara.add(in.readLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}