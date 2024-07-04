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

    public void m(int s,int e,Scanner in){
        boolean itselfOrRevComp = false;
        boolean comOrRev=false;
        boolean itselfOrRev = false;
        boolean copOrComRev=false;
        boolean itself = false;
        boolean comp = false;
        int notEqual = -1;
        int equal = -1;
        for (int i = 1; i <= 2; i++) {
            String next = "";
            if (i % 10 == 1) {
                notEqual = find( s,e, false);
                equal = find(s,e, true);
                if (notEqual >= 0) {
                    System.out.println(notEqual + 1);
                    next = in.next();
                    itselfOrRevComp = (next.equals(chars[notEqual] + ""));
                    comOrRev= !itselfOrRevComp;
                } else {
                    System.out.println(equal + 1);
                    next = in.next();
                    itselfOrRev = (next.equals(chars[equal] + ""));
                    copOrComRev = !itselfOrRev;
                }
            } else if (i % 10 == 2) {
                if (itselfOrRevComp) {
                    if (equal >= 0) {
                        System.out.println(equal + 1);
                        next = in.next();
                        itself = (next.equals(chars[equal] + ""));
                    } else {
                        itself = true;
                    }
                }else if(comOrRev){
                    if(equal>=0){
                        System.out.println(equal + 1);
                        next = in.next();
                        comp = !(next.equals(chars[equal] + ""));
                    }else{
                        comp=true;
                    }

                }else if (itselfOrRev) {
                    if (notEqual >= 0) {
                        System.out.println(notEqual + 1);
                        next = in.next();
                        itself = (next.equals(chars[notEqual] + ""));
                    } else {
                        itself = true;
                    }
                } else {//compOrCompRev
                    if (notEqual >= 0) {
                        System.out.println(notEqual + 1);
                        next = in.next();
                        comp = !(next.equals(chars[notEqual] + ""));
                    } else {
                        comp = true;
                    }
                }
                if (!itself) {
                    if (comp) {
                       comp(s,e);
                    } else if (itselfOrRevComp) {
                        rev(s,e);
                        comp(s,e);
                    } else if (itselfOrRev || comOrRev) {
                        rev(s,e);
                    } else {
                        rev(s,e);
                        comp(s,e);
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
            }

        }

    }

    static char[] chars;
    public String solve(final Scanner in) {
        String res = "";
        chars = new char[B];
        // B/2-5 o B/2+4
        for (int i = 0; i < 10; i++) {
            chars[B/2-5+i]=get(B/2-5+i,in);
        }
        if(B==10){
            System.out.println(new String(chars));
        }else {
            m(B/2-5,B/2+4,in);
            int start = B / 2 - 5;
            int end = B / 2 + 4;
            int i = 1;
            while (start > 0) {
                start--;
                end++;
                chars[start] = get(start, in);
                i++;
                chars[end] = get(end, in);
                i++;
                if (i == 8) {
                    m(start, end, in);
                }
            }
            System.out.println(new String(chars));
        }
        in.next();
        return "";
    }

    private char get(int i,Scanner in){
        System.out.println(i + 1);
        return in.next().charAt(0);
    }

    private void rev(int s, int e) {
        for (int i = 0; i < (e-s+1)/2; i++) {
            char t= chars[i+s];
            chars[i+s] = chars[e-i];
            chars[e-i] =t;
        }
    }

    private void comp(int s, int e) {
        for (int i = 0; i < e-s+1; i++) {
            chars[i+s] = (chars[i+s]=='1')?'0':'1';
        }
    }

    private int find(int s,int e,boolean equal) {
        for (int i = 0; i < (e-s+1)/2; i++) {
            if (equal == (chars[i+s] == chars[e-i])) {
                return i+s;
            }
        }
        return -1;
    }
}
/******************************************************************************
 *  Put all final helper classes here:
 ******************************************************************************/
