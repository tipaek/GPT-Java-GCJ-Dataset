import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.TreeSet;

public class Solution {
    public static void main(String[]args) throws IOException{
        Problem problem = new Problem();
        problem.print();
    }
}
class Problem {
    int t;
    int n;
    int[][] res;
    int[][] data;
    TreeSet<Integer> check;
    Problem() throws IOException{
        QuickInput in = new QuickInput();
        t = in.nextInt();
        res = new int[t+1][3];
        check = new TreeSet<>();
        for(int i = 1; i < t+1; i++) {
            n = in.nextInt();
            data = new int[n+1][n+1];
            for(int j = 1; j < n+1; j++) {
                for(int k = 1; k < n+1; k++) {
                    data[j][k] = in.nextInt();
                    if(k == j) {
                        res[i][0] += data[j][k];
                    }
                    check.add(data[j][k]);
                }
                if(check.size() < n) {
                    res[i][1]++ ;
                }
                check.clear();
            }
            for(int j = 1; j < n+1; j++) {
                for(int ii = 1; ii < n+1; ii++) {
                    check.add(data[ii][j]);
                }
                if(check.size() < n) {
                    res[i][2]++;
                }
                check.clear();
            }
        }
    }
    void print() throws IOException{
        PrintWriter out = new PrintWriter(System.out);
        for(int i = 1; i < t+1; i++) {
            out.println("Case #"+ i + ":" + " " + res[i][0] + " " + res[i][1] + " " + res[i][2]);
        }
        out.flush();
        out.close();
    }
}
class QuickInput {
    StreamTokenizer stk;
    QuickInput() throws IOException {
        stk = new StreamTokenizer(new BufferedReader(new InputStreamReader(System.in)));
    }
    int nextInt() throws IOException {
        stk.nextToken();
        return (int)stk.nval;
    }
    double nextDouble() throws IOException {
        stk.nextToken();
        return stk.nval;
    }
    String next() throws IOException {
        stk.nextToken();
        return stk.sval;
    }
}