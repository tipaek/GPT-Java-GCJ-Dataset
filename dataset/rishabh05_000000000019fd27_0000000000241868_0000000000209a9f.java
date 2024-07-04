import java.io.*;
import java.util.*;
public class Solution
{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        for(int z=1;z<=t;z++){
            String str=sc.nextLine();
            String res="";
            int nest=0,pos=-1;
            for(int i=0;i<str.length();i++){
                int n=Character.getNumericValue(str.charAt(i));
                if(n>=nest){
                    String tmp="";
                    for(int j=1;j<=n-nest;j++) tmp+="(";
                    tmp+=n;
                    for(int j=1;j<=n-nest;j++) tmp+=")";
                    res=new StringBuffer(res).insert(pos+1,tmp).toString();
                    pos=pos+1+n-nest;
                }
                else{
                    res=new StringBuffer(res).insert(pos+1+nest-n,Integer.toString(n)).toString();
                    pos=pos+1+nest-n;
                }
                nest=n;
            }
            System.out.print("Case #"+z+": "+res);
            System.out.println();
        }
    }
}