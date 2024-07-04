import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main( String[] args ) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        for (int counter = 0; counter < n; counter++) {
            int N = Integer.parseInt(in.nextLine());
            List<String> result = new ArrayList<>();
            result.add("");
            result.add("*");
            result.add("*");
            result.add("");
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                strings.add(in.nextLine());
            }
            for(String string: strings){
                boolean start = checkStart(string, result);
                boolean end = checkEnd(string, result);
                if(end && start) addStringToResult(string, result);
                else{
                    result = new ArrayList<>();
                    result.add("*");
                    break;
                }
            }
            System.out.print("Case #" + (counter + 1) + ": ");
            printResult(result);
            System.out.println();
        }
    }

    private static void printResult(List<String> result) {
        if(result.size() == 1) System.out.print("*");
        else {
            for (String string : result) {
                if (!string.equalsIgnoreCase("*")) System.out.print(string);
            }
        }
    }

    private static void addStringToResult(String pattern, List<String> result) {
        String[] strings = (pattern).split("\\*");
        if(pattern.charAt(0) != '0' && checkStart(pattern, result)){
            String start = result.get(0);
            if(start.length() < strings[0].length()){
                result.remove(0);
                result.add(0, strings[0]);
            }
        }
        if(pattern.charAt(pattern.length() - 1) != '*' && checkEnd(pattern, result)){
            String end = result.get(result.size() - 1);
            if(end.length() < strings[strings.length - 1].length()){
                result.remove(result.size() - 1);
                result.add(strings[strings.length - 1]);
            }
        }
        for (int i = 1; i < strings.length - 1; i++) {
            result.add(2, strings[i]);
        }
        if(pattern.charAt(pattern.length() - 1) == '*' && strings.length != 1) result.add(2, strings[strings.length - 1]);
    }

    private static boolean checkEnd(String string, List<String> result) {
        if(string.charAt(string.length() - 1) == '*') return true;
        String[] stringArray = string.split("\\*");
        return checkEndString(result, stringArray[stringArray.length - 1]);
    }

    private static boolean checkStart(String string, List<String> result) {
        if(string.charAt(0) == '*') return true;
        return checkStartString(result, string.split("\\*")[0]);
    }

    private static boolean checkEndString(List<String> result, String s) {
        if(result.size() == 0) return true;
        String end = "";
        int index = result.size() - 1;
        String tempString = result.get(index);
        while(!tempString.equals("*")){
            end = tempString + end;
            index--;
            tempString = result.get(index);
        }
        int length = Math.min(end.length(), s.length());
        if(s.substring(s.length() - length).equalsIgnoreCase(end.substring(end.length() - length))) return true;
        return false;
    }

    private static boolean checkStartString(List<String> result, String s) {
        String start = "";
        int index = 0;
        String tempString = result.get(index);
        while(!tempString.equals("*")){
            start = start + tempString;
            index++;
            tempString = result.get(index);
        }
        int length = Math.min(start.length(), s.length());
        if(s.substring(0,length).equalsIgnoreCase(start.substring(0,length))) return true;
        return false;
    }

}
