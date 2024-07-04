import java.util.Scanner;

public class Solution {

    static String addCharacters(String s, int nr, String c){
        for(int i=1; i<=nr; i++){
            s = s + c;
        }
        return s;
    }
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int noTests = Integer.parseInt(scanner.nextLine());

        String result = "";
        String line = "";
        int noOpenBrackets, value;
        for(int t=1; t<=noTests; t++){
            result = "";
            line = scanner.nextLine();
            noOpenBrackets = 0;
            for(int i=0; i<line.length(); i++){
                value = line.charAt(i)-'0';
                if(value>noOpenBrackets){
                    result = addCharacters(result, value-noOpenBrackets, "(");
                }
                else if(value<noOpenBrackets){
                   result = addCharacters(result, noOpenBrackets-value, ")");
                }
                noOpenBrackets=value;
                result = result + line.charAt(i);
            }

            if(noOpenBrackets>0) result = addCharacters(result, noOpenBrackets, ")");

            System.out.println("Case #" + t + ": " + result);
        }
    }
}
