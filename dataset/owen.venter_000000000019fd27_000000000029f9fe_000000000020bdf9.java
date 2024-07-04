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
            
            boolean impossible=true;
            int numOfT=in.nextInt();
            Map<Integer, Task> map=new HashMap();
            List changed=new LinkedList();
            
            for (int w = 1; w <= numOfT; w++) {
                int startTime=Integer.parseInt(in.next());
                int endTime=Integer.parseInt(in.next());
                map.put(w, new Task("J",startTime,endTime));
                
                changed.add(startTime);
                
            }
            
            //SORT
            for (int r = 1; r < map.size(); r++) {
                for (int t = r+1; t < (map.size()+1); t++) {
                    Task t1=new Task(map.get(r).name,map.get(r).startT,map.get(r).endT);
                    Task t2=new Task(map.get(t).name,map.get(t).startT,map.get(t).endT);
                    if (t1.startT>t2.startT) {
                   
                    Map<Integer, Task> temp=new HashMap();
                    temp.put(r, t1);
                    map.put(r, t2);
                    map.put(t, temp.get(r));
                }
                    
                }
            }
            
           
            
           
          
           for (int e = 1; e < map.size(); e++) {
                     if(e==1){
                    String newName="J";
                          Task change=new Task(newName,map.get(e).startT,map.get(e).endT); 
                          map.put(e, change);
                        }
                     
                   Task t= new Task(map.get(e).name,map.get(e).startT,map.get(e).endT);
                   Task o= new Task(map.get((e+1)).name,map.get((e+1)).startT,map.get((e+1)).endT);
                    
                     if (t.endT >= o.startT ) {
                          if(t.name=="C"){
                             String newName="J";
                                    Task once=new Task(newName,map.get((e+1)).startT,map.get((e+1)).endT);
                                    map.put((e+1), once);
                             
                         } else{
                             String newName="C";
                                    Task once=new Task(newName,map.get((e+1)).startT,map.get((e+1)).endT);
                                    map.put((e+1), once);
                         
                     
           }
                     }else{
                         if(t.name=="C"){
                             String newName="C";
                                    Task once=new Task(newName,map.get((e+1)).startT,map.get((e+1)).endT);
                                    map.put((e+1), once);
                             
                         } else{
                             String newName="J";
                                    Task once=new Task(newName,map.get((e+1)).startT,map.get((e+1)).endT);
                                    map.put((e+1), once);
                         }
                     }{
               
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
                  
                 
                  if(map.size()==2){
                      impossible=false;
                  }else{
                      for(int i=1; i<map.size();i++){
                      for (int j = i+1; j < map.size()+1 ; j++ ) {
                          if (map.get(j).startT>=map.get(i).endT) {
                             impossible=true;
                          }else{
                              impossible=false;
                          }
                          
                      }
                  }     
                              
                  }
            
               //Print out values
                 boolean cased=false;
                  boolean imposd=false;
                 for (int d = 0; d < map.size(); d++) {
                     if(cased==false){
                     System.out.print("Case #"+(fok)+": ");
                     cased=true;
                     fok++;
                     }
                     if(impossible==false && imposd==false && map.size()!=2){
                         System.out.print("IMPOSSIBLE");
                         imposd=true;
                     }else if(imposd==false){
                     System.out.print(map.get((d+1)).name);
                     
                     }
                    }
                      System.out.print("\n");
                      
 
              
                
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