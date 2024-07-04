import java.util.*;
import java.io.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        int tcs= sc.nextInt();
        for (int x=1; x<=tcs; x++){
            char[] numArr= sc.next().toCharArray();
            int[] array= new int[numArr.length];
            for (int i=0; i<numArr.length; i++){
                array[i]= Integer.parseInt(String.valueOf(numArr[i]));
            }
            String res="";
            int curOpen=0;
            for (int i=0; i<array.length; i++){
                int num= array[i];
                if (num>curOpen){
                    while (num>curOpen){
                        res+="(";
                        curOpen++;
                    }
                }
                if (num<curOpen){
                    while (num<curOpen){
                        res+=")";
                        curOpen--;
                    }
                }
                res+=array[i];
                if (i==array.length-1 && curOpen>0){
                    while (curOpen>0){
                        curOpen--;
                        res+=")";
                    }
                }
            }
            System.out.println("Case #"+x+": "+res);
        }
    }
}
/*
4
2 2 2 2
2 3 2 3
2 2 2 3
2 2 2 2
 */