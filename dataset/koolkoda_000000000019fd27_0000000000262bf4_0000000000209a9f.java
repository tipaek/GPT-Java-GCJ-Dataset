import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int T = Integer.parseInt(input.nextLine());

        for(int i = 0; i < T; i++){
            String str = input.nextLine();
            String[] splits = str.split("");

            StringBuilder stringBuilder = new StringBuilder();
            Stack<String> stack = new Stack<>();
            for (int j = 0; j < splits.length; j++) {
                String c = splits[j];
                int charInt = Integer.parseInt(c);

                while(stack.size() > charInt){
                    stringBuilder.append(stack.pop());
                }


                for (int k = 0; k < charInt; k++) {
                    if(stack.size() != charInt){
                        stringBuilder.append("(");
                        stack.push(")");
                    }
                }

                stringBuilder.append(c);

                for(int k = j + 1; k < splits.length; k++){
                    if(!c.equals(splits[k])){
                        break;
                    }
                    stringBuilder.append(c);
                    j++;
                }

            }

            while (!stack.isEmpty()){
                stringBuilder.append(stack.pop());
            }

            System.out.printf("Case #%d: %s%n", i + 1, stringBuilder);

        }
    }
}
