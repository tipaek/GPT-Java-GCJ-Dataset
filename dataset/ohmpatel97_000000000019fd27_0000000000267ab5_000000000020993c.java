import java.util.*;
class Solution{
    public static void main(String []args){
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        int c = 0;
        while(c < t){
            int trace = 0;
            int n = s.nextInt();
            HashMap hm = new HashMap();
            HashMap hmc = new HashMap();
            HashSet nr = new HashSet();
            HashSet nc = new HashSet();
            int arr[][] = new int[n][n];
            for(int  i= 0;i<n;i++){
                hm.put(i,new HashSet());
                for(int j = 0;j<n;j++){
                    arr[i][j] = s.nextInt();
                    HashSet row = (HashSet)hm.get(i);
                    if(row.contains(arr[i][j])){
                        nr.add(i);
                    }else{
                        row.add(arr[i][j]);
                        hm.put(i,row);
                    }
                    if(i == j){
                        trace += arr[i][j];
                    }

                }
            }



             for(int  j = 0;j<n;j++){
                hmc.put(j,new HashSet());
                for(int i = 0;i<n;i++){
                   HashSet column = (HashSet)hmc.get(j);
                     if(column.contains(arr[i][j])){
                        nc.add(j);
                    }else{
                        column.add(arr[i][j]);
                        hmc.put(i,column);
                    }
                }
            }

            System.out.println("Case #"+(c+1) + ": " + trace + " " + nr.size() + " " + nc.size());
            c++;
        }
    }
    public static int cal(int arr[][],int []topindices){
        int max = Integer.MIN_VALUE;
        int lasstackused = 0;
            for(int i = 0;i<arr.length;i++){
                if(topindices[i] < arr[i].length){
                    int top = (int) arr[i][topindices[i]];
                    if(max < top){
                        max = top;
                        lasstackused = i;
                    }
                    max = Math.max(top,max);
                }
            }
            topindices[lasstackused]++;
            return max;
    }
}