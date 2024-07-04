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
            String output="";
            String check1 = "";
            String check0 = "";
            System.out.println(y);
            if(y.length()==1){
                if(y.charAt(0)=='1'){
                        output +="(1)";
                }else{
                    output +="0";    
                }
                    
            }else{
               for(int k = 0; k < y.length(); k++){
                    if(k == y.length()-1){
                        if(y.charAt(k)=='1'){
                            check1+= "1";
                            output+="("+check1+") ";
                            check1="";
                        }else{
                            check0+= "0";
                            output+=check0+" ";
                            check0="";
                        }

                    }else{
                        if(y.charAt(k)=='1'){
                            if(y.charAt(k+1)=='1'){
                                check1+= "1";
                            }else{
                                check1+= "1";
                                output+="("+check1+") ";
                                check1="";
                            }
                        }else{
                            if(y.charAt(k+1)=='0'){
                                check0+= "0";
                            }else{
                                check0+= "0";
                                output+=check0+" ";
                                check0="";
                            }
                        }
                    }
               }
            }
            
            newY.add(output);
            
            
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