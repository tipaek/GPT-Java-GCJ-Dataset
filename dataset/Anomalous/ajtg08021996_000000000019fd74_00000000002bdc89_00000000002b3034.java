import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.hasNext() ? sc.nextInt() : 0;

        for (int i = 0; i < T; i++) {
            int N = sc.hasNext() ? sc.nextInt() : 0;
            ArrayList<String> al = new ArrayList<>();
            ArrayList<String> alf = new ArrayList<>();
            ArrayList<String> alr = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                String ss = sc.hasNext() ? sc.next() : "";
                if (ss.startsWith("*")) {
                    String[] ar = ss.split("\\*");
                    for (String s : ar) {
                        alr.add(s);
                    }
                } else if (ss.endsWith("*")) {
                    String[] ar = ss.split("\\*");
                    for (String s : ar) {
                        alf.add(s);
                    }
                } else {
                    String[] ar = ss.split("\\*");
                    for (String s : ar) {
                        al.add(s);
                    }
                }
            }

            // Placeholder for further processing if needed
            if (alf.size() == alr.size()) {
                for (int k = 0; k < alf.size(); k++) {
                    // Placeholder for further processing if needed
                }
            }

            // Find the longest string in al
            String s = al.isEmpty() ? "" : al.get(0);
            for (String str : al) {
                if (s.length() < str.length()) {
                    s = str;
                }
            }

            // Placeholder for further processing if needed
            for (int j = 0; j < N; j++) {
                // Placeholder for further processing if needed
            }
        }
    }
}