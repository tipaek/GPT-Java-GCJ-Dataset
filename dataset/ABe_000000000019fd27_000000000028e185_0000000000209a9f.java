import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.

        for (int i = 1; i <= t; ++i) {
            String input = in.next();
            char [] input_array = input.toCharArray();
            ArrayList<Character> input_array_list = new ArrayList<Character>();

            int current_open = 0;

            for( int i = 0; i < input.length(); i++) {
                int index = i;

                while (input_array[i] == input_array[index+1]) {
                    index++;
                }

                int number = (int) input_array[i];
                int difference = number - current_open;

                if(difference > 0){
                    while(difference != 0) {
                        input_array_list.add('(');
                        difference--;
                    }
                }
                else {
                    while(difference != 0 ) {
                        input_array_list.add(')');
                        difference++;
                    }
                }
                for(int j = i; j < index; j++ ) {
                    input_array_list.add(input_array[j]);
                }
                current_open = (int) input_array[i];
                i = index;
            }

            while(current_open != 0) {
                input_array_list.add(')');
                current_open--;
            }

        System.out.println("Case #" + i + ": " + result );
        }
    }
}