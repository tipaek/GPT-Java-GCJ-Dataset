import java.util.*;
class NestingDepth{
	public static void main(String[] args){
	     Scanner sc=new Scanner(System.in);
         int n=sc.nextInt();
         for(int i=0;i<n;i++){
         	String s=sc.next();
         	String[] snum=s.split("");
         	int[] num=new int[snum.length];
         	int tot=0;
         	for(int j=0;j<snum.length;j++){
         		num[j]=Integer.parseInt(snum[j]);
         		if(tot<num[j]){
         		tot=tot+num[j]-tot;
         	    }
         	}
            String str="";
            int temp=num[0];
            int endp=temp;
            int l=temp;
            while(l>0){
            	str=str+"(";
            	l--;
            }
            str=str+temp;
            for(int k=1;k<num.length-1;k++){
                if(num[k]>temp){
                	int addp=num[k]-temp;
                	int p=addp;
                	endp+=addp;
                	while(p>0){
                		str=str+"(";
                		p--;
                	}
                	str=str+num[k];
                	temp=num[k];
                }
                else{
                	str=str+num[k];
                }
                
            }
            int last=num[num.length-1];
            if(last>temp){
            	    int addp=last-temp;
                	int p=addp;
                	endp+=addp;
                	while(p>0){
                		str=str+"(";
                		p--;
                	}
                }
            str=str+last;
            while(endp>0){
            	str=str+")";
            	endp--;
            }
              System.out.println(str);
            } 
         }
	}
