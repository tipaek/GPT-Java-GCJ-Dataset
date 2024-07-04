import java.lang.*;
import static java.lang.Math.*;
import static java.math.BigInteger.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import java.math.*;
import java.util.*;
import java.io.*;


public class Vestigium{
    
    public static void main(String[]args){ new Vestigium.run(); }
        
    void run(){
        
        int numberOfTests;
        
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input = in.readLine();
        
        numberOfTests = Integer.parseInt(input);
        int trace;
        int matrixSize;
        String zeileMatrix;
        
        for(int i=1; i <= numberOfTests; i++){
            
            trace = 0;
            matrixSize = Integer.parseInt(in.readLine());
            int[][] matrix = new int[matrixSize][matrixSize];
            
            for(int j = 0 ; j < matrixsize; j++){
                
                zeileMatrix = in.readLine();
                
                String[] numbers = zeileMatrix.split("\\s+");
                
                int[] answer = new int[numbers.length];
                
                for (int i = 0; i < numbers.length; i++)
                    answer[i] = Integer.parseInt(numbers[i]);
                    
                matrix[j] = answer;
                
            }
            
            for(int k=0 ; k < matrixSize; k++)
                trace += matrix[k][k];
                
            
            int fehlerSpalte = 0;
            int fehlerZeile = 0;
            
            for(int l=0; l<matrixSize; l++){
                
                boolean [] test = new boolean[matrixSize];
                boolean [] test2 = new boolean[matrixSize];
                
                
                for(int m=0; m<matrixSize; m++){
                
                    test[matrix[l][m]-1] = true;
                    test2[matrix[m][l]-1] = true;
                }
                
                boolean spalte = true;
                boolean zeile = true;
                
                for(int n=0; n<matrixSize; n++){
                    if(!test[n])
                        zeile = false;
                    if(!test2[n])
                        spalte = false;
                }
                
                if(!zeile)
                    fehlerZeile++;
                if(!spalte)
                    fehlerSpalte++;
                    
                
            }
            
            
            System.out.println("Case #" + i + ": " + trace + " " + fehlerZeile + " " + fehlerSpalte);    
            
            
            
        }

    }    
        
}
