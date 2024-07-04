import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Tests number
        for (int i = 0; i < t; i++) {
            int u = in.nextInt(); // U defines max 10^u - 1

            Map<Integer, String> tries = new TreeMap<>();

            while(in.hasNextLine()) {
                int inp = in.nextInt();
                String resp = in.nextLine().trim();
                //System.out.println("input: " + inp + " - out:" + resp);
                tries.put(inp, resp);
            }

            Iterator it = tries.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry element = (Map.Entry) it.next();
                //System.out.println("Try: " + element);
            }

            String output = "TPFOXLUSHB";
            System.out.println("Case #" + (i + 1) + ": " + output);
        }
    }
}
