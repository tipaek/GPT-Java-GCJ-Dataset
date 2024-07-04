import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution3 {
	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			int t, B;
			String s[] = br.readLine().split(" ");
			t = Integer.parseInt(s[0]);
			B = Integer.parseInt(s[1]);
			for(int e = 0; e < t; ++e) {
				if(B==100 || B == 20) {
					ArrayList<int[]> lists[] = new ArrayList[(B/10)*4];
					for(int i = 0 ; i < (B/10)*4; ++i) {
						lists[i] = new ArrayList<>();
					}
					for(int i = 0; i<B/10; ++i) {
						for(int j = 5*i+1; j<=5*(i+1);++j) {
							System.out.println(j);
							int a = Integer.parseInt(br.readLine());
							System.out.println(B+1-j);
							int b = Integer.parseInt(br.readLine());
							int pair[] = {j,B+1-j};
							if(a==b && a == 0) {
								lists[4*i].add(pair);
							}
							else if(a==b && a != 0) {
								lists[4*i+3].add(pair);
							}
							else if(a!=b && a==1) {
								lists[4*i+2].add(pair);
							}
							else {
								lists[4*i+1].add(pair);
							}
						}
					}
					ArrayList<int[]> definitiveList0 = new ArrayList<>();
					ArrayList<int[]> definitiveList1 = new ArrayList<>();
					ArrayList<int[]> definitiveList2 = new ArrayList<>();
					ArrayList<int[]> definitiveList3 = new ArrayList<>();
					int notTrash = 0;
					for(int i = 0; i < B/10;++i) {
						int a = -1;
						int b = -1;
						if(lists[i*4].size()==0 && lists[i*4 +3].size() == 0) {
							continue;
						}
						if(definitiveList0.size() == 0 && definitiveList3.size()==0) {
							definitiveList0 = lists[4*i];
							definitiveList3 = lists[4*i+3];
							continue;
						}
						if(definitiveList0.size() == 0) {
							notTrash+=2;
							if(lists[i*4].size()==0) {
								System.out.println(definitiveList3.get(0)[0]);
								a = Integer.parseInt(br.readLine());
								System.out.println(lists[4*i+3].get(0)[0]);
								b = Integer.parseInt(br.readLine());
								if(a==b) {
									definitiveList3.addAll(lists[4*i+3]);
								}
								else {
									definitiveList0.addAll(lists[4*i+3]);
								}
							}
							else {
								System.out.println(definitiveList3.get(0)[0]);
								a = Integer.parseInt(br.readLine());
								System.out.println(lists[4*i].get(0)[0]);
								b = Integer.parseInt(br.readLine());
								if(a==b) {
									definitiveList3.addAll(lists[4*i]);
									definitiveList0.addAll(lists[4*i+3]);
								}
								else {
									definitiveList0.addAll(lists[4*i]);
									definitiveList3.addAll(lists[4*i+3]);
								}
							}
						}
						else {
							notTrash+=2;
							if(lists[i*4].size()==0) {
								System.out.println(definitiveList0.get(0)[0]);
								a = Integer.parseInt(br.readLine());
								System.out.println(lists[4*i+3].get(0)[0]);
								b = Integer.parseInt(br.readLine());
								if(a==b) {
									definitiveList0.addAll(lists[4*i+3]);
								}
								else {
									definitiveList3.addAll(lists[4*i+3]);
								}
							}
							else {
								System.out.println(definitiveList0.get(0)[0]);
								a = Integer.parseInt(br.readLine());
								System.out.println(lists[4*i].get(0)[0]);
								b = Integer.parseInt(br.readLine());
								if(a==b) {
									definitiveList0.addAll(lists[4*i]);
									definitiveList3.addAll(lists[4*i+3]);
								}
								else {
									definitiveList3.addAll(lists[4*i]);
									definitiveList0.addAll(lists[4*i+3]);
								}
							}
						}
					}
					if(B!=20) {
						for(int i = 0; i < 10 - notTrash; ++i ) {
							System.out.println("1");
							br.readLine();
						}
					}

					notTrash = 0;
					for(int i = 0; i < B/10;++i) {
						int a = -1;
						int b = -1;
						if(lists[i*4+1].size()==0 && lists[i*4 +2].size() == 0) {
							continue;
						}
						if(definitiveList1.size() == 0 && definitiveList2.size()==0) {
							definitiveList1 = lists[4*i+1];
							definitiveList2 = lists[4*i+2];
							continue;
						}
						if(definitiveList1.size() == 0) {
							notTrash+=2;
							if(lists[i*4+1].size()==0) {
								System.out.println(definitiveList2.get(0)[0]);
								a = Integer.parseInt(br.readLine());
								System.out.println(lists[4*i+2].get(0)[0]);
								b = Integer.parseInt(br.readLine());
								if(a==b) {
									definitiveList2.addAll(lists[4*i+2]);
								}
								else {
									definitiveList1.addAll(lists[4*i+1]);
								}
							}
							else {
								System.out.println(definitiveList2.get(0)[0]);
								a = Integer.parseInt(br.readLine());
								System.out.println(lists[4*i+1].get(0)[0]);
								b = Integer.parseInt(br.readLine());
								if(a==b) {
									definitiveList2.addAll(lists[4*i+1]);
									definitiveList1.addAll(lists[4*i+2]);
								}
								else {
									definitiveList1.addAll(lists[4*i+1]);
									definitiveList2.addAll(lists[4*i+2]);
								}
							}
						}
						else {
							notTrash+=2;
							if(lists[i*4+1].size()==0) {
								System.out.println(definitiveList1.get(0)[0]);
								a = Integer.parseInt(br.readLine());
								System.out.println(lists[4*i+2].get(0)[0]);
								b = Integer.parseInt(br.readLine());
								if(a==b) {
									definitiveList1.addAll(lists[4*i+2]);
								}
								else {
									definitiveList2.addAll(lists[4*i+2]);
								}
							}
							else {
								System.out.println(definitiveList1.get(0)[0]);
								a = Integer.parseInt(br.readLine());
								System.out.println(lists[4*i+1].get(0)[0]);
								b = Integer.parseInt(br.readLine());
								if(a==b) {
									definitiveList1.addAll(lists[4*i+1]);
									definitiveList2.addAll(lists[4*i+2]);
								}
								else {
									definitiveList2.addAll(lists[4*i+1]);
									definitiveList1.addAll(lists[4*i+2]);
								}
							}
						}
					}
					if (B!=20) {
						for(int i = 0; i < 10 - notTrash; ++i ) {
							System.out.println("1");
							br.readLine();
						}
					}

					int resp[] = new int[B];
					int a = -1;
					int b = -1;
					int c = -1;
					int d = -1;
					if(definitiveList0.size()!=0) {
						System.out.println(definitiveList0.get(0)[0]);
						a = Integer.parseInt(br.readLine());
					}
					else {
						if(definitiveList3.size()!=0) {
							System.out.println(definitiveList3.get(0)[0]);
							b = Integer.parseInt(br.readLine());
						}
					}
					if(definitiveList1.size()!=0) {
						System.out.println(definitiveList1.get(0)[0]);
						c = Integer.parseInt(br.readLine());
					}
					else {
						if(definitiveList2.size()!=0) {
							System.out.println(definitiveList2.get(0)[0]);
							d = Integer.parseInt(br.readLine());
						}

					}
					if(a == 1) {
						b = 0;
						for(int i = 0; i < definitiveList0.size();++i) {
							resp[definitiveList0.get(i)[0]-1] = a;
							resp[definitiveList0.get(i)[1]-1] = a;
						}
						for(int i = 0; i < definitiveList3.size();++i) {
							resp[definitiveList3.get(i)[0]-1] = b;
							resp[definitiveList3.get(i)[1]-1] = b;
						}
					}
					else if(a == 0) {
						b = 1;
						for(int i = 0; i < definitiveList0.size();++i) {
							resp[definitiveList0.get(i)[0]-1] = a;
							resp[definitiveList0.get(i)[1]-1] = a;
						}
						for(int i = 0; i < definitiveList3.size();++i) {
							resp[definitiveList3.get(i)[0]-1] = b;
							resp[definitiveList3.get(i)[1]-1] = b;
						}
					}
					else if (b == 1) {
						for(int i = 0; i < definitiveList3.size();++i) {
							resp[definitiveList3.get(i)[0]-1] = b;
							resp[definitiveList3.get(i)[1]-1] = b;
						}
					}
					else if(b == 0) {
						for(int i = 0; i < definitiveList3.size();++i) {
							resp[definitiveList3.get(i)[0]-1] = b;
							resp[definitiveList3.get(i)[1]-1] = b;
						}
					}
					if (c == 1) {
						d = 0;
						for(int i = 0 ; i < definitiveList1.size();++i) {
							resp[definitiveList1.get(i)[0]-1] = c;
							resp[definitiveList1.get(i)[1]-1] = d;
						}
						for(int i = 0 ; i < definitiveList2.size();++i) {
							resp[definitiveList2.get(i)[0]-1] = d;
							resp[definitiveList2.get(i)[1]-1] = c;
						}
					}
					else if(c == 0) {
						d = 1;
						for(int i = 0 ; i < definitiveList1.size();++i) {
							resp[definitiveList1.get(i)[0]-1] = c;
							resp[definitiveList1.get(i)[1]-1] = d;
						}
						for(int i = 0 ; i < definitiveList2.size();++i) {
							resp[definitiveList2.get(i)[0]-1] = d;
							resp[definitiveList2.get(i)[1]-1] = c;
						}
					}
					else if(d == 0) {
						c = 1;
						for(int i = 0; i < definitiveList2.size();++i) {
							resp[definitiveList2.get(i)[0]-1] = d;
							resp[definitiveList2.get(i)[1]-1] = c;
						}
					}
					else if(d == 1) {
						c = 0;
						for(int i = 0; i < definitiveList2.size();++i) {
							resp[definitiveList3.get(i)[0]-1] = d;
							resp[definitiveList3.get(i)[1]-1] = c;
						}
					}
					String l = "";
					for(int i = 0; i < B; ++i) {
						l+=resp[i];
					}
					System.out.println(l);
					br.readLine();	
				}
				if(B == 10) {
					String l = "";
					for(int i = 1; i <=B; ++i) {
						System.out.println(i);
						l+=br.readLine();
					}
					System.out.println(l);
				}

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
