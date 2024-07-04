import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner s =new Scanner(System.in);
        int t = s.nextInt();
        int count =1;
        while(t-->0){
            int n = s.nextInt();
            int a[][] = new int[n][3];
            for(int i=0;i<n;i++){
                a[i][0]=s.nextInt();
                a[i][1]=s.nextInt();
				a[i][2]=i;
            }
             Arrays.sort(a, new Comparator<int[]>() { 
					@Override             
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
            if (entry1[0] > entry2[0]) 
                return 1; 
            else
                return -1; 
          } 
        });
            String ans = "";
            int c=0,j=0;
            c=a[0][1];
            ans +="C";
            boolean flag = true;
            for(int i=1;i<n;i++){
                if(a[i][0]>=c){
                    c=a[i][1];
                    ans+="C";
                }else if(a[i][0]>=j){
                    ans+="J";
                    j=a[i][1];
                }else{
                    ans = "IMPOSSIBLE";
                    flag =false;
                    break;
                }
                if(a[i][0]>=c)
                c=0;
                if(a[i][0]>=j)
                j=0;
            }
            if(flag){
            char ca[] = ans.toCharArray();
            System.out.print("Case #"+count+++": ");
			for(int[] x:a){
				System.out.print(ca[x[2]]);
			}
			System.out.println();
        }else{
           System.out.println("Case #"+count+++": "+ans);
        }
            
        }
    }
}