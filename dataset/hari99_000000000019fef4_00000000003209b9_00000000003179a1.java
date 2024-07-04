import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int tst=sc.nextInt();
        for(int t=1;t<=tst;t++){
            int u=sc.nextInt();
            long arr[][]=new long[26][10];
            for(int xn=0;xn<Math.pow(10,4);xn++){
            String q=sc.next();
            String s=sc.next();
            for(int i=0;i<Math.min(s.length(),q.length());i++){
                arr[s.charAt(i)-'A'][q.charAt(i)-'0']++;
            }
            }
            char ans[]=new char[10];
            for(int i=0;i<26;i++){
                long max=0;
                int no=-1;
                for(int j=0;j<10;j++){
                    if(arr[i][j]>max){
                        max=arr[i][j];
                        no=j;
                    }
                }
                if(max==0)
                continue;
                
                ans[no]=(char)(i+65);
            }
            
            String answer="";
            for(char ch:ans){
                answer+=Character.toString(ch);
            }
            System.out.println("Case #"+t+": "+answer);
        }
    }
}