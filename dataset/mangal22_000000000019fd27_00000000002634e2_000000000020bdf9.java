import java.util.*;
public class Solution {
public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		List<String> li=new ArrayList<>();
		for(int i=0;i<n;i++) {
			int m=sc.nextInt();
			int[][] a=new int[m][2];
			int[] b=new int[m];
			boolean J=true;
			boolean C=true;
			Map<Integer,String> map=new HashMap<>();
			
			for(int j=0;j<m;j++) {
				a[j][0]=sc.nextInt();
				a[j][1]=sc.nextInt();
				map.put(j, "");
				b[j]=j;
			}
			
			for(int j=0;j<m;j++) {
				for(int k=j+1;k<m;k++) {
					if(a[k][0]<a[j][0]) {
						int temp1=a[j][0];
						int temp2=a[j][1];
						a[j][0]=a[k][0];
						a[j][1]=a[k][1];
						a[k][0]=temp1;
						a[k][1]=temp2;
						int temp3=b[j];
						b[j]=b[k];
						b[k]=temp3;
					}
				}
			}
			String op="";
			int jStart=0,jEnd=0,cStart=0,cEnd=0, l;
			for(int j=0;j<m;j++) {
				if(J) {
					jStart=a[j][0];
					jEnd=a[j][1];
					for(l=0;l<m;l++) {
						if(b[l]==j) {
							break;
						}
					}
					map.replace(l, "J");
					J=false;
				}
				else if(C) {
					cStart=a[j][0];
					cEnd=a[j][1];
					C=false;
					for(l=0;l<m;l++) {
						if(b[l]==j) {
							break;
						}
					}
					map.replace(l, "C");
				}
				else {
					if(a[j][0]>=jEnd) {
						jStart=a[j][0];
						jEnd=a[j][1];
						for(l=0;l<m;l++) {
							if(b[l]==j) {
								break;
							}
						}
						map.replace(l, "J");
						J=false;
					}
					else if(a[j][0]>=cEnd) {
						cStart=a[j][0];
						cEnd=a[j][1];
						C=false;
						for(l=0;l<m;l++) {
							if(b[l]==j) {
								break;
							}
						}
						map.replace(l, "C");
					}
					else {
						op="IMPOSSIBLE";
						break;
					}
				}
				
			}
			if(op.equalsIgnoreCase("IMPOSSIBLE")) {
				li.add(op);
				continue;
			}
			op="";
			for(Integer s: map.keySet()) {
				
				op+=map.get(s);
			}
			li.add(op);
			
		}
		for(int i=0;i<n;i++) {
			System.out.println("Case #"+(i+1)+": "+li.get(i));
		}

	}

}

