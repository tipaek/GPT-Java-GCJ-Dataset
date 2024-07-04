import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = in.nextInt();
        in.nextLine();

        for (int test = 0; test < tests; test++){
            System.out.print(String.format("Case #%d: ", test+1));

            String s = in.nextLine();
            int pars = 0;
            int prevNum = s.charAt(0)-48;
            for (int i = 0; i < prevNum; i++){
                System.out.print('(');
                pars++;
            }
            System.out.print(prevNum);

            for (int i = 1; i < s.length(); i++){
                int num = s.charAt(i)-48;

                if (num == prevNum){
                    System.out.print(num);
                } else if (num < prevNum){
                    for (int j = num; j < prevNum; j++){
                        System.out.print(')');
                        pars--;
                    }
                    System.out.print(num);
                } else { //num > prevNum
                    for (int j = prevNum; j < num; j++){
                        System.out.print('(');
                        pars++;
                    }
                    System.out.print(num);
                }

                prevNum = num;
            }

            for (int i = 0; i < pars; i++){
                System.out.print(')');
            }
            System.out.println();
        }
    }
}