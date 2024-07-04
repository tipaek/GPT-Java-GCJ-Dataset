
import java.io.FileNotFoundException;
import java.util.*;

public class Solution {
    Scanner in = new Scanner(System.in);
//    Scanner in = new Scanner(new FileInputStream("In"));

//    public Solution() throws FileNotFoundException {
//    }

    String solve(int t, int U) {
        int[] freq = new int[26];
        for (int k=0;k<10000;k++) {
            long q = in.nextLong();
            String r = in.next();
            for (int j=0;j<r.length();j++) {
                freq[r.charAt(j)-'A']++;
            }
        }

        List<int[]> f = new ArrayList<>();
        for (int i=0;i<26;i++) {
            if (freq[i] > 0) {
                f.add(new int[]{i, freq[i]});
            }
        }
        f.sort(Comparator.comparingInt(x -> x[1]));
        StringBuilder ret = new StringBuilder();
        for (int i=0;i<10;i++) {
            ret.append(((char) ('A' + f.get((10-i)%10)[0])));
        }

        return ret.toString();
    }

    void run() {
        int T = in.nextInt();
        for (int t=1;t<=T;t++) {
            System.out.println(String.format("Case #%d: %s", t, solve(t, in.nextInt())));
        }
    }

    public static void main(String[] args) throws Exception {
        new Solution().run();
    }
}
