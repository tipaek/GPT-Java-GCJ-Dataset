import java.util.*;
import java.lang.*;

public class Solution {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int numberofcase=Integer.parseInt(input.nextLine());
        
        for (int i=1;i<=numberofcase;i++){
            int col=input.nextInt();
            int row=input.nextInt();
            System.out.println("Case #"+i+": "+find_dis(row,col));
        }
    }
    
    public static String find_dis(int row,int col){
        if ((row%2!=0 && col%2!=0) || (row%2==0 && col%2==0)){
            return "IMPOSSIBLE";
        }
        
        Queue<String[]> queue=new LinkedList<>();
        long mark=1;
        final int con=1000000000;
        queue.offer(new String[]{"0","0",""});
        
        while (!queue.isEmpty() && mark<=Integer.MAX_VALUE){
            int size=queue.size();
            
            for (int i=0;i<size;i++){
                String[] temp=queue.poll();
                long row_cur=Long.parseLong(temp[0]),col_cur=Long.parseLong(temp[1]);
                if (row_cur+mark<=con){
                    queue.offer(new String[]{String.valueOf(row_cur+mark),String.valueOf(col_cur),temp[2]+"N"});
                    if (row_cur+mark==row && col_cur==col){
                        return temp[2]+"N";
                    }
                }
                if (row_cur-mark>=-1*con){
                    queue.offer(new String[]{String.valueOf(row_cur-mark),String.valueOf(col_cur),temp[2]+"S"});
                    if (row_cur-mark==row && col_cur==col){
                        return temp[2]+"S";
                    }
                }
                if (col_cur+mark<=con){
                    queue.offer(new String[]{String.valueOf(row_cur),String.valueOf(col_cur+mark),temp[2]+"E"});
                    if (row_cur==row && col_cur+mark==col){
                        return temp[2]+"E";
                    }
                }
                if (col_cur-mark>=-1*con){
                    queue.offer(new String[]{String.valueOf(row_cur),String.valueOf(col_cur-mark),temp[2]+"W"});
                    if (row_cur==row && col_cur-mark==col){
                        return temp[2]+"W";
                    }
                }
            }
            mark<<=1;
        }
        return "IMPOSSIBLE";
    }
}
