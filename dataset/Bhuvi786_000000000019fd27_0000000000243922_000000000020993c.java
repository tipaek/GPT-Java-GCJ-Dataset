import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
	// write your code here
        Scanner s=new Scanner(System.in);
        int test=s.nextInt();
        for (int i = 0; i <test ; i++) {
            int size=s.nextInt();
            int[][] array=new int[size][size];
            int sum=0;

            for (int j = 0; j <size ; j++) {
                for (int k = 0; k <size; k++) {
                    array[j][k]=s.nextInt();
                    if(i==k){
                        sum=sum+array[j][k];

                    }
                }
            }
            int ref=(size)*(size+1)/2;
            int sum1=0;
            int sum2=0;
            int count1=0;
            int count2=0;
            for (int j = 0; j <size ; j++) {
                List<Integer> l = new ArrayList<>();
                for (int k = 0; k < size; k++) {
                    l.add(array[j][k]);
                }
                for (int k = 1; k <size+1 ; k++) {
                    if(!(l.contains(k))){
                        count1=count1+1;
                    break;

                }
            }}
            for (int j = 0; j <size ; j++) {
                List<Integer> l = new ArrayList<>();
                for (int k = 0; k < size; k++) {
                    l.add(array[k][j]);
                }
                for (int k = 1; k <size+1 ; k++) {
                    if(!(l.contains(k))){
                        count2=count2+1;

                        break;

                    }
                }}

            System.out.println("Case #"+i+": "+sum+" "+count1+" "+count2);


    }
}}
