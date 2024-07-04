import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.lang.Object;


public class Solution {
    
    public static boolean checkExists(List<Integer[]> jamie,int a,int b,int k,String name){
        Collections.sort(jamie, new Comparator<Integer[]>() {
            @Override
            public int compare(Integer[] o1, Integer[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int j = k; j< jamie.size(); j++){
            if((jamie.get(j)[1]<=a&&jamie.get(j)[1]<=b)||(jamie.get(j)[0]>=a&&jamie.get(j)[0]>=b)){
                if (j!=jamie.size()-1){
                    j++;
                  return checkExists(jamie,a,b,j,name);
                   
                } else {
                    return true;
                }
            } else {
                break;
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
	        List<Integer[]> jamie = new ArrayList<>();
	        List<Integer[]> cameron = new ArrayList<>();
	        jamie.add(new Integer[]{std.nextInt(),std.nextInt()});
	        StringBuilder str = new StringBuilder();
	        str.append("J");
            for(int i = 0; i <work-1;i++){
                
                int a = std.nextInt();
                int b = std.nextInt();
                
                if (checkExists(jamie,a,b,0,"j")){
                    jamie.add(new Integer[]{a,b});
                    str.append("J");
                } else if(cameron.size()==0){
                    cameron.add(new Integer[]{a,b});
                    str.append("C");
                } else if(cameron.size()!=0){
                    if(checkExists(cameron,a,b,0,"c")){
                        cameron.add(new Integer[]{a,b});
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