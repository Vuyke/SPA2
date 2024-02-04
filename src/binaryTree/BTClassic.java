package binaryTree;

import java.util.LinkedList;

import util.Osobe;
import util.Util;

public class BTClassic<T extends Comparable<T>> {
	private BTNode<T> root;

	public BTClassic(BTNode<T> root) {
		this.root = root;
	}

	public BTClassic() {
		this(null);
	}

	public boolean isEmpty() {
		return root == null;
	}
	
	public BTNode<T> getRoot() {
		return root;
	}
	
	public int nodeCount() {
		return nodeCount(root);
	}
	
	private int nodeCount(BTNode<T> cur) {///drugacije nego na sladjovima!!!
		if(cur == null)
			return 0;
		return nodeCount(cur.getLeft()) + nodeCount(cur.getRight()) + 1;
	}
	
	public int depth() {
		return depth(root);
	}
	
	private int depth(BTNode<T> cur) {//drugacije nego na slajdovima!!!
		if(cur == null)
			return -1;
		return Math.max(depth(cur.getLeft()), depth(cur.getRight())) + 1;
	}
	
	public void BFS() { //primer sa ispisom elemenata
		if(root == null) return;
		LinkedList<BTNode<T>> queue = new LinkedList<BTNode<T>>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BTNode<T> cur = queue.removeFirst();
			System.out.print(cur + ", ");
			if(cur.getLeft() != null)
				queue.add(cur.getLeft());
			if(cur.getRight() != null)
				queue.add(cur.getRight());
		}
		System.out.println();
	}
	
	public BTNode<T> DFS(T info) { //primer sa pretragom za element
		if(root == null) return null;
		LinkedList<BTNode<T>> queue = new LinkedList<BTNode<T>>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BTNode<T> cur = queue.removeLast();
			if(cur.getInfo().equals(info)) {
				return cur;
			}
			if(cur.getLeft() != null)
				queue.add(cur.getLeft());
			if(cur.getRight() != null)
				queue.add(cur.getRight());
		}
		return null;
	}
	public static void main(String args[]) {
		Osobe[] osobe = Util.osobe;
		BTNode<Osobe> jovan = new BTNode<Osobe>(osobe[0]);
		BTNode<Osobe> milana = new BTNode<Osobe>(osobe[1]);
		BTNode<Osobe> luka = new BTNode<Osobe>(osobe[2]);
		BTNode<Osobe> sebastijan = new BTNode<Osobe>(osobe[3]);
		BTNode<Osobe> milica = new BTNode<Osobe>(osobe[4]);
		BTNode<Osobe> danilo = new BTNode<Osobe>(osobe[5]);
		BTNode<Osobe> radmila = new BTNode<Osobe>(osobe[6]);
		BTNode<Osobe> ana = new BTNode<Osobe>(osobe[7]);
		jovan.setLeft(milana);
		jovan.setRight(luka);
		milana.setLeft(sebastijan);
		milana.setRight(milica);
		luka.setLeft(danilo);
		luka.setRight(radmila);
		radmila.setLeft(ana);
		BTClassic<Osobe> bin = new BTClassic<Osobe>(jovan);
		bin.BFS();
		System.out.println(bin.depth());
		System.out.println(bin.nodeCount());
	}
}
