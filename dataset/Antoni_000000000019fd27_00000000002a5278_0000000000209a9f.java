import java.util.Scanner;

public class Solution {

    private static int open = 0;

    public static void main(String[] args) {
        codeJam();
    }

    public static void codeJam() {

        Scanner myReader = new Scanner(System.in);
        int casos = Integer.parseInt(myReader.nextLine());
        for (int i = 0; i < casos; i++) {
            open = 0;
            String line = myReader.nextLine();
            hacerCosas(line);
        }
        myReader.close();
    }

    private static void hacerCosas(String line) {
        StringBuilder sb = new StringBuilder();

        int lastChar = 0;
        int actualChar;
        int nextChar;
        for (int i = 0; i < line.length(); i++) {
            actualChar = Integer.parseInt(String.valueOf(line.charAt(i)));
            if (lastChar !=  actualChar){
                openParentesis(actualChar - open, sb);
                sb.append(actualChar);
            } else {
                sb.append(actualChar);
            }
            if (i != line.length() - 1) {
                nextChar =  Integer.parseInt(String.valueOf(line.charAt(i + 1)));
            } else {
                nextChar = 0;
            }
            closeParentesis(open - nextChar, sb);
            lastChar = actualChar;
        }
        System.out.println(sb);
    }
    private static void openParentesis(int toOpen, StringBuilder sb) {
        for (int i = 0; i < toOpen; i++) {
            sb.append("(");
            open++;
        }
    }
    private static void closeParentesis(int toClose, StringBuilder sb) {
        for (int i = 0; i < toClose; i++) {
            sb.append(")");
            open--;
        }
    }

}