
import java.util.Scanner;


public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        String s = "";

        for (int test = 0; test < t; test++) {
            s = sc.next();
            int[] matrix = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                matrix[i] = Integer.parseInt(Character.toString(s.charAt(i)));
            }
            int count = 0;
            int i = 0;
            StringBuilder result = new StringBuilder("case #" + (test+1) + ": ");
            while(i < matrix.length -1){
                if(count < matrix[i]){
                    for(int j = 0; j < matrix[i] - count; j++){
                        result.append("(");
                        count++;
                    }
                    result.append(matrix[i]);
                    i++;

                    while(true){
                        if(i < matrix.length-1 && matrix[i] == matrix[i-1]) {
                            result.append(matrix[i]);
                            i++;
                        } else break;
                    }
                } else {
                    for(int j = 0; j < count - matrix[i]; j++){
                        result.append(")");
                        count--;
                    }
                    result.append(matrix[i]);
                    i++;

                    while(true){
                        if(i < matrix.length-1 && matrix[i] == matrix[i-1]) {
                            result.append(matrix[i]);
                            i++;
                        } else break;
                    }
                }
            }

            if(count < matrix[i]){
                for(int j = 0; j < matrix[i] - count; j++){
                    result.append("(");
                    count++;
                }
                result.append(matrix[i]);
                for(int j = 0; j < count; j++){
                    result.append(")");
                }
            } else {
                for(int j = 0; j < count-matrix[i]; j++){
                    result.append(")");
                    count--;
                }
                result.append(matrix[i]);
                for(int j = 0; j < count; j++){
                    result.append(")");
                }
            }

            System.out.println(result);
        }
    }
}