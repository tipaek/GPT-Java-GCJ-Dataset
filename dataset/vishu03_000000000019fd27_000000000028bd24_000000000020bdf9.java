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
            List<String> z1=new ArrayList<String>();
            for(String[] ar:z){
                z1.add(ar[0]);
            }
            z=sortInput(z);
            System.out.println("Case #"+(j+1)+": "+answer(z, z1));
        }
     }
     public static String answer(String[][] input, List<String> ref){
         String ans="C";
         String finalAns="";
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
         List<String> temp=new ArrayList<String>();
         for(String[] li:input){
             temp.add(li[0]);
         }
         for(int i=0;i<ref.size();i++){
             int ind=temp.indexOf(ref.get(i));
             finalAns+=ans.substring(ind, ind+1);
             temp.remove(ind);
             if(ind==0)
                ans=ans.substring(1);
             else if(ind==ans.length()-1)
                ans=ans.substring(0, ans.length()-1);
             else
                ans=ans.substring(0,ind)+ans.substring(ind+1);
             
         }
         return finalAns;
     }
     public static boolean addToList(String[][] input, List<Integer> list, int inputNumber){
         int x=Integer.parseInt(input[inputNumber][0]);
         int y=Integer.parseInt(input[inputNumber][1]);
         for(int i=0;i<list.size();i++){
            int a=Integer.parseInt(input[list.get(i)][0]);
            int b=Integer.parseInt(input[list.get(i)][1]);
            if(y<=a || x>=b){
               //doNothing 
            }
            else{
                return false;
            }
         }
         return true;
     }
     public static String[][] sortInput(String[][] input){
         Arrays.sort(input, new Comparator<String[]>(){
            public int compare(final String[] i1, final String[] i2){
                if(Integer.parseInt(i1[0])>Integer.parseInt(i2[0]))
                    return 1;
                else if(Integer.parseInt(i1[0])<Integer.parseInt(i2[0]))
                    return -1;
                else
                    return 0;
            } 
         });
         return input;
     }
         
}