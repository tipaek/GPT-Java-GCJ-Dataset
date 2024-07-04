import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {

    public static int[] convertArray(int[] array) {
        int[] result = new int[array.length + 1];
        System.arraycopy(array, 0, result, 1, array.length);
        return result;
    }

    public static int getStringDepth(String str) {
        int maxDepth = 0;
        for (int i = 0; i < str.length(); i++) {
            int currentDepth = Character.getNumericValue(str.charAt(i));
            if (currentDepth > maxDepth) {
                maxDepth = currentDepth;
            }
        }
        return maxDepth;
    }

    public static int getMinDepth(String str) {
        int minDepth = 10;
        for (int i = 0; i < str.length(); i++) {
            int currentDepth = Character.getNumericValue(str.charAt(i));
            if (currentDepth < minDepth) {
                minDepth = currentDepth;
            }
        }
        return minDepth;
    }

    public static int getMinDepthAbove(String str, int threshold) {
        int minDepth = 10;
        for (int i = 0; i < str.length(); i++) {
            int currentDepth = Character.getNumericValue(str.charAt(i));
            if (currentDepth > threshold && currentDepth < minDepth) {
                minDepth = currentDepth;
            }
        }
        return minDepth;
    }

    public void solveForDepth(String str, int depth) {
        // Method implementation is missing in the original code
    }

    public static void main(String[] args) {
        Transpose tr = Transpose.getInstance();
        tr.start(new Transpose.Test() {
            @Override
            void onTest(int i, int T) {
                String S = tr.nextLine();
                Depth mainDepth = new Depth();
                mainDepth.s = S;
                mainDepth.finalString = new StringBuilder(S);
                mainDepth.start = 0;
                mainDepth.end = S.length();
                mainDepth.solve();
                Inserter inserter = new Inserter();
                mainDepth.generateInserts(inserter);
                String resultString = inserter.build(S);
                tr.addCase(i, resultString);
            }
        });
        tr.flush();
    }
}

class Insert {
    int pos = 0;
    String c = "";

    @Override
    public String toString() {
        return pos + " - " + c;
    }
}

class Inserter {
    ArrayList<Insert> inserts = new ArrayList<>();

    public void insert(Insert insert) {
        inserts.add(insert);
    }

    public String build(String str) {
        StringBuilder builder = new StringBuilder(str);
        int offset = 0;
        for (Insert insert : inserts) {
            builder.insert(offset + insert.pos, insert.c);
            offset += insert.c.length();
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        return inserts.toString();
    }
}

class Depth {
    String s;
    int start;
    int end;
    int ac = 0;
    Depth parent = null;
    StringBuilder finalString;
    int depth = 0;
    Depth root = null;
    ArrayList<Depth> subs = new ArrayList<>();

    public Depth getRoot() {
        return root == null ? this : root;
    }

    public String repeat(String c, int count) {
        return c.repeat(count);
    }

    public void generateInserts(Inserter inserter) {
        for (Depth sub : subs) {
            int depthDifference = sub.depth - depth;
            Insert insert = new Insert();
            insert.pos = sub.start;
            insert.c = repeat("(", depthDifference);
            inserter.insert(insert);
            sub.generateInserts(inserter);
            insert = new Insert();
            insert.pos = sub.end;
            insert.c = repeat(")", depthDifference);
            inserter.insert(insert);
        }
    }

    public void solve() {
        int currentStart = 0;
        int last = 0;

        if (s.length() == 1) {
            int depthValue = Character.getNumericValue(s.charAt(0));
            Depth depth = new Depth();
            depth.depth = depthValue;
            depth.start = start;
            depth.end = start + 1;
            depth.s = s;
            depth.root = getRoot();
            depth.parent = this;
            subs.add(depth);
        } else {
            while (last != s.length() - 1) {
                int minDepthAbove = Solution.getMinDepthAbove(s.substring(currentStart), depth);

                if (minDepthAbove == 10) return;

                int subStart = -1;
                int subEnd = s.length();
                for (int i = currentStart; i < s.length(); i++) {
                    int currentDepth = Character.getNumericValue(s.charAt(i));
                    if (currentDepth >= minDepthAbove) {
                        if (subStart == -1) {
                            subStart = i;
                        }
                        if (i == s.length() - 1) {
                            subEnd = i + 1;
                            Depth subDepth = new Depth();
                            subDepth.depth = minDepthAbove;
                            subDepth.start = start + subStart;
                            subDepth.end = start + subEnd;
                            subDepth.s = s.substring(subStart, subEnd);
                            subDepth.root = getRoot();
                            subDepth.parent = this;
                            subDepth.solve();
                            subs.add(subDepth);
                            last = i;
                            currentStart = subEnd;
                            break;
                        }
                    } else if (subStart != -1) {
                        subEnd = i;
                        Depth subDepth = new Depth();
                        subDepth.depth = minDepthAbove;
                        subDepth.start = start + subStart;
                        subDepth.end = start + subEnd;
                        subDepth.s = s.substring(subStart, subEnd);
                        subDepth.parent = this;
                        subDepth.root = getRoot();
                        subDepth.solve();
                        subs.add(subDepth);
                        last = i;
                        currentStart = subEnd;
                        break;
                    }
                    last = i;
                }
            }
        }
    }
}

class Transpose {
    private BufferedReader br;
    private String queue = "";
    private int T = -1;
    private int TE = -1;

    public static Transpose getInstance() {
        return new Transpose();
    }

    private Transpose() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    public String nextLine() {
        try {
            return br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public int nextInt() {
        return Integer.parseInt(nextLine());
    }

    public double nextDouble() {
        return Double.parseDouble(nextLine());
    }

    public String[] nextStringArray() {
        try {
            return br.readLine().split(" ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String[]{};
    }

    public int[] nextIntArray() {
        String[] stringArray = nextStringArray();
        int[] intArray = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

    public void start(Test test) {
        int[] ts = nextIntArray();
        T = ts[0];
        if (ts.length > 1) {
            TE = ts[1];
        }
        for (int i = 1; i <= T; i++) {
            test.onTest(i, T);
        }
    }

    public Transpose add(String str) {
        queue += str;
        return this;
    }

    public Transpose addCase(int i, String str) {
        addLine("Case #" + i + ": " + str);
        return this;
    }

    public Transpose addLine(String str) {
        return add(str + "\n");
    }

    public void print(String str) {
        System.out.print(str);
    }

    public void println(String str) {
        System.out.println(str);
    }

    public void printCase(int i, String str) {
        println("Case #" + i + ": " + str);
    }

    public void flush() {
        if (!queue.isEmpty())
            System.out.print(queue);
        queue = "";
    }

    static abstract class Test {
        abstract void onTest(int i, int T);
    }
}