import java.util.*;
    import java.io.*;
    public class Solution {
        public static String reverse(String m){
         String w="";
        for(int i=0;i<m.length();i++){
        w=m.charAt(i)+w;
        }
        return w;
        }
        public static String comp(String m){
         String w="";
        for(int i=0;i<m.length();i++){
        if(m.charAt(i)=='0')w=w+"1";
        else w=w+"0";
        }
        return w;
        }
        public static String change(String m,int n){
        Scanner scan = new Scanner(System.in);    
        System.out.println(n);
            char check = scan.next().charAt(0);//0
            
        char a=m.charAt(0);//0
        
        
        if(a==m.charAt(m.length()-1) && a==check){
         int i=0;
        for(i=0;i<m.length()/2;i++){
        if(m.charAt(i)!=m.charAt(m.length()-1-i))break;
        }
        System.out.println(i+n);
        char c = scan.next().charAt(0);    
        if(m.charAt(i)!=c)
         m=reverse(m);
        }
        else if(a==m.charAt(m.length()-1) && a!=check){
        int i=0;
        for(i=0;i<m.length()/2;i++){
        if(m.charAt(i)!=m.charAt(m.length()-1-i))break;
        }
        System.out.println(i+n);
        char c = scan.next().charAt(0);
        m=comp(m);
        
        if(m.charAt(i)==c)
        m=reverse(m);
        }
         
        else if(a!=m.charAt(m.length()-1) && a==check){
        int i=0;
        for(i=0;i<m.length()/2;i++){
        if(m.charAt(i)==m.charAt(m.length()-1-i))break;
        }
        System.out.println(i+n);
        char c = scan.next().charAt(0);
        
        
        if(m.charAt(i)!=c){
        m=reverse(m);
        m=comp(m);
    }
        }
        else if(a!=m.charAt(m.length()-1) && a!=check){
        int i=0;
        for(i=0;i<m.length()/2;i++){
        if(m.charAt(i)==m.charAt(m.length()-1-i))break;
        }
        System.out.println(i+n);
        char c = scan.next().charAt(0);
        
        
        if(m.charAt(i)!=c)
        m=comp(m);
        else m=reverse(m);
    
        
    }
        return m;
        }
      public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt(); 
        int b = in.nextInt();
        for (int i = 1; i <= t; ++i) {
            String Result="";
            if(b==10){
              int count=1;
              while(count<=10){
                System.out.println(count);
                Result=Result+in.next();
                count++;
                }
            System.out.println(Result);
            String check = (in.next()).trim();
            if(check.equals("N"))break;
            
            }
            else if(b==20){
             int count=1;
             int  m=10,n=11;
             
              while(count<=24){
                 
                  if(count%2!=0){
                System.out.println(m);
                m--;
                Result=in.next()+Result;
            }
                else{
                System.out.println(n);
                n++;
                Result=Result+in.next();
            } 
               if(count%10==0) { 
                   Result=change(Result,m+1);
                  
               count=count+2;
            }
            
                count++;
                
                }
              System.out.println(Result);
            String check = (in.next()).trim();
            if(check.equals("N"))break;
            
            }
            else break;
      }
    }
    }