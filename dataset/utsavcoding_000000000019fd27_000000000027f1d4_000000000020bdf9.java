import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
    
    class Interval{
        int start;
        int end;
        int pos;
        
        Interval(int start,int end,int pos){
            this.start=start;
            this.end=end;
            this.pos=pos;
        }
    }
    
    class Output{
        String person;
        int taskNo;
        
        Output(String person,int taskNo){
            this.person=person;
            this.taskNo=taskNo;
        }
    }
    
    void run(){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int cnt=0;
        while(cnt<t){
            cnt++;
            int n=sc.nextInt();
            Interval item[]=new Interval[n];
            
            for(int i=0;i<n;i++){
                int start=sc.nextInt();
                int end=sc.nextInt();
                item[i]=new Interval(start,end,i);
            }
            
            Arrays.sort(item,(x,y)->{
                if(x.start!=y.start)
                    return x.start-y.start;
                return x.end-y.end;
            });
            
            
            List<Output> list=new ArrayList<Output>();
            Interval valC=null,valJ=null;
            int flag=1;
            valC=item[0];
            list.add(new Output("C",item[0].pos));
            for(int i=1;i<item.length;i++){
                if(valC!=null && valJ==null && item[i].start<valC.end){
                    valJ=item[i];
                    list.add(new Output("J",item[i].pos));
                }else if(valJ!=null && valC==null && item[i].start<valJ.end){
                    valC=item[i];
                    list.add(new Output("C",item[i].pos));
                }else{
                    if(item[i].start>=valC.end){
                        valC=item[i];
                        list.add(new Output("C",item[i].pos));
                    }else if(item[i].start>=valJ.end){
                        valJ=item[i];
                        list.add(new Output("J",item[i].pos));
                    }else{
                        flag=0;
                        break;
                    }
                }
            }
            
            if(flag==0){
                System.out.println("Case #"+cnt+": "+"IMPOSSIBLE");
                continue;
            }
            
            list.sort((x,y)->{
                return x.taskNo-y.taskNo;
            });
            
            System.out.print("Case #"+cnt+": ");
            for(Output res:list){
                System.out.print(res.person);
            }
            System.out.println();
        }
    }
    
    public static void main(String args[]) throws IOException{
        new Solution().run();
    }
}