import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Nesting {
    public static void main(String[] args) {
        //insert code here
        Scanner sc=new Scanner(System.in);
    int  t=sc.nextInt();
    for(int x=1;x<=t;x++){
    String s=sc.next();
    String op="";
    int a[]=new int[s.length()+2];
    a[0]=0;
    a[s.length()+1]=0;
     for(int i=0;i<s.length();i++){
         a[i+1]=Integer.parseInt(s.valueOf(s.charAt(i)));
     }
     for(int i=1;i<=s.length()+1;i++){
         int d=a[i]-a[i-1];
         int ad=Math.abs(d);
         String c;
         if(d>0)
             c="(";
         else
             c=")";
         for(int j=0;j<ad;j++){
             op+=c;
         }
         op+=Integer.toString(a[i]);
     }
     int l=op.length();
     System.out.println("Case #"+x+": "+op.substring(0,l-1));
    }
    }

}
