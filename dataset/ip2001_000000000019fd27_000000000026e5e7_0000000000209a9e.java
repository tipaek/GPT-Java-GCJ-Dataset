import java.util.*;
import java.io.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
        int bits = scanner.nextInt();
        
        for(int i = 0; i < cases; i++){
            String answer = "";
            for(int j = 0; j < bits; j++){
                System.out.print(j+1);
                answer +=  scanner.next();
                
            }
            System.out.println(answer);
        }
        
        
    }

}