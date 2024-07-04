
import java.util.Scanner;

public class Solution {
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t <= T; t++){
            StringBuilder result = new StringBuilder();
            String str = sc.next();
            int n = str.length();
            int [] digits = new int [n];
            for(int i = 0; i < n; i++) digits[i] = str.charAt(i) - '0';

            int [] opening = new int [n]; // opening parentheses before str[i]
            int [] closing = new int [n]; // closing parentheses after str[i]

            for(;;){

                //finding non 0 min and its position
                int min = 0, i;
                for(i = 0; i < n; i++){
                    if(digits[i] != 0){
                        min = digits[i];
                        break;
                    }
                }
                for(int j = i + 1; j < n; j++){
                    if(digits[j] < min && digits[j] > 0){
                        min = digits[j];
                        i = j;
                    }
                }

                if(min == 0) break;

                // finding start for opening parentheses
                int j = i - 1;
                for(; j >= 0 && digits[j] >= min; j--) ;
                j++;
                opening[j] += min;

                for(int k = j; k < i; k++) digits[k] -= min;

                // finding end for closing parentheses
                j = i + 1;
                for(; j < n && digits[j] >= min; j++) ;
                j--;
                closing[j] += min;

                for(int k = i; k <= j; k++) digits[k] -= min;
            }

            /*
            for(int i = 0; i < n; i++){
                int a = digits[i];
                opening[i] += a;

                int j = i + 1;
                for(; j < n && digits[j] >= a; j++) ;

                j--;
                closing[j] += a;

                for(int k = i; k <= j; k++) digits[k] -= a;
            }*/

            for(int i = 0; i < n; i++){
                for(int j = 0; j < opening[i]; j++) result.append('(');
                result.append(str.charAt(i));
                for(int j = 0; j < closing[i]; j++) result.append(')');
            }

            System.out.println(String.format("Case #%d: %s", t, result));
        }
    }
}
