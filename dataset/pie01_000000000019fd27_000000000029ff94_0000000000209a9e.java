import java.util.*;
import java.io.*;
import java.math.BigInteger;

// Qualification Round 2020: Problem D - ESAb ATAd
//
public class Solution {
    private static final int BULK = 10;
    private static final int MASK = (1 << BULK) - 1;

    private static class Chunk {
        private int[] buffer = new int[2];
        private int[] index = new int[2];
        private int second = 0;
        private int[] startIndex = new int[2];
        private int active = 0;
        private int retry = 10;

        public Chunk(int i, int j) {
            startIndex[0] = i;
            startIndex[1] = j;
        }

        public boolean hasPair() {
            return startIndex[0] != startIndex[1];
        }

        public int send() {
            if (active < 0) return sendLast();

            return index[active] + startIndex[active];
        }

        public boolean receive(int bitVal) {
            if (active < 0) {
                return receiveLast(bitVal);
            }
            buffer[active] <<= 1;
            buffer[active] |= bitVal;
            if (++index[active] < BULK) return false;

            if (!hasPair()) return true;

            if (active == 0) {
                active = 1;
                return false;
            }
            int cmp = compare(buffer[0], buffer[1]);
            if (cmp < 0 || retry-- < 0) {
                active = -1; // next phrase
            }
            return false;
        }

        private Set<Integer> candidates;
        private int bitIndex = 0;

        private int sendLast() {
            if (candidates == null) {
                candidates = new HashSet<>();
                for (int a : transform(buffer[0])) {
                    for (int b : transform(buffer[1])) {
                        candidates.add((a << BULK) | b);
                        candidates.add((b << BULK) | a);
                    }
                }
            }

            if (candidates.size() == 1) {
                return 1; // any
            }

            int lastBit = -1;
            for (int cand : candidates) {
                int curBit = (cand >> (19 - bitIndex)) & 1;
                if (lastBit < 0) {
                    lastBit = curBit;
                } else if (curBit != lastBit) {
                    return bitIndex < BULK ? bitIndex + startIndex[0] : bitIndex - BULK + startIndex[1];
                }
                bitIndex++;
            }
            return -1;
        }

        private int[] transform(int a) {
            int ra = reverse(a);
            return new int[]{a, (a ^ MASK), ra, (ra ^ MASK)};
        }

        private boolean receiveLast(int bitVal) {
            Iterator<Integer> iterator = candidates.iterator();
            while (iterator.hasNext()) {
                int cand = iterator.next();
                int curBit = (cand >> (19 - bitIndex)) & 1;
                if (curBit != bitVal) {
                    iterator.remove();
                }
            }
            if (candidates.size() > 1) return false;

            int cand = candidates.iterator().next();
            buffer[0] = cand >> BULK;
            buffer[1] = MASK & cand;
            return true;
        }

        public static int compare(int a, int b) {
            if (a == b) return 0;

            if ((a ^ MASK) == b) return 1;

            int ra = reverse(a);
            if (ra == b) return 2;

            if ((ra ^ MASK) == b) return 3;

            return -1;
        }

        private static int reverse(int x) {
            int res = 0;
            for (int position = BULK - 1; position > 0; position--, x >>= 1) {
                res += ((x & 1) << position);
            }
            return res;
        }

        public String toString(boolean firstHalf) {
            return String.format("%10s", Integer.toBinaryString(buffer[firstHalf ? 0 : 1])).replace(' ', '0');
        }
    }

    private static class Inferer {
        private int bitSize;
        private Chunk[] chunks;
        private int activeChunk = 0;

        public Inferer(int bitSize) {
            this.bitSize = bitSize;
            int count = bitSize / BULK;
            chunks = new Chunk[(count + 1) / 2];
            for (int i = 0; i < chunks.length; i++) { // pairs
                chunks[i] = new Chunk(i * BULK, (count - i - 1) * BULK);
            }
        }

        public String send() {
            if (activeChunk >= chunks.length) return toString(chunks);

            int index = chunks[activeChunk].send();
            return String.valueOf(index + 1);
        }

        public void receive(boolean bitVal) {
            if (chunks[activeChunk].receive(bitVal ? 1 : 0)) {
                activeChunk++;
            }
        }

        private String toString(Chunk[] chunks) {
            StringBuilder sb = new StringBuilder();
            for (Chunk chunk : chunks) {
                sb.append(chunk.toString(true));
            }
            for (int i = chunks.length - 1; i >= 0; i--) {
                Chunk chunk = chunks[i];

                if (chunk.hasPair()) {
                    sb.append(chunk.toString(false));
                }
            }
            System.err.println("==========answer:" + sb);
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        int b = in.nextInt();
        for (int i = 1; i <= t; i++) {
            System.err.println("TEST " + i + "--------;b=" + b);
            Inferer inferer = new Inferer(b);
            for (int index = 1; index < 150; index++) {
                System.out.println(inferer.send());
                String resp = in.next();
                System.err.println("----response=" + resp);
                if ("Y".equals(resp)) break;
                if ("N".equals(resp)) {
                    System.err.println("FAIL");
                    return;
                }

                inferer.receive("1".equals(resp));
            }
        }
        System.err.println("PASS");
    }
}
