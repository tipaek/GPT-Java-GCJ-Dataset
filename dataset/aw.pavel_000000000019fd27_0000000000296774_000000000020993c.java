import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(
            new BufferedReader(new InputStreamReader(System.in)));
        byte t = scanner.nextByte();
        byte [][][] cases = new byte[t][][];
        byte index1, index2, index3, index4, flag, n = 0;
        for (index1 = 0; index1 < t ; index1++) {
            n = scanner.nextByte();
            cases[index1] = new byte[n][n];
            for (index2 = 0; index2 < n; index2++) {
                for(index3 = 0; index3 < n; index3++) {
                    cases[index1][index2][index3] = scanner.nextByte();
                }
            }
        }
        short trace = 0;
        byte curLength = 0, rows = 0, cols = 0;
        for(index1 = 0; index1 < t; index1++) {
            System.out.print("Case #"+(index1+1)+": ");
            trace = 0;
            curLength = (byte) cases[index1][0].length;
            for(index2 = 0; index2 < curLength; index2++)
                trace += cases[index1][index2][index2];
            System.out.print(trace+" ");
            
            rows = 0;
            cols = 0;
            
            for(index2 = 0; index2 < curLength; index2++) {
                flag = 0;
                for(index3 = 0; index3< curLength - 1; index3 ++) {
                    for(index4 = (byte)(index3+1); index4 < curLength; index4++)
                        if(cases[index1][index2][index4] == 
                            cases[index1][index2][index3]) {
                            rows++;
                            flag = 1;
                            break;
                        }
                    if (flag == 1) break;
                }
            }
            System.out.print(rows+" ");
            for(index3 = 0; index3 < curLength; index3++) {
                flag = 0;
                for(index2 = 0; index2< curLength-1; index2 ++) {
                    for(index4 = ((byte)(index2+1)); index4 < curLength; index4++)
                        if(cases[index1][index4][index3] == 
                            cases[index1][index2][index3]) {
                            cols++;
                            flag = 1;
                            break;
                        }
                    if (flag == 1) break;
                }
            }
            System.out.println(cols);
        }
        
    }
}