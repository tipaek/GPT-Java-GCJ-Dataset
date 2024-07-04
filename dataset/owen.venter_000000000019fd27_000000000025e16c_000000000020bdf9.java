import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author owen
 */
public class Solution {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Scanner in=new Scanner(System.in);
       int tests=in.nextInt();
       int fok=1;
        for (int q = 0; q < tests; q++) {
            
            boolean impossible=false;
            int numOfT=in.nextInt();
            Map<Integer, Task> map=new HashMap();
            List changed=new LinkedList();
            
            for (int w = 1; w <= numOfT; w++) {
                int startTime=Integer.parseInt(in.next());
                int endTime=Integer.parseInt(in.next());
                map.put(w, new Task("U",startTime,endTime));
                
                changed.add(startTime);
                
            }
            
            //SORT
            for (int r = 1; r < map.size(); r++) {
                for (int t = r+1; t < (map.size()+1); t++) {
                    Task t1=new Task(map.get(r).name,map.get(r).startT,map.get(r).endT);
                    Task t2=new Task(map.get(t).name,map.get(t).startT,map.get(t).endT);
                    if (t1.startT>t2.startT) {
                    //Task temp= t1;
                    //t1 = t2;
                    //t2 = temp;
                    Map<Integer, Task> temp=new HashMap();
                    temp.put(r, t1);
                    map.put(r, t2);
                    map.put(t, temp.get(r));
                }
                    
                }
            }
            
           
            
           
          
                 for (int e = 1; e < map.size(); e++) {//might be out of bounds error
                     
                     //System.out.println("SIZE:"+map.size());
                     //setting 1st task
                     if(e==1){
                    String newName="C";
                          Task change=new Task(newName,map.get(e).startT,map.get(e).endT); 
                          map.put(e, change);
                }
                     
                    Task t= new Task(map.get(e).name,map.get(e).startT,map.get(e).endT);
                    Task o= new Task(map.get(e+1).name,map.get(e+1).startT,map.get(e+1).endT);
                    //checking second task
                     if (t.endT>o.startT) {
                         if (t.name=="C"){
                             //System.out.println("YES");
                          String newName="J";
                          Task change=new Task(newName,map.get(e+1).startT,map.get(e+1).endT); 
                          map.put(e+1, change);
                         }else{
                           String newName="C";
                          Task change=new Task(newName,map.get(e+1).startT,map.get(e+1).endT); 
                          map.put(e+1, change);  
                     }
                     }else{
                         
                         boolean hasChanged=true;
                       //FIND Impossibles
                       hasChanged=false;
                             for (int u = 1; u < (e+1); u++) {
                                 hasChanged=true;
                                 Task one=new Task(map.get(u).name,map.get(u).startT,map.get(u).endT);
                                 if(o.startT>=one.endT && t.name!=one.name ){
                                     
                                     //System.out.println("IMPOSSIBLE");
                                     if (one.name=="C") {
                                        // System.out.println("here");
                                         String newName="C";
                                         Task change=new Task(newName,map.get(e+1).startT,map.get(e+1).endT); 
                                        map.put(e+1, change); 
                                     }else {
                                         String newName="J";
                                        Task change=new Task(newName,map.get(e+1).startT,map.get(e+1).endT); 
                                         map.put(e+1, change); 
                                     }
                                     hasChanged=true;
                                    
                                 }else{
                                     
                                    String newName="J";
                                         Task change=new Task(newName,map.get(e+1).startT,map.get(e+1).endT); 
                                        map.put(e+1, change);
                                    // System.out.println("Impossible");
                                     }
                                
                                 }
                            
                              if(hasChanged==true){
                                     impossible=true;
                                 }
                             
                             
                         
                     }
                
                }
                 
                 
                //sort back
                for (int a = 1; a < map.size(); a++) {
                    if (map.get(a).startT!=Integer.parseInt(""+changed.get((a-1)))) {
                        for (int o = a+1; o < (map.size()+1); o++) {
                            if (Integer.parseInt(""+changed.get((a-1)))==map.get(o).startT) {
                                Task t1=new Task(map.get(a).name,map.get(a).startT,map.get(a).endT);
                                Task t2=new Task(map.get(o).name,map.get(o).startT,map.get(o).endT);
                                Map<Integer, Task> temp=new HashMap();
                                     temp.put(a, t1);
                                     map.put(a, t2);
                                     map.put(o, temp.get(a));
                                
                            }
 
                        }
                    }
            }
                  //if(impossible==false){
                              //   System.out.println("THIS IS DEFS IMPOS");
                             //}else{
                  
                  
                 /* 
                  for(Map.Entry<Integer, Task> entry:map.entrySet()){    
                       
                     int key=entry.getKey(); 
                     fok=fok+key;
                     Task b=entry.getValue(); 
                     if(cased==false){
                       System.out.print("Case #"+(key)+": ");
                       cased=true;
                     }
                     if(impossible==false && imposd==false){
                         System.out.print("IMPOSSIBLE");
                         imposd=true;
                     }else if(imposd==false){
                     System.out.print(b.name);   
                    }
                     
                  }
                  */
                 boolean cased=false;
                  boolean imposd=false;
                 for (int d = 0; d < map.size(); d++) {
                     if(cased==false){
                     System.out.print("Case #"+(fok)+": ");
                     cased=true;
                     fok++;
                     }
                if(impossible==false && imposd==false){
                         System.out.print("IMPOSSIBLE");
                         imposd=true;
                     }else if(imposd==false){
                     System.out.print(map.get((d+1)).name);
                     
                    }
            }
                      
                      System.out.print("\n");
                      
 
              //}
                
            }//end of test
           
           
        }
 
    }
    


class Task{
String name;
int startT;
int endT;
public Task(String nameI, int startTI,int endTI){
    this.name=nameI;
    this.startT=startTI;
    this.endT=endTI;

}
}