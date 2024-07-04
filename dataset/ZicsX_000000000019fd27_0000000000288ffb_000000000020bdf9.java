import java.util.*;public class Main
{private static Scanner scan;static int tn=1;public static void main(String[]args)
{scan=new Scanner(System.in);int t=scan.nextInt();scan.nextLine();while(t-->0)
{schedl();}}
private static void schedl()
{int n=scan.nextInt();int[][]mat=new int[n][2];int[][]mats=mat.clone();StringBuilder sb=new StringBuilder();Stack<int[]>JJ=new Stack<>();Stack<int[]>CC=new Stack<>();char person='J';char[]chars=new char[n];boolean impossible=false;Map<int[],Integer>map=new HashMap<>();for(int i=0;i<mat.length;i++)
{for(int j=0;j<mat[i].length;j++)
{mat[i][j]=scan.nextInt();}
map.put(mat[i],i);}
Arrays.sort(mats,new Comparator<int[]>()
{@Override
public int compare(int[]a,int[]b)
{return a[0]-b[0];}});for(int i=0;i<mats.length;i++)
{chars[map.get(mats[i])]=person;if(i<mats.length-1&&doesOverlap(mats[i],mats[i+1]))
{if(person=='J')
{JJ.push(mats[i]);person=getPerson(person);if(!CC.isEmpty()&&doesOverlap(CC.peek(),mats[i+1]))
{impossible=true;break;}}
else
{CC.push(mats[i]);person=getPerson(person);if(!JJ.isEmpty()&&doesOverlap(JJ.peek(),mats[i+1]))
{impossible=true;break;}}}
else
{if(person=='J')
{JJ.push(mats[i]);}
else
{CC.push(mats[i]);}}}
System.out.println("Case #"+(tn++)+": "+
(impossible?"IMPOSSIBLE":new String(chars)));}
private static char getPerson(char p)
{return p=='J'?'C':'J';}
private static boolean doesOverlap(int[]a,int[]b)
{return a[1]>b[0];}}