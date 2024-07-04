import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.max;

public class Solution {

    static String buildString(String str) {
        String[] strList = str.split("");
        List<Integer> intList = new ArrayList<>();
        Arrays.stream(strList)
            .forEach(strInt -> intList.add(Integer.parseInt(strInt)));
        intList.add(0);
        String mySolution = "";
        int numberOfLeftBracket;
        int numberOfRightBracket;
        int previous = 0;
        for (int i =0; i<intList.size(); i++) {
            int current = intList.get(i);
            int next = i == intList.size()-1 ? 0 : intList.get(i+1);
            if (current != 0) {
                numberOfLeftBracket = (i==0||previous==0) ? current : max(0,current-previous);
                numberOfRightBracket = (i==intList.size()||next==0) ? current : max(0,current-next);
                String leftBracket = String.join("", Collections.nCopies(numberOfLeftBracket, "("));
                String rightBracket = String.join("", Collections.nCopies(numberOfRightBracket, ")"));
                mySolution = mySolution + leftBracket+current+rightBracket;
            } else if (intList.get(i) == 0 && i!=intList.size()-1) {
                mySolution = mySolution + intList.get(i);
            }
            previous = current;
        }
        return mySolution;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for (int i =0; i<cases; i++) {
            String str = sc.next();
            System.out.println("Case #" + i +" : "+buildString(str));
        }
    }
}

