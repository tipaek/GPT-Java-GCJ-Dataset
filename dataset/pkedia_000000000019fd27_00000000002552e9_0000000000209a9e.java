import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        String[] strings = in.nextLine().split(" ");
        int numberOFTestCases = Integer.parseInt(strings[0]);
        int n = Integer.parseInt(strings[1]);
        Random random = new Random(4);
        boolean[] input = new boolean[n];
        String judgePass = in.nextLine();
        for(int i=0;i<judgePass.length();i++)
        {
            input[i]=(judgePass.charAt(i)-48)==0?false:true;
        }
        for (int caseNumber = 1; caseNumber <= numberOFTestCases; caseNumber++) {
            String newInput = in.nextLine();
            if("ok".equals(newInput)) {
                System.out.println("exit");
                break;
            }

            String number = newInput.split(" ")[1];
            if(number.length()>=input.length)
            {
                System.out.println("ok");
            }else{
                int lineNumber = Integer.parseInt(number);
                input= any(input,random.nextInt());
                System.out.println(input[lineNumber]?1:0);
            }
            System.out.flush();
        }
        in.close();
    }
    private static boolean[] any(boolean[] input, int random){
        switch (random)
        {
            case 0:
                  comp(input);
                  break;
            case 1:
                  reverse(input);
                  break;
            case 2:
                 comprevers(input);
        }
        return input;
    }
    private static void comp(boolean[] input)
    {
        for(int index=0;index<input.length;index++)
            input[index]= !input[index];
    }
    private static void reverse(boolean[] input)
    {
        for(int index=0;index<input.length/2;index++)
        {
            boolean temp = input[index];
            input[index]=input[input.length-index-1];
            input[input.length-index-1]=temp;
        }
    }
    private static void comprevers(boolean[] input)
    {
        comp(input);
        reverse(input);
    }
}
