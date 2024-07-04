import java.util.*;
import java.io.*;
class Solution{
    
    private static String correct(String s,int[][] arr){
            StringBuilder sbb=new StringBuilder(s);
            for(int i=0;i<s.length();i++){
                sbb.setCharAt(arr[i][2],s.charAt(i));
                
            }
            return sbb.toString();
            
        }
    public static void main(String[] args){
        
        
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int kk=1;
        while(t-->0){
            int n=sc.nextInt();
            int[][] arr=new int[n][3];
            for(int i=0;i<n;i++){
                for(int j=0;j<2;j++){
                    arr[i][j]=sc.nextInt();
                }
                
            }
            int ll=0;
            for(int i=0;i<n;i++){
                arr[i][2]=ll++;
            }
            
            String init="";
            for(int i=0;i<n;i++){
                init+='P';
            }
            StringBuilder sb=new StringBuilder(init);
            Arrays.sort(arr,new Comparator<int[]>(){
                public int compare(int[] a1,int[] a2){
                    if(a1[1]>a2[1]){
                        return 1;
                    }
                    else{
                        return -1;
                    }
                    
                }}
                );
                
                List<Integer> lis=new ArrayList<>();
                lis.add(0);
                 
                     int fin=arr[0][1];
                sb.setCharAt(0,'J');
                for(int j=1;j<n;j++){
                    if(arr[j][0]>=fin){
                        lis.add(j);
                        fin=arr[j][1];
                        sb.setCharAt(j,'J');
                    }
                }
            
            int idx=Integer.MIN_VALUE;
            for(int i=0;i<sb.length();i++){
                if(sb.charAt(i)=='P'){
                    idx=i;
                    break;
                } 
            }
            if(idx==Integer.MIN_VALUE){
                System.out.println("Case #"+kk+": "+correct(sb.toString(),arr));
            }
            else{
            
                    int fin2=arr[idx][1];
                    sb.setCharAt(idx,'C');
                    for(int j=idx+1;j<n;j++){
                    if(arr[j][0]>=fin2 && !lis.contains(j)){
                        fin2=arr[j][1];
                        sb.setCharAt(j,'C');
                    }
                }
                    
                    
                
                int las=Integer.MIN_VALUE;
                for(int i=0;i<sb.length();i++){
                if(sb.charAt(i)=='P'){
                    las=i;
                    break;
                } 
            }
                
                if(las==Integer.MIN_VALUE){
                     System.out.println("Case #"+kk+": "+correct(sb.toString(),arr));
                }
                else{
                     System.out.println("Case #"+kk+": IMPOSSIBLE");
                    
                }
            }
                
     kk+=1;   
    }
    
    
    
}
}