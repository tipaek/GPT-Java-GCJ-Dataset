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

            for( int k = 0; k < input.length(); k++) {
                int index = k;

                boolean exit = false;
                while(exit == false) {
                    int index_check = index+1;
                    if (index_check == input_array.length){
                        exit = true;
                    }
                    else {
                        if(input_array[k] == input_array[index+1] ) {
                            index++;
                        }
                        else {
                            exit = true;
                        }

                    }
                }


                int number = Integer.parseInt( String.valueOf(input_array[k]) ) ;
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
                for(int j = k; j <= index; j++ ) {
                    input_array_list.add(input_array[j]);
                }
                current_open =  number;
                k = index;
            }

            while(current_open != 0) {
                input_array_list.add(')');
                current_open--;
            }

            StringBuilder sb = new StringBuilder();
            for (Character c : input_array_list)
            {
                sb.append(c);
            }

            String result = sb.toString();

        System.out.println("Case #" + i + ": " + result );
        }
    }
}
