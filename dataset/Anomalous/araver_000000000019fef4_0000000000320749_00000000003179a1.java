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
            bw = new BufferedWriter(new FileWriter("C2020R1CPB.out"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        try {
            int tests = Integer.parseInt(br.readLine());

            for (int i = 0; i < tests; i++) {
                int u = Integer.parseInt(br.readLine());
                Map<Character, Integer> map = new HashMap<>();
                Map<Character, Integer> alph = new HashMap<>();

                for (int j = 0; j < 1000; j++) {
                    String[] p = br.readLine().split("\\s+");
                    int q = Integer.parseInt(p[0]);
                    String r = p[1];
                    char c = r.charAt(0);
                    int digits = (int) Math.log10(q) + 1;

                    if (digits == r.length()) {
                        map.put(c, Math.min(map.getOrDefault(c, Integer.MAX_VALUE), q));
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
        } finally {
            br.close();
            if (FROM_FILE) {
                bw.close();
            }
        }
    }
}