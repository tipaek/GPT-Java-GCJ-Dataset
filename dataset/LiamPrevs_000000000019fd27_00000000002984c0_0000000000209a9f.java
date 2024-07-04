import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numCases = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < numCases; i++){
            String currLine = sc.nextLine() + "0";
            String returnLine = "";
            Integer pastNum = 0;

            for(char currNumChar : currLine.toCharArray()){
                int currNum = Integer.parseInt(String.valueOf(currNumChar));

                for(int c = 0; c < Math.abs(currNum-pastNum); c++){
                    if(currNum > pastNum){
                        returnLine += '(';
                    }
                    else{
                        returnLine += ')';
                    }
                }

                returnLine += currNum;
                pastNum = currNum;
            }
            System.out.println(returnLine.substring(0, returnLine.length()-1));
        }
    }
}
