import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String args[])throws IOException
    {
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for (int i = 0; i <T; i++) {
             int N=sc.nextInt();
             String fin="";
             sc.nextLine();
             int max=0;
             String[]lines=new String[N];
            for (int j = 0; j <N; j++) {
                String k=sc.nextLine();
                lines[j]=k.substring(1);
                if(lines[j].length()>max) {
                    max = lines[j].length();
                    fin=lines[j];
                }
            }
            boolean a=true;
            for (int j = 0; j <N; j++) {
                if(fin.indexOf(lines[j])==-1)
                {
                    a=false;
                    break;
                }
            }
            if(a)
                System.out.println("Case #"+(i+1)+": "+fin);
            else
                System.out.println("Case #"+(i+1)+": *");
        }
    }

}
