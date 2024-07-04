import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner myScanner = new Scanner(System.in);

        int _t = myScanner.nextInt();
        //myScanner.hasNextLine();
        int __t = _t;

        while (_t != 0) {
            myScanner = new Scanner(System.in);
            String numString = myScanner.nextLine();
            ArrayList<String> numberArray = stringToNumberList(numString);

            StringBuilder outNumberString = new StringBuilder();
            boolean isFastNumber = true;
            //int lastInt = -1;

            int totalOpenP = 0;
            //int totalCloseP = 0;

            int counter = 1;
            for (String number : numberArray) {
                int n = Integer.parseInt("" + number.charAt(0));

                if (isFastNumber) {
                    while (n != 0) {
                        outNumberString.append("(");
                        totalOpenP++;
                        n--;
                    }
                    outNumberString.append(number);
                    isFastNumber = false;
                } else if (n > totalOpenP) {
                    int t = n - totalOpenP;
                    while (t != 0) {
                        outNumberString.append("(");
                        totalOpenP++;
                        t--;
                    }
                    outNumberString.append(number);
                } else if (n < totalOpenP) {
                    int t = totalOpenP - n;
                    while (t != 0) {
                        outNumberString.append(")");
                        totalOpenP--;
                        t--;
                    }
                    outNumberString.append(number);
                }
                if (counter == numberArray.size()) {
                    int t = totalOpenP;
                    while (t != 0) {
                        outNumberString.append(")");
                        totalOpenP--;
                        t--;
                    }
                }


                //System.out.println(n);
                counter++;
                //lastInt = n;
            }
            System.out.println("Case #"+(__t-(--_t))+": "+outNumberString.toString());

            //System.out.println(numberArray.toString());
            //_t --;
        }


    }

    public static ArrayList<String> stringToNumberList(String numString) {

        ArrayList<String> numberArray = new ArrayList<>();
        char lastChar = numString.charAt(0);
        char currentCher;
        int charCount = 1;
        for (int i = 1; i < numString.length(); i++) {
            currentCher = numString.charAt(i);
            if (currentCher == lastChar) {
                charCount++;
            } else {
                StringBuilder number = new StringBuilder();
                number.append(lastChar);
                while (charCount != 1) {
                    number.append(lastChar);
                    charCount--;
                }
                numberArray.add(number.toString());
                charCount = 1;
                lastChar = currentCher;
            }
        }
        StringBuilder number = new StringBuilder();
        number.append(lastChar);
        while (charCount != 1) {
            number.append(lastChar);
            charCount--;

        }
        numberArray.add(number.toString());
        return numberArray;
    }
}
