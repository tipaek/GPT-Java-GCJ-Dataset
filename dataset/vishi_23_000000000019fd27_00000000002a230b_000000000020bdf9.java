import java.util.Scanner;

class Solution {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int tc=sc.nextInt();
	    int t=1;
		while(tc>0){
			int l=sc.nextInt();
			int a[][]=new int[l][2];
			for(int i=0;i<l;i++){
				for(int j=0;j<2;j++){
					a[i][j]=sc.nextInt();
				}
			}
			String result=find(a);
			System.out.println("Case #"+t+": "+result);
			t++;
			tc--;
		}
		sc.close();
	}

	static String find(int a[][]){
		String fs="C";
		int count=0,temp=0;
		boolean flag=false;
		for(int i=0;i<a.length-1;i++){
		    for(int j=0;j<2;j=j+2){
		        for(int k=i+1;k<a.length;k++){
		            if(a[i][j]<a[k][0]&&a[i][j+1]>a[k][0]||a[i][j]<a[k][1]&&a[i][j+1]>a[k][1]){
						if(flag!=true){
							count++;
							temp=temp+count;
                        }else{
							break;
						}
					}else{
						if(fs.charAt(fs.length()-1)=='C'){
							fs=fs+"C";
						}else{
							fs=fs+"J";
						}
						flag=false;
					}
				    if(temp>1){
							count=0;
							flag=true;
							break;
					}else{  
						    if(count==1){
								if(fs.charAt(fs.length()-1)=='C'){
									fs=fs+"J";
								}else{
									fs=fs+"C";
								}
							}
							count=0;
					}
				}
			}
			if(fs.length()==a.length||temp==a.length-1){
				break;
			}
			temp=0;
			
		}
		if(fs.length()<a.length){
		    return "IMPOSSIBLE";
		}else{
		    return fs;
		}
	}
}