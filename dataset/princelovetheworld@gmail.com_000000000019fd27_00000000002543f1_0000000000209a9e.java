import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author zhxu
 */

public class Solution {
    public static void main(final String[] args) {
        final Scanner in = new Scanner(System.in);
        final int testCases = in.nextInt();
        final int length = in.nextInt();

        for (int i = 0; i < testCases; ++i) {
            if (length == 10) {
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < 10; j++) {
                    sb.append(query(j + 1, in));
                }
                System.out.println(sb.toString());
                System.out.flush();
            }
            else {
                int[] seq = new int[length];
                int count = 0;
                Base base1 = new Base(query(1, in), query(length, in));

                count += 2;
                seq[0] = base1.first;
                seq[seq.length - 1] = base1.second;

                int base21;
                int base22;
                Base otherB1;
                Base otherB2;
                if (base1.equals(new Base(0, 0)) || base1.equals(new Base(1, 1))) {
                    otherB1 = new Base(1, 0);
                    otherB2 = new Base(0, 1);
                } else {
                    otherB1 = new Base(0, 0);
                    otherB2 = new Base(1, 1);
                }
                Base next;
                int idx = 2;
                do {
                    next = new Base(query(idx, in), query(length - idx + 1, in));
                    base21 = idx;
                    base22 = length - idx + 1;
                    seq[base21 - 1] = next.first;
                    seq[base22 - 1] = next.second;
                    idx++;
                    count += 2;
                } while(idx <= length / 2 && !(next.equals(otherB1) || next.equals(otherB2)));

                if(idx > length / 2) { // not found, only 00/11 only complementation work only 01/10 -> reverse equals complementation
                    while(count % 10 != 0) {
                        query(1, in);
                        count++;
                    }

                    for(int pos = 1; pos <= length / 2; pos += 5) {
                        if(query(pos, in) != seq[pos - 1]) {
                            for(int p = 0; p < 5; p++) {
                                seq[pos - 1 + p] = seq[pos - 1 + p] ^ 1;
                                seq[length - p - pos] = seq[length - p - pos] ^ 1;
                            }
                        }
                    }
                    String res = Arrays.stream(seq).boxed().map(String::valueOf).collect(Collectors.joining());
                    System.out.println(res);
                    System.out.flush();
                } else {
                    while(count % 10 != 0) {
                        query(1, in);
                        count++;
                    }
                    Base base2 = null;

                    Base oldBase1;
                    Base oldBase2;

                    boolean firstBase = true;
                    boolean reversed = false;

                    for(int pos = 1; pos <= length; pos++) {
                        if(count % 10 == 0) {
                            oldBase1 = base1;
                            oldBase2 = base2;
                            base1 = new Base(query(1, in), query(length, in));
                            base2 = new Base(query(base21, in), query(base22, in));
                            count += 4;
                            if(!firstBase) {
                                switch (judge(base1, base2, oldBase1, oldBase2)) {
                                    case 0:
                                        break;
                                    case 1:
                                        reversed = !reversed;
                                        reverse(seq);
                                        break;
                                    case 2:
                                        com(seq);
                                        break;
                                    case 3:
                                        reversed = !reversed;
                                        reverse(seq);
                                        com(seq);
                                        break;
                                }
                            }
                            firstBase = false;
                        }
                        int posToQuery = reversed ? (length - pos + 1) : pos;
                        seq[posToQuery] = query(posToQuery, in);
                        count++;
                    }
                    String res = Arrays.stream(seq).boxed().map(String::valueOf).collect(Collectors.joining());
                    System.out.println(res);
                    System.out.flush();
                }
            }
            in.nextLine();
            String res = in.nextLine();
            if(res.equals("N")) {
                break;
            }

        }
    }

    static void reverse(int[] seq) {
        int lo = 0;
        int hi = seq.length - 1;
        while(lo < hi) {
            int t = seq[lo];
            seq[lo] = seq[hi];
            seq[hi] = t;
            lo++;
            hi--;
        }
    }

    static void com(int[] seq) {
        for(int k = 0; k < seq.length; k++) {
            seq[k] ^= 1;
        }
    }

    static int judge(Base b1, Base b2, Base ob1, Base ob2) {
        // 0 nothing, 1 reverse, 2 com, 3 both
        if (ob1.equals(b1) && ob2.equals(b2)) {
            return 0;
        } else if (ob1.reverse().equals(b1) && ob2.reverse().equals(b2)) {
            return 1;
        } else if (ob1.com().equals(b1) && ob2.com().equals(b2)) {
            return 2;
        } else if (ob1.both().equals(b1) && ob2.both().equals(b2)) {
            return 3;
        } else {
            throw new IllegalArgumentException("Invalid base comparison");
        }
    }

    private static int query(int pos, Scanner in) {
        System.out.println(pos);
        System.out.flush();
        return in.nextInt();
    }

    static class Base {
        int first;
        int second;
        Base(int a, int b) {
            first = a;
            second = b;
        }

        boolean equals(Base other) {
            return other.first == this.first && other.second == this.second;
        }

        Base com() {
            return new Base(first ^ 1, second ^ 1);
        }

        Base reverse() {
            return new Base(second, first);
        }

        Base both() {
            return com().reverse();
        }
    }
}

//  0 0  -> 0 0     0 0     1 1     1 1
//  0 1  -> 0 1     1 0     1 0     0 1
//  1 0  -> 1 0     0 1     0 1     1 0
//  1 1  -> 1 1     1 1     0 0     0 0
//
//
//  00 01
//  00 10
//  01 11
//  10 11
//
//  00/11
//  01/10
