import java.util.Scanner;
public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();
        int bits = sc.nextInt();
        int[] bitArray =  new int[bits];
        for(int i = 0; i<bits; i++){
            bitArray[i] = 0;
        }
        if(bits==10){
            for(int i = 0; i<10; i++){
                System.out.println(i+1);
                bitArray[i] = sc.nextInt();
            }
            for(int i = 0; i<10; i++){
                System.out.print(bitArray[i]);
            }
            System.out.println();
        }
    }
    
    
    /*public int[] complement(int n, int[] array){
        for(int i = 0; i<n; i++){
            if(array[i] == 0)
                array[i] = 1;
            else
                array[i] = 0;
        }
        return array;
    }
    
    public int[] reverse(int n, int[] array){
        for(int i = 0; i<n/2; i++){
            int temp = array[i];
            array[i] = array[n-i-1];
            array[n-i-1] = temp;
        }
        return array;
    }*/
}