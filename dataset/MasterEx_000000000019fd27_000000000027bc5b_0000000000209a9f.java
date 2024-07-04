
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
            System.out.print("Case #"+(i++)+": ");
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
        int openedParen = 0;
        for(int i=0; i<c.S.length(); i++) {
            int currentNum = Character.getNumericValue(c.S.charAt(i));
            int nextNum = i+1 == c.S.length() ? Integer.MAX_VALUE : Character.getNumericValue(c.S.charAt(i+1));
            if (openedParen == 0) {
                openedParen = currentNum;
                printOpenParentheses(currentNum);
            } else if(openedParen - currentNum < 0) {
                printOpenParentheses(currentNum - openedParen);
                openedParen += (currentNum - openedParen);
            } else if(openedParen - currentNum > 0) {
                printOpenParentheses(openedParen - currentNum);
                openedParen += (openedParen - currentNum);
            }
            System.out.print(currentNum);
            if (currentNum > nextNum) {
                openedParen -= (currentNum - nextNum);
                printCloseParentheses(currentNum - openedParen);
            }
            previousNum = currentNum;
        }
        printCloseParentheses(openedParen);
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
