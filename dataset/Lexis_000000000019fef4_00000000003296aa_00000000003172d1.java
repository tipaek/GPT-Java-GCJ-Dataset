import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public void processRawInput(InputStream is) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        int caseNumber = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= caseNumber; i++) {
            String target = reader.readLine();
            String[] parts = target.split(" ");
            int pieces = Integer.parseInt(parts[0]);
            int dinners = Integer.parseInt(parts[1]);
            String astr = reader.readLine();
            List<Long> angles = new ArrayList<>(pieces);
            String[] astrP = astr.split(" ");
            for (String a : astrP) {
                angles.add(Long.parseLong(a));
            }
            angles.sort(Long::compareTo);

            System.out.println("Case #" + i + ": " + process(pieces, dinners, angles));
        }

    }

    public int process(int pieces, int diners, List<Long> angles) {
        Map<Long, Integer> count = new TreeMap<>((o1, o2) -> -Long.compare(o1, o2));
        for (Long a : angles) {
            int p = count.getOrDefault(a, 0) + 1;
            if (p >= diners)
                return 0;
            count.put(a, p);
        }
        if (pieces == 1)
            return (diners + 1) / 2;
        if (diners == 2)
            return 1;
        boolean operationP = false;
        do {
            for (Long a : new ArrayList<>(count.keySet())) {
                for (long l = 2; l < diners; l++) {
                    if (a % l == 0) {
                        int p = count.getOrDefault(a / l, 0) + count.get(a) * 2;
                        if (p >= diners)
                            return (int) ((diners - count.getOrDefault(a / l, 0)) / l);
                        count.put(a / l, p);
                        count.put(a, count.get(a) - 1);
                        operationP = true;
                    }
                }
            }
        } while (operationP);
        return (diners + 1) / 2;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        new Solution().processRawInput(System.in);
    }
}
