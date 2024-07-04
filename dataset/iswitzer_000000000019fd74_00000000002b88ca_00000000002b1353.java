import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int cases = Integer.parseInt(in.nextLine());
        ArrayList<String> answers = new ArrayList<>();
        for(int m=1; m<cases+1; m++) {
            int sum = Integer.parseInt(in.nextLine());
            ArrayList<String> answer = new ArrayList<>();
            if(sum <= 501) {
                sum -= 1;
                answer.add("1 1");
                if(sum > 0) {
                    sum -= 1;
                    answer.add("2 1");
                }
                if(sum >= 2) {
                    answer.add("3 2");
                    sum -= 2;
                }
                int start = 3;
                while(sum > 0) {
                    answer.add(start + " 1");
                    start++; sum -= 1;
                }
            }
            answers.add("Case #" + m + ":");
            for(String s : answer) answers.add(s);
        }
        for(String a : answers) {
            System.out.println(a);
        }
    }
}
