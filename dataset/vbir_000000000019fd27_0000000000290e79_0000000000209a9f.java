import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        List<List<Integer>> data = new ArrayList<>();
        int lineNr = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine();
            char[] cells = line.toCharArray();
            if(lineNr == 0) {
                lineNr ++;
                continue;
            }
            List<Integer> row = new ArrayList<>();
            for(char c: cells){
                row.add((int)c - '0');
            }
            data.add(row);
            lineNr ++;
        }

        String output = "";
        int caseNr = 1;
        for(List<Integer> dp: data){
            output += String.format("Case #%d: %s\n",caseNr,transform(dp));
            caseNr ++;
        }
        System.out.println(output);
    }

    private static String transform(List<Integer> row){
        String result = "";
        result += multiplyChar('(',row.get(0));
        result+=row.get(0);
        for(int i = 1; i < row.size(); i++){
            if(row.get(i-1) > row.get(i)){
                result+= multiplyChar(')',(row.get(i-1)-row.get(i)));
            }else if(row.get(i-1) < row.get(i)){
                result+=multiplyChar('(',(row.get(i)-row.get(i-1)));
            }
            result += row.get(i);
        }
        result+= multiplyChar(')',row.get(row.size()-1));
        return result;
    }

    private static String multiplyChar(char c, int n){
        String s = "";
        for(int i = 0; i < n; i++){
            s += c;
        }
        return s;
    }
}
