import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    private static final boolean FROM_FILE = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br;
        BufferedWriter bw;

        if (FROM_FILE) {
            br = new BufferedReader(new FileReader("C2020R1CPB.in"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

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

            String line = br.readLine();
            int tests = Integer.parseInt(line);

            for (int i = 0; i < tests; i++) {
                line = br.readLine();
                int u = Integer.parseInt(line);
                Map<Character, Integer> map = new HashMap<>();
                Map<Character, Integer> alph = new HashMap<>();

                for (int j = 0; j < 10000; j++) {
                    line = br.readLine();
                    String[] p = line.split("\\s+");
                    int q = Integer.parseInt(p[0]);
                    String r = p[1];
                    char c = r.charAt(0);
                    int qq = q;
                    int digits = 1;

                    while (qq >= 10) {
                        qq = (qq - qq % 10) / 10;
                        digits++;
                    }

                    if (digits == r.length()) {
                        map.put(c, Math.min(map.getOrDefault(c, Integer.MAX_VALUE), qq));
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
                            map.put(entry.getKey(), -1);
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

                bw.write("Case #" + (i + 1) + ": " + answer.toString() + "\n");
                bw.flush();
            }

            if (FROM_FILE) {
                bw.close();
            }
        } finally {
            if (FROM_FILE) {
                br.close();
            }
        }
    }
}