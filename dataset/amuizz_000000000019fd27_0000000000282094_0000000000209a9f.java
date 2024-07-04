import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testcases = Integer.parseInt(in.nextLine());
        for(int nooftestcases = 1;nooftestcases<=testcases;nooftestcases++){
            String no = in.nextLine();
            StringBuilder result = new StringBuilder();
            char[]chars = no.toCharArray();
            int num = 0;
            int brackets =0;
            int first = Character.getNumericValue(chars[0]);
            num = first;
            brackets= first;
            for(int i =0;i<first;i++){
                result.append('(');
                }
            result.append(first);
            for(int i =1;i<chars.length;i++){
                int d = Character.getNumericValue(chars[i]);
                if(d == num){
                    result.append(d);
                }
                else if(d>num){
                    int diff = d-num;
                    for(int j=0;j<diff;++j){
                        result.append('(');
                        brackets++;
                    }
                    result.append(d);
                }
                else{
                    int diff = num-d;
                    for(int j =0;j<diff;j++){
                        result.append(')');
                        brackets--;

                    }
                    result.append(d);
                }
                num = Character.getNumericValue(chars[i]);
            }
            while(brackets--> 0){
                result.append(')');
            }


            System.out.println("Case #"+nooftestcases+": "+result.toString());
        }
    }
}
