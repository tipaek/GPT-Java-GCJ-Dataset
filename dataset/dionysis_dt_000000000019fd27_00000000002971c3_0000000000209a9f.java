import java.util.*;

public class Solution {

    public static void main(String[] args) {

        int T = 0;

        Scanner reader = new Scanner(System.in);
        String data;

        if (reader.hasNextLine()) {
            data = reader.nextLine();
            T = Integer.parseInt(data);
        }

        for (int i = 0; i < T; i++) {

            data = reader.nextLine();

            int currentValue = 0;
            int openParentheses = 0;

            StringBuilder sb = new StringBuilder();

            for(int j=0; j<data.length(); j++) {
                int newCharValue = Character.getNumericValue(data.charAt(j));
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

            System.out.println(String.format("Case #%d: %s", i+1, sb));
        }

        reader.close();


    }

}