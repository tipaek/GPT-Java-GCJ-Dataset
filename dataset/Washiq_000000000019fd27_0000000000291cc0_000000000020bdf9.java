import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    
    
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        
        for(int v=0;v<t;v++){
        
        int n = in.nextInt();
        
        ArrayList<String> c = new ArrayList();
        
        ArrayList<String> j = new ArrayList();
        
        String ans=""; boolean jh=false;
        
        m:  for(int i=0;i<n;i++){
            
            String k="";
            
            int x = in.nextInt();
            
            int y = in.nextInt();
            
            
            
            k=x+"-"+y;

            if(i==0){
                
                c.add(k);
                ans+='C';
            }
            else{
               
               
                int a=x;
                int b=y;
                
                boolean svr=false;
                for(int l=0;l<c.size();l++){
                     String s1[] = c.get(l).split("-");
                     int a1=Integer.parseInt(s1[0].trim());
                     int b1=Integer.parseInt(s1[1].trim());
                     if(((a1>=b) || (b1<=a)) /*&& (a1!=a && b1!=b) */){
                        
                         svr=true;
                        
 
                     }
                     else{
                         svr=false;break;
                     }   
                }
                if(svr){
                     ans+='C';
                     c.add(k);
                    continue m;
                }
                else if(j.isEmpty()){
                    ans+='J';
                    j.add(k);
                    
                }
                else{
                    
                for(int l=0;l<j.size();l++){
                     String s1[] = j.get(l).split("-");
                     int a1=Integer.parseInt(s1[0].trim());
                     int b1=Integer.parseInt(s1[1].trim());
                     if(((a1>=b) || (b1<=a)) /*&& (a1!=a && b1!=b)*/){
                        
                         svr=true;
                       
                     }
                     else{
                         svr=false;break;
                     }
                }
                if(svr){
                    ans+='J';
                    j.add(k); 
                }
                
                if(!svr){
                   
                    jh=true;
                   
                }
                    
                    
                    
                }
               
                
            }
            
            
        }
        if(!jh){
        if(ans.length()==n)    
        System.out.println("Case #"+(v+1)+": "+ans);
        else System.out.println("Case #"+(v+1)+": "+"IMPOSSIBLE");
        }
        else{
        System.out.println("Case #"+(v+1)+": "+"IMPOSSIBLE");  
        }
        }
    }
    
}
