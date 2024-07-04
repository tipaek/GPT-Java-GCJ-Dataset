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
                int lastIndx=0;
                for(int k=0; k<rc; k++){
                    if(!trig&&contains(tmp, mat[j][k])){
                        trig=true;
                        contaRig++;
                    } else {
                        tmp[lastIndx]=mat[j][k];
                        lastIndx++;
                    }
                }
            }
            for(int j=0; j<rc; j++){
                boolean trig=false;
                int tmp[]=new int[rc];
                int lastIndx=0;
                for(int k=0; k<rc; k++){
                    if(!trig&&contains(tmp, mat[k][j])){
                        trig=true;
                        contaCol++;
                    } else {
                        tmp[lastIndx]=mat[k][j];
                        lastIndx++;
                    }
                }
            }
            System.out.println("Case #" + i + ": " + trace + " " + contaRig + " " + contaCol);
        }
      }
      static boolean contains(int[] arr, int val){
          for(int var : arr) if(var==val) return true;
          return false;
      }
    }