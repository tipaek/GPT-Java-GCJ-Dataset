import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int testcases = 1; testcases <= T; testcases++) {
            String s = scanner.next();
            String[] arr = s.split("");
            ArrayList<String> answer = new ArrayList<>();
            int open = 0;
            for(int i = 0; i < arr.length; i++){
                int num = Integer.parseInt(arr[i]);
                int opening = 0;
                int closing = 0;
                if(num>open)opening+=num-open;
                if(num < open)closing+=open-num;
                open+=opening;
                open-=closing;
                for(int c = 0; c < opening; c++)answer.add("(");
                for(int c = 0; c < closing; c++)answer.add(")");
                answer.add(String.valueOf(num));
            }
            for(int i = 0; i < open; i++){
                answer.add(")");
            }
            System.out.print("Case #"+testcases+": ");
            for(int i = 0; i < answer.size(); i++){
                System.out.print(answer.get(i));
            }
            System.out.println();
        }
    }
}
