import java.util.Scanner;
public class Solution {
    
    
    
    public static void main(String args[]){
        
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
       
        //char arr[]=input.toCharArray();
        for(int c=0;c<t;c++){
        String input=sc.next();
        String ans="";
        
        for(int i =0; i<input.length(); i++){
            int digit=Integer.parseInt(String.valueOf(input.charAt(i)));
            for(int j=0;j<digit;j++){
                ans+="(";
            }
            
            ans+=input.charAt(i);
            
            for(int j=0;j<digit;j++){
                ans+=")";
            }
        }
        
        ans=ans.replace(")(", "\0");
        
        System.out.println("Case #"+(c+1)+": "+ans);
        
        }
    }
}