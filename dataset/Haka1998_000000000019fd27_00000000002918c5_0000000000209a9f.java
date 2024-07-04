import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.Scanner;
import java.util.stream.Collectors;


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
            List<String> myList = new ArrayList<String>(Arrays.asList(y.split("")));
            y="";
            System.out.println(myList);
            if(myList.size()==1){
                if(myList.get(0)=="0"){
                        myList.set(0,"(1)");
                    }
            }else{
                for(int k=0;k<myList.size();k++){
                    System.out.println("k la: ---"+k);
                    
                if(k==myList.size()-1){
                    if(myList.get(k).charAt(0)=='1'){
                        myList.set(k,"1)");
                    }
                }else{
                    
                    if(myList.get(k).charAt(0)=='0'){
                        if(myList.get(k+1).charAt(0)=='1'){
                            myList.add(k+1," (");
                            k++;                 
                        }
                    }else{
                        if(k==0){
                            if(myList.get(k+1).charAt(0)=='0'){
                                myList.set(k, "(1) ");
                            }else{
                                myList.set(k, "(1");
                            }
                            
                        }else{
                            if(myList.get(k+1).charAt(0)=='0'){
                                myList.add(k+1,") ");
                                k++;
                            }
                        }
                    }
                }
            }
            }
            y = myList.stream().map(n -> String.valueOf(n)).collect(Collectors.joining());
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