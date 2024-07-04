import java.io.*;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {

    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(new FileInputStream(new File("a.in")))));
        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            scanner.nextLine();
            List<String> list = IntStream.range(0, N).mapToObj(i -> scanner.nextLine()).collect(Collectors.toList());
            String pref = "";
            for (String s : list) {
                String st = s.substring(0, s.indexOf('*'));
                if (st.length() > pref.length()) {
                    pref = st;
                }
            }
            boolean ok = true;
            for (String s : list) {
                if (!pref.startsWith(s.substring(0, s.indexOf('*')))) {
                    ok = false;
                    break;
                }
            }
            if (!ok) {
                System.out.println("Case #" + t + ": *");
                continue;
            }
            String suf = "";
            for (String s : list) {
                String st = s.substring(s.lastIndexOf('*') + 1);
                if (st.length() > suf.length()) {
                    suf = st;
                }
            }
            for (String s : list) {
                if (!suf.endsWith(s.substring(s.lastIndexOf('*') + 1))) {
                    ok = false;
                    break;
                }
            }
            if (!ok) {
                System.out.println("Case #" + t + ": *");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(pref);
            for (String s : list) {
                int beginIndex = s.indexOf('*') + 1;
                int endIndex = s.lastIndexOf('*');
                if (beginIndex >= endIndex) {
                    continue;
                }
                char[] mid = s.substring(beginIndex, endIndex).toCharArray();
                for (char c : mid) {
                    if (c != '*') {
                        sb.append(c);
                    }
                }
            }
            sb.append(suf);
            System.out.println("Case #" + t + ": " + sb.toString());
        }
    }
}
