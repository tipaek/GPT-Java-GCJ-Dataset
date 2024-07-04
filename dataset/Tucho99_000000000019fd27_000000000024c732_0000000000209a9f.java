import java.util.*;

public class Solution {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        String input= scanner.nextLine();
        int T = Integer.parseInt(input);
        for(int t=0;t<T;t++){
            String S = scanner.nextLine();
            String resul = addParenthesis(S);
            System.out.println("Case #"+ (t+1)+": "+addParenthesis(S));


        }
    }

    private static String addParenthesis(String S){
        StringBuffer parenthesis = new StringBuffer();
         int prev= Integer.parseInt(String.valueOf(S.charAt(0)));
        for(int i=0;i<prev;i++){
            parenthesis.append('(');
        }
        parenthesis.append(prev);

        for(int i=1;i<S.length();i++){
            int current= Integer.parseInt(String.valueOf(S.charAt(i)));
            if(current<prev){
                int dif= prev - current;
                for(int j=0;j<dif;j++){
                    parenthesis.append(')');
                }

            }
            else if(current> prev){
                int dif= current - prev;
                for(int j=0;j<dif;j++){
                    parenthesis.append('(');
                }
            }
            parenthesis.append(current);
            prev= current;

        }
        int end = Integer.parseInt(String.valueOf(S.charAt(S.length()-1)));

        for(int j=0;j<end;j++){
            parenthesis.append(')');
        }
        return parenthesis.toString();


    }
}
