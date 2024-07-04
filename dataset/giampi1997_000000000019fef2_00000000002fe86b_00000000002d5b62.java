import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] strings) {

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int first = scanner.nextInt();
            int second = scanner.nextInt();
            boolean firstNegative = false;
            boolean secondNegative = false;
            if (first < 0){
                firstNegative = true;
                first = Math.abs(first);
            }
            if (second < 0){
                secondNegative = true;
                second = Math.abs(second);
            }

            StringBuilder firstString = new StringBuilder('0' + Integer.toBinaryString(first));
            StringBuilder secondString = new StringBuilder('0' + Integer.toBinaryString(second));

            while (firstString.length() < secondString.length())
                firstString.insert(0,'0');

            while (secondString.length() < firstString.length())
                secondString.insert(0,'0');

            if (firstString.charAt(firstString.length()-1) == secondString.charAt(secondString.length()-1)){
                System.out.println("Case #"+i+1+": IMPOSSIBLE");
                continue;
            }

            boolean correct = true;

            for (int j = firstString.length()-2; j > 0; j--) {

                if (firstString.charAt(j) != '0' && secondString.charAt(j) != '0'){
                    if (firstString.charAt(j) == '1' && firstString.charAt(j+1) == '2'){
                        firstString.replace(j, j+2, "01");
                    }
                    else if (firstString.charAt(j) == '2' && firstString.charAt(j+1) == '1'){
                        firstString.replace(j, j+2, "02");
                    }
                    else if (secondString.charAt(j) == '1' && secondString.charAt(j+1) == '2'){
                        secondString.replace(j, j+2, "01");
                    }
                    else if (secondString.charAt(j) == '2' && secondString.charAt(j+1) == '1'){
                        secondString.replace(j, j+2, "02");
                    }

                    else if (firstString.charAt(j-1) == '0' && firstString.charAt(j) == '1' && firstString.charAt(j+1) == '1'){
                        firstString.replace(j-1, j+2, "102");
                    }

                    else if (firstString.charAt(j-1) == '0' && firstString.charAt(j) == '2' && firstString.charAt(j+1) == '2'){
                        firstString.replace(j-1, j+2, "201");
                    }

                    else if (secondString.charAt(j-1) == '0' && secondString.charAt(j) == '1' && secondString.charAt(j+1) == '1'){
                        secondString.replace(j-1, j+2, "102");
                    }

                    else if (secondString.charAt(j-1) == '0' && secondString.charAt(j) == '2' && secondString.charAt(j+1) == '2'){
                        secondString.replace(j-1, j+2, "201");
                    }

                    else {
                        correct = false;
                        break;
                    }

                }
                else if (firstString.charAt(j) == '0' && secondString.charAt(j) == '0'){
                    if (firstString.charAt(j+1) == '2'){
                        firstString.replace(j, j+2, "21");
                    }
                    else if (firstString.charAt(j+1) == '1'){
                        firstString.replace(j, j+2, "12");
                    }
                    else if (secondString.charAt(j+1) == '2'){
                        secondString.replace(j, j+2, "21");
                    }
                    else if (secondString.charAt(j+1) == '1'){
                        secondString.replace(j, j+2, "12");
                    }
                    else {
                        correct = false;
                        break;
                    }
                }

            }

            if (!correct){
                System.out.println("Case #"+i+1+": IMPOSSIBLE");
            }
            else{
                StringBuilder answer = new StringBuilder();
                for (int j = firstString.length()-1; j >= 0; j--) {
                    
                    if (firstString.charAt(j) == '1'){
                        if (!firstNegative)
                            answer.append('E');
                        else
                            answer.append('W');
                    }
                    else if (firstString.charAt(j) == '2'){
                        if (!firstNegative)
                            answer.append('W');
                        else
                            answer.append('E');
                    }
                    else if (secondString.charAt(j) == '1'){
                        if (!secondNegative)
                            answer.append('N');
                        else
                            answer.append('S');
                    }
                    else if (secondString.charAt(j) == '2'){
                        if (!secondNegative)
                            answer.append('S');
                        else
                            answer.append('N');
                    }
                }
                System.out.println("Case #"+i+1+": " + answer);

            }

        }


    }
}