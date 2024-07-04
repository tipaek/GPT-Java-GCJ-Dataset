import javax.swing.*;
import java.util.Scanner;
import java.util.Stack;

class Test {

    public static void main(String[] args) {

        int numberOFString;
        String[] inputString;
        String[] outputString;

        Scanner scanner = new Scanner(System.in);

        System.out.println("enter number of String");
        numberOFString = scanner.nextInt();

        inputString = new String[numberOFString];
        outputString = new String[numberOFString];

        for (int i = 0; i < numberOFString; i++) {
            inputString[i] = scanner.next();
        }

        Stack<Character> characters;
        StringBuilder output ;
        for (int i = 0; i < numberOFString; i++) {
            characters = new Stack<>();
            output=new StringBuilder();
            for (int j = 0; j < inputString[i].length(); j++) {
                if (inputString[i].charAt(j) == '1') {
                    if (inputString[i].length() == 1) {
                        output.append("(1)");
                    } else {
                        characters.push(inputString[i].charAt(j));
                    }
                } else {
                    int count = 0;
                    while (!characters.empty()) {
                        if (count == 0)
                            output.append("(");
                        else
                            output.append(characters.pop());
                        count++;
                    }
                    if (count != 0)
                        output.append(")");
                    output.append("0");
                }
            }
            if(!characters.empty()){
                int count = 0;
                while (!characters.empty()) {
                    if (count == 0)
                        output.append("(");
                    else
                        output.append(characters.pop());
                    count++;
                }
                if (count != 0)
                    output.append(")");
            }
            outputString[i] = output.toString();

        }

        for (int i = 0; i < numberOFString; i++) {
            System.out.println(outputString[i]);
        }
    }


}


