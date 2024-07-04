import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Solution {
    private final static String IMPOSSIBLE = "IMPOSSIBLE";
    private static boolean READ_FROM_FILE = false;
    private static boolean WRITE_TO_FILE = false;
    private static PrintWriter writer = null;

    public final static void main(String[] args) throws IOException {
        Scanner in;
        File inFile = null;
        if (READ_FROM_FILE) {
            inFile = new File(args[0]);
            in = new Scanner(new BufferedReader(new FileReader(args[0])));
        } else {
            in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        }

        if (WRITE_TO_FILE) {
            String fileOut;
            if (inFile == null) {
                fileOut = "out-" + new SimpleDateFormat("YYYYMMdd-HHmmss").format(new Date(System.currentTimeMillis())) + ".out";
            } else {
                fileOut = inFile.getParent() + "/" + inFile.getName().replace(".in", new SimpleDateFormat("YYYYMMdd-HHmmss").format(new Date(System.currentTimeMillis())) + ".out");
            }
            writer = new PrintWriter(new BufferedWriter(new FileWriter(fileOut)));
        }

        int t = in.nextInt();
        B = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            final Solution solution = new Solution();
            solution.solve(in);
        }

        if (writer != null) {
            writer.flush();
            writer.close();
        }

    }

    public final static void print(int caseNumber, String result) {
        final String toWrite = "Case #" + caseNumber + ": " + result;
        if (writer != null) {
            writer.println(toWrite);
        } else {
            System.out.println(toWrite);
        }
    }


    /******************************************************************************
     *  Normally you should start coding from here:
     ******************************************************************************/
    public Solution() {
    }

    static int B;

    public String solve(final Scanner in) {
        String res = "";
        String s = in.next();
        char[] ch = s.toCharArray();
        boolean itselfOrRevComp = false;
        boolean comOrRev=false;
        boolean itselfOrRev = false;
        boolean copOrComRev=false;
        boolean itself = false;
        boolean comp = false;
        int notEqual = -1;
        int equal = -1;
        for (int i = 1; i <= 150; i++) {
            String next = "";
            if (i % 10 == 1) {
                notEqual = find(ch, false);
                equal = find(ch, true);
                if (notEqual >= 0) {
                    System.out.println(notEqual + 1);
                    next = in.next();
                    itselfOrRevComp = (next.equals(ch[notEqual] + ""));
                    comOrRev= !itselfOrRevComp;
                } else {
                    System.out.println(equal + 1);
                    next = in.next();
                    itselfOrRev = (next.equals(ch[equal] + ""));
                    copOrComRev = !itselfOrRev;
                }
            } else if (i % 10 == 2) {
                if (itselfOrRevComp) {
                    if (equal >= 0) {
                        System.out.println(equal + 1);
                        next = in.next();
                        itself = (next.equals(ch[equal] + ""));
                    } else {
                        itself = true;
                    }
                }else if(comOrRev){
                    if(equal>=0){
                        System.out.println(equal + 1);
                        next = in.next();
                        comp = !(next.equals(ch[equal] + ""));
                    }else{
                        comp=true;
                    }

                }else if (itselfOrRev) {
                    if (notEqual >= 0) {
                        System.out.println(notEqual + 1);
                        next = in.next();
                        itself = (next.equals(ch[notEqual] + ""));
                    } else {
                        itself = true;
                    }
                } else {//compOrCompRev
                    if (notEqual >= 0) {
                        System.out.println(notEqual + 1);
                        next = in.next();
                        comp = !(next.equals(ch[notEqual] + ""));
                    } else {
                        comp = true;
                    }
                }
                if (!itself) {
                    if (comp) {
                        ch = comp(ch);
                    } else if (itselfOrRevComp) {
                        ch = comp(rev(ch));
                    } else if (itselfOrRev || comOrRev) {
                        ch = rev(ch);
                    } else {
                        ch = comp(rev(ch));
                    }
                }
                itselfOrRevComp = false;
                itselfOrRev = false;
                itself = false;
                comOrRev=false;
                copOrComRev =false;
                comp = false;
                notEqual = -1;
                equal = -1;
            } else {//pass
                System.out.println("1");
                next = in.next();
            }

        }
        System.out.println(new String(ch));
        in.next();
        return res;
    }

    private char[] rev(char[] input) {
        for (int i = 0; i < input.length/2; i++) {
            char t= input[i];
            input[i] = input[input.length-1-i];
            input[input.length-1-i] =t;
        }
        return input;
    }

    private char[] comp(char[] input) {
        for (int i = 0; i < input.length; i++) {
            input[i] = (input[i]=='1')?'0':'1';
        }
        return input;
    }

    private int find(char[] ch, boolean equal) {
        for (int i = 0; i < ch.length/2; i++) {
            if (equal == (ch[i] == ch[ch.length - 1 - i])) {
                return i;
            }
        }
        return -1;
    }
}
/******************************************************************************
 *  Put all final helper classes here:
 ******************************************************************************/
