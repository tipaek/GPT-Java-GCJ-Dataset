import java.util.*;
import java.io.*;

class Triple {
    Integer x;
    Integer y;
    Integer z;

    public Triple(Integer x, Integer y, Integer z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Triple() {}
}

class Solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int T = Integer.parseInt(br.readLine());
            for (int caseNum = 1; caseNum <= T; caseNum++) {
                int N = Integer.parseInt(br.readLine());
                List<Triple> list = new ArrayList<>();
                for (int i = 0; i < N; i++) {
                    String[] strarr = br.readLine().trim().split("\\s+");
                    Triple t = new Triple(Integer.parseInt(strarr[0]), Integer.parseInt(strarr[1]), i);
                    list.add(t);
                }

                list.sort(Comparator.comparingInt(a -> a.x));

                int cEnd = -1, jEnd = -1;
                boolean isPossible = true;
                char[] result = new char[N];

                for (Triple t : list) {
                    if (cEnd <= t.x) {
                        result[t.z] = 'C';
                        cEnd = t.y;
                    } else if (jEnd <= t.x) {
                        result[t.z] = 'J';
                        jEnd = t.y;
                    } else {
                        isPossible = false;
                        break;
                    }
                }

                String output = isPossible ? new String(result) : "IMPOSSIBLE";
                System.out.println("Case #" + caseNum + ": " + output);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}