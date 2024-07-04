import java.util.Scanner;
public class Solution {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int k=1;k<=t;k++){
            String s=sc.next();
            String o="";
            int f=0;
            int n=s.length();
            for(int i=0;i<n;i++){
                if(s.charAt(i)=='0'){
                    if(f==1){
                        o+=')';
                        f=0;
                    }
                }else{
                    if(f==0){
                        o+='(';
                        f=1;
                    }
                }
                o+=s.charAt(i);
            }
            if(f==1){
                o+=')';
                f=0;
            }
            System.out.println("Case #"+k+": "+o);
        }
    }
}