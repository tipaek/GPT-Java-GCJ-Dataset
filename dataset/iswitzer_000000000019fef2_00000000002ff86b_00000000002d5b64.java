import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(in.nextLine());

        ArrayList<String> answers = new ArrayList<>();
        for(int q=1; q<=cases; q++) {
            String data = in.nextLine();
            int R = Integer.parseInt(data.split(" ")[0]);
            int S = Integer.parseInt(data.split(" ")[1]);

            answers.add("Case #" + q + ": " + (R-1)*(S-1));
            int back = 1;
            for(int r=0; r<R-1; r++) {
                for(int s=0; s<S-1; s++) {
                    int a = R-r;
                    int b = (S-1)*(R-r)-s-1;
                    answers.add(a + " " + b);
                }
            }

        }

        for(String s : answers) System.out.println(s);
    }
}
