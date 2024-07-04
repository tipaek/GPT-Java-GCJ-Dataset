import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int line = scanner.nextInt();

        for(int i= 0; i<line; i++){
            String s = scanner.next();
            String result = "";

            for(int j=0; j< s.length();j++){
                char t = s.charAt(j);
                if(t == '0'){
                    result = result + t;
                } else {
                    int n = Character.getNumericValue(t);
                    if(j == 0){
                        result = result + t;
                        for (int k=0; k< n; k++){
                            result = "(" + result + ")";
                        }
                    } else {
                        if(result.endsWith(")")){
                            int calc = calculate(result);
                            if(calc >= n){
                                result = result.substring(0,result.length()-n) + n + result.substring(result.length()-n);
                            } else {
                                String add = "" + t;
                                for (int k=0; k< n-calc; k++){
                                    add = "(" + add + ")";
                                }
                                result = result.substring(0,result.length()-calc) + add + result.substring(result.length()-calc);
                            }
                        } else {
                            String add = "" + t;
                            for (int k=0; k< n; k++){
                                add = "(" + add + ")";
                            }
                            result = result + add;
                        }
                    }
                }
            }

            System.out.println("Case #" + (i+1) + ": "  + result);
        }
    }

    public static int calculate(String r){
        int result = 0;
        while (r.endsWith(")")){
            result++;
            r = r.substring(0, r.length()-1);
        }
        return result;
    }
}
