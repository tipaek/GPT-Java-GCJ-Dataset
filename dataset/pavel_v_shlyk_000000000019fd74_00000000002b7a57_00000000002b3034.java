// package codejam._2020_round1A;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {

    public static void main (String[] args) throws Exception {


//        String s = "2\n" +
//                "5\n" +
//                "*CONUTS\n" +
//                "*COCONUTS\n" +
//                "*OCONUTS\n" +
//                "*CONUTS\n" +
//                "*S\n" +
//                "2\n" +
//                "*XZ\n" +
//                "*XYZ";

//        String s = "1\n" +
//                "4\n" +
//                "H*O\n" +
//                "HELLO*\n" +
//                "*HELLO\n" +
//                "HE*";

//        String s = "1\n" +
//                "2\n" +
//                "CO*DE\n" +
//                "J*AM";

//        String s = "1\n" +
//                "2\n" +
//                "CODE*\n" +
//                "*JAM";

//        String s = "1\n" +
//                "2\n" +
//                "A*C*E\n" +
//                "*B*D";

//        String s = "1\n" +
//                "2\n" +
//                "**Q**\n" +
//                "*A*";

//        String s = "1\n" +
//                "2\n" +
//                "*QQ\n" +
//                "*QQ";


//        StringBuffer sb = new StringBuffer("1\n" +
//                "100000 100000\n");
//        Random r = new Random();
//        for (int i=0; i<100000; ++i) {
//            int C = r.nextInt(1000000000);
//            C = Math.abs(C);
//            sb.append(" " + C);
////            System.out.print(C + " ");
//        }
//        String s = sb.toString();


        int T;
//        Scanner scan = new Scanner(System.in);
        Scanner scan = new Scanner(s);

        long time = System.currentTimeMillis();

        T = scan.nextInt();
        next_test:
        for (int t=1; t<=T; ++t) {
            int N = scan.nextInt();

            ArrayList<String> start = new ArrayList<>();
            ArrayList<String> end = new ArrayList<>();
            ArrayList<String> middle = new ArrayList<>();

            for (int n=0; n<N; ++n) {
                String p = scan.next();

                if (p.charAt(p.length() - 1) == '*' && p.charAt(0) == '*') {
                    middle.add(p.replaceAll("\\*", ""));
                } else if (p.charAt(p.length() - 1) == '*') {
                    String[] P = p.split("\\*");
                    start.add(P[0]);
                    StringBuffer sb = new StringBuffer();
                    for (int i = 1; i < P.length; ++i) sb.append(P[i]);
                    if (sb.length() > 0) middle.add(sb.toString());
                } else if (p.charAt(0) == '*') {
                    String[] P = p.split("\\*");
                    end.add(P[P.length - 1]);
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < P.length - 1; ++i) sb.append(P[i]);
                    if (sb.length() > 0) middle.add(sb.toString());
                } else {
                    String[] P = p.split("\\*");
                    start.add(P[0]);
                    end.add(P[P.length - 1]);
                    StringBuffer sb = new StringBuffer();
                    for (int i = 1; i < P.length - 1; ++i) sb.append(P[i]);
                    if (sb.length() > 0) middle.add(sb.toString());
                }
            }

            Comparator<String> comp = new Comparator<String>() {
                public int compare(String o1, String o2) {
                    return o1.length()-o2.length();
                }
            };

            start.sort(comp);
            for (int i=1; i<start.size(); ++i) {
                if (!start.get(i).startsWith(start.get(i-1))) {
                    System.out.println("Case #"+t+": " + "*");
                    continue next_test;
                }
            }

            end.sort(comp);
            for (int i=1; i<end.size(); ++i) {
                if (!end.get(i).endsWith(end.get(i-1))) {
                    System.out.println("Case #"+t+": " + "*");
                    continue next_test;
                }
            }

            StringBuffer result = new StringBuffer();
            if (start.size()>0) result.append(start.get(start.size()-1));
            for (String m:middle) result.append(m);
            if (end.size()>0) result.append(end.get(end.size()-1));

            System.out.println("Case #"+t+": " + result.toString());
        }
    }
}
