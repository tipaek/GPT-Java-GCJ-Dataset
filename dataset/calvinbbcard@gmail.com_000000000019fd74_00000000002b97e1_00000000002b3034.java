import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int q = reader.nextInt();
        int c = 1;
        while (c++ <= q) {
            int n = reader.nextInt();
            String[] patterns = new String[n];
            for (int i=0;i<n;i++) patterns[i] = reader.next();
            String suffix = "";
            String prefix = "";
            boolean possible = true;
            boolean[] considered = new boolean[n];
            for (int i=0;i<n;i++) {
                int count = 0;
                for (int j=0;j<patterns[i].length();j++) if (patterns[i].charAt(j) == '*') count++;
                if (count == 1) {
                    String[] parts = patterns[i].split("\\*");
                    System.out.println(Arrays.toString(parts));
                    String end = parts.length == 1 ? "" : parts[1];
                    String start = parts[0];
                    considered[i] = true;
                    if (end.length() > suffix.length() && end.contains(suffix)) {
                        suffix = end;
                    } else if (!suffix.contains(end)) {
                        // System.out.printf("End: %s does not contain %s\n", end, suffix);
                        possible = false;
                    }
                    
                    if (start.length() > prefix.length() && start.contains(prefix)) {
                        prefix = start;
                    } else if (!prefix.contains(start)) {
                        possible = false;
                    }
                }
            }
            if (!possible) {
                System.out.printf("Case #%d: *\n", c-1);
                continue;
            }
            boolean all = true;
            for (int i=0;i<n;i++) {
                if (!considered[i]) all = false;
            }
            
            if (all) {
                System.out.printf("Case #%d: %s\n", c-1, prefix + suffix);
            }
        }
    }

}
