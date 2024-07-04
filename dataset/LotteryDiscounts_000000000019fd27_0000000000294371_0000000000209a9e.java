import java.io.*;
import java.util.Scanner;

public class Solution {

    static int[] bits = null;
    static boolean debug = true;
    static FileOutputStream fileStream = null;
    static int queryCount = 0;

    public static void query(String s) {
        if (debug) {
            if (s.length() == bits.length) {
                System.out.println("Guessing: " + s);
                for(int i = 0; i < bits.length; i++) {
                    if (s.charAt(i) - '0' != bits[i]) {
                        try {
                            fileStream.write("N\n".getBytes());
                            fileStream.flush();
                            return;
                        } catch(Exception e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
                try {
                    fileStream.write("Y\n".getBytes());
                    fileStream.flush();
                } catch(Exception e) {
                    throw new RuntimeException(e);
                }
            } else {
                if (queryCount % 10 == 0) {
                    int mode = (queryCount/10 + 3) % 4;
                    transform(mode);
                }
                int index = Integer.parseInt(s);
                try {
                    fileStream.write((String.valueOf(bits[index-1]) + "\n").getBytes());
                    fileStream.flush();
                } catch(Exception e) {
                    throw new RuntimeException(e);
                }
                queryCount++;
            }

        } else {
            System.out.println(s);
            System.out.flush();
        }
    }

    private static void transform(int mode) {
        boolean reverse = (mode & 0x2) == 0x2;
        boolean complement = (mode & 0x1) == 0x1;
        if (reverse) {
            for(int i = 0; i < bits.length/2; i++) {
                int tmp = bits[i];
                bits[i] = bits[bits.length - i - 1];
                bits[bits.length - i - 1] = tmp;
            }
        }
        if (complement) {
            for(int i = 0; i < bits.length; i++) {
                bits[i] = (bits[i] == 1) ? 0 : 1;
            }
        }
        return;
    }

    public static void main(String[] args) {


        InputStream inputStream = System.in;

        if (debug) {
            try {
                File f = new File("out.txt.1");
                f.delete();
                fileStream = new FileOutputStream(f);
                inputStream = new FileInputStream(f);
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
            bits = new int[]{0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1};
//            bits = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
            queryCount = 0;
            try {
                fileStream.write(("1 " + bits.length + "\n").getBytes());
                fileStream.flush();
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        }

        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(inputStream)));

        int t = in.nextInt();
        int b = in.nextInt();
        for (int c = 1; c <= t; ++c) {

            int set[] = new int[b];
            int firstDiff = -1;
            int firstSame = -1;
            int queryCount = 0;
            for (int i = 0; i < b/2; i++) {
                queryCount = updateForTransform(in, b, set, firstDiff, firstSame, queryCount);
                query(String.valueOf(i + 1));
                queryCount++;
                int left = in.nextInt();
                set[i] = left;

                if (queryCount % 10 == 0) {
                    // don't split because of the risk of reversing a junk right value
                    i--;
                    continue;
                }
                query(String.valueOf(b - i));
                queryCount++;
                int right = in.nextInt();
                set[b-i-1] = right;
                if (left != right && firstDiff == -1) {
                    firstDiff = i;
                } else if (left == right && firstSame == -1) {
                    firstSame = i;
                }
            }
            String guess = "";
            for(int j = 0; j < b; j++) {
                guess += set[j];
            }
            query(guess);
            String answer = in.next();
            if (answer.equals("N")) {
                if (debug) {
                    System.out.print("Failed: was ");
                    for(int j = 0; j < b; j++) {
                        System.out.print(bits[j]);
                    }
                    System.out.println();
                }
                System.exit(0);
            } else if (answer.equals("Y")) {
                if (debug) {
                    System.out.println("Success");
                }
//                System.exit(0);
            }
        }
    }

    private static int updateForTransform(Scanner in, int b, int[] set, int firstDiff, int firstSame, int queryCount) {
        if (queryCount % 10 == 0) {
            boolean diffChanged = false;
            boolean sameChanged = false;
            if (firstDiff != -1) {
                query(String.valueOf(firstDiff + 1));
                queryCount++;
                int left = in.nextInt();

                if (left != set[firstDiff]) {
                    diffChanged = true;
                }
            }
            if (firstSame != -1) {
                query(String.valueOf(firstSame + 1));
                queryCount++;
                int left = in.nextInt();

                if (left != set[firstSame]) {
                    sameChanged = true;
                }
            }
            boolean complement = sameChanged;
            boolean reverse = (sameChanged && !diffChanged) || (!sameChanged && diffChanged);

            if (complement) {
                for(int j = 0; j < b; j++) {
                    set[j] = (set[j] == 1) ? 0 : 1;
                }
            }
            if (reverse) {
                for(int j = 0; j < b/2; j++) {
                    int tmp = set[j];
                    set[j] = set[b - j - 1];
                    set[b - j - 1] = tmp;
                }
            }
        }
        return queryCount;
    }
}