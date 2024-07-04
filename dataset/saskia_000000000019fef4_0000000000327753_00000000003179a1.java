import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt();
        double noLines = Math.pow(10, 4);

        for (int i = 0; i < testCases; i++) {
            HashMap<Character, boolean[]> letterNoComb = new HashMap<>();
            in.nextInt();
            //double boundary = Math.pow(10, in.nextInt()) - 1;
            Character[] letters = new Character[10];
            int lettersCurr = -1;

            for (int j = 0; j < noLines; j++) {
                int inpNo = in.nextInt();
                String retVal = in.next();

                String noAsStr = String.valueOf(inpNo);
                int length = noAsStr.length();

                if (retVal.length() == 1) {
                    boolean[] comb = null;
                    if (letterNoComb.containsKey(retVal.charAt(0))) {
                        comb = letterNoComb.get(retVal.charAt(0));
                    } else {
                        comb = new boolean[10];
                        Arrays.fill(comb, true);
                        lettersCurr++;
                        letters[lettersCurr] = retVal.charAt(0);
                    }
                    comb[0] = false;
                    letterNoComb.put(retVal.charAt(0), comb);
                    //System.out.println(retVal.charAt(0));
                }

                if (length == 1 || length == retVal.length()) {
                    boolean[] comb = null;
                    if (letterNoComb.containsKey(retVal.charAt(0))) {
                        comb = letterNoComb.get(retVal.charAt(0));
                    } else {
                        comb = new boolean[10];
                        Arrays.fill(comb, true);
                        lettersCurr++;
                        letters[lettersCurr] = retVal.charAt(0);
                    }
                    int count = 9;
                    char b = noAsStr.charAt((0));
                    while (count > Integer.parseInt(String.valueOf(b)) && count >= 0) {
                        comb[count] = false;
                        count--;
                    }
                    letterNoComb.put(retVal.charAt(0), comb);
                    //System.out.println(retVal.charAt(0));
                }

                if (length > 1) {
                    for (int h = 1; h < retVal.length(); h++) {
                        Character x = retVal.charAt(h);
                        if (!letterNoComb.containsKey(x)) {
                            boolean[] comb = new boolean[10];
                            Arrays.fill(comb, true);
                            lettersCurr++;
                            letters[lettersCurr] = retVal.charAt(h);
                            letterNoComb.put(retVal.charAt(h), comb);
                            //System.out.println(retVal.charAt(h));
                        }
                    }
                }

            }

            char[] out = new char[10];
            for (Character x : letters) {
                boolean[] comb = null;
                if (letterNoComb.containsKey(x)) {
                    comb = letterNoComb.get(x);
                    boolean ind = false;
                    int counter = 9;
                    int index = 9;
                    while (!ind) {
                        ind = comb[counter];
                        index = counter;
                        counter--;
                    }


                    if (index == 9 && comb[0] == true) {
                        index = 0;
                    }

                    out[index] = x;
                }
            }

            String outputStr = new String(out);

            int caseNo = i + 1;
            System.out.println("Case #" + caseNo + ": " + outputStr);

        }

    }


}
