import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution{
    public static void main(String args[]){
        
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();
        sc.nextLine();
        int count = 0;
        while(t-->0){
            String ip = sc.nextLine();
            String op = "";
            int length = ip.length();
            for(int iCounter=0;iCounter<(ip.charAt(0)-48);iCounter++){
                op+='(';
            }
            for(int iCounter=0; iCounter<length-1; iCounter++){
                int temp = Math.abs(ip.charAt(iCounter) - ip.charAt(iCounter+1));
                op+=ip.charAt(iCounter);
                if(ip.charAt(iCounter)>ip.charAt(iCounter+1))
                {
                    for(int i=0;i<temp;i++){
                        op += ')';
                    }
                }   
                else if(ip.charAt(iCounter)<ip.charAt(iCounter+1))
                {
                    for(int i=0;i<temp;i++){
                        op += '(';
                    }
                }
            }
            op+=ip.charAt(length-1);
            for(int iCounter=0;iCounter<(ip.charAt(length-1)-48);iCounter++)
            {
                op += ')';
            }
            System.out.println("Case #"+count+": "+op);
        }
    }
}