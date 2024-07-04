

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    private static void print(BufferedOutputStream bufferedOutputStream, byte[] bytes) throws IOException {
        bufferedOutputStream.write(bytes);
    }

    private static int search(char[] ch, char c) {
        for(int i = 0; i < ch.length; i++) {
            if(ch[i] == c) return i;
        }
        return ch.length;
    }

    private static boolean isValid(StringBuilder sb, char[] ch, boolean sfd, boolean inv) {
        if(ch.length == 0) return false;
        if (inv) {
            char[] sbch = sb.toString().toCharArray();
            for(int i = 0; i < sbch.length; i++) {
                if(ch.length - i > 0 && ch[ch.length - i - 1] == '*') return true;
                else if(i == ch.length || ch[ch.length - i - 1] != sbch[i]) return false;
            }

            if(!sfd && ch.length > sb.length() && ch[ch.length - sb.length() - 1] != '*') return false;

            for(int i = ch.length - sbch.length - 1; i >=0 && ch[i] != '*'; i--) sb.append(ch[i]);

            return true;
        }
        char[] sbch = sb.toString().toCharArray();
        for(int i = 0; i < sbch.length; i++) {
            if(ch[i] == '*') return true;
            else if(i == ch.length || ch[i] != sbch[i]) return false;
        }

        if(!sfd && ch.length > sb.length() && ch[sb.length()] != '*') return false;

        for(int i = sbch.length; i < ch.length && ch[i] != '*'; i++) sb.append(ch[i]);

        return true;
    }

    public static void main(String args[]) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(System.out);
            String eol = System.getProperty("line.separator");
            byte[] eolb = eol.getBytes();
            String str[] = bufferedReader.readLine().split(" ");
            int testCases = Integer.parseInt(str[0]);
            byte[] testCaseStrBytes = "Case #".getBytes();
            byte[] colSpace = ": ".getBytes();
            byte[] space = " ".getBytes();
            for (int t = 1; t<=testCases; t++) {
                str = bufferedReader.readLine().split(" ");
                int n = Integer.parseInt(str[0]);
                char[][] seq = new char[n][];
                for(int i = 0;i < n; i++) {
                    str = bufferedReader.readLine().split(" ");
                    seq[i] = str[0].toCharArray();
                }
                StringBuilder sb = new StringBuilder();
                boolean starFnd = true, inv = false;
                for(int i = 0;i < n; i++) {
                    if(sb.length() > 0 && !isValid(sb, seq[i], starFnd, inv)) {
                        sb = new StringBuilder(); sb.append('*');
                        break;
                    }
                    int sId = search(seq[i], '*');
                    starFnd &= (sId != seq[i].length);
                    if(sb.length() == 0) for(int j = 0; j < sId; j++) sb.append(seq[i][j]);
                }

                StringBuilder sb1 = new StringBuilder();
                starFnd = true; inv = true;
                for(int i = 0;i < n; i++) {
                    if(sb1.length() > 0 && !isValid(sb1, seq[i], starFnd, inv)) {
                        sb1 = new StringBuilder();sb1.append('*');
                        break;
                    }
                    int sId = search(seq[i], '*');
                    starFnd &= (sId != seq[i].length);
                    if(sb1.length() == 0) for(int j = seq[i].length - 1; j > sId; j--) sb1.append(seq[i][j]);
                }

                StringBuilder stringBuilder = new StringBuilder();
                if(sb1.length() > 0 && sb1.toString().charAt(0) == '*' ||
                        (sb.length() > 0 && sb.toString().charAt(0) == '*'))
                    stringBuilder.append('*');
                else if((sb1.length() > 0 && sb1.toString().charAt(0) != '*')
                || (sb.length() > 0 && sb.toString().charAt(0) != '*')) {
                    sb1 = sb1.reverse();
                    stringBuilder.append(sb);
                    stringBuilder.append(sb1);
                } else {
                    stringBuilder.append('*');
                }


                print(bufferedOutputStream, testCaseStrBytes);
                print(bufferedOutputStream, Integer.toString(t).getBytes());
                print(bufferedOutputStream, colSpace);
                print(bufferedOutputStream, stringBuilder.toString().getBytes());
                print(bufferedOutputStream, eolb);
            }
            bufferedOutputStream.flush();
            bufferedOutputStream.close();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
