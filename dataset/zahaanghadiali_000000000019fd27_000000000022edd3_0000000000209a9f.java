import java.util.Scanner;
public class Solution {
    
    
    public static void main(String args[]){
        
        Scanner sc= new Scanner(System.in);
        int t=sc.nextInt();
        
        String input[]=new String[t];
        String print[]=new String[t];
        
        for(int i=0;i<t;i++){
            input[i]=sc.next();
        }
        
        for(int c=0;c<t;c++){
        String ans="";
        
        for(int i =0; i<input[c].length(); i++){
            int digit=Integer.parseInt(String.valueOf(input[c].charAt(i)));
            for(int j=0;j<digit;j++){
                ans+="(";
            }
            
            ans+=input[c].charAt(i);
            
            for(int j=0;j<digit;j++){
                ans+=")";
            }
        }
        
        ans=ans.replace(")(", "\0");
        
        print[c]=ans;
        }
        
        for(int i=0;i<t;i++){
            System.out.println("Case #"+(i+1)+": "+print[i]);
        }
    }
}