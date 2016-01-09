package codestars;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

public class task4 {
	// aka BFS
	String start;
	Graph g;
	static int counter = 0;

	public static class Graph {
		HashMap<String, Set<String>> adj;
		int V;

		public Graph() {
			adj = new HashMap<String, Set<String>>();
			V = 0;
		}

		public void addV(String item) {
			adj.put(item, null);
			V++;
			//System.err.println("added " + item + " V=" + V);
		}

		public void addE(String p, String q) {
			if (!adj.containsKey(p))
				addV(p);
			if (!adj.containsKey(q))
				addV(q);
			Set<String> padj = adj(p);
			if (padj == null){
				padj = new HashSet<String>();
				adj.put(p, padj);
			}
			Set<String> qadj = adj(q);
			if (qadj == null){
				qadj = new HashSet<String>();
				adj.put(q, qadj);
			}
			padj.add(q);
			qadj.add(p);
			//System.err.println(p+" : "+adj(p));
			//System.err.println(q+" : "+adj(q));
		}

		public Set<String> adj(String item) {
			return adj.get(item);
		}

		public int V() {
			return V;
		}
	}

	public task4(Graph g, String st) {
		start = st;
		this.g = g;
	}

	public int search(String item) {
		LinkedList<String> qu = new LinkedList<String>();
		Set<String> vi = new HashSet<String>();
		int result = 0;
		String cur = start;
		//System.err.println(vi.size()+" "+g.V());
		while (vi.size() < g.V()) {
			System.err.println(cur);
			if (cur.equals(item))
				return result;
			//System.err.println(cur+g.adj(cur));
			for(String v: g.adj(cur))
				if(!vi.contains(v))
					qu.add(v);
			vi.add(cur);
			cur = qu.poll();
			result++;
		}
		return -1;
	}

	public static void main(String[] args) throws IOException {
		Scanner in;
		PrintWriter out;
		PrintWriter debug;
		in = new Scanner(new File("24.data"));
		out = new PrintWriter(System.out);
		debug = new PrintWriter(new File("24.debug"));
		Graph g = new task4.Graph();
		while (in.hasNextLine()) {
			try {
				String name = in.next();
				String p = in.next();
				String q = in.next();
				//debug.println(name + " " + p + " " + q);
				g.addE(p, q);
			} catch (Exception e) {
				debug.close();
			}
		}
		debug.println(g.adj);
		task4 bfs = new task4(g, "Албанский");
		out.println(bfs.search("Исландский"));
		debug.close();
		in.close();
		out.close();
	}

}
