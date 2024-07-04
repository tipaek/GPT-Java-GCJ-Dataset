import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    enum ItemType {SAME, INV, KNOWN}
    enum Happening {NOP, INV, REV, BOTH}

    static boolean LOG = false;

    static class Item {

        ItemType type;
        int startPos;
        int firstSame = -1;
        int firstInv = -1;
        char[] bits1;
        char[] bits2;

        int getRealPos(int localPos) {
            return startPos + localPos + 1;
        }

        Item(int B, Scanner in, int startPos, int length) {

            this.startPos = startPos;
            bits1 = new char[length];
            bits2 = new char[length];

            for (int i = 0; i < length; i++) {
                char c1 = send(in, Integer.toString(getRealPos(i)));
                bits1[i] = c1;

                char c2 = send(in, Integer.toString(B - getRealPos(i) + 1));
                bits2[length - i - 1] = c2;

                if (firstSame < 0 && c1 == c2) {
                    firstSame = i;
                } else if (firstInv < 0 && c1 != c2) {
                    firstInv = i;
                }
            }

            if (firstSame >= 0 && firstInv >= 0) {
                type = ItemType.KNOWN;
            } else if (firstSame >= 0) {
                type = ItemType.SAME;
            } else {
                type = ItemType.INV;
            }
        }

        public void update(Happening happen) {
            log("update " + happen);
            log("before " + this.toString());
            if (happen == Happening.INV || happen == Happening.BOTH) {
                for (int i = 0; i < bits1.length; i++) {
                    bits1[i] = bits1[i] == '0' ? '1' : '0';
                    bits2[i] = bits2[i] == '0' ? '1' : '0';
                }
            }
            if (happen == Happening.REV || happen == Happening.BOTH) {
                for (int i = 0; i < bits1.length; i++) {
                    char tmp = bits1[i];
                    bits1[i] = bits2[bits1.length - i - 1];
                    bits2[bits1.length - i - 1] = tmp;
                }
            }
            log("after  " + this.toString());
        }

        Happening findOutWhatHappened(Scanner in) {
            char c1 = send(in, Integer.toString(getRealPos(firstSame)));
            char c2 = send(in, Integer.toString(getRealPos(firstInv)));

            Happening result;

            if (bits1[firstSame] != bits1[firstInv]) {
                if (c1 == bits1[firstSame] && c2 == bits1[firstInv]) {
                    result = Happening.NOP;
                } else if (c1 == bits1[firstSame] && c2 == bits1[firstSame]) {
                    result = Happening.REV;
                } else if (c1 == bits1[firstInv] && c2 == bits1[firstInv]) {
                    result = Happening.BOTH;
                } else {
                    result = Happening.INV;
                }
            } else {
                if (c1 == bits1[firstSame] && c2 == bits1[firstInv]) {
                    result = Happening.NOP;
                } else if (c1 != bits1[firstSame] && c2 != bits1[firstSame]) {
                    result = Happening.INV;
                } else if (c1 == bits1[firstSame]) {
                    result = Happening.REV;
                } else {
                    result = Happening.BOTH;
                }
            }
            log("Happening: " + result);
            return result;
        }

        public void makeKnown(Scanner in) {
            char c = send(in, Integer.toString(getRealPos(0)));
            if (c != bits1[0]) {
                update(Happening.INV);
            }
            type = ItemType.KNOWN;
        }

        @Override
        public String toString() {
            return "[" + type + ", " + new String(bits1) + ", " + new String(bits2) + "]";
        }
    }

    static void log(String str) {
        if (LOG) {
            System.err.println(str);
        }
    }

    static char send(Scanner in, String str) {
        log("Send: " + str);
        System.out.println(str);
        System.out.flush();
        char read = in.next().charAt(0);
        log("Read: " + read);
        return read;
    }

    static boolean process(Scanner in, int B) throws IOException {

        List<Item> items = new ArrayList<>();
        Item known = null;

        int startPos = 0;
        int length = 5;
        int queryLeft = 0;

        while (startPos < B / 2) {

            queryLeft = 10;

            if (known != null) {
                Happening happen = known.findOutWhatHappened(in);
                queryLeft -= 2;
                for (Item item : items) {
                    if (item.type == ItemType.KNOWN) {
                        item.update(happen);
                    }
                }
            }

            if (startPos + length > B / 2) {
                length = B / 2 - startPos;
            }

            Item item = new Item(B, in, startPos, length);
            items.add(item);
            startPos += length;
            queryLeft -= 2 * length;
            log(item.toString());

            if (known == null && item.type == ItemType.KNOWN) {
                known = item;
                length = 4;
            }
        }

        log("Queryleft: " + queryLeft);

        List<Item> unknownItems = items.stream().filter(item -> item.type != ItemType.KNOWN).collect(Collectors.toList());

        log("Unknowns: " + unknownItems);

        if (known == null) {
            queryLeft = 10;
        }

        while (!unknownItems.isEmpty()) {
            if (known != null && queryLeft == 0) {
                Happening happen = known.findOutWhatHappened(in);
                queryLeft = 8;
                for (Item item : items) {
                    if (item.type == ItemType.KNOWN) {
                        item.update(happen);
                    }
                }
            }
            Item remove = unknownItems.remove(0);
            remove.makeKnown(in);
            queryLeft--;
        }

        StringBuilder result1 = new StringBuilder();
        StringBuilder result2 = new StringBuilder();
        for (Item item : items) {
            result1.append(new String(item.bits1));
            result2.append(new StringBuilder(new String(item.bits2)).reverse());
        }
        char c = send(in, result1.toString() + result2.reverse().toString());
        return c == 'Y';
    }

    static String hack(String str) {
        return str.replaceAll(".", "$0\n");
    }

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        /*
        in = new Scanner(new StringReader("1\n30"
                + "\n1\n1\n1\n1\n1\n1\n1\n1\n1\n1\n"
                + "\n1\n0\n1\n1\n1\n0\n1\n0\n1\n0" + "\n1\n1\n"
                + "\n1\n0\n1\n0\n1\n0\n1\n0" + "\n1\n1\n"
                + "\n1\n0\n"
                + "1\n1\n1\n"
                + "Y\n"));
        in = new Scanner(new StringReader("2\n10\n"
                + hack("1010000110")
                + "Y\n"
                + hack("1010000110")
                + "Y\n"));
         */
        //ESAbATAd.LOG = true;
        int T = in.nextInt();
        int B = in.nextInt();
        for (int i = 0; i < T; i++) {
            if (!process(in, B)) {
                break;
            }
        }
    }
}