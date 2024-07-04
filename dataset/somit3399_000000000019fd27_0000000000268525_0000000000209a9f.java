import java.util.Scanner;
 
public class Solution {
    public static void main(String...args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++){
            String s = scan.next();
            System.out.print("Case #"+(i+1)+": ");
            if (s.length() >1){
            for (int j = 0; j < s.length(); j++){
            int a = s.charAt(j)-'0';
                if(j==0){
                    while(a!=0){
                        System.out.print("("); 
                        a--;
                    }
                    System.out.print(s.charAt(j)); 
                    int b = s.charAt(j+1)-'0';
                    a = s.charAt(j)-'0';
                    int c = b-a;
                   if(c<0){
                        while(c<0){
                        System.out.print(")"); 
                        c++;
                        }
                    }
                } 
                else if(j!=s.length()-1){
                    a = s.charAt(j)-'0';
                    int b = s.charAt(j-1)-'0';
                    
                    int c = (a-b);
                    while(c>0){
                        System.out.print("("); 
                        c--;
                    }
                    System.out.print(s.charAt(j)); 
                    b = s.charAt(j+1)-'0';
                    c = b-a;
                   if(c<0){
                        while(c<0){
                        System.out.print(")"); 
                        c++;
                        }
                    }
                }else{
                    a = s.charAt(j)-'0';
                    int b = s.charAt(j-1)-'0';
                    
                    int c = (a-b);
                    while(c>0){
                        System.out.print("("); 
                        c--;
                    }
                    System.out.print(s.charAt(j)); 
                    
                    while(a>0){
                        System.out.print(")"); 
                        a--;
                    }
                }
            
            }
        }
        else{
            int a = s.charAt(0)-'0';
            while(a>0){
                System.out.print("("); 
                        a--;
            }
            a = s.charAt(0)-'0';
            System.out.print(a);
            while(a>0){
                System.out.print(")"); 
                        a--;
            }
        }
        if(i != t-1){
            System.out.println();
        }
        }
        
    }
}