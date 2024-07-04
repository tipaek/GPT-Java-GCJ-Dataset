import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static int openPar = 0;
    static ArrayList<String> strings;

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        in.nextLine();

        for(int i=0; i<T; i++){
            StringBuffer y = new StringBuffer();
            String str = in.nextLine();

            strings = divideString(str);

            openPar = 0;

            for (int j = 0; j < strings.size(); j++) {
                String string = strings.get(j);
                char c = string.charAt(0);
                addParenthesis(y, string, Character.getNumericValue(c),j);
            }

            System.out.println("Case #" + (i+1) + ": " + y);
        }
    }

    private static void addParenthesis(StringBuffer y, String str, int num, int j){

        if(openPar > num){
            while (openPar > 0){
                y.append(')');
                openPar--;
            }
        }
        else{
            while (openPar < num) {
                y.append('(');
                openPar++;
            }
        }

        y.append(str);

        try {
            int nextNum = Character.getNumericValue(strings.get(j + 1).charAt(0));
            while(nextNum < openPar){
                y.append(')');
                openPar--;
            }
        }catch (IndexOutOfBoundsException e){
            while (openPar>0){
                y.append(')');
                openPar--;
            }
        }
    }




    private static ArrayList<String> divideString(String str){
        ArrayList<String> strings = new ArrayList<>();

        StringBuilder subString = new StringBuilder();
        char character = str.charAt(0);
        subString.append(character);

        for(int j=1; j<str.length(); j++){
            if(character != str.charAt(j)){
                strings.add(subString.toString());
                subString = new StringBuilder();
            }

            character = str.charAt(j);
            subString.append(character);
        }

        strings.add(subString.toString());

        return strings;
    }
}

