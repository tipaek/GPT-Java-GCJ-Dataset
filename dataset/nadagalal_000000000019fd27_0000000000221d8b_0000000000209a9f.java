import java.util.Scanner;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String numberOfTestCases = scanner.nextLine();
        for (int i = 0; i < Integer.parseInt(numberOfTestCases); i++) {
            String input = scanner.nextLine();
            int open = 0;
            String s = "";
            char[] numbers = input.toCharArray();
            for (int j = 0; j < numbers.length; j++) {
                int number = Integer.parseInt(String.valueOf(numbers[j]));
                int openedParantheses = number - open;
                if (openedParantheses >0){
                    while(openedParantheses > 0){
                        s=s+"(";
                        openedParantheses--;
                        open++;
                    }
                    s=s+number;
                }
                else if(openedParantheses<0){

                    while(openedParantheses < 0){
                        s=s+")";
                        openedParantheses++;
                        open--;
                    }
                    s =s+number;
                   // open =0;
                }
                else{
                    s+=number;
                }
            }
          while(open>0){
              s+=")";
              open--;
          }
            System.out.println("case #" + (i+1) +":"+ " " +s);
        }
    }
}
