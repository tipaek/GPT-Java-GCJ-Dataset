import java.util.Scanner;
import java.util.InputMismatchException;

public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        //System.out.println(number);
        for(int n = 0;n < number; n++){
            String str = sc.next(); // str
            String[] strArray = new String[str.length()];
            int[] intArray = new int[str.length()];
            int[] bracketsArray = new int[str.length()+1];
            
            for (int i = 0; i < str.length(); i++) {
                String str2 = String.valueOf(str.charAt(i));
                strArray[i] = str2;
                intArray[i] = Integer.parseInt(str2);
                bracketsArray[i] = 0;
            }
            
            bracketsArray[str.length()] = 0;
            int count = 0;
            for (int i = 0; i < strArray.length; i++) {
                count = intArray[i];
                bracketsArray[i] += count;
                bracketsArray[i+1] -= count;
            }
            System.out.print("Case #"+(n+1)+": ");
            for (int i = 0; i < strArray.length; i++) {
                System.out.print(makeBrackets(bracketsArray[i]) + strArray[i]);
            }
            System.out.print(makeBrackets(bracketsArray[strArray.length]));
            System.out.println();
        }
        sc.close();
    }

    static String makeBrackets(int number){
        String tmpStr = "";
        if(number>0){
            for(int i=0;i<number;i++){
                tmpStr = tmpStr + "(";
            }
            return tmpStr;
        }else{
            number = Math.abs(number);
            for(int i=0;i<number;i++){
                tmpStr = tmpStr + ")";
            }
            return tmpStr;
        }
    }
}