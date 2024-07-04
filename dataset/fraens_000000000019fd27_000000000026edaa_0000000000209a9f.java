import java.io.BufferedReader;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.Scanner;

public class Solution {

    /**
     * @param in Scanner
     * @return ArrayList of all test cases as ArrayList<Integer>
     */
    public static ArrayList<ArrayList<Integer>>  listOfTestCases(Scanner in){
        ArrayList<ArrayList<Integer>> arrayListOfDigitArrayLists = new ArrayList<>();
        int numberOfTestCases = in.nextInt();
        in.nextLine();
        ArrayList<Integer> digitArrayList = new ArrayList<>();
        String digitString = "";

        for (int i = 0; i < numberOfTestCases; i++) {
            digitString = in.nextLine();
            digitArrayList = new ArrayList<>();

            for (int j = 0; j < digitString.length(); j++) {
                digitArrayList.add(Character.getNumericValue(digitString.charAt(j)));
            }
            arrayListOfDigitArrayLists.add(digitArrayList);
        }
        return arrayListOfDigitArrayLists;
    }


    public static String stringForOneTestCase(ArrayList<Integer> digits){
        String answerString = "";
        Integer previousDigit = 0;
        int difference;

        for (Integer digit : digits) {
            if(digit.equals(previousDigit)){
                answerString += digit.toString();
            }
            else if(digit > previousDigit){
                difference = digit - previousDigit;
                String repeated = new String(new char[difference]).replace("\0", "(");
                answerString = answerString + repeated + digit;
            }
            else {
                difference = previousDigit - digit;
                String repeated = new String(new char[difference]).replace("\0", ")");
                answerString = answerString + repeated + digit;
            }
            previousDigit = digit;
        }

        answerString += new String(new char[digits.get(digits.size()-1)]).replace("\0", ")");

        return answerString;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        ArrayList<ArrayList<Integer>> myList = listOfTestCases(in);
        int caseCounter = 1;
        for (ArrayList<Integer> arrayListOfDigits : myList) {
            System.out.println("Case #" + caseCounter + ": " + stringForOneTestCase(arrayListOfDigits));
            caseCounter++;
        }
    }
}

