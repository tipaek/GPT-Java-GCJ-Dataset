import java.util.*;
public class Solution{

     public static void main(String []args){
        Scanner s =new Scanner(System.in);
        int x=s.nextInt();
        for(int j=0;j<x;j++){
            int y=s.nextInt();
            String[][] z=new String[y][2];
            s.nextLine();
            for(int i=0;i<y;i++){
                z[i]=s.nextLine().split("\\s+");
            }
            System.out.println("Case #"+(j+1)+": "+answer(z));
        }
     }
     public static String answer(String[][] input){
         String ans="C";
         List<Integer> cList=new ArrayList<Integer>();
         List<Integer> jList=new ArrayList<Integer>();
         cList.add(0);
         for(int i=1;i<input.length;i++){
             boolean flag=false;
             
             if(!flag && addToList(input, cList,i)){
                cList.add(i);
                ans+="C";
                flag=true;
             }
             if(!flag && addToList(input, jList,i)){
                jList.add(i);
                ans+="J";
                flag=true;
             }
             if(!flag)
                return "IMPOSSIBLE";
         }
         return ans;
     }
     public static boolean addToList(String[][] input, List<Integer> list, int inputNumber){
         int x=Integer.parseInt(input[inputNumber][0]);
         int y=Integer.parseInt(input[inputNumber][1]);
         for(int i=0;i<list.size();i++){
            int a=Integer.parseInt(input[list.get(i)][0]);
            int b=Integer.parseInt(input[list.get(i)][1]);
            if((x<=a && y<=a) || (x>=b && y>=b)){
               //doNothing 
            }
            else{
                return false;
            }
         }
         return true;
     }
         
}