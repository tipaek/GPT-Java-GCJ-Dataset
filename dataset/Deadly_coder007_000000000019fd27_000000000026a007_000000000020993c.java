import java.util.*;
import java.lang.*;
class Solution{

    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int x=s.nextInt();
        for(int i=0;i<x;i++){
            int n=s.nextInt();
            int[][] a=new int[n][n];
            int sum=0;
            HashMap<Integer,HashSet<Integer>> row=new HashMap<>();

            HashMap<Integer,HashSet<Integer>> column=new HashMap<>();

            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    a[j][k]=s.nextInt();
                    if(j==k)
                        sum=sum+a[j][k];
                    if(!row.containsKey(j)){
                        HashSet<Integer> l=new HashSet<>();
                        l.add(a[j][k]);
                        row.put(j,l);
                    }
                    else{
                        row.get(j).add(a[j][k]);
                    }
                    if(!column.containsKey(k)){
                        HashSet<Integer> l=new HashSet<>();
                        l.add(a[j][k]);
                        column.put(k,l);
                    }
                    else{
                        column.get(k).add(a[j][k]);
                    }
                }

            }
            int r=0;
            int c=0;
            System.out.println(row);
            System.out.println(column);
            for(int g:row.keySet()){
                if(row.get(g).size()!=n)
                r++;
            }
            for(int g:column.keySet()){
                if(column.get(g).size()!=n)
                    c++;
            }
            System.out.println("Case #"+(i+1)+": "+sum+" "+r+" "+c);
        }
    }
}

