
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ntanasis Periklis <pntanasis@gmail.com>
 */
public class Solution {

    static class Case {

        public String S;
    }

    public static void main(String[] args) {
        List<Case> cases = readCases();
        int i = 1;
        for (Case c : cases) {
            System.out.print("Case #"+(i++)+" ");
            printNestedString(c);
            System.out.println();
        }
    }
    
    static List<Case> readCases() {
        List<Case> cases = new ArrayList<>();
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            Case c = new Case();
            c.S = in.next();
            cases.add(c);
        }
        return cases;
    }
    
    static void printNestedString(Case c) {
        int previousNum = 0;
        for(int i=0; i<c.S.length(); i++) {
            int currentNum = Character.getNumericValue(c.S.charAt(i));
            int nextNum = i+1 == c.S.length() ? Integer.MAX_VALUE : Character.getNumericValue(c.S.charAt(i+1));
            if (previousNum < currentNum) {
                if(currentNum - previousNum == 1) {
                    printOpenParentheses(1);
                } else {
                    printOpenParentheses(currentNum);
                }
            }
            System.out.print(currentNum);
            if (currentNum > nextNum) {
                printCloseParentheses(currentNum - nextNum);
            } else if (currentNum+1 < nextNum) {
                printCloseParentheses(currentNum);
            }
            previousNum = currentNum;
        }
    }
    
    static void printOpenParentheses(int n) {
        for(int i=0; i<n; i++) {
            System.out.print("(");
        }
    }
    
    static void printCloseParentheses(int n) {
        for(int i=0; i<n; i++) {
            System.out.print(")");
        }
    }
    
}
