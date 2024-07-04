import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        int testcases = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < testcases; i++){
            String s = scanner.nextLine();
            printSolution(i +1,s);
        }

        scanner.close();

    }

    public static void printSolution(int testcase, String s){
        int[] array = new int [s.length()];
        for( int i = 0; i < s.length(); i++){
            array[i] = Character.getNumericValue(s.charAt(i));
        }
        String result = createString(array);

        System.out.printf("Case #%s: %s\n", testcase, result);
    }

    public static String createString(int[] array){
        StringBuffer stringBuffer = new StringBuffer();
        Queue<String> parentheses = new ArrayDeque<>();
        String OPEN = "(";
        String CLOSE = ")";

        for (int i = 0; i < array.length; i++){
            if(array[i] == 0){
                clearQueue(stringBuffer, parentheses);
                stringBuffer.append(0);
            }
            else{
                if(parentheses.isEmpty()){
                    for(int j = 0; j < array[i]; j++){
                        stringBuffer.append(OPEN);
                        parentheses.add(CLOSE);
                    }
                    stringBuffer.append(array[i]);
                    //kleiner dan
                }else if(array[i] < array[i -1]){
                    for(int j = 0; j < array[i-1] - array[i]; j++){
                        stringBuffer.append(parentheses.poll());
                    }
                    stringBuffer.append(array[i]);
                    //groter dan
                }else if (array[i] > array[i -1]){
                    for(int j = 0; j < array[i] - array[i-1]; j++){
                        stringBuffer.append(OPEN);
                        parentheses.add(CLOSE);
                    }
                    stringBuffer.append(array[i]);
                    //gelijk
                }else {
                    stringBuffer.append(array[i]);
                }
            }
        }

        clearQueue(stringBuffer, parentheses);

        return stringBuffer.toString();
    }

    private static void clearQueue(StringBuffer stringBuffer, Queue<String> parentheses) {
        while (parentheses.peek() != null) {
            stringBuffer.append(parentheses.poll());
        }
    }

}
