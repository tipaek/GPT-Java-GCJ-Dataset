import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++) {
        	int activiy = input.nextInt();
        	int[][] map=new int[activiy][3];
        	StringBuffer str 
            = new StringBuffer(activiy); 
        	for(int i=0;i<activiy;i++){
        		map[i][0]=input.nextInt();
        		map[i][1]=input.nextInt();
        		map[i][2]=i;
        		str.append(i);
        	}
        	String output="";
        	int endtimec=0;
        	int endtimeJ=0;
        	for(int i=0;i<activiy;i++){
        		for(int j=i+1;j<activiy;j++){
        			if(map[i][0]>map[j][0]){
        				int temp1,temp2,temp3;
        				temp3=map[i][2];
        				temp1=map[i][0];
        				temp2=map[i][1];
        				map[i][0]=map[j][0];
        				map[i][1]=map[j][1];
        				map[i][2]=map[j][2];
        				map[j][0]=temp1;
        				map[j][1]=temp2;
        				map[j][2]=temp3;
        			}
        		}
	        	if(endtimec<=map[i][0]){
	       			 output+="C";
	       			 endtimec=map[i][1];
	       		 }
	       		 else if(endtimeJ<=map[i][0]){
	       			 output+="J";
	       			 endtimeJ=map[i][1];
	       		 }
	       		 else{
	       			 output="IMPOSSIBLE";
	       			 break;
	       		 }
        	}
        	if(!output.equals("IMPOSSIBLE")){
        		for(int i=0;i<activiy;i++){
        			str.setCharAt(map[i][2], output.charAt(i));
        		}
        	}
        	else{
        		str=new StringBuffer("IMPOSSIBLE");
        	}
        	System.out.printf("Case #%d: "+str, n + 1);
            System.out.println();
        }
    }

}
