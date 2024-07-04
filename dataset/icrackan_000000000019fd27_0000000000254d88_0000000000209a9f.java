import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int t = 0; t < T; t++){
            String S = scanner.nextLine();
            int lengthS = S.length();
            int[] leftParenthesesSIth = new int[lengthS];
            int[] rightParenthesesSIth = new int[lengthS];

            for (int i = 0; i < lengthS; i++){
                int valueSIth = Character.getNumericValue(S.charAt(i));
                if(valueSIth > 0) {
                    leftParenthesesSIth[i] = valueSIth;
                    rightParenthesesSIth[i] = valueSIth;
                    if (i > 0) {
                        if(rightParenthesesSIth[i - 1] > 0){
                            int borrowLeftParentheses = leftParenthesesSIth[i] - rightParenthesesSIth[i - 1];
                            if(borrowLeftParentheses < 0){
                                leftParenthesesSIth[i] = 0;
                                rightParenthesesSIth[i - 1] = Math.abs(borrowLeftParentheses);
                            } else {
                                leftParenthesesSIth[i] = borrowLeftParentheses;
                                rightParenthesesSIth[i - 1] = 0;
                            }
                        }
                    }
                }
            }

            //print result
            System.out.print("Case #" + (t + 1) + ": ");
            for (int i = 0; i < lengthS; i++){
                if(leftParenthesesSIth[i] > 0){
                    for(int k = 0; k < leftParenthesesSIth[i]; k++){
                        System.out.print("(");
                    }
                }

                System.out.print(S.charAt(i));

                if(rightParenthesesSIth[i] > 0){
                    for(int k = 0; k < rightParenthesesSIth[i]; k++){
                        System.out.print(")");
                    }
                }
            }
        }
    }
}