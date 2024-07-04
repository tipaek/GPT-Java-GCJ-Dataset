import java.io.*;
import java.util.*;

class Solution {
    //the sum of the values on the main diagonal 
    //runs from the upper left to the lower right 
    
    //compute the number of rows and the number of 
    //columns that contain repeated values 
    
    //input: 
    //output is where x is the test case number(starting from 1 
    // k is the trace is the matrix 
    // r is the number of rows that have repeated e
    // c is the number of columns have repeated e 
    
    public static void main(String args[]){
        
       Scanner sc = new Scannner(System.in);
        int T = sc.nextInt(); 
        for(int w = 1; w<= T; w++){
            int size = sc.nextInt();
            int matrix[][] = new int[size][size];
          //iterate through the matrix   
        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        int k = trace(matrix, size);
        int r = rowDuplicates(matrix, size);
        int c = columnDuplicates(matrix, size);
        //print the first case 
        System.out.println("Case #" + w + ":" + " " + k + " " + r + " " + c);
        
    }
}
 
public static int trace(int arr[][], int size){
    int sum = 0; 
    for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++){
            if(i==j)
            sum = sum + arr[i][j];
        }
    }
    return sum; 
}

public static int rowDuplicates(int arr[][], int size){
    Hashtable<Integer, Integer> hash = new Hashtable<>();
    int count = 0; 
    for(int i = 0; i < size; i++){
        int row[] = arr[i];
        for(int j = 0; j < row.length; j++){
            if(hash.containsKey(row[j])){
                count ++; 
                break; 
                
            }
            else{
                hash.put(row[j],1);
            }
        }
        hash.clear();
    }
    return count; 
}

public static int columnDuplicates(int arr[][], int size){
    Hashtable<Integer, Integer> hash = new Hashtable<>(); 
    int count = 0; 
    for(int i = 0; i < size; i++){
        for(int j = 0; j < size; j++){
            int current = arr[j][i];
            if(hash.containsKey(current)){
                count++;
                break; 
            } else{
                hash.put(current, 1);
            }
        }
        hash.clear();
    }
    return count; 
    }
}
    
    
    
    
