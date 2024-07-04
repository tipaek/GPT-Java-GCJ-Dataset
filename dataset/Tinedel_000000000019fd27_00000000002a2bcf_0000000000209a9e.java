import java.util.BitSet;
import java.util.Scanner;

public class Solution {
    public static void solve10(Scanner input, int len) {
        BitSet a1 = new BitSet(len);
        for (int i = 0; i < len; i++) {
            askBit(input, a1, i + 1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(a1.get(i) ? '1' : '0');
        }
        System.out.println(sb.toString());
        System.out.flush();
        String resp = input.next();
        if (!"Y".equals(resp)) {
            System.exit(0);
        }
    }

    private static void askBit(Scanner input, BitSet a, int pos) {
        boolean b = askBit(input, pos);
        if (b) {
            a.set(pos - 1);
        } else {
            a.clear(pos - 1);
        }
    }

    private static boolean askBit(Scanner input, int pos) {
        System.out.println(pos);
        System.out.flush();
        int b = input.nextInt();
        return b == 1;
    }

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int T = input.nextInt();
        int B = input.nextInt();
        for (int ks = 1; ks <= T; ks++) {
            if (B <= 10) {
                solve10(input, B);
            } else {
                solve(input, B);
            }
        }
    }

    private static void solve(Scanner input, int len) {
        BitSet bs = new BitSet(len);
        int current = 0;
        char[] status = new char[len / 10];
        while (current < len / 10) {
            askDecWord(input, current, bs, len);
            status[current] = checkStatus(bs, current, len);
            if (status[current] == 'M') break;
            current++;
        }
        // got to mixed words and just randomized
        // need to flip in any case

        int asked = 0;
        for (int i = 0; i < len / 10; i++) {
            if (status[i] == 'M') break;
            asked++;
            if (!askIfSame(input, bs, pos(i, 0))) {
                flipDecWord(i, bs, len);
            }
        }


        if (current >= len / 10) {
            // don't have any mixed words
            // let's glue and send an answer as it's already normalized
            sendAnswer(input, bs, len);
            // finished this testcase, let's move on
            return;
        }

        Anchor anchor = findAnchor(bs, index(current, 0), index(current, 4), len);
        if (asked == 9) {
            boolean h = homogeneous(status);

            Anchor symmetryAnchor = h ? null : findAnchor(bs, 0, index(current, -1), len);
            askBit(input, 0); // lets make it flip

            if (h) {
                asked = 1;
                for (int i = 0; i < current; i++) {
                    flipDecWord(i, bs, len);
                }
            } else {
                asked = 2;
                normalize(input, bs, symmetryAnchor, 0, index(current, -1), len);
            }

            anchor = new Anchor();
        }

        // need to find out and normalize only known mixed

        asked += 2;
        normalize(input, bs, anchor, index(current, 0), index(current, 4), len);

        int cPos = pos(current, 4) + 1; // first pos of the unread
        int lastPos = len / 2;

        if (asked % 2 == 1) askBit(input, 1); // need even known state

        while (cPos <= lastPos) {
            if (asked % 10 == 0) {
                asked = 2; // 2 reads in anchor
                normalize(input, bs, anchor, 0, cPos, len);
            }
            asked++;
            askBit(input, bs, cPos);
            asked++;
            askBit(input, bs, mirrorPos(cPos, len));
            cPos++;
        }


        // shouldn't be needed, but either it's to late and i missed something,
        // or python local test is messing up in some rare cases
        normalize(input, bs, anchor, 0, cPos, len);

        sendAnswer(input, bs, len);
    }

    private static boolean homogeneous(char[] status) {
        char seen = status[0];
        int current = 1;
        while (seen == status[current] && status[current] != 'M') current++;
        return status[current] == 'M';
    }

