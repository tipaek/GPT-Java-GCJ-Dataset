import java.util.Scanner;

public class Solution2{

    public static void main(String[] args){

        Scanner sc=new Scanner(System.in);
        int cases = Integer.parseInt(sc.nextLine());

        for (int test = 1; test <= cases; test++) {

            String S = sc.nextLine();
            System.out.print("Case #" + test + ": ");

            System.out.println(findNestingDepth(S.trim()));

        }
    }

    static String findNestingDepth(String S1) {

        String result ="";

        int prev = Integer.parseInt(S1.charAt(0)+"");
        for (int i = 0; i < prev; i++) {
            result += "(";
        }

        result += S1.charAt(0);

        int rem = prev;

        for (int i = 1; i < S1.length(); i++) {
            int number = Integer.parseInt(S1.charAt(i)+"");

            if (number == prev) {
                result += number;
            }
            else {
                if (number == 0) {
                    for (int j = 0; j < rem; j++) {
                        result += ")";
                    }
                    result += number;
                    rem = 0;
                } else {
                    if(rem == 0) {
                        for (int j = 0; j < number; j++) {
                            result += "(";
                        }
                        result += number;
                        rem = number;
                    }
                    else if(rem > 0){
                        rem -= number;
                        if(rem > 0){
                            for (int j = 0; j < rem; j++) {
                                result += ")";
                            }
                        }else{
                            for (int j = 0; j < Math.abs(rem); j++) {
                                result += "(";
                            }
                        }
                        result += number;
                        rem = number;

                    }
                }
            }
            prev = number;
        }
        for (int j = 0; j < rem; j++) {
            result += ")";
        }

        return result;
    }
}