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
        String output = strList.get(0).replace("*","");
        for (int i = 1; i < strList.size(); i++) {
            String strToMatch = strList.get(i).replace("*","");
            int index = output.indexOf(strToMatch);
            if(index+strToMatch.length() == output.length()){
                //do nothing
            }else{
                return "*";
            }
        } 
        return output;
    }


}