import java.util.*;
public class Solution {
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
        int test=0;
        int k=2;
        test=Integer.parseInt(sc.nextLine());
        for(int t=1;t<=test;t++){
        	int TasksNo=0;
            String[] inpts;
            String in;
            List<Integer> skip=new ArrayList<>();
            List<Integer> first=new LinkedList<>();
            List<Integer> second=new LinkedList<>();
            TasksNo=Integer.parseInt(sc.nextLine());
            int[][] tasks=new int[TasksNo][2];
            List<String> result=new ArrayList<>();
            for(int i=0;i<TasksNo;i++) {
            	result.add("C");
            }
            for(int i=0;i<TasksNo;i++){
            	in=sc.nextLine();
            	inpts=in.split(" ");
            	tasks[i][0]=Integer.parseInt(inpts[0]);
            	tasks[i][1]=Integer.parseInt(inpts[1]);
            }
            for(int i=0;i<tasks.length;i++){
            	for(int j=0;j<tasks.length;j++){
            		if(tasks[i][0]<tasks[j][1]&&(tasks[i][0]>tasks[j][0])){
            			//System.out.println("Task "+(i)+"Overlaps with "+j);
            			first.add(i);
            			second.add(j);
            		}
            	} 	
           }
           for(int i=0;i<first.size();i++){
        	   //System.out.println("First "+first.get(i));
        	   //System.out.println("Second "+second.get(i));
        	   if(result.get(first.get(i)<second.get(i)?(first.get(i)):second.get(i))=="J") {
        		   result.set((first.get(i)>second.get(i)?(first.get(i)):second.get(i)),"C");
        	   }
        	   if(result.get(first.get(i)<second.get(i)?(first.get(i)):second.get(i))=="C"){
        		   result.set((first.get(i)>second.get(i)?(first.get(i)):second.get(i)),"J");
        	   }
           }
           System.out.print("Case #"+t+": ");
           for(String s:result){
        	   System.out.print(s);
           }
           System.out.println();
        }
        
	}
}
