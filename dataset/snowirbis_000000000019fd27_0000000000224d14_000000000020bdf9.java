import java.util.*;


public class Solution {
    
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int cases = scanner.nextInt();
     
        //looping thu cases
        for(int ci1=1; ci1<cases+1; ci1++ ){
            
            int numActivites = scanner.nextInt();
            Stack<Integer> cam = new Stack<Integer>(); 
            Stack<Integer> jam = new Stack<Integer>(); 
            String toPrint="CASE #"+ci1+": ";
            
            for(int ci2=0; ci2<numActivites; ci2++ ){
                //loop through each activity 

                boolean pushed= false;
                int startTime= scanner.nextInt();
                int endTime =scanner.nextInt();
  
                if(cam.empty() || startTime >= cam.peek()){
                    cam.push(startTime);
                    cam.push(endTime);
                    toPrint=toPrint+"C";
                    pushed= true;

                } 
                
                if((jam.empty() || startTime >= jam.peek()) && pushed== false){
                    jam.push(startTime);
                    jam.push(endTime);
                    toPrint=toPrint+"J";
                    pushed = true;

                }
                
                //if couldn't fit in either look retoractively if there is an opening
                if(pushed == false){
                    
                    Stack<Integer> copy_Stack = (Stack)cam.clone(); 
                 
                    while (copy_Stack.size()>0){
                           
                          int dummyend= copy_Stack.pop();
                         int  dummystart= copy_Stack.pop();
              
                         if((startTime <= dummystart) ){
                             if(copy_Stack.size()==0 || (copy_Stack.peek() <= endTime)){
                              toPrint=toPrint+"C";
                               pushed= true;
                             }
                         }
                         
                    }
                    Stack<Integer> copy_Stack2 = (Stack)jam.clone(); 

                    while (copy_Stack2.size()>0){
                         
                         int dummyend= copy_Stack2.pop();
                         int dummystart=copy_Stack2.pop();
                         
                         if((startTime<=dummystart)){
                             if(copy_Stack2.size()==0 || copy_Stack2.peek() <= endTime){
                              toPrint=toPrint+"J";
                               pushed= true;
                          }
                   }
                         
                }
                     if(pushed == false){
                      toPrint="CASE #"+ci1+": IMPOSSIBLE";
                      
                    }
            }
                
          }
             System.out.println(toPrint);
              
        }
        
        scanner.close();
        
    


    

      
    }
}