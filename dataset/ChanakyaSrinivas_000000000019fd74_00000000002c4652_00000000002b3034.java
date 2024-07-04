import java.util.Scanner;

public class Solution {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            System.out.print("Case #"+t+": ");
            int N=sc.nextInt();
            String str[]=new String[N];
            String left="";
            String right="";
            boolean flag=true;
            for(int i=0;i<N;i++){
                str[i]=sc.next();
                int ind=str[i].indexOf('*');
                String temp=str[i].substring(0,ind);
                if(flag){
                    int l=Math.min(temp.length(),left.length());
                    if(temp.substring(0,l).equals(left.substring(0,l)))
                        if(temp.length()<left.length())
                            left=temp;
                        else
                            flag=true;
                    else
                        flag=false;
                }
                temp=str[i].substring(ind+1);
                if(flag){
                    int l=Math.min(temp.length(),right.length());
                    if(temp.substring(temp.length()-l).equals(right.substring(right.length()-l)))
                        if(right.length()<temp.length())
                            right=temp;
                        else
                            flag=true;
                    else
                        flag=false;
                }
            }
            if(flag)
                System.out.println(left+right);
            else
                System.out.println("*");
        }
    }
}
