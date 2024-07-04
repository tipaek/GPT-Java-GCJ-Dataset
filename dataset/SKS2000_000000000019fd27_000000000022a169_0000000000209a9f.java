import javax.swing.*;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int T,N;
        Scanner sc=new Scanner(System.in);
        T=sc.nextInt();
        while(T-->0){
        String str=sc.nextLine();
        StringBuilder res = new StringBuilder();
        for(int i=str.length()-1;i>=0;i--)
        {
            if(str.charAt(i)=='0')
            System.out.print(0);
            else if(str.charAt(i)=='1')
                   System.out.print("("+1+")");
        }
        System.out.println();


        }
    }
}
