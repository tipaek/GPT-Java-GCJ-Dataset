import java.util.Scanner;
import java.util.ArrayList;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases  = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i< cases; i++){
            String str = sc.nextLine();
            char[] array = str.toCharArray();
            int prev = 0;
            ArrayList<Character> output = new ArrayList<>();
            for(int j = 0; j<array.length; j++){
                int current = Character.getNumericValue(array[j]);
                if(prev==current){
                    output.add(array[j]);
                    if(j==array.length-1){
                        for(int k = 0; k<current; k++) {
                            output.add(')');
                        } 
                    }
                    continue;
                } else if(current > prev) {
                    for(int k = 0; k<current-prev; k++) {
                        output.add('(');
                    }
                } else {
                    for(int k = 0; k<prev-current; k++) {
                        output.add(')');
                    }
                }
                output.add(array[j]);
                prev = current;
                if(j==array.length-1){
                   for(int k = 0; k<current; k++) {
                        output.add(')');
                    } 
                }
            }
            System.out.printf("Case #%d: ", i+1);
            for(int j = 0; j<output.size(); j++){
                System.out.print(output.get(j));
            }
            System.out.println();
        }
    }
}