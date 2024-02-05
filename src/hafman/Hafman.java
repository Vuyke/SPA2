package hafman;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;

import binaryTree.BTClassic;
import binaryTree.BTNode;

public class Hafman {
	private static class Node implements Comparable<Node> {
		int frequency;
		char c;

		public Node(int frequency, char c) {
			this.frequency = frequency;
			this.c = c;
		}

		public int compareTo(Node o) {
			return frequency - o.frequency;
		}

		public String toString() {
			return "{" + c + ", " + frequency + "}";
		}
	}

	private LinkedList<Node> l;
	private BTClassic<Node> bin;

	public Hafman(String text) {
		frequencies(text);
		construct();
	}

	private void frequencies(String text) {
		l = new LinkedList<Node>();
		HashMap<Character, Node> map = new HashMap<Character, Node>();
		for (int i = 0; i < text.length(); i++) {
			char cur = text.charAt(i);
			Node tren = map.get(cur);
			if (tren != null) {
				tren.frequency++;
				continue;
			}
			tren = new Node(1, cur);
			l.addLast(tren);
			map.put(cur, tren);
		}
	}

	private void construct() {
		PriorityQueue<BTNode<Node>> prio = new PriorityQueue<BTNode<Node>>();
		Iterator<Node> it = l.iterator();
		while (it.hasNext()) {
			Node cur = it.next();
			BTNode<Node> n = new BTNode<Node>(cur);
			prio.add(n);
		}
		while (prio.size() >= 2) {
			BTNode<Node> n1 = prio.poll();
			BTNode<Node> n2 = prio.poll();
			Node cur = new Node(n1.getInfo().frequency + n2.getInfo().frequency, '?');
			BTNode<Node> n = new BTNode<Node>(cur, n1, n2);
			prio.add(n);
		}
		bin = new BTClassic(prio.poll());
	}

	public void print() {
		BTNode<Node> root = bin.getRoot();
		if (root.getLeft() == null && root.getRight() == null) {
			System.out.println(root.getInfo() + ": " + "1");
			return;
		}
		print(root, new String(""));
	}

	private void print(BTNode<Node> cur, String s) {
		if (cur.getLeft() == null && cur.getRight() == null) {
			System.out.println(cur.getInfo() + ": " + s);
			return;
		}
		if (cur.getLeft() != null) {
			print(cur.getLeft(), s + '1');
		}
		if (cur.getRight() != null) {
			print(cur.getRight(), s + '0');
		}
	}

	public static void main(String args[]) {
		Hafman h = new Hafman("ana voli milovana");
		h.print();
	}
}
