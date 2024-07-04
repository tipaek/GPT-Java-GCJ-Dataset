import java.io.*;
import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=1;i<=t;i++){
            int size = sc.nextInt();
            int mat[][] = new int[size][size];
            
            for(int j=0;j<size;j++){
                for(int k=0;k<size;k++){
                    mat[i][j] = sc.nextInt();
                }
            }
            int traceValue = findValue(mat,size);
            int rowValue = copyRowData(mat,size);
            int colValue = copyColData(mat,size);
            System.out.println("Case #"+i+ ":"+" "+traceValue+ " "+rowValue+" "+colValue);
        }
    }
    
    public static int findValue(int arr[][], int size){
        int sum = 0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(i==j){
                    sum = sum + arr[i][j];
                }
            }
        }
        return sum;
    }
    
    public static int copyRowData(int arr[][], int size){
        Hashtable<Integer,Integer> hashData = new HashTable<>();
        int count = 0;
        for(int i=0;i<size;i++){
            int row[] = arr[i];
            for(int j=0;j<row.length;j++){
                if(hashData.containsKey(row[j])){
                    count++;
                    break;
                } else{
                    hashData.put(row[j],1);
                }
            }
            hashData.clear();
        }
        return count;
    }
    
    public static int copyColData(int arr[][], int size){
        HashTable<Integer,Integer> hashData = new HashTable<>();
        int count = 0;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                int element = arr[j][i];
                if(hashData.containsKey(element)){
                    count++;
                    break;
                } else{
                    hashData.put(element,1);
                }
            }
            return count;
        }
    }
}