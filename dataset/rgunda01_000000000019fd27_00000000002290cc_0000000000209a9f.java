import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String args[])throws IOException
    {

        Scanner sc=new Scanner(System.in);

        int T=sc.nextInt();
        sc.nextLine();
        for (int i = 0; i <T; i++) {
            String num=sc.nextLine();
            Stack<Character>fin=new Stack<Character>();
            Stack<Integer>prev=new Stack<Integer>();
            for (int j = 0; j <num.length(); j++) {
                int number=Integer.parseInt(String.valueOf(num.charAt(j)));
                if(prev.isEmpty())
                {
                    for (int k = 0; k <number; k++) {
                        fin.push('(');
                    }
                    prev.push(number);
                }

                else
                {
                    int diff=number-prev.pop();
                    if(diff>=0)
                    {
                        for (int k = 0; k <diff; k++) {
                            fin.push('(');
                        }
                    }
                    else
                    {
                        for (int k = 0; k <Math.abs(diff); k++) {
                            fin.push(')');
                        }
                    }
                }
                fin.push((char)(number+'0'));
                prev.push(number);
                if(j==num.length()-1)
                {
                    for (int k = 0; k <number; k++) {
                        fin.push(')');
                    }
                }
            }
            System.out.print("Case #"+(i+1)+": ");
            for(Character j:fin)
            {
                System.out.print(j);
            }
            System.out.println();
        }

    }
}