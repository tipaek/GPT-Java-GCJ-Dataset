import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

//     owner: sedatcamli
//     04.04.2020
public class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        s.start();
    }
    public void start(){
        Scanner scanIn = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int numberOfTestCases = scanIn.nextInt();
        for (int i = 1; i <= numberOfTestCases; i++) {
            String s = scanIn.next();
            StringBuilder sb = new StringBuilder();
            for(int j = 0 ;j<s.length();j++){
                if(s.charAt(j)=='0'){
                    sb.append("0");
                } else{

                    String strDigit =  s.substring(j,j+1);
                    int digit = Integer.valueOf(strDigit);
                    for(int k = 0; k<digit;k++){
                        sb.append("(");
                    }
                    sb.append(digit);
                    for(int k = 0; k<digit;k++){
                        sb.append(")");
                    }
                }
            }
            for(int j = 0 ; j<sb.length()-1;j++){
                if(sb.charAt(j)==')' && sb.charAt(j+1)=='('){
                    sb.replace(j,j+2,"");
                    j=j-2;
                }
            }

            System.out.println("Case #"+i+": "+ sb.toString());
        }
    }

}
