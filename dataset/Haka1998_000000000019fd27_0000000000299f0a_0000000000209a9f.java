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
           
            if(myList.size()==1){
                if(!myList.get(0).equals("0")){
                        String a="";
                        int kt=Integer.parseInt(myList.get(0).toString());
                        for(int z=0;z<kt;z++){
                            a += "(";
                            myList.set(0, myList.get(0)+")");
                        }
                        myList.set(0, a+myList.get(0));
                    }
            }else{
                for(int k=0;k<myList.size();k++){
                    
                    
                if(k==myList.size()-1){
                    
                    if(!myList.get(k).equals("0")){
                        if(!myList.get(k).equals(myList.get(k-1))){
                            String a="";
                            int kt=Integer.parseInt(myList.get(k).toString());
                            for(int z=0;z<kt;z++){
                                a += "(";
                                myList.set(k, myList.get(k)+")");
                            }
                            myList.set(k, a+myList.get(k));
                        }else{
                            int kt=Integer.parseInt(myList.get(k).toString());
                            for(int z=0;z<kt;z++){

                                myList.set(k,myList.get(k)+")");
                            }

                        }
                        
                        
                        
                    }
                }else{

                    if(myList.get(k).equals("0")){
                        if(!myList.get(k+1).equals("0")){
                            String a="";
                            int kt=Integer.parseInt(myList.get(k+1).toString());
                            for(int z=0;z<kt;z++){
                                a += "(";
                            }
                            myList.add(k+1,a);
                            k++;                 
                        }
                    }else{
                        if(k==0){
                            if(myList.get(k+1).equals("0")){
                                String a="";
                                int kt=Integer.parseInt(myList.get(k).toString());
                                for(int z=0;z<kt;z++){
                                    a += "(";
                                    myList.set(k, myList.get(k)+")");
                                }
                                myList.set(k, a+myList.get(k));
                            }else{
                                if(myList.get(k).equals(myList.get(k+1))){
                                    int kt=Integer.parseInt(myList.get(k).toString());
                                    for(int z=0;z<kt;z++){
                                        myList.set(k,"("+myList.get(k));
                                    }
                                }else{
                                    String a="";
                                    int kt=Integer.parseInt(myList.get(k).toString());
                                    for(int z=0;z<kt;z++){
                                        a += "(";
                                        myList.set(k, myList.get(k)+")");
                                    }
                                    myList.set(k, a+myList.get(k));
                                }
                            }
                            
                        }else{
                            if(!myList.get(k).equals("0")){
                                if(!myList.get(k).equals(myList.get(k-1))){
                                String a="";
                                int kt=Integer.parseInt(myList.get(k).toString());
                                for(int z=0;z<kt;z++){
                                    a+="(";
                                }
                                myList.add(k,a);
                                k++;
                                if(!myList.get(k).equals(myList.get(k+1))){
                                    String b="";
                                    int kt2=Integer.parseInt(myList.get(k).toString());
                                    for(int z=0;z<kt2;z++){
                                        b+=")";
                                    }
                                    myList.add(k+1,b);
                                    k++;
                                }
                            }else{
                                String a="";
                                int kt=Integer.parseInt(myList.get(k).toString());
                                for(int z=0;z<kt;z++){
                                        a+=")";
                                }
                                myList.add(k+1,a);
                                k++;
                            }
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