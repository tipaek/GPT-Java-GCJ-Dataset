import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    public static boolean checkExists(List<int[]> jamie,int a,int b,int k,String name){
        for(int j = k; j< jamie.size(); j++){
            if((jamie.get(j)[0]<=a&&jamie.get(j)[1]<=a)||(jamie.get(j)[0]>=b&&jamie.get(j)[1]>=b)){
                if (j!=jamie.size()-1){
                    j++;
                  return checkExists(jamie,a,b,j,name);
                   
                } else {
                    return true;
                }
            }
        }
        return false;
    }
    
	public static void main(String[] args) {
		String number;
		Scanner std = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = std.nextInt();
	    for (int caseNumber = 1; caseNumber <=t; caseNumber++){
	        int work = std.nextInt();
	        List<int[]> jamie = new ArrayList<>();
	        List<int[]> cameron = new ArrayList<>();
	        jamie.add(new int[]{std.nextInt(),std.nextInt()});
	        StringBuilder str = new StringBuilder();
	        str.append("J");
            for(int i = 0; i <work-1;i++){
                
                int a = std.nextInt();
                int b = std.nextInt();
                if (checkExists(jamie,a,b,0,"j")){
                    jamie.add(new int[]{a,b});
                    str.append("J");
                } else if(cameron.size()==0){
                    cameron.add(new int[]{a,b});
                    str.append("C");
                } else if(cameron.size()!=0){
                    if(checkExists(cameron,a,b,0,"c")){
                        cameron.add(new int[]{a,b});
                        str.append("C");
                    }
                } 
            }
            
            if(str.length()==work){
                System.out.println("Case #" + caseNumber + ": " +str);
            } else {
                System.out.println("Case #" + caseNumber + ": IMPOSSIBLE");
            }
	    }
	}
}