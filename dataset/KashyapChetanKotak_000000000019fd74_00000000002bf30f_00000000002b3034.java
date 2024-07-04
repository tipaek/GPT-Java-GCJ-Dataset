import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int n = sc.nextInt();
			StringBuilder result=new StringBuilder();
//			String[] str=new String[n];
			int longInd=0;
			int longest=-1;
			sc.nextLine();
			for(int i=0;i<n;i++) {
				String str=sc.nextLine();
				//System.out.println("got "+str);
				//System.out.println("curr result:"+result.toString());
				if(i==0 || result.toString().equals("*")) {
					result=new StringBuilder();
					result.append(str);
					//System.out.println("set again:"+result.toString());
					continue;
				}
				if(str.indexOf('*')==-1 && result.toString().contains(str)) {
					result=new StringBuilder(str);
					continue;
				}
				else if(str.indexOf('*')==-1 && !result.toString().contains(str)) {
					result=new StringBuilder("*");
					break;
				}
				else if(result.toString().contains(str.replace("*",""))) {
					//System.out.println("if");
					continue; // do nothing
				} else {
					//System.out.println("else 1");
					String[] resultSplit=result.toString().split("\\*");
					//System.out.println(result);
					//System.out.println(resultSplit[0]);
					//System.out.println(resultSplit[1]);
					//System.out.println("============");
					boolean doBreak=false;
					boolean gotIndex=false;
					for(int j=0;j<resultSplit.length;j++) {
						int foundStr=str.indexOf(resultSplit[j]);
						if(foundStr!=-1) {
							int index=result.indexOf(resultSplit[j]);
							//System.out.println(index);
							//System.out.println(resultSplit[j]);
							if(!resultSplit[j].equals("")) {
								if((foundStr==0 || (foundStr==1 && str.charAt(0)=='*')) && result.charAt(index+resultSplit[j].length())=='*')
									index=index+resultSplit[j].length();
								else if(foundStr!=0 && result.charAt(index-1)=='*')
									index=index-1;
								
								result.replace(index,index+1,str.replaceAll(resultSplit[j],""));
								gotIndex=true;
								break;
							}
						} else if(resultSplit.length==1 && foundStr==-1) {
							result=new StringBuilder("*");
							doBreak=true;
						}
					}
					if(gotIndex==false) {
						result=new StringBuilder("*");
						break;
					}
					if(doBreak)
						break;
				}
				
			}
			
			
			
			String finalStr=result.toString().replace("*","");
			if(finalStr.length()==0)
				finalStr="*";
			System.out.println("Case #"+tc+": "+finalStr);
			
		}//tc
	}//main
}
