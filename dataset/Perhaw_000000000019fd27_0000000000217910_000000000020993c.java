import java.util.*;
import java.io.*;
class vishnu {
static int[][] arr;
static int[] arr1;
static int[] col;
static int[] arr2 = new int[3];
	public static void main(String[] args) {
	   
     Scanner ref = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
     int test = ref.nextInt();
     int con = 1;
     while(con<=test) {
    	 int size = ref.nextInt();
    	 arr = new int[size][size];
    	 col = new int[size];
    	 for(int index= 0; index<size; index++) {
    		 int code = 0;
    		 arr1 = new int[size];
    		 for(int index1 = 0; index1<size; index1++) {
    			 arr[index][index1] = ref.nextInt();
    			 if(code==0 && arr1[arr[index][index1]-1]>0) {
    				 code++;
    				 arr2[1]++;
    			 }else
    				 arr1[arr[index][index1]-1] = arr[index][index1];
    			 if(index==index1)
    				 arr2[0] = arr2[0]+arr[index][index1];
    			 if(index==size-1) {
    				 int a = 0;
    				 int code1 = 0;
    				 while(a<size) {
    					 if(code1==0 && col[arr[a][index1]-1]>0) {
    						 code1++;
    						 arr2[2]++;
    					 }else
    						 col[arr[a][index1]-1] = arr[a][index1];
    					 a++;
    				 }
    				 col = new int[size];
    			 }
    		 }
    	 }
    	 System.out.println("Case #"+con+": "+arr2[0]+" "+arr2[1]+" "+arr2[2]);
    	 con++;
     }
	}

}
