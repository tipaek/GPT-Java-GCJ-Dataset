import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static StringBuffer reverse(StringBuffer str) {
        return new StringBuffer(str).reverse();
    }

    public static StringBuffer complement(StringBuffer str) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            result.append(str.charAt(i) == '0' ? '1' : '0');
        }
        return result;
    }

    public static boolean isEqual(StringBuffer a, StringBuffer b) {
        return a.toString().equals(b.toString());
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int T = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);

        for (int t = 1; t <= T; t++) {
            if (B == 10) {
                StringBuffer sb = new StringBuffer();
                for (int i = 1; i <= B; i++) {
                    System.out.println(i);
                    System.out.flush();
                    int n = br.readLine().charAt(0) - '0';
                    sb.append(n);
                }
                System.out.println(sb);
                System.out.flush();
                br.readLine();
            } else if (B == 20) {
                StringBuffer[] buffers = new StringBuffer[6];
                for (int i = 0; i < buffers.length; i++) {
                    buffers[i] = new StringBuffer();
                }

                int[][] ranges = {{1, 5}, {16, 20}, {6, 10}, {11, 15}, {1, 5}, {6, 10}};
                for (int i = 0; i < ranges.length; i++) {
                    for (int j = ranges[i][0]; j <= ranges[i][1]; j++) {
                        System.out.println(j);
                        System.out.flush();
                        int n = br.readLine().charAt(0) - '0';
                        buffers[i].append(n);
                    }
                }

                StringBuffer a = buffers[0];
                StringBuffer b = buffers[1];
                StringBuffer c = buffers[2];
                StringBuffer d = buffers[3];
                StringBuffer e = buffers[4];
                StringBuffer f = buffers[5];

                StringBuffer aComp = complement(a);
                StringBuffer bRev = reverse(b);
                StringBuffer bRevComp = complement(bRev);
                StringBuffer cComp = complement(c);
                StringBuffer dRev = reverse(d);
                StringBuffer dRevComp = complement(dRev);

                StringBuffer ans = new StringBuffer();
                if (isEqual(c, f)) {
                    ans.append(c).append(d);
                } else if (isEqual(cComp, f)) {
                    ans.append(cComp).append(complement(d));
                } else if (isEqual(dRev, f)) {
                    ans.append(dRev).append(reverse(c));
                } else {
                    ans.append(dRevComp).append(complement(reverse(c)));
                }

                if (isEqual(a, e)) {
                    System.out.println(a.toString() + ans.toString() + b.toString());
                } else if (isEqual(aComp, e)) {
                    System.out.println(aComp.toString() + ans.toString() + complement(b).toString());
                } else if (isEqual(bRev, e)) {
                    System.out.println(bRev.toString() + ans.toString() + reverse(a).toString());
                } else {
                    System.out.println(bRevComp.toString() + ans.toString() + complement(reverse(a)).toString());
                }
                br.readLine();
            }
        }
    }
}