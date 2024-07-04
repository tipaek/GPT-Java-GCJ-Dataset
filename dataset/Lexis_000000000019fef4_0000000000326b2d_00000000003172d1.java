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
        if (diners == 2)
            return 1;
        boolean first = true;
        for (Long a : new ArrayList<>(count.keySet())) {
            if (!first && count.get(a) > 1)
                return 1;
            first = false;
        }
        return 2;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        new Solution().processRawInput(System.in);
    }
}
