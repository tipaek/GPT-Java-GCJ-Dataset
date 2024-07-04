import java.util.Scanner;
 
public class Solution {
    public static void main(String...args){
        Scanner kb = new Scanner(System.in);
        int test = kb.nextInt();
        for (int i = 0; i < test; i++){
            String str = kb.next();
            System.out.print("Case #"+(i+1)+": ");
           
            if (str.length() >1){
            for (int j = 0; j < str.length(); j++){
            int a = str.charAt(j)-'0';
                if(j==0){
                    while(a!=0){
                        System.out.print("("); 
                        a--;
                    }
                    System.out.print(str.charAt(j)); 
                    int b = str.charAt(j+1)-'0';
                    a = str.charAt(j)-'0';
                    int c = b-a;
                   if(c<0){
                        while(c<0){
                        System.out.print(")"); 
                        c++;
                        }
                    }
                } 
                else if(j!=str.length()-1){
                    a = str.charAt(j)-'0';
                    int b = str.charAt(j-1)-'0';
                    
                    int c = (a-b);
                    while(c>0){
                        System.out.print("("); 
                        c--;
                    }
                    System.out.print(str.charAt(j)); 
                    b = str.charAt(j+1)-'0';
                    c = b-a;
                   if(c<0){
                        while(c<0){
                        System.out.print(")"); 
                        c++;
                        }
                    }
                }else{
                    a = str.charAt(j)-'0';
                    int b = str.charAt(j-1)-'0';
                    
                    int c = (a-b);
                    while(c>0){
                        System.out.print("("); 
                        c--;
                    }
                    System.out.print(str.charAt(j)); 
                    
                    while(a>0){
                        System.out.print(")"); 
                        a--;
                    }
                }
            
            }
        }
        else{
            int ab = str.charAt(0)-'0';
            while(ab>0){
                System.out.print("("); 
                        ab--;
            }
            ab = str.charAt(0)-'0';
            System.out.print(ab);
            while(ab>0){
                System.out.print(")"); 
                        ab--;
            }
        }
          if(i != t-1){
            System.out.println();
        }
        }
        
    }
}