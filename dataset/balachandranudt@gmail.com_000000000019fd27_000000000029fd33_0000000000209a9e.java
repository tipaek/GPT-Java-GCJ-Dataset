import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Solution {


    //Reverse rightmost 10 bits of x assuming leftmost 6 bits are 0
    static int reverseBits(int x, int len) {
        for (int i = 0; i < len / 2; i++) {
            int ls = 1 << i, rs = 1 << (len - 1 - i);
            int l = x & ls, r = x & rs;
            if (l == 0)
                x &= ~rs;
            else
                x |= rs;
            if (r == 0)
                x &= ~(ls);
            else
                x |= ls;
        }
        return x;
    }

    static int read(BufferedReader reader) throws IOException {
        int ans = 0;
        for (int j = 0; j < 10; j++) {
            System.out.println(j + 1);
            if (Integer.parseInt(reader.readLine()) == 1)
                ans |= (1 << (9 - j));
        }
        return ans;
    }

    static String result(int[] pos, BufferedReader reader) throws IOException {
        int ans = 0;
        for (int i = 20; i >= 12; i--) {
            System.out.println(i);
            if (Integer.parseInt(reader.readLine()) == 1)
                ans |= (1 << (20 - i));
        }
        System.out.println(10);
        if (Integer.parseInt(reader.readLine()) == 1)
            ans |= (1 << 10);
        for (int po : pos) {
            if (ans == (po & 0x5FF))
                return padBinaryStr(po, 20);
        }
        return null;
    }

    static String padBinaryStr(int in, int len) {
        return String.format("%20s", Integer.toBinaryString(in)).replace(' ', '0').substring(20 - len);
    }

    static void prettyPrint(int in, int len, PrintStream writer) {
        char[] c = padBinaryStr(in, len).toCharArray();
        for (int i = 0; i < c.length; i++) {
            writer.print(c[i]);
            if ((i + 1) % 5 == 0)
                writer.print(' ');
        }
        writer.println();
    }

    static boolean isSame(int l, int r) {
        if (l == r)
            return true;
        int comp = 0x3FF;
        if (l == (r ^ comp))
            return true;
        int rr = reverseBits(r, 10);
        if (l == rr)
            return true;
        return l == (rr ^ comp);
    }

    static void readDecision(BufferedReader reader) throws IOException {
        boolean isSuccess = reader.readLine().toCharArray()[0] == 'Y';
        if (!isSuccess)
            System.exit(0);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader reader = new BufferedReader(new FileReader("/Users/bchandrasekaran/Temp/db.in"));
//        PrintStream stream = new PrintStream(new FileOutputStream("/Users/bchandrasekaran/Temp/db.out"));
        String[] tb = reader.readLine().split(" ");
        int t = Integer.parseInt(tb[0]), b = Integer.parseInt(tb[1]);
        if (b > 20)
            throw new UnsupportedOperationException();
        if (b == 10) {
            for (int i = 0; i < t; i++) {
                System.out.println(padBinaryStr(read(reader), 10));
                readDecision(reader);
            }
        } else if (b == 20) {
            int first = read(reader), second = 0;
            for (int i = 0; i < 6; i++) {
                second = read(reader);
                if (!isSame(first, second))
                    break;
            }
            int[] pos = new int[8];
            pos[0] = (second << 10) | reverseBits(first, 10);
            pos[1] = (second << 10) | (reverseBits(first, 10) ^ 0x3FF);
            pos[2] = reverseBits(pos[0], 20);
            pos[3] = reverseBits(pos[1], 20);
            pos[4] = pos[0] ^ 0xFFFFF;
            pos[5] = pos[1] ^ 0xFFFFF;
            pos[6] = reverseBits(pos[3], 20);
            pos[7] = reverseBits(pos[4], 20);
//            Arrays.stream(pos).forEach(x -> Database.prettyPrint(x, 20, stream));
            String result = result(pos, reader);
            System.out.println(result == null ? padBinaryStr(pos[0], 20) : result);
            readDecision(reader);
        }
//        stream.close();
    }
}
