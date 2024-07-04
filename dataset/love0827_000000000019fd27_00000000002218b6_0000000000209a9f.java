import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int testcases = 1; testcases <= T; testcases++) {
            String s = scanner.next();
            String[] list = s.split("");
            ArrayList<String> answer = new ArrayList<>();
            int f = 0;
            for(int i = 0; i < list.length; i++){
                int num = Integer.parseInt(list[i]);
                int front = 0;
                int back = 0;
                if(num>f)front+=num-f;
                if(num < f)front+=f-num;
                f+=front;
                f-=back;
                for(int c = 0; c < front; c++)answer.add("(");
                for(int c = 0; c < back; c++)answer.add(")");
                answer.add(String.valueOf(num));
            }
            for(int i = 0; i < f; i++){
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