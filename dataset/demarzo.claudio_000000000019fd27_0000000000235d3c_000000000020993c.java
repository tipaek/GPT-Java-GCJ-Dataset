import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            int rc=in.nextInt();
            int mat[][]=new int[rc][rc];
            for (int j=0; j<rc; j++){
                for (int k=0; k<rc ; k++){
                    mat[j][k]=in.nextInt();
                }
            }
            int trace=0;
            for(int j=0; j<rc; j++) trace+=mat[j+1][j+1];
            int contaCol=0, contaRig=0;
            for(int j=0; j<rc; j++){
                boolean trig=false;
                int tmp[]=new int[rc];
                for(int k=0; k<rc; k++){
                    if(!trig&&IntStream.of(mat).anyMatch(x -> x == mat[j][k])){
                        trig=true;
                        contaRig++;
                    }
                }
            }
            for(int j=0; j<rc; j++){
                boolean trig=false;
                int tmp[]=new int[rc];
                for(int k=0; k<rc; k++){
                    if(!trig&&IntStream.of(mat).anyMatch(x -> x == mat[k][j])){
                        trig=true;
                        contaCol++;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + contaRig + " " + contaCol);
        }
      }
    }