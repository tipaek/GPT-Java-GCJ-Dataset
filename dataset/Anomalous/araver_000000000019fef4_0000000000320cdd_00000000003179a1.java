import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final boolean FROM_FILE = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = FROM_FILE ? new BufferedReader(new FileReader("C2020R1CPB.in"))
                                      : new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = null;

        try {
            if (FROM_FILE) {
                File file = new File("C2020R1CPB.out");
                if (!file.exists()) {
                    file.createNewFile();
                }
                bw = new BufferedWriter(new FileWriter(file.getAbsoluteFile()));
            } else {
                bw = new BufferedWriter(new OutputStreamWriter(System.out));
            }

            int tests = Integer.parseInt(br.readLine());

            for (int i = 0; i < tests; i++) {
                int u = Integer.parseInt(br.readLine());
                Map<Character, Integer> map = new HashMap<>();
                Map<Character, Integer> alph = new HashMap<>();

                for (int j = 0; j < 10000; j++) {
                    String[] p = br.readLine().split("\\s+");
                    long q = Long.parseLong(p[0]);
                    String r = p[1];
                    char c = r.charAt(0);

                    long qq = q;
                    int digits = 1;
                    while (qq >= 10) {
                        qq /= 10;
                        digits++;
                    }
                    int qd = (int) (qq % 10);

                    if (digits == r.length()) {
                        map.put(c, Math.min(map.getOrDefault(c, qd), qd));
                    }

                    for (char ch : r.toCharArray()) {
                        alph.putIfAbsent(ch, 0);
                    }
                }

                StringBuilder answer = new StringBuilder();
                for (int k = 9; k >= 0; k--) {
                    for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                        if (entry.getValue() == k) {
                            answer.insert(0, entry.getKey());
                            entry.setValue(-1);
                        }
                    }
                }

                if (answer.length() < 10) {
                    for (char key : alph.keySet()) {
                        if (!map.containsKey(key)) {
                            answer.insert(0, key);
                            break;
                        }
                    }
                }

                bw.write("Case #" + (i + 1) + ": " + answer + "\n");
                bw.flush();
            }

        } finally {
            if (FROM_FILE) {
                if (br != null) br.close();
                if (bw != null) bw.close();
            }
        }
    }
}