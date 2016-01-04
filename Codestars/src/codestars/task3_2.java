package codestars;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class task3_2 {
	int[] id;
	int[] sz;
	int count;

	public task3_2(int N) {
		count = N;
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			sz[i] = 1;
			id[i] = i;
		}
	}

	public int find(int p) {
		if(p>=id.length){System.err.println(p);}
		while (p != id[p])
			p = id[p];
		return p;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public void union(int p, int q) {
		int i = find(p);
		int j = find(q);
		if (i == j)
			return;
		if (sz[i] > sz[j]) {
			id[j] = i;
			sz[i] += sz[j];
		} else {
			id[i] = j;
			sz[j] += sz[i];
		}
		count--;
	}
	
	public int count(){
		return count;
	}

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(new File("19.data"));
		PrintStream out = System.out;
		task3_2 uf = new task3_2(1001);
		while(in.hasNext()){
			int p = in.nextInt();
			int q = in.nextInt();
			uf.union(p, q);
		}
		int fake = 0;
		for(int i=0; i<uf.sz.length;i++){
			if(uf.sz[i]==1&&uf.id[i]==i){fake++;}
		}
		in.close();
		out.println(uf.count()-fake);
	}

}
