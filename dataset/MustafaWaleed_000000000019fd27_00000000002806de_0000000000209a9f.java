import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) {
        FastReader reader = new FastReader();
        StringBuilder output = new StringBuilder();
        int t = reader.nextInt();
        int caseNumber = 1;
        while (t-- > 0) {
            NestingDepth vestigium = new NestingDepth(reader, output, caseNumber);
            vestigium.solve();
            caseNumber++;
        }
        System.out.print(output);
    }
}

class NestingDepth {
    FastReader reader;
    StringBuilder output;
    String string[];
    StringBuilder newString;
    int caseNumber;
    int[] numbers;


    public NestingDepth(FastReader reader, StringBuilder output, int caseNumber) {
        this.reader = reader;
        this.output = output;
        this.caseNumber = caseNumber;
        string = reader.nextLine().split("");
        this.numbers = new int[string.length];
        this.newString = new StringBuilder();
    }

    public void solve() {
        this.readNumbers();
        this.getNewString();
        output.append("Case #")
                .append(caseNumber).append(": ")
                .append(newString)
                .append("\n");
    }

    void readNumbers() {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(string[i]);
        }
    }

    void getNewString() {
        putAllParentheses();
        removeDuplicateParentheses();
    }

    void putAllParentheses(){
        for (int i = 0; i < numbers.length; i++) {
            putOpenParentheses(numbers[i]);
            newString.append(numbers[i]);
            putCloseParentheses(numbers[i]);
        }
    }

    void removeDuplicateParentheses(){
        for (int i = 1; i < newString.length(); i++) {
           if(parenthesesIsDuplicate( i-1,i)){
               newString.deleteCharAt(i);
               newString.deleteCharAt(i - 1);
               i--;
           }
        }
    }

    boolean parenthesesIsDuplicate(int idx1,int idx2){
        return newString.charAt(idx1) == ')' && newString.charAt(idx2) == '(';
    }

    void putOpenParentheses(int number) {
        while(number-- > 0){
            this.newString.append("(");
        }
    }

    void putCloseParentheses(int number) {
        while(number-- > 0){
            this.newString.append(")");
        }
    }
}

class FastReader {

    BufferedReader br;
    StringTokenizer st;

    public FastReader() {
        br = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }

    long nextLong() {
        return Long.parseLong(next());
    }

    double nextDouble() {
        return Double.parseDouble(next());
    }

    String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
}
