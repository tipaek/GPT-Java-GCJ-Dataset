import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bufferedReader.readLine());
        int counter = 1;
        while(t-- > 0){
            String s = bufferedReader.readLine();
            String result = solve(s);
            System.out.println("Case #" + counter + ": " + result);
            counter++;
        }
    }

    public static String solve(String s){
        ArrayList<Character> list = new ArrayList<>();
        int left = 0;
        int right = 0;
        int diff = 0;
        //int currentIndexOfList = 0;
        for(char c : s.toCharArray()){
            int digit = c - '0';
            diff = left - right;
            if(diff == digit){
                list.add(c);
            }
            else if(digit > diff){  //add lefts
                int temp = Math.abs(digit - diff);
                left += temp;
                while(temp-- > 0){
                    list.add('(');
                }
                list.add(c);
            }
            else{   //add rights
                int temp = Math.abs(digit - diff);
                right += temp;
                while(temp-- > 0){
                    list.add(')');
                }
                list.add(c);
            }
        }
        diff = left - right;
        while(diff-- > 0){
            list.add(')');
        }

        return printList(list);

        //return "Nothing";
    }

    public static String printList(ArrayList<Character> list){
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : list){
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
        //System.out.println(stringBuilder);
    }
}
