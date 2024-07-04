
import java.util.*;
import java.io.*;

public class Solution {

    static int N;
    static Scanner in;
    public static void main(String[] args) {
        main(System.in);
    }

    public static void main(InputStream is) {
        in = new Scanner(new BufferedReader(new InputStreamReader(is)));
        int t = in.nextInt();
        int b = in.nextInt();
        for (int run = 1; run <= t; ++run) {
            if(b==10) {
                singleRun10();
            } else {
                singleRun(b);
            }
        }
    }
    private static void singleRun10() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
            int val = in.nextInt();
            sb.append(val);
        }
        System.out.println(sb.toString());
    }
    
    private static void singleRun(int b) {
        //scanning phase
        Integer sameBitIndex = null;
        int sameBitNormalValue = 0;
        Integer oppositeBitIndex = null;
        int oppositeBitValue = 0;
        int usedQuestions = 0;
        for(int i=1;i<=b/2;i=i++) {
            System.out.println(i);
            int valA = in.nextInt();
            System.out.println(b+1-i);
            int valB = in.nextInt();
            if (valA==valB && sameBitIndex==null) {
                sameBitIndex=i;
                sameBitNormalValue=valA;
            } else if (oppositeBitIndex==null) {
                oppositeBitIndex=i;
                oppositeBitValue=valA;
            }
            usedQuestions+=2;
            if(sameBitIndex!= null && oppositeBitIndex!= null) {
                break;
            }
        }
        if(sameBitIndex==null) {
            sameBitIndex=1;
        }
        if(oppositeBitIndex==null) {
            oppositeBitIndex=1;
        }
        while (usedQuestions%10!=0) {
            System.out.println(1);
            int valA = in.nextInt();
            //System.err.println("Ignroed garbage "+valA);
            System.out.println(1);
            int valB = in.nextInt();
            //System.err.println("Ignroed garbage "+valB);
            usedQuestions+=2;
        }
        //reading
        int[] result = new int[b+1];
        int toRead = 1;
        while(true) {
            System.out.println(sameBitIndex);
            int val = in.nextInt();
            boolean negated = (val!=sameBitNormalValue);
            System.out.println(oppositeBitIndex);
            val = in.nextInt();
            boolean reversed = (val != oppositeBitValue && !negated) || (val == oppositeBitValue && negated);
            usedQuestions+=2;
            //System.err.println("detected negated = " + negated + " reversed=" + reversed);
            for (int j = 0; j < 8 && toRead <= b; j++) {
                usedQuestions++;
                if (!reversed) {
                    System.out.println(toRead);
                    val = in.nextInt();
                    System.err.println("read "+val+ " for "+toRead);

                    if(negated) {
                        result[toRead] = 1-val;
                    } else {
                        result[toRead] = val;
                    }
                } else {
                    System.out.println(b - toRead + 1);
                    val = in.nextInt();
                    if (negated) {
                        result[toRead] = 1 - val;
                    } else {
                        result[toRead] = val;
                    }
                }
                toRead++;
            }
            //System.err.println("b="+b+" toREad="+toRead);
            if (toRead > b||usedQuestions>=150) {
                StringBuilder sb = new StringBuilder();
                for (int j = 1; j <= b; j++) {
                    if(reversed) {
                        val = result[b-j+1];
                    } else {
                        val = result[j];
                    }
                    if (negated) {
                        val = 1 - val;
                    }
                    sb.append(val);
                }
                System.out.println(sb.toString());
                in.next();
                break;
            }
        }

    }


}
