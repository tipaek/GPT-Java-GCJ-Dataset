import java.util.Scanner;
import java.util.Arrays;
import java.lang.String;
class Main{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int z=0;
        while(t!=z){
            int n=sc.nextInt();
            
            String str[]=new String[n];
            for(int i=0;i<n;i++)
                str[i]=sc.next();
            String ans=str[0].substring(1,str[0].length());
            for(int i=1;i<n;i++){
                if(str[i].length()>ans.length()){
                    int a=str[i].length()-ans.length();
                    String m1=str[i].substring(a+1,str[i].length()-1);
                    String m2=ans.substring(1,ans.length()-1);
                    if(m1.equals(m2))
                        ans=str[i].substring(1,str[i].length());
                }
                else{
                    int a=ans.length()-str[i].length();
                    String m1=ans.substring(a+1,ans.length()-1);
                    String m2=str[i].substring(1,str[i].length()-1);
                    if(m1.equals(m2))
                        ans=ans.substring(0,ans.length());   
                }
           
            }
            z++;
            System.out.println("Case #"+z+": "+ans);
        }
    }
}