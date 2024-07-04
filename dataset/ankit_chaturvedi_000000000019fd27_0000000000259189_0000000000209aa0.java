import java.util.Arrays;
import java.util.Random;
import java.io.*;
import java.lang.*;
import java.util.*;

class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        int count  =1;
        StringBuffer sbuf = new StringBuffer();
        while(t-->0){
            String[] nk = br.readLine().trim().split("\\s+");
            int n =  Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

         int size = n;

        
        int[][] matrix= new int[size][];

        ArrayList<Integer> list=  new ArrayList<>();
        
        boolean flag = false;
        if(n>k){
            sbuf.append("Case #"+count+": "+"IMPOSSIBLE");
            count++;
            continue;
        }




        for(int p=0;p<7000;p++){
            
        matrix[0] = MatrixOps.createOrderedArray(size, 1);

        
        for(int x=0; x < size; x++) {
            matrix[x] = MatrixOps.createOrderedArray(size, 1);
            do {
                MatrixOps.shuffle(matrix[x]);
            } while(! MatrixOps.compare2DArray(matrix[x], matrix, 0, x));
        }
        //MatrixOps.print(matrix);
        //System.out.println();
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += matrix[i][i];
        }
        if(sum==k){
           flag = true;
            break;
        }
    
    }

    if(flag==true){
        sbuf.append("Case #"+count+": "+"POSSIBLE"+"\n");
        for(int j=0;j<n;j++){
            for(int w=0;w<n;w++)
            sbuf.append(matrix[j][w]+" ");
            sbuf.append("\n");
        }
    }
    else
    sbuf.append("Case #"+count+": "+"IMPOSSIBLE"+"\n");
    
    count++;
    
    }
    System.out.println(sbuf);
}

}

class MatrixOps {

    public static void shuffle(int[] arr){
        Random random = new Random();
        for(int x = 0; x < arr.length; x++)
            swap(arr, x, random.nextInt(arr.length));
    }

    public static int[] createOrderedArray(int size, int startValue) {
        int[] num = new int[size];
        for (int x = 0; x < num.length; x++)
            num[x] = x + startValue;
        return num;
    }

    public static boolean compare2DArray(int[] arr1, int[][] arr2, int begin, int end) {
        for (int x = begin; x < end; x++)
            if (!compareArray(arr1, arr2[x]))
                return false;
        return true;
    }

    
    public static void print(int[][] array) {
        for (int[] x: array) {
            for (int y: x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    private static boolean compareArray(int[] arr1, int[] arr2){
        if(arr1.length != arr2.length)
            return false;
        for(int x=0; x<arr1.length; x++)
            if(arr1[x] == arr2[x])
                return false;
        return true;
    }

    private static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}