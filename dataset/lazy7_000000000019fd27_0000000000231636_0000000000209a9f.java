import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        for (int t = 0; t < T; t++) {
            String s = br.readLine().trim();
            int length = s.length();

            char[] charArr = new char[2000];
            int index = 0;

            for (int i = 0; i < length; i++) {
                int n = Integer.parseInt("" + s.charAt(i));
                for (int j = 0; j < n; j++) {
                    charArr[index] = '(';
                    index++;
                }
                charArr[index] = Character.forDigit(n, 10);
                index++;

                for (int k = (i + 1); k < length; k++) {
                    int next = Integer.parseInt("" + s.charAt(k));
                    if (next == n) {
                        charArr[index] = Character.forDigit(n, 10);
                        index++;
                        i++;
                    } else {
                        break;
                    }
                }

                for (int j = 0; j < n; j++) {
                    charArr[index] = ')';
                    index++;
                }
            }

            // System.out.println(answer);
            // StringBuilder answer = new StringBuilder();
            // int sLen = answer.length();

            // printArr(charArr, index);

            for (int i = 0; i < index; i++) {
                char ci = charArr[i];
                if (ci == ')') {
                    // find how many closing
                    int closing = 0;
                    int j;
                    int k;
                    for (j = i; j < index; j++) {
                        char cj = charArr[j];
                        if (cj == ')') {
                            closing++;
                        } else {
                            break;
                        }
                    }
                    // find opening
                    int opening = 0;
                    for (k = j; k < index; k++) {
                        char ck = charArr[k];
                        if (ck == '(') {
                            opening++;
                        } else {
                            break;
                        }
                    }
                    int toRemove = Math.min(opening, closing);

                    // remove closing
                    for (int r = 0; r < toRemove; r++) {
                        charArr[i] = 'x';
                        i++;
                    }

                    // remove opening
                    for (int r = 0; r < toRemove; r++) {
                        charArr[j] = 'x';
                        j++;
                    }
                    i = k;
                }
            }

            StringBuilder answer = new StringBuilder();
            for (int i = 0; i < index; i++) {
                char c = charArr[i];
                if (c == 'x') {
                    continue;
                } else {
                    answer.append(c);
                }

            }
            System.out.println("Case #" + (t + 1) + ": " + answer);
        }
    }

    public static void printArr(char[] c, int len) {
        for (int i = 0; i < len; i++) {
            System.out.print(c[i]);
        }
        System.out.println();
    }
}