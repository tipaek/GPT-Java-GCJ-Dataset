import java.util.Scanner;



public class Solution {

  
    public static void main(String[] args)  {

       Scanner scan1 = new Scanner(System.in);
            int T =scan1.nextInt();
            scan1.nextLine();
            
            
        for(int t=1; t<=T; t++){
            
             int N =scan1.nextInt();
            scan1.nextLine();
            String [] patron=new String[N];
            int lengh=0;
            int size=0;
            for(int i=0; i<N; i++){
                patron[i]=scan1.nextLine();
              
                if(patron[i].length()>size){
                    size=patron[i].length();
                    lengh=i; 
                }
            }
            
            int count=0;
            
            for(int k=0;k<N; k++){
                 for(int j=1; j<patron[lengh].length(); j++){
                     
                String a=patron[lengh].substring(j);
                if(a.equals(patron[k].substring(1)) && k!=lengh){
                    count++;
                }
            }
         }
            
            if(count==N-1){
                System.out.println("Case #"+t+":"+" "+patron[lengh].substring(1));
            }else{
                 System.out.println("Case #"+t+":"+" *");
            }
        }    
           
            
            
            
            
            scan1.close();
    
        }
    
  
        
    }