

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
	// write your code here
        Scanner s=new Scanner(System.in);
        int test=s.nextInt();
        for (int i = 0; i <test ; i++) {
        String str=s.next();
        int size=str.length();

        int[] array=new int[size];
        String str1="";
        String str2="";
        for (int j = 0; j <size ; j++) {
            str1=str.substring(j,j+1);
            array[j]=Integer.parseInt(str1);
            if(size==1){
                for (int k = 0; k <array[j] ; k++) {
                    str2=str2+"(";
                }
                str2=str2+array[j];
                for (int k = 0; k <array[j] ; k++) {
                    str2=str2+")";

                }
            }
            else if(j==size-1){
                if(array[j]-array[j-1]>=0){
                    for (int k = 0; k <array[j]-array[j-1] ; k++) {
                        str2=str2+"(";

                    }

                }

                else if (array[j]-array[j-1]<0){

                    for (int k = 0; k <array[j-1]-array[j] ; k++) {
                        str2=str2+")";
                    }


                }
                str2=str2+array[j];
                for (int k = 0; k <array[j] ; k++) {
                    str2=str2+")";
                }
            }

          else   if(j==0){
                 for (int k = 0; k <array[j] ; k++) {
                     str2=str2+"(";
                 }
                 str2=str2+array[j];
             }
            else if(array[j]-array[j-1]>=0){
                 for (int k = 0; k <array[j]-array[j-1] ; k++) {
                 str2=str2+"(";

                 }
                str2=str2+array[j];
                 }

                else if (array[j]-array[j-1]<0){

                    for (int k = 0; k <array[j-1]-array[j] ; k++) {
                        str2=str2+")";
                    }
                 str2=str2+array[j];

                }
                }
        int c=i+1;
            System.out.println("Case #"+c+": "+str2);



        }

    }
}
