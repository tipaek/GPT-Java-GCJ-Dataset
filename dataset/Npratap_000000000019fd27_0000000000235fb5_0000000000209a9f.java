import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String n1 = sc.nextLine();
        int n = Integer.parseInt(n1);
        mainloop:
        for(int i=1;i<=n;i++){
            String line = sc.nextLine();
            line = line.trim();
            int l = line.length();
            int[] arr = new int[l];
            int[] darr = new int[l];
            int c=0;
            for(String s : line.split("")){
            arr[c] = Integer.parseInt(s);
            darr[c] = Integer.parseInt(s);
            c= c+1;             
            }
            
            int flag=0;
            for(int f=0;f<l;f++){
            if(arr[f]!=0)
                flag=1;
            }
            if(flag==0){
            System.out.println("Case #"+i+": "+line);
            continue mainloop;
            }
            int sum=1000;
            
            while(sum!=0){
            int sta=0;
            
            
            for(int j=0;j<l;j++){
            if(darr[j]>0){
               sta=j;
                break;
            }
            
            }
            int stp =sta;
            for(int j=sta;j<l;j++){
            if(darr[j]>0){
               stp = j;
                
            }
            if(darr[j]==0){
               stp = j-1;
               break; 
            }
            
            }
            
            int a=0 ,b=0;
            
        
            
            int co=0;
            
            int r=0;
            for(int p=0;p<line.length();p++){
            if(line.substring(p, p+1).equals("(") || line.substring(p, p+1).equals(")") ){
            co = co + 1;
            }
            else{
                if(r==sta){
                a = co + r; 
                }
                if(r==stp){
                b = co + r; 
                }
                r=r+1;
            }
            }
            
            
            
            int l1 =line.length();
            if(b+1<l1 && a>0)
            line = line.substring(0, a) + "(" + line.substring(a, b+1) + ")"+ line.substring(b+1);
            if(b+1>=l1 && a>0)
            line = line.substring(0, a) + "(" + line.substring(a, b+1) + ")";
            if(b+1<l1 && a<=0)
            line = "(" + line.substring(a, b+1) + ")"+ line.substring(b+1);
            if(b+1>=l1 && a<=0)
            line = "(" + line.substring(a, b+1) + ")";
            for(int j=sta;j<=stp;j++){
            darr[j] = darr[j] -1;                
            }
            sum=0;
            for(int j=0;j<l;j++){
                
            sum = sum + darr[j];                
            }
            
        }
            
            System.out.println("Case #"+i+": "+line);
            
            
            
           
            
        }
    }
   
    
  
}
