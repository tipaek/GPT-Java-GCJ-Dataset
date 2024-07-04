/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/


import java.util.*;

public class Main 
{
    private static Scanner sc;
    static int tn=1;
    
   public static void main(String[] args) 
   {
      sc = new Scanner(System.in); 
       
      int t= sc.nextInt(); 
      sc.nextLine();
    
    while(t-->0){
        solve();
    }
  }
private static void solve(){
    int n=sc.nextInt();
    int[][] mat = new int[n][2];
     int[][] matSorted=mat.clone();

    Stack<int[]> jstack=new Stack<>();
    Stack<int[]> cstack=new Stack<>();
    boolean impossible=false;
    char person='J';
    char[] chars =new char[n];
Map<int[],Integer>map=new HashMap<>();
    
      for(int i=0;i<mat.length;i++){
          for(int j=0;j<mat[i].length;j++){
              mat[i][j]=sc.nextInt();
          }
          map.put(mat[i],i);
      }
      Arrays.sort(matSorted,new Comparator<int[]>(){
          @Override
          public int compare(int []a,int []b){
              return a[0]-b[0];
          }
      });
       for(int i=0;i<matSorted.length;i++){
            chars[map.get(matSorted[i])]=person;

        if(i<matSorted.length-1&&overlap(matSorted[i],matSorted[i+1])){
                if(person=='J'){
                    jstack.push(matSorted[i]);
                    person=getperson(person);

                    if(!cstack.isEmpty()&&overlap(cstack.peek(),matSorted[i+1])){
                        impossible=true;
                        break;
                    }
                }

            else{
                    cstack.push(matSorted[i]);
                    person=getperson(person);
                    if(!jstack.isEmpty()&&overlap(jstack.peek(),matSorted[i+1])){
                        impossible=true;
                        break;
                    }
                }
        }
        else{
            if(person=='J'){
                jstack.push(matSorted[i]);

            }
            else{
                cstack.push(matSorted[i]);
            }
        }
      }
      
      System.out.println("Case #"+(tn++)+ ": "+(impossible ? "IMPOSSIBLE":new String(chars)));
    }
    
private static boolean overlap(int[] a,int[] b){

return a[1]>b[0];
}
private static char getperson(char p){
return p=='J'?'C':'J';

}
    }

