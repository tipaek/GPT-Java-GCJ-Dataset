import java.io.*;
import java.util.*;
public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int testCases = in.nextInt(); // num test cases
        int testCaseCounter = 0;
        while (testCaseCounter < testCases) {
            int inputSize = in.nextInt();
            testCaseCounter++;
            List<String> stringList = new ArrayList<>();
            String[] input = new String[inputSize];
            for (int i = 0; i < inputSize; ++i) {
               String str = in.next();
               input[i] = str;
               stringList.add(str);
            }
            String result = matcher(stringList);
            System.out.println("Case #" + testCaseCounter + ": " + result);

        }
    }

    public static String matcher(List<String> strList){
        strList.sort(Comparator.comparing(String::length));
        Collections.reverse(strList);
        StringBuilder sb = new StringBuilder();
        String output = "";
        for (String str: strList) {
            String strToMatch = str.substring(1);
            if(output.equals("")){
                output = strToMatch;
            }
            boolean doesContain = output.contains(strToMatch);
            if(doesContain){
                //do nothing
            }else{
                return "*";
            }
        } 
        return output;
    }
}