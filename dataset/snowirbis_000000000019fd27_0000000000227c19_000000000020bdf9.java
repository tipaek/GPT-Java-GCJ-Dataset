import java.util.*;
import java.util.ArrayList; 


public class Solution {
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
       
        if(scanner.hasNextLine()){
        int cases = scanner.nextInt();
          
        //looping thu cases
        for(int ci1=1; ci1<cases+1; ci1++ ){
            
            int numActivites = scanner.nextInt();
            ArrayList<Integer> cam = new ArrayList<Integer>(); 
            ArrayList<Integer> jam = new ArrayList<Integer>(); 
            String toPrint="Case #"+ci1+": ";
            
            for(int ci2=0; ci2<numActivites; ci2++ ){
                //loop through each activity 

                boolean pushed= false;
                int startTime= scanner.nextInt();
                int endTime =scanner.nextInt();
  
                if(cam.size()==0 || startTime >= cam.get(cam.size()-1)){
                    cam.add(startTime);
                    cam.add(endTime);
                    toPrint=toPrint+"C";
                    pushed= true;

                } 
                
                if((jam.size()==0|| startTime >= jam.get(jam.size()-1)) && pushed== false){
                    jam.add(startTime);
                    jam.add(endTime);
                    toPrint=toPrint+"J";
                    pushed = true;

                }
                
                //if couldn't fit in either look retoractively if there is an opening
                if(pushed == false){
                    
                    ArrayList<Integer> copy_Stack = (ArrayList)cam.clone(); 
                
                    while (copy_Stack.size()>0){
                        
                         int dummyend= copy_Stack.remove(copy_Stack.size()-1);
                         int dummystart= copy_Stack.remove(copy_Stack.size()-1);
              
                         if((startTime <= dummystart) ){
                             if(copy_Stack.size()==0 || (copy_Stack.get(copy_Stack.size()-1) <= endTime)){
                              toPrint=toPrint+"C";
                               pushed= true;
                               int position= (copy_Stack.size()==0) ? 0  : copy_Stack.size()-1;
                              
                               cam.add(position,startTime);
                               cam.add(position+1,endTime);
                               
                             }
                         }
                         
                    }
                    ArrayList<Integer> copy_Stack2 = (ArrayList)jam.clone(); 
        
                    while (copy_Stack2.size()>0){
                      
                         int dummyend= copy_Stack2.remove(copy_Stack2.size()-1);
                              
                         int dummystart=copy_Stack2.remove(copy_Stack2.size()-1);
                                     
                         if((startTime<=dummystart)){
                             if(copy_Stack2.size()==0 || copy_Stack2.get(copy_Stack2.size()-1) <= endTime){
                              toPrint=toPrint+"J";
                              pushed= true;
                              int position1= (copy_Stack2.size()==0) ? 0  : copy_Stack2.size()-1;
                               jam.add(position1,startTime);
                               jam.add(position1+1,endTime);
                         
                          }
                   }
                         
                }
                     if(pushed == false){
                      toPrint="Case #"+ci1+": IMPOSSIBLE";
                      
                    }
            }
                
          }
             System.out.println(toPrint);
              
        
        }}
        scanner.close();
        
    


    

      
    }
}