import java.util.*;
class p{
	public static void main(String[] args) {
	    Scanner sc= new Scanner(System.in);
	    int t=sc.nextInt();
	    for(int i=0;i<t;i++){
	    int n=sc.nextInt();
	    int[] x=new int[n];
	    int[] y=new int[n];//[n];
	for(int j=0;j<n;j++){
		x[j]=sc.nextInt();
		y[j]=sc.nextInt();
		//cin>>x[j]>>y[j];
	}
//	if(i==0){cout<<"\n";}
	//    remove_extra_whitespaces(x,v);
	boolean flag=false;
	for(int j=1;j<n;j++){
		if(x[j]<y[j-1]){
			flag=true;
		}
		else
			flag=false;
	}
	if(flag){
	//	cout<<" IMPOSSIBLE";
	System.out.print("Case #"+(i+1)+": IMPOSSIBLE");
	//	printf("Case #%d: IMPOSSIBLE",i+1);
	}
	else
	{
		//printf("Case #%d: ",i+1);
		char[] v=new char[n]; //v[n];
		v[0]='J';
		for(int j=1;j<n;j++){
           if(x[j]<y[j-1]){
              if(v[j-1]=='J')
              	v[j]='C';
              else
              	v[j]='J';
           }
           else{
           	if(v[j-1]=='C')
           		v[j]='C';
           	else
           		v[j]='J';
           }
		}
	//	remove_extra_whitespaces(v,v);
	System.out.print("Case #"+(i+1)+":");
	//	printf("Case #%d: ",i+1 );
			for(int j=0;j<n;j++)
			System.out.print(v[j]);
		    //printf("%c",v[j]);		//rintf("\n");
	}
	//remove_extra_whitespaces(x,v);    remove_extra_whitespaces(input,output);
   System.out.println("\n");
//	printf("\n");
		
	}
}
}