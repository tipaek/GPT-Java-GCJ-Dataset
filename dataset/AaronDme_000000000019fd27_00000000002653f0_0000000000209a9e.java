import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args) throws IOException {
        String[] tb = input.readLine().split("\\s+");
        int t = Integer.parseInt(tb[0]);
        int b = Integer.parseInt(tb[1]);
        for(int i = 1; i <= t; i++){
           int[] bits = new int[b];
           Arrays.fill(bits, -1);
           int leftMark = 0;
           boolean isComplement = false;
           boolean isInverse = false;
           int complementChecker = -1;
           int inverseChecker = -1;
           int guessNumber = 0;
           
           while(leftMark * 2 < b){
               if(guessNumber == 10){
                if(complementChecker != -1){
                    System.out.println(complementChecker + 1);
                    System.out.flush();
                    int a = Integer.parseInt(input.readLine());
                    isComplement = !(a == bits[complementChecker]);
                }
                else{
                    System.out.println(1);
                    System.out.flush();
                    Integer.parseInt(input.readLine());
                }
                if(inverseChecker != -1){
                    System.out.println(inverseChecker + 1);
                    System.out.flush();
                    int a = Integer.parseInt(input.readLine());
                    isInverse = (isComplement && a == bits[inverseChecker]) || (!isComplement && a != bits[inverseChecker]);
                }
                else{
                    System.out.println(1);
                    System.out.flush();
                    Integer.parseInt(input.readLine());
                }
                guessNumber = 2;
                continue;
               }
               System.out.println(leftMark + 1);
               System.out.flush();

               int x = Integer.parseInt(input.readLine());
               bits[(isInverse)? b - 1 - leftMark:leftMark] = (isComplement)? (x == 0)? 1:0 :x;

               System.out.println(b - leftMark);
               System.out.flush();

              x = Integer.parseInt(input.readLine());
               bits[(!isInverse)? b - 1 - leftMark:leftMark] = (isComplement)? (x == 0)? 1:0 :x;

               if(complementChecker == -1){
                if(bits[leftMark] == bits[b - 1 - leftMark])
                    complementChecker = leftMark;
               }
               if(inverseChecker == -1){
                if(bits[leftMark] != bits[b - 1 - leftMark])
                    inverseChecker = leftMark;
               }
                guessNumber += 2;
                leftMark++;
           }
           for(int j = 0; j < b; j++){
               int out;
               if(isInverse)
                    out = bits[b - j - 1];
                else
                    out = bits[j];

                System.out.print((isComplement)? (out == 0)? 1:0:out);
           }
           System.out.println("");
           System.out.flush();
           if(input.readLine().equals("N")){
            break;
           }
        }
    }
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
}