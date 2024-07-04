import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.util.*;

public class Solution {

    private static boolean debug = false;

    private static PrintStream inOut;
    private static PrintStream outOut;
    private static PrintStream dialogOut;

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static String readLn() {
        String line;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        if (debug) {
            inOut.println(line);
            dialogOut.println("RCVD "+move+": " + line);
        }
        if (line.equals("N"))
            System.exit(0);
        return line;
    }

    private static boolean readBit(int idx) {
        move++;
        writeLine(idx);
        String line = readLn();
        return line.equals("1");
    }

    private static void writeLine(Object line) {
        if (debug) {
            outOut.println(line);
            dialogOut.println("SENT "+move+": " + line);
        }
        System.out.println(line);
        System.out.flush();
    }

    public void processRawInput() throws NumberFormatException, IOException {
        reset(0);
        String input = readLn();
        String[] parts = input.split(" ");
        int cases = Integer.parseInt(parts[0]);
        int bits = Integer.parseInt(parts[1]);

        for (int i = 1; i <= cases; i++) {
            reset(bits);
            process();
        }

    }

    public static void process() {
        while (pos < arr.length/2) {
            boolean v1 = readBit(pos + 1);
            boolean flucHappened = moveIsFluc(move);
            if (flucHappened) {
                if (debug) {
                    dialogOut.println("Fluctuation deteced (move1), sameFound: "+sameFound+" diffFound: "+differentFound);
                }
                checkAfterFluc();
            }
            boolean v2 = readBit(arr.length - pos);
            flucHappened = moveIsFluc(move);
            if (flucHappened) {
                checkAfterFluc();
                if ((!sameFound || !differentFound) || reversePerformed) {
                    v1 = readBit(pos + 1);
                } else {
                    if (complimentPerformed)
                        v1 = !v1;
                }
            }

            arr[pos] = v1;
            arr[arr.length-pos-1] = v2;
            if (debug) {
                dialogOut.println("ARR : " + arrToString());
            }
            if (v1 == v2) {
                if (!sameFound) {
                    sameFound = true;
                    sameIdx1 = pos;
                    sameValue = v1;
                }
            } else {
                if (!differentFound) {
                    differentFound = true;
                    differentIdx1 = pos;
                    diffValue1 = v1;
                }
            }
            pos++;
        }
        writeLine(arrToString());
        String reply = readLn();
        if (!reply.equals("Y")) {
            System.exit(-1);
        }
    }

    private static String arrToString() {
        StringBuilder sb = new StringBuilder();
        for (Boolean b : arr) {
            sb.append(b == null ? "_" : b == Boolean.TRUE ? "1":"0");
        }
        return sb.toString();
    }

    private static boolean moveIsFluc(int move) {
        return (""+move).endsWith("1");
    }

    private static Boolean[] arr;
    private static int pos = 0;
    private static int move;

    private static boolean sameFound;
    private static int sameIdx1;
    private static boolean sameValue;

    private static boolean differentFound;
    private static int differentIdx1;
    private static boolean diffValue1;

    private static boolean complimentPerformed;
    private static boolean reversePerformed;

    private static void reset(int bits) {
        if (debug) {
            try {
                inOut = new PrintStream(new FileOutputStream("C:\\projects\\codejam2020\\04-interactive\\in.out"));
                outOut = new PrintStream(new FileOutputStream("C:\\projects\\codejam2020\\04-interactive\\out.out"));
                dialogOut = new PrintStream(new FileOutputStream("C:\\projects\\codejam2020\\04-interactive\\dia.out"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        arr = new Boolean[bits];
        pos = 0;
        move = 0;
        sameFound = false;
        differentFound = false;
    }

    private static void checkAfterFluc() {
        boolean c = false;
        boolean r = false;
        if (sameFound) {
            boolean bit = readBit(sameIdx1+1);
            c = sameValue != bit;
            if (debug) {
                dialogOut.println("Fluc detected complement: " + c);
            }
        }
        if (differentFound) {
            boolean bit = readBit(differentIdx1+1);
            boolean changed = diffValue1 != bit;
            if (c) {
                r = !changed;
            } else {
                r = changed;
            }
            if (debug) {
                dialogOut.println("Fluc detected Reverse: " + r);
            }

        }
        complimentPerformed = c;
        if (c) {
            complement(arr);
        }
        reversePerformed = r;
        if (r) {
            reverse(arr);
        }
        if (sameFound) {
            sameValue = arr[sameIdx1];
        }
        if (differentFound) {
            diffValue1 = arr[differentIdx1];
        }
    }

    private static void complement(Boolean[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                arr[i] = !arr[i];
            }
        }
        if (debug) {
            dialogOut.println("COMPL: " + arrToString());
        }
    }

    private static void reverse(Boolean[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            Boolean tmp = arr[i];
            arr[i] = arr[arr.length-i-1];
            arr[arr.length-i-1] = tmp;
        }
        if (debug) {
            dialogOut.println("REVR: " + arrToString());
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        new Solution().processRawInput();
    }

}
