import java.io.*;
import java.util.*;

public class Vestigium{
    public static void main(String[] args){
        Map<Integer, Integer> n1 = new TreeMap<>();
        Map<Integer, Set<Integer>> n2 = new TreeMap<>();
        Scanner input = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int x = cases(input);
        int dim = input.nextInt();
        int rr = 0;
        int cr = 0;
        for(int a=0;a<x;a++){
            res(a,trace(input,n1,n2,dim,rr,cr),rr,cr);
        } 
    }

    
    private static int cases(Scanner input){
        int caseNum = 0;
        while(input.hasNextLine()){
            caseNum = input.nextInt();
        }
        return caseNum;
    }

    private static int trace(Scanner input, Map n1, Map n2,int dim,int rr, int cr){  
        int trace = 0;
        int order = 0;
        for(int i=0;i<dim;i++){
            for(int j=0;j<dim;j++){
                order++;
                num = input.nextInt();
                if(i==j)trace+=num;
                rr = rowRepeat(i,n1,dim,num);
                cr = columnRepeat(order,n2,dim,num);
            }
        }
        return trace;
    }

    // private int rowRepeat(int k, Map m, int c,int dim){
    //     int rowMax = 0;
    //     for(int i=0;i<dim;i++){
    //         for(int j=0;j<dim;j++){
    //             int count = m.get(k);
    //             if(m.containsKey(k)!=true){
    //                 m.put(k,c);
    //             }
    //             else{
    //                 m.put(k,count+1);
    //             }
    //             rowMax = Math.Max(rowMax,Collections.max(m.values()));  
    //         }
    //         m.clear();
    //     }
    //     return rowMax;  
    // }

    private int maxRepeat(int k, Map t,int dim){
        int max = 0;
        Set<Integer> temp = new Set<>();
            for(int i=0;i<dim;i++){
                if(m.containsKey(k)!=true){
                    m.put(k,c);
                }
                else{
                    m.put(k,count+1);
                }
                max = Math.Max(max,Collections.max(m.values())); 
                temp.add(max);
                m.clear();   
            }
        return Collections.max(temp);  
    }

    private int rowRepeat(int i,Map n1,int dim,int num){
        int rowNum = i;
        Set nset = new Set<Integer>();
        if(n1.containsKey(rowNum)!=true){
            n1.put(rowNum,nset);
        }
        n1.get(rowNum).add(num);
        return maxRepeat(rowNum,n1,dim);
    }

    private int columnRepeat(int order,Map n2,int num){
        int columnNum = order%(dim);
        Set ns = new Set<Integer>();
        if(n2.containsKey(columnNum)!=true){
            n2.put(columnNum,ns);
        }
        n2.get(columnNum).add(num);
        return maxRepeat(columnNum, n2, dim);
    }

    private static void res(int x,int trace,int rr, int cr){
        System.out.println("#"+x+": "+rr+" "+cr);
    }


}