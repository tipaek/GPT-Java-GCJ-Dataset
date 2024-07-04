import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int k=1;k<=t;k++){
            int n=s.nextInt();
            int[][] point=new int[n][3];
            for(int i=0;i<n;i++) {
            	point[i][0]=s.nextInt();
            	point[i][1]=s.nextInt();
            	point[i][2]=i;
            	
            }
            Arrays.sort(point,(a,b)->a[0]-b[0]);
            
            char[] arr=new char[n];
            int sc=-1;
            int sj=-1;
            int ec=-1;
            int ej=-1;
            String str="";
            for(int i=0;i<n;i++) {
            	int start=point[i][0];
            	int end=point[i][1];
            	if(ec <= start ) {
            		arr[point[i][2]]='C';
            		sc=start;
            		ec=end;
            	}
            	else if(ej<=start) {
            		arr[point[i][2]]='J';
            		sj=start;
            		ej=end;
            	}
            	else {
            		str="IMPOSSIBLE";
            		break;
            		
            	}
            }
            
            if(str.equals("")) {
            for(char ch:arr)
            	str+=ch;
            }
            System.out.println("Case #"+k+": "+str);
        }
    }
}