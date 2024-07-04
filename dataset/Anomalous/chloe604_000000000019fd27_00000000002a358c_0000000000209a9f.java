import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputList = new ArrayList<>();
        ArrayList<String> outputList = new ArrayList<>();

        int T = scanner.nextInt();
        for (int i = 0; i < T; i++) {
            inputList.add(scanner.next());
        }

        for (String input : inputList) {
            if (input.charAt(0) == '0' && areAllCharactersSame(input)) {
                outputList.add(input);
            } else {
                StringBuilder modifiedString = new StringBuilder(input);
                for (int j = 0; j < input.length(); j++) {
                    if (input.charAt(j) == '1') {
                        modifiedString.insert(j, "(");
                        if (j != input.length() - 1 && input.charAt(j) != input.charAt(j + 1)) {
                            modifiedString.insert(j + 2, ")");
                        } else if (j == input.length() - 1) {
                            modifiedString.insert(j + 2, ")");
                        }
                    }
                }
                outputList.add(modifiedString.toString());
            }
        }

        for (int i = 0; i < outputList.size(); i++) {
            System.out.println("Case #" + (i + 1) + ": " + outputList.get(i));
        }
    }

    private static boolean areAllCharactersSame(String s) {
        char firstChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != firstChar) {
                return false;
            }
        }
        return true;
    }
}