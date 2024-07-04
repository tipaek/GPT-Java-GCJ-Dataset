import java.util.*;
public class Solution{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 1; i <= t; i++){
            String s = scanner.next();
            int length = s.length();
            char [] digits = s.toCharArray();
            ArrayList<Character> ans = new ArrayList<>();
            for(int j = 0; j < s.length(); j++){
                ans.add(digits[j]);
            }
            ans.add('0');
            int parentheses = 0;
            for(int j = 0; j < length; j++){
                if(j == 0){
                    for(int k = 0; k < Character.getNumericValue(ans.get(0)); k++){
                        ans.add(0, '(');
                        length++;
                        parentheses++;
                    }
                }
                else{
                    if(parentheses == 0 && ans.get(j) != '0') {
                        parentheses = Character.getNumericValue(ans.get(j));
                        int temp = parentheses;
                        while(temp > 0){
                            ans.add(j, '(');
                            temp--;
                        }
                    }
                    else {
                        if (ans.get(j) == '0') {
                            while (parentheses > 0) {
                                ans.add(j, ')');
                                parentheses--;
                                length++;
                            }
                            continue;
                        }
                        if (ans.get(j) != '(' && Character.getNumericValue(ans.get(j)) == Character.getNumericValue(ans.get(j + 1))) {
                            continue;
                        } else if (ans.get(j) != '(' && ans.get(j) != ')' && Character.getNumericValue(ans.get(j)) < Character.getNumericValue(ans.get(j - 1))) {
                            for (int k = 0; k < Integer.parseInt(Character.toString(ans.get(j))); k++) {
                                ans.add(0, '(');
                                parentheses++;
                                length++;
                            }
                        } else {
                            while (parentheses > 0) {
                                ans.add(j + 1, ')');
                                parentheses--;
                                length++;
                            }
                        }
                    }
                }
            }
            ans.remove(ans.size() - 1);
            if(ans.get(ans.size() - 1) != '0'){
                int x = Character.getNumericValue(ans.get(ans.size() - 1));
                while(x > 0){
                    ans.add(ans.size() - 1, '(');
                    ans.add(')');
                    x--;
                }
            }
            System.out.print("Case #" + i + ": ");
            for(int q = 0; q < ans.size(); q++){
                System.out.print(ans.get(q));
            }
            System.out.println(" ");
        }
    }
}