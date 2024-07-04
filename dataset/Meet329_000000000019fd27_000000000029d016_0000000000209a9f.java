import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        //System.out.println("meet");
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        //sc.nextLine();
        //int testCase = Integer.parseInt(args[0]);
        for(int i=1;i<=testCase;i++){
            int current = 0;
            String output = "";
            String input = sc.nextLine();
            int length = input.length();
            char[] stringToCharArray = input.toCharArray();
            //System.out.println(length+","+args[i]);
            for(int j=0;j<length;j++){
                int digit = Character.getNumericValue(stringToCharArray[j]);
                //System.out.println(digit);
                if(digit>current){
                    int dif = digit - current;
                    for(int k=0;k<dif;k++){
                        output=output.concat("(");
                    }
                    output=output.concat(String.valueOf(stringToCharArray[j]));
                    current=digit;
                }
                else if(digit<current){
                    int dif = current - digit;
                    for(int k=0;k<dif;k++){
                        output=output.concat(")");
                    }
                    output=output.concat(String.valueOf(stringToCharArray[j]));
                    current=digit;
                }
                else{
                    output=output.concat(String.valueOf(stringToCharArray[j]));
                }
            }
            for(int k=0;k<current;k++){
                output=output.concat(")");
            }
            System.out.println(output);
        }
        sc.close();
    }
}
