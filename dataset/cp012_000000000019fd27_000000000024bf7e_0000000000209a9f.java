import java.util.Scanner;

public class Solution{
    private static Scanner sc=new Scanner(System.in);
    static int tn=1;
     
  public static void main (String[] args){
       int test=sc.nextInt();
        sc.nextLine();
         while(test-- > 0){
               solve();
}    
}//main      
  public static void solve(){
     String s=sc.nextLine();
      StringBuilder sb=new StringBuilder();
     char[] chars=s.toCharArray();
        int pairs=0;
         int brackets=0;
           int first=Character.getNumericValue(chars[0]);
       pairs=first;
        brackets=first;
        
            for(int i=0;i<first;i++){
          sb.append('(');
}//loop      

          sb.append(first);
      
           for(int i=1;i<chars.length;i++){
         int d=Character.getNumericValue(chars[i]);
             if(d==pairs){
                sb.append(d);
             }      
            else if(d>pairs){
               int no=d-pairs;
               for(int j=0;j<no;j++){
                sb.append('(');
               brackets++;
             } 
                  sb.append(d);
            }
             else{
                        int no=pairs-d;
                   for(int j=0;j<no;j++){
                      sb.append(')');
                        brackets--;
          } 
               sb.append(d);
           
           }
     pairs=Character.getNumericValue(chars[i]);
}
        while(brackets-- >0){
                    sb.append(')');
        }
    System.out.println("Case #"+(tn++)+": "+sb.toString());          
}  
}