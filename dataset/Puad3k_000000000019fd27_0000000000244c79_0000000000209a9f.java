import java.util.Scanner;

public class Solution {

    public static void main (String[] args){
        Scanner input = new Scanner(System.in);
        int total = Integer.parseInt(input.nextLine());

        for (int i = 0; i<total; i++ ){
            String s = input.nextLine();

            System.out.printf("Case #%d: %s\n",i+1,addBracket(s));
        }
    }

    private static String addBracket(String s){
        String temp = s;
        int bracketOpened = 0;
        StringBuilder builder = new StringBuilder();

        char[] charac = temp.toCharArray();
        for (char c : charac){
            Integer i = new Integer(""+c);

            if(i.compareTo(bracketOpened) ==1){
                int opened=bracketOpened;
                for(int j=0; j<i-opened; j++){
                    builder.append("(");
                    bracketOpened++;
                }
                builder.append(i);
            } else if(i.compareTo(bracketOpened) == -1){
                int opened = bracketOpened;
                for (int j=0; j<opened-i; j++){
                    builder.append(")");
                    bracketOpened--;
                }
                builder.append(i);
            } else {
                builder.append(i);
            }


        }

        for (int j=0; j<bracketOpened; j++){
            builder.append(")");
        }

        return builder.toString();
    }
}
