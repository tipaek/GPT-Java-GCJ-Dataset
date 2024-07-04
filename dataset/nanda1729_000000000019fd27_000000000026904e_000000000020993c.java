import java.util.*;

public class Solution {

public static boolean isDuplicateArray(int arr[]) {
    int n = arr.length;
    int matrix[] = new int[n];
    for(int i=0;i< n;i++) {
        matrix[i]= 0;
    }
    
    for(int i=0;i<n;i++) {
        int count = matrix[arr[i]-1];
        if(count >= 1) {
            return true;
        }
        matrix[arr[i]-1] += 1;
    }
    
    return false;
}

public static void findDuplicateRows(int matrix[][]) {
    int n = matrix.length;
    int countOfRows = 0;
    for(int i=0;i<n;i++) {
        if(isDuplicateArray(matrix[i])) {
            countOfRows += 1;
        }
    }
    int countOfColumns = 0;
    int arr[] = new int[n];
    for(int i=0;i<n;i++) {
        for(int j=0;j <n ;j++) {
            arr[j] = matrix[j][i];
        }
        if(isDuplicateArray(arr)) {
            countOfColumns += 1;
        }
    }
    
    System.out.println(countOfRows + " " + countOfColumns);
    
    
}



public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);
    int T = scan.nextInt();
    int start = 0;
    while(start < T) {
        int n = scan.nextInt();
        int matrix[][]  = new int[n][n];
        for (int i=0; i< n;i++) {
            for(int j=0;j<n;j++) {
                matrix[i][j] = scan.nextInt(); 
            }
        }
        
        int trace = 0;
        for (int i=0; i< n;i++) {
            trace = trace+ matrix[i][i];
        }
        System.out.print(trace + " ");
        findDuplicateRows(matrix);
        start++;
    }
    
}

}
