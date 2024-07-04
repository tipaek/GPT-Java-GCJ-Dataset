import java.util.*;
class Solution{
	 public static void main(String[] args) {
	 	Scanner sc=new Scanner(System.in);
	 	int t=sc.nextInt();
	 	sc.nextLine();
	 	int q=1;
	 	o: while(t-->0){
	 		//sc.nextLine();
	 		String ans="";
	 		String s=sc.nextLine();
	 		int i,j,k,y;
	 		for(i=0;i<s.length();i++){
	 			if(s.charAt(i)!='0')
	 				break;
	 		}
	 		ans=ans+s.substring(0,i);
	 		//System.out.println(ans+" yooo");
	 		if(i>=s.length()){
	 			System.out.println("Case #"+q+":"+" "+ans);
	 			q++;
	 			continue o;
	 		}
	 		int u=Integer.parseInt(s.substring(i,i+1));
	 		for(k=1;k<=u;k++)
	 				ans=ans+"(";
	 			//System.out.println(ans+" ufff");
	 			for(j=i+1;j<s.length();j++){
	 					if(s.charAt(j)!=s.charAt(i))
	 						break;
	 				}
	 			ans=ans+s.substring(i,j);
	 			for(k=1;k<u;k++)
	 				ans=ans+")";
	 		for(i=j;i<s.length();){
	 			 u=Integer.parseInt(s.substring(i,i+1));
	 			 if(u!=0){
	 			for(k=1;k<u;k++)
	 				ans=ans+"(";
	 				for(j=i+1;j<s.length();j++){
	 					if(s.charAt(j)!=s.charAt(i))
	 						break;
	 				}
	 			ans=ans+s.substring(i,j);
	 			for(k=1;k<u;k++)
	 				ans=ans+")";
	 			i=j;
	 		}
	 		else{
	 			ans=ans+")";
	 			for(y=i+1;y<s.length();y++){
	 				if(s.charAt(y)!='0')
	 					break;
	 			}
	 			ans=ans+s.substring(i,y);
	 			if(y>=s.length()){
	 			//System.out.println(ans);
	 				System.out.println("Case #"+q+":"+" "+ans);
	 				q++;
	 			continue o;
	 		}
	 		 u=Integer.parseInt(s.substring(y,y+1));
	 		 for(k=1;k<=u;k++)
	 				ans=ans+"(";
	 			for(j=y+1;j<s.length();j++){
	 					if(s.charAt(j)!=s.charAt(y))
	 						break;
	 				}
	 			ans=ans+s.substring(y,j);
	 			for(k=1;k<u;k++)
	 				ans=ans+")";
	 			i=j;
	 		}
	 	}
	 		ans=ans+")";
	 		//System.out.println(ans);
	 		System.out.println("Case #"+q+":"+" "+ans);
	 		q++;
	 	}
	 }
}