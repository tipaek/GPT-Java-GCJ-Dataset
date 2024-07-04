package codejam;

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            String s = br.readLine();
            char[] chars = s.toCharArray();
            ArrayList<Character> result = new ArrayList<>();
            boolean isOpen = false;
            boolean isBinary = true;

            for (char c : chars) {
                if (c == '0') {
                    if (isOpen) {
                        result.add(')');
                        isOpen = false;
                    }
                    result.add(c);
                } else if (c == '1') {
                    if (!isOpen) {
                        result.add('(');
                        isOpen = true;
                    }
                    result.add(c);
                } else {
                    isBinary = false;
                    if (!isOpen) {
                        result.add('(');
                        isOpen = true;
                    }
                    result.add(c);
                }
            }

            if (isOpen) {
                result.add(')');
            }

            if (!isBinary) {
                for (int j = 1; j <= 8; j++) {
                    ArrayList<Character> temp = new ArrayList<>();
                    isOpen = false;
                    for (char c : result) {
                        if (c == '(') {
                            temp.add(c);
                        } else if (c == ')') {
                            temp.add(c);
                        } else if (c <= (48 + j)) {
                            if (isOpen) {
                                temp.add(')');
                                isOpen = false;
                            }
                            temp.add(c);
                        } else {
                            if (!isOpen) {
                                temp.add('(');
                                isOpen = true;
                            }
                            temp.add(c);
                        }
                    }
                    if (isOpen) {
                        temp.add(')');
                    }
                    result = temp;
                }
            }

            StringBuilder sb = new StringBuilder();
            for (char c : result) {
                sb.append(c);
            }

            out.println("#" + i + ": " + sb);
        }

        out.flush();
        out.close();
    }
}