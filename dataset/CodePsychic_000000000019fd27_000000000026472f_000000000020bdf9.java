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
            for(int i=1;i<=n;i++){
                in.nextLine();
                times.add(new Integer[]{in.nextInt(),in.nextInt()});
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
        
        int c=0,j=0,start=0,end=0;
        for(Integer[] arr:times){
           //System.out.println(arr[0]+" - "+arr[1]);
           start=arr[0];
           end=arr[1];
            //check if c is free if so assign to him
            if(c<=start){
               result.append('C');
               c=end;  //c is busy till end    
            }else if(j<=start){
               result.append('J');
               j=end;  //j is busy till end
            }else{ //both busy
               result.setLength(0);
               result.append("IMPOSSIBLE");
               break;
            }
        }
           
           
        System.out.println("Case #"+x+": "+result);   
           
           
    }
    
    
    
    
    
    
    
    
    
    public static void solveBrackets(int x,String str){
        //System.out.println(str);
        
        StringBuilder result = new StringBuilder();
        int open=0;
        int required=0;
        
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            required=(int)(c-'0');
            //System.out.println("required="+required);
            if(open==required)
                result.append(c);
            else if(open<required){
                while(open<required){
                    open++;
                    result.append('(');
                }
                result.append(c);
            }else if(open>required){
                while(open>required){
                    open--;
                    result.append(')');
                }
                result.append(c);
            }
            
        }
        
        while(open>0){
            open--;
            result.append(')');
        }
        
        
        System.out.println("Case #"+x+": "+result);
        
    }
    
    
    
    
    
}