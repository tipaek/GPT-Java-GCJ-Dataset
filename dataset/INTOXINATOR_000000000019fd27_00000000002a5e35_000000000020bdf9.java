import java.util.Scanner;
import java.util.*;
import java.lang.*;
import java.util.Arrays; 
import java.util.Comparator;
import java.util.Set;
import java.io.*; 
import java.lang.*;

public class Solution{
    private static Scanner sc;
    static int tn =1;

    public static void main(String[] args){

        sc=new Scanner(System.in);

        int t=sc.nextInt();
        sc.nextLine();

        while(t-->0){
            solve();
            }
            }
    
    private static void solve(){
        int n=sc.nextInt();
        int[][] mat=new int[n][2];
        int[][] matSorted = mat;
        char person ='J';
        Stack<int[]> JStack=new Stack<>();
        Satck<int[]> CStack=new Stack<>(); 
        
        Map<int[],Integer>map=new HashMap<>();
        
        for (int i=0; i< mat.length;i++){
            for(int j=0;j<mat[i].length;j++){
            mat[i][j]=sc.nextInt();
            }
            map.put(mat[i],i);
        }
        
            Arrays.sort(matSorted,new Comparator<int[]>(){
                @Override
                public int compare(int [] a,int[] b){
                    return a[0] - b[0];
                    }
                });
            
            for (int i=0;i<matSorted.length;i++){
                chars[map.get(matSorted[i])]=person;
                
                
                if (i<matSorted.length-1 && doseOverlap(matSorted[i],matSorted[i+1])){
                    if(person =='J'){
                        JStack.push(matSorted[i]);
                        person=getPerson(person);
                        
                        
                        if (!CStack.isEmpty()&&doseOverlap(matSorted[i+1],CStack.peek())){
                            imposible=true;
                            break;
                        }
                    }
                    else{
                        CStack.push(matSorted[i]);
                        person=getPerson(person);
                        if (!CStack.isEmpty()&& doseOverlap(matSorted[i],CStack.peek())|| !JStack.isEmpty()&& doseOverlap(matSorted[i],JStack.peek())){
                            impossible=true;
                            break;
                        }
                 
                    if (person=='J'){
                        JStack.push(matSorted[i]);
                        
                    }else{
                            CStack.push(matSorted[i]);
                        }    
                    }
            
            }
            System.out.println("Case #"+(tn++)+": "+new String(chars));
            }}
            private static char getPerson(char p){
                return p == 'J'?'C':'J';
                
            }
            private static boolean doseOverlap(int[] a,int[] b){
                return a[1]>b[0];
            
            }
}
            


















    