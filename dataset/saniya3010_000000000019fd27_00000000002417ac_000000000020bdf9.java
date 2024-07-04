import java.util.*;
class Solution
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		    int t=sc.nextInt();
            for(int k=1;k<=t;k++){
                int n=sc.nextInt();
                int[] s=new int[n];
                int[] e=new int[n];
                for(int i=0;i<n;i++){
                    s[i]=sc.nextInt();
                    e[i]=sc.nextInt();
                }
                String ans="";
                ArrayList<Integer>[] al=new ArrayList[n];
                for(int i=0;i<n;i++){
                    al[i]=new ArrayList<Integer>();
                    for(int j=i+1;j<n;j++){
                        if((s[j]>s[i] && s[j]<e[i]) || (e[j]>s[i] && e[j]<e[i])) al[i].add(j);
                    }
                }
                int f=0;
                for(int i=0;i<n;i++){
                    for(int j=0;j<al[i].size();j++){
                        int x=al[i].get(j);
                        for(int l=j+1;l<al[i].size();l++){
                            for(int m=0;m<al[x].size();m++){
                                if(al[x].get(m)==al[i].get(l)){ f=1; break;}
                            }
                            if(f==1) break;
                        }
                        if(f==1) break;
                    }
                    if(f==1) break;
                }
                if(f==1) ans="IMPOSSIBLE";
                else{
                    String[] st=new String[n];
                    for(int i=0;i<n;i++){
                        if(i==0){ 
                            st[i]="C";
                            for(int j=0;j<al[i].size();j++){
                                st[al[i].get(j)] ="J";
                            }
                        }
                        else if(st[i]!="C" && st[i]!="J"){
                            st[i]="C";
                            for(int j=0;j<al[i].size();j++){
                                st[al[i].get(j)] ="J";
                            }
                        }
                        else{
                            if(st[i]=="C"){
                                for(int j=0;j<al[i].size();j++){
                                    st[al[i].get(j)] ="J";
                                }
                            }
                            else{
                                for(int j=0;j<al[i].size();j++){
                                    st[al[i].get(j)] ="C";
                                }
                            }
                        }
                    }
                    for(int i=0;i<n;i++){
                        ans+=st[i];
                    }
                }
                
                System.out.println("Case #"+k+": "+ans);
            }
	}
}

