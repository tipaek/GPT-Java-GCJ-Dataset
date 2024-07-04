import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    private static String getBalancedBrackets(String input){
        char[] inputArr = input.toCharArray();
        Queue<Character> queue = new LinkedList<>();
        Integer value = -1;
        Integer prev = -1;
        Integer diff = -1;
        int lengthOfString = input.length();
        int count = 0;
        for(char ch:inputArr){
            ++count;
            value = ch - '0';
           // System.out.println("Display:"+value);
            if(value == 0 && prev <= 0){
          //      System.out.println("----------------1");
                queue.add(ch);
            }else if(value > 0){
                if(prev <= 0){
                    for(int i = 0; i < value; i++){
                        queue.add('(');
                    }
                    queue.add(ch);
                    prev = value;
                }else{
                    if(value == prev){
                        if(value == 1){
                            queue.add(ch);
                        }else if (value > 1){ // TODO: New addition
                            for(int i = 0; i < value; i++){
                                queue.add(')');
                            }
                            for(int i = 0; i < value; i++){
                                queue.add('(');
                            }
                            queue.add(ch);
                        }

                    }else if(prev > value){
                        diff = prev - value;
                        for(int i = 0; i < diff; i++){
                            queue.add(')');
                        }
                        queue.add(ch);  // TODO: New addition
                        prev = value;
                    }else if(value > prev){
                        diff = value - prev;
                        for(int i = 0; i < diff; i++){
                            queue.add('(');
                        }
                        queue.add(ch);  // TODO: New addition
                        prev = value;
                    }
                }
            }if(value == 0 && prev > 0){
             //   System.out.println("------------------------------2"+" prev: "+prev);
                for(int i = 0; i < prev; i++){
                    queue.add(')');
                }
                queue.add(ch);
                prev = value;
            }
            if(count == lengthOfString && value > 0){
             //   System.out.println("------------------------------3"+" value: "+value);
                for(int i = 0; i < value; i++){
                    queue.add(')');
                }
            }
        }
        StringBuilder sbr = new StringBuilder();
        for (char ch:queue){
           // System.out.print(ch);
            sbr.append(ch);
        }
       // System.out.println(sbr.toString());
        return sbr.toString();
    }

    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        Integer cases = in.nextInt();
        for(int i=0; i < cases; i++){
            String input = in.next();
            //System.out.println("input:"+input);
            String output = getBalancedBrackets(input);
            System.out.println("Case #"+(i+1)+": "+output);
        }
    }
}
