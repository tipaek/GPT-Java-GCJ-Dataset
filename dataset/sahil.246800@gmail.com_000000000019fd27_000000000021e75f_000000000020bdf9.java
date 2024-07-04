import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i =1; i<=t; i++){
            int n = sc.nextInt();
            StringBuffer str = new StringBuffer();
            int[][] a = new int[n][2];
            int[] arr = new int[1441];
            int[] brr = new int[1441];
            int[] paint = new int[1441];
            ArrayList<Integer>[] arrayLists = new ArrayList[1441]; 
            for(int j=0; j<1441; j++){
                arrayLists[j] = new ArrayList<>();
            }

            for(int j=0; j<n; j++){
                a[j][0] = sc.nextInt();
                a[j][1] = sc.nextInt();
                arr[a[j][0]]++;
                brr[a[j][1]-1]--;
                arrayLists[a[j][0]].add(j);
            }
            int count = 0;
            boolean flag = false;
            for(int j=0; j<1441; j++){
                count+=arr[j];
                if(count>=3){
                    flag = true;
                    break;
                }
                count+=brr[j];
            }            
            if(flag){
                str.append("IMPOSSIBLE");
            }
            else{
                char[] chars = new char[n];
                for(ArrayList<Integer> arrayList : arrayLists){
                    for(int u : arrayList){
                        if(paint[a[u][0]]==0 || paint[a[u][0]]==2){
                            for(int r = a[u][0]; r<a[u][1]; r++){
                                paint[r] = 1;
                            }
                            chars[u] = 'C';
                        }
                        else if(paint[a[u][0]]==1){
                            for(int r = a[u][0]; r<a[u][1]; r++){
                                paint[r] = 2;
                            }
                            chars[u] = 'J';
                        }
                    }
                }
                for(int j=0;j<n;j++){
                    str.append(chars[j]);
                }
            }
            System.out.println("Case #"+i+": "+str);
        }
        sc.close();
    }
}