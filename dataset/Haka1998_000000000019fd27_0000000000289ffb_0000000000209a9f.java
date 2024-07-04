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
            y="";
            String check1 = "";
            String check0 = "";
            if(ch.length==1){
                if(ch[0]=='1'){
                        y +="(1)";
                }else{
                    y +="0";    
                }
                    
            }else{
               for(int k = 0; k <ch.length;k++){
                    if(k == ch.length-1){
                        if(ch[k]=='1'){
                            check1+= "1";
                            y+="("+check1+") ";
                            check1="";
                        }else{
                            check0+= "0";
                            y+=check0+" ";
                            check0="";
                        }

                    }else{
                        if(ch[k]=='1'){
                            if(ch[k+1]=='1'){
                                check1+= "1";
                            }else{
                                check1+= "1";
                                y+="("+check1+") ";
                                check1="";
                            }
                        }else{
                            if(ch[k+1]=='0'){
                                check0+= "0";
                            }else{
                                check0+= "0";
                                y+=check0+" ";
                                check0="";
                            }
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