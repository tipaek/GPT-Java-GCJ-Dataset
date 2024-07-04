import java.util.*;
public class Vestigium{

     public static void main(String []args){
        Scanner s =new Scanner(System.in);
        int x=s.nextInt();
        for(int i=0;i<x;i++){
            int y=s.nextInt();s.nextLine();
            String[][] input = new String[y][y];
            for(int j=0;j<y;j++){
                input[j]=s.nextLine().split("\\s+");
            }
            System.out.println("Case #1: "+answer(input));
        }
     }
     public static String answer(String[][] input){
         int diag=0;
         int rowAns=0;
         int colAns=0;
         for(int i=0;i<input.length;i++){
            List<String> rowCount=new ArrayList<String>();
            List<String> colCount=new ArrayList<String>();
            for(int j=0;j<input.length;j++){
                if(i==j)
                    diag+=Integer.parseInt(input[i][i]);
                if(rowCount.contains(input[i][j])){
                    //rowAns++;
                }
                else{
                    rowCount.add(input[i][j]);
                }
            }
            for(int k=0;k<input.length;k++){
                if(colCount.contains(input[k][i])){
                    //colAns++;
                }
                else{
                    colCount.add(input[k][i]);
                }
            }
            if(rowCount.size()!=input.length){
                rowAns++;
            }
            if(colCount.size()!=input.length){
                colAns++;
            }
         }
         return diag+" "+rowAns+" "+colAns;
     }
}