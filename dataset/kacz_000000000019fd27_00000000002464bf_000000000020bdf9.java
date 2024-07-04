import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    private static Scanner input = null;
    private static PrintStream logger = null;
    private static PrintStream output = null;
    private static boolean debug = false;

    public static <E> void log(E msg) {
        if(debug) {
            logger.println("LOG: " + msg);
        }
    }

    public static <E> void out(E msg) {
        out(msg, false);
    }

    public static <E> void outln(E msg) {
        out(msg, true);
    }

    private static <E> void out(E msg, boolean println) {
        output.print(msg);
        if(println) {
            output.println();
        }
        output.flush();

        if(debug) {
            logger.print("OUT: " + msg);
            if(println) {
                logger.println("\\n");
            } else {
                logger.println();
            }
            logger.flush();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        if (args.length > 0 && args[0].equals("-debug")) {
            debug = true;
            input = new Scanner(new File("in.txt"));
            output = new PrintStream(new File("out.txt"));
            logger = new PrintStream(new File("log.txt"));
        } else {
            input = new Scanner(System.in);
            output = new PrintStream(System.out);
        }

        int cases = input.nextInt();
        input.nextLine();
        for (int i = 0; i < cases; ++i) {
            solve(i + 1);
        }
    }

    private static void solve(int testCaseNumber) {
        out("Case #" + testCaseNumber + ": ");
        int n = input.nextInt();

        List<Item> items = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int start = input.nextInt();
            int end = input.nextInt();
            items.add(new Item(i, start, end));
        }

        items = items.stream().sorted(Comparator.comparingInt(Item::getStart)).collect(Collectors.toList());

        int jamie = 0;
        int cameron = 0;

        boolean impossible = false;

        for (Item i: items) {
            if (i.start >= jamie) {
                jamie = i.end;
                i.setWho('J');
                continue;
            }
            if (i.start >= cameron) {
                cameron = i.end;
                i.setWho('C');
                continue;
            }
            impossible = true;
            break;
        }

        if (impossible) {
            outln("IMPOSSIBLE");
        } else {
            items = items.stream().sorted(Comparator.comparingInt(Item::getIndex)).collect(Collectors.toList());
            for (Item i: items) {
                out(i.who);
            }
            outln("");
        }
    }

    static class Item {
        int index;
        int start;
        int end;
        char who;

        public Item(int index, int start, int end) {
            this.index = index;
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public char getWho() {
            return who;
        }

        public void setWho(char who) {
            this.who = who;
        }

        public int getIndex() {
            return index;
        }
    }
}