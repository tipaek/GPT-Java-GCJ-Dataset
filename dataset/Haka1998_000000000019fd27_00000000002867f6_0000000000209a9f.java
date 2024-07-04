package javaapplication20;

import java.util.ArrayList;

import java.util.Scanner;


/**
 *
 * @author ASUS
 */
public class Solution{
    
        

    public static void run(){
        Scanner sc = new Scanner(System.in);
        int Case = sc.nextInt();
        ArrayList<String> newY=new ArrayList<>();
        for( int i=0 ; i < Case ; i++ ){       
            String y=sc.next();
            char[] ch = y.toCharArray();
            boolean check=false;
            boolean last1=false;
            y="";
            
            for(int k = 0; k <ch.length;k++){
                if(ch[k]=='1'){
                    if(check==false){
                        
                        if(k==ch.length-1){
                            y+="(1)";
                        }else{
                            if(ch[k+1]=='1'){
                                y+="(1";
                                check = true;
                            }else{
                                y+="(1) ";
                            }
                        }
                        
                    }else{
                        if(k==ch.length-1){
                           y+="1) ";
                        }else{
                           if(ch[k+1]=='1'){
                            y+="1";
                            }else{
                            y+="1) ";
                            } 
                        }
                    }
                }else{
                    if(k==ch.length-1){
                        y+="0";
                    }else{
                        if(ch[k+1]=='0'){
                        y+="0";     
                    }else{
                        y+="0 ";
                    }
                    }
                }
            }
            newY.add(y);
            
            
        }
        for(int i=0;i<newY.size();i++){
            System.out.println("Case #"+(i+1)+": "+newY.get(i));
        }
        
        
        
        
       
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           run();
    }
    
}