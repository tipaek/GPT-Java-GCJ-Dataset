package nestingDepth;

import java.util.*;

public class Solution {

    private int T;
    //private ArrayList<String> strings = new ArrayList<>();

    public static void main(String[] args) {

        try {
            Solution solution = new Solution();
            solution.readInput();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        /*
        for (int x = 0; x < nestingDepth.strings.size(); x++) {
            String string = nestingDepth.strings.get(x);
            String newString = nestingDepth.applyParentheses(string);
            System.out.println(String.format("Case #%d: %s", x+1, newString));
        }
         */

    }

    private String applyParentheses(String string) {

//        List<Integer> list = new ArrayList<>();
//        for(int i=0; i<string.length(); i++) {
//            list.add(Character.getNumericValue(i));
//        }
//        int min = Collections.min(list);
//
//        String newString = "";
//        int openParentheses = 0;
//        int currentValue = min;
//        while(openParentheses<min) {
//            newString += "(";
//            openParentheses++;
//        }

        int newCharValue = Character.getNumericValue(string.charAt(0));
        int currentValue = 0;
        int openParentheses = 0;

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<string.length(); i++) {
            newCharValue = Character.getNumericValue(string.charAt(i));
            if(newCharValue == currentValue) {
                sb.append(newCharValue);
            } else if(newCharValue < currentValue) {
                currentValue = newCharValue;
                while(openParentheses > currentValue) {
                    sb.append(')');
                    openParentheses--;
                }
                sb.append(currentValue);
            } else if(newCharValue > currentValue) {
                currentValue = newCharValue;
                while(openParentheses < currentValue) {
                    sb.append('(');
                    openParentheses++;
                }
                sb.append(currentValue);
            }
        }

        while(openParentheses>0) {
            sb.append(')');
            openParentheses--;
        }

        return sb.toString();
    }

    private void readInput() {
        Scanner reader = new Scanner(System.in);
        String data;

        if (reader.hasNextLine()) {
            data = reader.nextLine();
            T = Integer.parseInt(data);
        }

        for (int i = 0; i < T; i++) {
            //data = reader.nextLine();
            //strings.add(data);
            System.out.println(String.format("Case #%d: %s", i+1, this.applyParentheses(reader.nextLine())));
        }

        reader.close();
    }

}