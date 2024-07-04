import java.util.Scanner;
import java.util.*;
public class Solution
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        int tcCount = in.nextInt();
        //System.out.println("tcCount= "+tcCount);
        
        for(int x=1;x<=tcCount;x++){
            //System.out.println("Testcase #"+x);
            in.nextLine();
            int n = in.nextInt();
            List<Integer[]> times=new ArrayList<Integer[]>();
            for(int i=0;i<n;i++){
                in.nextLine();
                times.add(new Integer[]{in.nextInt(),in.nextInt(),new Integer(i)});
            }
            
            solveScheduling(x,n,times);
        }
        
    }
    
    public static void solveScheduling(int x, int n, List<Integer[]> times){
        
        StringBuilder result = new StringBuilder();
        
        Collections.sort(times, new Comparator<Integer[]>(){
            public int compare(Integer[] arr1, Integer[] arr2){
                return arr1[0]-arr2[0];
            }
            
            
        });
        
        
        char[] assignees = new char[n];
        
        int c=0,j=0,start=0,end=0,order=0;
        for(Integer[] arr:times){
           //System.out.println(arr[0]+" - "+arr[1]);
           start=arr[0];
           end=arr[1];
           order=arr[2];
            //check if c is free if so assign to him
            if(c<=start){
               //result.append('C');
               c=end;  //c is busy till end  
               assignees[order]='C';
            }else if(j<=start){
               //result.append('J');
               j=end;  //j is busy till end
               assignees[order]='J';
            }else{ //both busy
               result.setLength(0);
               result.append("IMPOSSIBLE");
               break;
            }
        }
        
        if(result.length()==0){
           result.append(new String(assignees)); 
        }
           
        
        /*
        Map<Character,Integer> map = new HashMap<Character,Integer>();
        map.put('C',0);
        map.put('J',0);
        solveScheduling(times,0,map,new StringBuilder(),result);
        if(result.length()==0)
           result.append("IMPOSSIBLE");
        */
        
        System.out.println("Case #"+x+": "+result);   
           
           
    }
    
    
    public static void solveScheduling(List<Integer[]> times, int i, Map<Character,Integer> map, StringBuilder path, StringBuilder result){
        
        if(i==times.size()){
            result.append(path.toString());
            return;
        }
        
        
        
        int start=times.get(i)[0];
        int end=times.get(i)[1];
        int old=0;
        
        //check if C is free
        if(map.get('C')<=start){
            //System.out.println("Path so far is: "+path+" for i= "+i+" ,assigned C");
            path.append('C');
            old=map.get('C');
            map.put('C',end);
            
            solveScheduling(times,i+1,map,path,result);
            path.setLength(path.length()-1);
            map.put('C',old);
        }
        
        if(result.length()>0)
          return;
        
        //check if J is free
        if(map.get('J')<=start){
            // System.out.println("Path so far is: "+path+" for i= "+i+" ,assigned J");
            path.append('J');
            old=map.get('J');
            map.put('J',end);
            
            solveScheduling(times,i+1,map,path,result);
            path.setLength(path.length()-1);
            map.put('J',old);
        }
        
        
    }
    
    
    
    
    
    
}