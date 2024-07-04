import java.util.Scanner;
import java.util.Stack;

public class Solution {


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        String numOfLines = in.nextLine();
        int numOfLinesint = Integer.parseInt(numOfLines);


        for(int i = 0; i<numOfLinesint; i++){

            String line  = in.nextLine();

            Stack <String> stack = new Stack<>();

            int length = line.length();

            for(int l = 0; l < length; l++){

                int num = Integer.parseInt( String.valueOf(line.charAt(l)));

                if(stack.empty() || isNumeric(stack.peek())){

                    for(int before = 0 ; before < num; before++){
                        stack.push("(");
                    }

                    stack.push(Integer.toString(num));

                    for(int before = 0 ; before < num; before++){
                        stack.push(")");
                    }

                }else{

                    int count = 0;
                    while(!isNumeric(stack.peek()) && count != num){

                        stack.pop();
                        count ++;
                    }

                    if(count != num){

                        for(int prntToInsert = 0; prntToInsert < num-count; prntToInsert++){
                            stack.push("(");
                        }
                        stack.push(Integer.toString(num));

                        for(int after = 0; after < num; after++){
                            stack.push(")");
                        }

                    }else{

                        stack.push(Integer.toString(num));

                        for(int after = 0; after < num; after++){
                            stack.push(")");
                        }

                    }

                }
            }

            String answer = stack.toString();
            answer = answer.replaceAll("\\s+","");
            answer = answer.replaceAll(",","");
            answer = answer.replaceAll("\\[","");
            answer = answer.replaceAll("\\]","");
            
            System.out.println("Case #"+(i+1)+": "+answer);


        }

    }

        public static boolean isNumeric(String strNum){


            if(strNum == null){
                return false;
            }

            try {
                double d = Double.parseDouble(strNum);
            }catch (NumberFormatException nfe){
                return false;
            }

            return true;
        }


}
