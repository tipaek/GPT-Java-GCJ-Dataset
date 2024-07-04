import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args) throws IOException {
        int t = getInt();
        int b = getInt();
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
                    int a = getInt();
                    isComplement = !(a == bits[complementChecker]);
                }
                else{
                    System.out.println(1);
                    System.out.flush();
                    getInt();
                }
                if(inverseChecker != -1){
                    System.out.println(inverseChecker + 1);
                    System.out.flush();
                    int a = getInt();
                    isInverse = (isComplement && a == bits[inverseChecker]) || (!isComplement && a != bits[inverseChecker]);
                }
                else{
                    System.out.println(1);
                    System.out.flush();
                    getInt();
                }
                guessNumber = 2;
                continue;
               }
               System.out.println(leftMark + 1);
               System.out.flush();

               int x = getInt();
               bits[(isInverse)? b - 1 - leftMark:leftMark] = (isComplement)? (x == 0)? 1:0 :x;

               System.out.println(b - leftMark);
               System.out.flush();

              x = getInt();
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
                    out = bits[b - j];
                else
                    out = bits[j];

                System.out.print((isComplement)? (out == 0)? 1:0:out);
           }
           System.out.println("");
        }
    }
    public static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
    public static int getInt() throws IOException{
        int c = skipSpace();
        boolean isNeg = (char) c == '-';
        int out = 0;
        if(isNeg)
          c = input.read();
        do {
          out *= 10;
          out += c - '0';
          c = input.read();
        } while (c <= '9' && c >= '0');
        return (isNeg)? -out: out;
      }
    public static int skipSpace() throws IOException{
        int s = input.read();
        while(s == ' ' || s == '\n' || s == '\r') {
          s = input.read();
        }
        return s;
      }
}