    private static void sendAnswer(Scanner input, BitSet bs, int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(bs.get(i) ? '1' : '0');
        }
        String normalized = sb.toString();
        System.out.println(normalized);
        String reply = input.next();
        if (!"Y".equals(reply)) {
            System.exit(0);
        }
    }

    private static void normalize(Scanner input, BitSet bs, Anchor anchor, int from, int to, int len) {
        if (anchor.isS(input, bs)) {
            anchor.valid = false; // indicate we need to reask on next call
        } else if (anchor.isR(input, bs)) {
            R(bs, from, to, len);
            anchor.R();
        } else if (anchor.isC(input, bs)) {
            C(bs, from, to, len);
            anchor.C();
        } else if (anchor.isRC(input, bs)) {
            RC(bs, from, to, len);
            anchor.RC();
        }
    }

    private static Anchor findAnchor(BitSet bs, int from, int to, int len) {
        int i = -1;
        int j = -1;
        boolean found = false;
        outer:
        for (i = from; i < to; i++) {
            for (j = i + 1; j <= to; j++) {
                if (bs.get(i) == bs.get(j) && bs.get(mirrorIndex(i, len)) != bs.get(mirrorIndex(j, len))
                        || bs.get(i) != bs.get(j) && bs.get(mirrorIndex(i, len)) == bs.get(mirrorIndex(j, len))) {
                    found = true;
                    break outer;
                }
            }
        }
        // must found as otherwise it'd be symmetric
        assert found;
        assert i >= 0;
        assert j > i;
        if (bs.get(i) != bs.get(j)) {
            i = mirrorIndex(i, len);
            j = mirrorIndex(j, len);
        }
        if (bs.get(j) != bs.get(mirrorIndex(j, len))) {
            int temp = i;
            i = j;
            j = temp;
        }
        Anchor res = new Anchor();
        res.a = new BitSet(4);
        res.idxs = new int[]{i, j, mirrorIndex(j, len), mirrorIndex(i, len)};

        for (int k = 0; k < res.idxs.length; k++) {
            res.a.set(k, bs.get(res.idxs[k]));
        }

        return res;
    }

    private static boolean askIfSame(Scanner input, BitSet bs, int pos) {
        return askBit(input, pos) == bs.get(pos - 1);
    }

    static int index(int word, int i) {
        return word * 5 + i;
    }

    static int pos(int word, int i) {
        return index(word, i) + 1;
    }

    private static void flipDecWord(int num, BitSet bs, int len) {
        bs.flip(index(num, 0), index(num, 5));
        bs.flip(mirrorIndex(index(num, 4), len), mirrorIndex(index(num, 4), len) + 5);
    }

    static int mirrorIndex(int i, int len) {
        return len - i - 1;
    }

    static int mirrorPos(int i, int len) {
        return len - i + 1;
    }

    private static char checkStatus(BitSet bs, int num, int len) {
        boolean symmetric = bs.get(num * 5) == bs.get(mirrorIndex(num * 5, len));
        for (int i = 1; i < 5; i++) {
            int current = num * 5 + i;
            boolean equalsMirror = bs.get(current) == bs.get(mirrorIndex(current, len));
            if (symmetric && !equalsMirror || !symmetric && equalsMirror) return 'M';
        }
        return symmetric ? 'S' : 'A';
    }

    private static void askDecWord(Scanner input, int num, BitSet bs, int len) {
        for (int i = 1; i <= 5; i++) {
            askBit(input, bs, 5 * num + i);
            askBit(input, bs, mirrorPos(5 * num + i, len));
        }
    }

    BitSet r(BitSet bs, int len) {
        for (int i = 0; i < len / 2; i++) {
            boolean temp = bs.get(i);
            bs.set(i, bs.get(len - i - 1));
            bs.set(len - i - 1, temp);
        }

        return bs;
    }

    BitSet c(BitSet bs, int len) {
        bs.flip(0, len);
        return bs;
    }

    BitSet rc(BitSet bs, int len) {
        return r(c(bs, len), len);
    }

    private static class Anchor {
        BitSet a;
        int[] idxs;

        boolean b1;
        boolean b2;

        boolean valid = false;

        void q(Scanner input) {
            b1 = askBit(input, idxs[0] + 1);
            b2 = askBit(input, idxs[1] + 1);
            valid = true;
        }

        boolean isS(Scanner input, BitSet bs) {
            if (!valid) q(input);
            return bs.get(idxs[0]) == b1 && bs.get(idxs[1]) == b2;
        }

        boolean isC(Scanner input, BitSet bs) {
            if (!valid) q(input);
            return bs.get(idxs[0]) == !b1 && bs.get(idxs[1]) == !b2;
        }

        boolean isR(Scanner input, BitSet bs) {
            if (!valid) q(input);
            return bs.get(idxs[3]) == b1 && bs.get(idxs[2]) == b2;
        }

        boolean isRC(Scanner input, BitSet bs) {
            if (!valid) q(input);
            return bs.get(idxs[3]) == !b1 && bs.get(idxs[2]) == !b2;
        }

        void R() {
            valid = false;
            Solution.R(a, 0, 1, 4);
            int temp = idxs[0];
            idxs[0] = idxs[3];
            idxs[3] = temp;

            temp = idxs[1];
            idxs[1] = idxs[2];
            idxs[2] = temp;
        }

        void C() {
            valid = false;
            Solution.C(a, 0, 1, 4);
        }

        void RC() {
            R();
            C();
        }
    }

    static void R(BitSet bs, int from, int to, int len) {
        for (int i = from; i <= to; i++) {
            boolean temp = bs.get(i);
            bs.set(i, bs.get(mirrorIndex(i, len)));
            bs.set(mirrorIndex(i, len), temp);
        }
    }

    static void C(BitSet bs, int from, int to, int len) {
        bs.flip(from, to + 1);
        bs.flip(mirrorIndex(to, len), mirrorIndex(from, len) + 1);
    }

    static void RC(BitSet bs, int from, int to, int len) {
        R(bs, from, to, len);
        C(bs, from, to, len);
    }
}
