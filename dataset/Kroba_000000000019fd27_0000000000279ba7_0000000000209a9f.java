/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author aleks
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int x=0;x<t;x++){
            int opened=0;
            int lastNum=0;
            String input2="";
            String input=sc.next();
            for(char c:input.toCharArray()){
                int tmpNum=Character.getNumericValue(c);
                if(opened==0){
                    while(opened!=tmpNum){
                        opened++;
                        input2+="(";
                    }
                    input2+=c;
                    lastNum=tmpNum;
                }else if(lastNum==tmpNum){
                    input2+=c;
                }else if(lastNum<tmpNum){
                    for(int i=opened;i<(opened+(tmpNum-lastNum));i++){
                        input2+="(";
                    }
                    opened+=(tmpNum-lastNum);
                    lastNum=tmpNum;
                    input2+=c;
                }else{
                    for(int i=opened;i>(opened+(tmpNum-lastNum));i--){
                        input2+=")";
                    }
                    opened+=(tmpNum-lastNum);
                    lastNum=tmpNum;
                    input2+=c;
                }
            }
            while(opened!=0){
                opened--;
                input2+=")";
            }
            System.out.println("Case #"+(x+1)+": "+input2);
            
        }
    }
    
    
}
