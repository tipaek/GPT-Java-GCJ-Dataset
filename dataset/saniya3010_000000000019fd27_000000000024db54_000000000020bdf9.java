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
                        for(int l=0;l<al[i].size();l++){
                            if(l==i) continue;
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
                    int c=0,g=0;
                    String[] st=new String[n];
                    for(int i=0;i<n;i++){
                        if(g==0 && st[i]!="C" && st[i]!="J"){ 
                            st[i]="C";
                            for(int j=0;j<al[i].size();j++){
                                st[al[i].get(j)] ="J";
                                c++;
                            }
                            c++;
                            g=1;
                        }
                        else if(st[i]!="C" && st[i]!="J"){
                            for(int j=0;j<al[i].size();j++){
                                if(st[al[i].get(j)] =="J"){
                                    st[i]="C";
                                    c++;
                                    break;
                                }
                                else if(st[al[i].get(j)] =="C"){
                                    st[i]="J";
                                    c++;
                                    break;
                                }
                            }
                        }
                        else{
                            if(st[i]=="C"){
                                for(int j=0;j<al[i].size();j++){
                                    if(st[al[i].get(j)] !="J"){
                                        c++;
                                        st[al[i].get(j)] ="J";
                                    }
                                }
                            }
                            else{
                                for(int j=0;j<al[i].size();j++){
                                    if(st[al[i].get(j)] !="C"){
                                        c++;
                                        st[al[i].get(j)] ="C";
                                    }
                                }
                            }
                        }
                        if(c!=n && i==n-1){
                            i=0;
                            g=0;
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
