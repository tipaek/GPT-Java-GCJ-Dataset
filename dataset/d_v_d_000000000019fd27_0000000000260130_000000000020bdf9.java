import java.util.*;
import javax.swing.text.html.CSS;
public class Solution{
    private static Scanner sc;
    static int t=1;
    public static void main(String args[]){
        sc=new Scanner(System.in);
        int test=sc.nextInt();
        sc.nextLine();
        while(test-- >0){
            google();
        }
    }
    private static void google(){
        int n=sc.nextInt();
        int[][] matrix=new int[n][2];
        int[][] matrixSorted=matrix.clone();
        char per='J';
        char[] chars=new char[n];
        Stack<int[]> Cstack=new Stack<>();
        Stack<int[]> Jstack=new Stack<>();
        boolean flag=false;
        Map<int[],Integer> map=new HashMap<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j]=sc.nextInt();
            }
            map.put(matrix[i],i);
        }
        Arrays.sort(matrixSorted,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[0]-b[0];
            }
        });
        for(int i=0;i<matrixSorted.length;i++){
            chars[map.get(matrixSorted[i])]=per;
            if(i<matrixSorted.length-1 && overlap(matrixSorted[i],matrixSorted[i+1])){
            if(per=='J'){
                Jstack.push(matrixSorted[i]);
                per=getperson(per);
                if(!Cstack.isEmpty() && overlap(Cstack.peek(),matrixSorted[i+1])){
                    flag=true;
                    break;
                }
            }
                else{
                    Cstack.push(matrixSorted[i]);
                    per=getperson(per);
                    if(!Jstack.isEmpty() && overlap(Jstack.peek(),matrixSorted[i+1])){
                        flag=true;
                        break;
                    }
                }
            
            }
            else{
                if (per=='J'){
                    Jstack.push(matrixSorted[i]);
                }
                else{
                Cstack.push(matrixSorted[i]);
                }
            }
            
            
        }
        System.out.println("Case #"+ (t++) + ": " + (flag ? "IMPOSSIBLE": new String(chars)));
    }
    

private static char getperson(char p){
    return p == 'J' ? 'C' : 'J';
}
private static boolean overlap(int[] a, int[] b){
    return a[1]>b[0];
}
}