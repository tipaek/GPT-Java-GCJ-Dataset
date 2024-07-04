package codejam;

import java.io.*;
import java.util.*;

public class ProblemA {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            String s = br.readLine();
            char[] ca = s.toCharArray();
            ArrayList<Character> cl = new ArrayList<>();
            boolean opening = false;
            boolean binary = true;

            for (char c : ca) {
                if (c == '0') {
                    if (opening) {
                        cl.add(')');
                        opening = false;
                    }
                    cl.add(c);
                } else if (c == '1') {
                    if (!opening) {
                        cl.add('(');
                        opening = true;
                    }
                    cl.add(c);
                } else {
                    binary = false;
                    if (!opening) {
                        cl.add('(');
                        opening = true;
                    }
                    cl.add(c);
                }
            }

            if (opening) {
                cl.add(')');
            }

            if (!binary) {
                for (int j = 1; j <= 8; j++) {
                    ArrayList<Character> temp = new ArrayList<>();
                    opening = false;

                    for (char c : cl) {
                        if (c == '(') {
                            temp.add(c);
                        } else if (c == ')') {
                            temp.add(c);
                        } else if (c <= (48 + j)) {
                            if (opening) {
                                temp.add(')');
                                opening = false;
                            }
                            temp.add(c);
                        } else {
                            if (!opening) {
                                temp.add('(');
                                opening = true;
                            }
                            temp.add(c);
                        }
                    }

                    if (opening) {
                        temp.add(')');
                    }

                    cl = temp;
                }
            }

            StringBuilder sn = new StringBuilder();
            for (char c : cl) {
                sn.append(c);
            }

            out.println("#" + i + ": " + sn);
        }

        out.flush();
        out.close();
    }
}