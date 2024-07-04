import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    private static List<String> inputNumberList = new ArrayList<>();
    private static List<String> outputNumberList = new ArrayList<>();

    public static void main(String[] arg){
        setDataFromUserInput();
        setOutputNumberList();
        printOutput();
    }

    private static void setOutputNumberList(){
        for(int i=0; i<inputNumberList.size(); i++){
            outputNumberList.add(getStringForInputNumber(inputNumberList.get(i)));
        }
    }

    private static String getStringForInputNumber(String number){
        String s = "";
        int open = 0;

        for(int i=0; i<number.length(); i++){
            int num = getNumberFromStringForIndex(number, i);
            while(open < num){
                s = s + "(";
                open++;
            }
            while(open > num){
                s = s + ")";
                open--;
            }
            s += num;
        }
        while(open > 0){
            s = s + ")";
            open--;
        }
        return s;
    }

    private static int getNumberFromStringForIndex(String number, int index){
        if(index < number.length()-1){
            return Integer.parseInt(number.substring(index, index+1));
        }
        return Integer.parseInt(number.substring(index));
    }


    private static void setDataFromUserInput(){

        Scanner scan = new Scanner(System.in);

        int numberOfTestCases = scan.nextInt();
        scan.nextLine();

        for(int i=0; i<numberOfTestCases; i++){
            String number = scan.nextLine();
            inputNumberList.add(number);
        }

    }

    private static void printOutput(){
        for(int i=0; i<outputNumberList.size(); i++){
            System.out.println("Case #"+(i+1)+": "+outputNumberList.get(i));
        }
    }

}
