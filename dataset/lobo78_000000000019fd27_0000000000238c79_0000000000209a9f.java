import java.util.Scanner;

public class Solution{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int x = Integer.parseInt(sc.nextLine());
        for(int i = 1; i<=x; i++){
            String str = sc.nextLine();
            StringBuilder answer = new StringBuilder();
            for(int j = 0; j< str.length(); j++){
                if(str.charAt(j) == '0') {
                    while (j < str.length() && str.charAt(j) == '0') {
                        answer.append('0');
                        j++;
                    }
                    j--;
                }else{
                    StringBuilder stringBuilder = new StringBuilder();
                    while (j < str.length() && str.charAt(j) != '0') {
                        stringBuilder.append(str.charAt(j));
                        j++;
                    }
                    j--;
                    String left = addLeftParen(stringBuilder.toString());
                    answer.append(addRightParen(left));
                }
            }

            System.out.println("Case #"+i+": "+answer.toString());
        }
    }

    public static String addLeftParen(String str){
        int length = str.length();
        int totalParen = 0;
        StringBuilder string = new StringBuilder();
        int left = -1;
        for(int i = 0; i<length; i++){
            char c = str.charAt(i);
            int digit = Integer.parseInt(""+c);
            if(digit != 0 && digit > left){
                if(totalParen >= digit){
                    string.append("(").append(digit);
                    totalParen++;
                }else{
                    int k = digit - totalParen;
                    for(int j = 0; j<k; j++){
                        string.append("(");
                        totalParen++;
                    }
                    string.append(digit);
                }
            }
            else{
                string.append(digit);
            }
            left = digit;
        }
        return string.toString();
    }

    public static String addRightParen(String str){
        int length = str.length();
        int totalParen = 0;
        StringBuilder string = new StringBuilder(str);
        int right = -1;
        for(int i = length-1; i>=0; i--){
            char c = str.charAt(i);
            if(c == '('){
                totalParen -= 1;
            }else {
                int digit = Integer.parseInt("" + c);
                if (digit != 0 && digit > right) {
                    if (totalParen >= digit) {
                        string.insert(i+1, ')');
                        totalParen++;
                    } else {
                        int k = digit - totalParen;
                        for (int j = 0; j < k; j++) {
                            string.insert(i+1, ')');
                            totalParen++;
                        }
                    }
                }
                right = digit;
            }
        }

        return string.toString();
    }
}
