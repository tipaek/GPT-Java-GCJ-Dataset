package nestingDepth;

import java.util.*;

public class Solution {

    private int T;
    private ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) {

        Solution nestingDepth = new Solution();
        nestingDepth.readInput();

        for (int x = 0; x < nestingDepth.strings.size(); x++) {
            String string = nestingDepth.strings.get(x);
            String newString = nestingDepth.applyParentheses(string);
            System.out.println(String.format("Case #%d: %s", x+1, newString));
        }

    }

    private String applyParentheses(String string) {

        List<Integer> list = new ArrayList<>();
        for(int i=0; i<string.length(); i++) {
            list.add(Character.getNumericValue(i));
        }
        int min = Collections.min(list);

        String newString = "";
        int openParentheses = 0;
        int currentValue = min;
        while(openParentheses<min) {
            newString += "(";
            openParentheses++;
        }

        for(int i=0; i<string.length(); i++) {
            int newCharValue = Character.getNumericValue(string.charAt(i));
            if(newCharValue == currentValue) {
                newString += newCharValue;
            } else if(newCharValue < currentValue) {
                currentValue = newCharValue;
                while(openParentheses > currentValue) {
                    newString += ")";
                    openParentheses--;
                }
                newString += currentValue;
            } else if(newCharValue > currentValue) {
                currentValue = newCharValue;
                while(openParentheses < currentValue) {
                    newString += "(";
                    openParentheses++;
                }
                newString += currentValue;
            }
        }

        while(openParentheses>0) {
            newString += ")";
            openParentheses--;
        }

        return newString;
    }

    private void readInput() {
        Scanner reader = new Scanner(System.in);
        String data;

        if (reader.hasNextLine()) {
            data = reader.nextLine();
            T = Integer.parseInt(data);
        }

        for (int i = 0; i < T; i++) {
            data = reader.nextLine();
            strings.add(data);
        }

        reader.close();
    }

}