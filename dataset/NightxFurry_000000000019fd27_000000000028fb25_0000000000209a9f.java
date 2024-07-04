import java.util.Scanner;
public class Main{

    /**
     * @param args the command line arguments
     */
     public static void main(String[] args) {
          try{
         Scanner sc=new Scanner(System.in);
         int t=sc.nextInt();
         int n=t;
         while(t--!=0){
           String str=sc.next();
           
           int[] arr=new int[str.length()];
           arr[0]=(int)str.charAt(0)-48;
             
           for(int i=1;i<str.length();i++){
               arr[i]=((int)str.charAt(i)-48);
               
           }
             
           int c=arr[0];
             System.out.print("Case #"+(n-t)+": " );
           while(c!=0){
               System.out.print("(");
               c--;
           }
             System.out.print(arr[0]);
           for(int i=1;i<str.length();i++){
               if(arr[i]-arr[i-1]>0){
                   c=arr[i]-arr[i-1];
                   //System.out.println(c);
                   while(c!=0){
                       System.out.print("(");
                       c--;
                   }
                   System.out.print(arr[i]);
               }
               else if(arr[i]-arr[i-1]==0)
                   System.out.print(arr[i]);
               else{
                   c=arr[i-1]-arr[i];
                   while(c!=0){
                       System.out.print(")");
                       c--;
                   }
                   System.out.print(arr[i]);
               }
                   
           }
           c=arr[str.length()-1];
            //System.out.print(arr[str.length()-1]);
           while(c!=0){
              c--;
               System.out.print(")");
           }
                   
             
         }
        }
        catch(Exception e){
            return;
        }
     }
     }

