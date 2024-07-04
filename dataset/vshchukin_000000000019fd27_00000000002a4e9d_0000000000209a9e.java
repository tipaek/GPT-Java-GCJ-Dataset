import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.util.List;
import java.util.Arrays;
import java.util.Scanner;
import java.util.BitSet;
import java.util.ArrayList;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Solution {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        ESAbATAd solver = new ESAbATAd();
        solver.solve(1, in, out);
        out.close();
    }

    static class ESAbATAd {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int numTests = in.nextInt();
            int b = in.nextInt();
            int numPairs = b / 10;
            int halfPairs = numPairs / 2;
            List<ESAbATAd.EntangledBits> list = new ArrayList<>();
            for (int _i = 0; _i < numTests; _i++) {
                for (int i = 0; i < numPairs; i++) {
                    BitSet first = new BitSet(5);
                    BitSet last = new BitSet(5);
                    for (int j = 0; j < 5; j++) {
                        out.println(5 * i + j);
                        out.flush();
                        first.set(j, in.nextInt() > 0);
                        out.println(b - (5 * i + j) - 1);
                        out.flush();
                        last.set(5 - j - 1, in.nextInt() > 0);
                    }
                    list.add(new ESAbATAd.EntangledBits(first, last, 5));
                }
                ESAbATAd.EntangledBits finalBits = list.get(0);
                if (halfPairs > 0) {
                    List<ESAbATAd.EntangledBits> toMerge = new ArrayList<>();
                    for (int i = 0; i < halfPairs; i++) {
                        ESAbATAd.EntangledBits bits = list.get(i);
                        bits.setState(5 * i, b, out, in);
                        toMerge.add(bits);
                    }
                    ESAbATAd.EntangledBits first = merge(toMerge);
                    List<ESAbATAd.EntangledBits> toMergeLast = new ArrayList<>();
                    for (int i = halfPairs; i < numPairs; i++) {
                        ESAbATAd.EntangledBits bits = list.get(i);
                        bits.setState(5 * i, b, out, in);
                    }
                    ESAbATAd.EntangledBits last = merge(toMergeLast);
                    first.setState(0, b, out, in);
                    last.setState(b / 2, b, out, in);
                    finalBits = merge(Arrays.asList(first, last));
                }
                finalBits.setState(0, b, out, in);
                finalBits.writeOutput(out, in);
            }
        }

        private ESAbATAd.EntangledBits merge(List<ESAbATAd.EntangledBits> toMerge) {
            int ebitsLen = toMerge.get(0).length;
            int len = toMerge.size() * ebitsLen;
            BitSet first = new BitSet(len);
            BitSet last = new BitSet(len);
            for (int i = 0; i < toMerge.size(); i++) {
                ESAbATAd.EntangledBits bits = toMerge.get(i);
                ESAbATAd.EntangledBits lastBits = toMerge.get(toMerge.size() - i - 1);
                for (int j = 0; j < ebitsLen; j++) {
                    first.set(i * ebitsLen + j, bits.first.get(j));
                    last.set(len - i * ebitsLen - j - 1, lastBits.last.get(ebitsLen - j - 1));
                }
            }
            return new ESAbATAd.EntangledBits(first, last, len);
        }

        static class EntangledBits {
            BitSet first;
            BitSet last;
            BitSet curFirst;
            BitSet curLast;
            int length;
            int flippingBit = -1;
            int sameBit = -1;
            int flippingState = -1;
            int sameState = -1;

            public EntangledBits(BitSet first, BitSet last, int length) {
                this.first = first;
                this.last = last;
                this.length = length;
                for (int i = 0; i < length; i++) {
                    if (first.get(i) == last.get(length - i - 1)) {
                        sameBit = i;
                        sameState = first.get(sameBit) ? 1 : 0;
                        break;
                    }
                }
                for (int i = 0; i < length; i++) {
                    if (first.get(i) != last.get(length - i - 1)) {
                        flippingBit = i;
                        flippingState = first.get(flippingBit) ? 1 : 0;
                        break;
                    }
                }
            }

            public boolean isSymmetric() {
                return flippingState == -1;
            }

            public boolean isSymmetricFlip() {
                return sameState == -1;
            }

            public boolean isQuadState() {
                return !(isSymmetric() || isSymmetricFlip());
            }

            public void setState(int start, int b, PrintWriter out, Scanner in) {
                out.println(Math.max(flippingBit, 0));
                out.flush();
                int currFlipping = in.nextInt();
                out.println(Math.max(sameBit, 0));
                out.flush();
                int currSame = in.nextInt();
                curFirst = (BitSet) first.clone();
                curLast = (BitSet) last.clone();
                if (isQuadState()) {
                    if (currSame == sameState && currFlipping != flippingState) {
                        for (int i = 0; i < length; i++) {
                            curFirst.set(i, last.get(length - i - 1));
                            curLast.set(i, first.get(length - i - 1));
                        }
                    } else if (currFlipping == flippingState && currSame != sameState) {
                        for (int i = 0; i < length; i++) {
                            curFirst.set(i, last.get(length - i - 1));
                            curLast.set(i, first.get(length - i - 1));
                        }
                        curFirst.flip(0, length);
                        curLast.flip(0, length);
                    } else if (currFlipping != flippingState) {
                        curFirst.flip(0, length);
                        curLast.flip(0, length);
                    }
                } else if (isSymmetric()) {
                    if (currSame != sameState) {
                        for (int i = 0; i < length; i++) {
                            curFirst.set(i, last.get(length - i - 1));
                            curLast.set(i, first.get(length - i - 1));
                        }
                    }
                } else if (isSymmetricFlip()) {
                    if (currFlipping != flippingState) {
                        curFirst.flip(0, length);
                        curLast.flip(0, length);
                    }
                }
            }

            public void writeOutput(PrintWriter out, Scanner in) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < length; i++) {
                    sb.append(first.get(i) ? 1 : 0);
                }
                for (int i = 0; i < length; i++) {
                    sb.append(last.get(i) ? 1 : 0);
                }
                out.println(sb.toString());
                out.flush();
                String res = in.next().trim();
                if (!res.equals("Y")) {
                    System.err.println("Bad things happened " + res);
                    //throw new RuntimeException("Bad things happened " + res);
                }
            }

        }

    }
}

