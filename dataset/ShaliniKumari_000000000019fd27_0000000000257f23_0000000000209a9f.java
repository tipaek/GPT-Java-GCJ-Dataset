import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine());
        int testCase = 1;
        while (t > 0) {
            String s = scanner.nextLine();
            String str = "";
            int open = 0;
            for (int j = 0; j < Integer.parseInt(s.charAt(0)+""); j++) {
                str += "(";
                open++;
            }
            str+=s.charAt(0);
            for (int i = 1; i < s.length() ; i++) {
                char ch = s.charAt(i);
                if(s.charAt(i-1)==s.charAt(i)){
                    str+=s.charAt(i);

                }
                else if(s.charAt(i-1)>s.charAt(i)){
                    for (int j = 0; j <s.charAt(i-1)-s.charAt(i) ; j++) {
                        str+=")";
                        open--;
                    }
                    str+=s.charAt(i);
                }else{
                    for (int j = 0; j <s.charAt(i)-s.charAt(i-1) ; j++) {
                        str+="(";
                        open++;
                    }
                    str+=s.charAt(i);
                }


            }
            for (int i = 0; i <open ; i++) {
                str+=")";
            }




            System.out.println("Case #" + testCase
                    + ": " + str);
            testCase++;
            t--;


        }
    }
}