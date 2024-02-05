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

	private int nodeCount(BTNode<T> cur) {/// drugacije nego na sladjovima!!!
		if (cur == null)
			return 0;
		return nodeCount(cur.getLeft()) + nodeCount(cur.getRight()) + 1;
	}

	public int depth() {
		return depth(root);
	}

	private int depth(BTNode<T> cur) {// drugacije nego na slajdovima!!!
		if (cur == null)
			return -1;
		return Math.max(depth(cur.getLeft()), depth(cur.getRight())) + 1;
	}

	public BTNode<T> BFS(T info) {
		if (root == null)
			return null;
		LinkedList<BTNode<T>> queue = new LinkedList<BTNode<T>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BTNode<T> cur = queue.removeFirst();
			if (cur.getInfo().equals(info)) {
				return cur;
			}
			if (cur.getLeft() != null)
				queue.add(cur.getLeft());
			if (cur.getRight() != null)
				queue.add(cur.getRight());
		}
		return null;
	}

	public BTNode<T> DFS(T info) { // primer sa pretragom za element
		if (root == null)
			return null;
		LinkedList<BTNode<T>> queue = new LinkedList<BTNode<T>>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BTNode<T> cur = queue.removeLast();
			if (cur.getInfo().equals(info)) {
				return cur;
			}
			if (cur.getLeft() != null)
				queue.add(cur.getLeft());
			if (cur.getRight() != null)
				queue.add(cur.getRight());
		}
		return null;
	}

	public void preOrder() {
		preOrder(root);
		System.out.println();
	}

	private void preOrder(BTNode<T> cur) {
		if (cur == null)
			return;
		System.out.print(cur);
		preOrder(cur.getLeft());
		preOrder(cur.getRight());
	}

	public void inOrder() {
		inOrder(root);
		System.out.println();
	}

	private void inOrder(BTNode<T> cur) {
		if (cur == null)
			return;
		inOrder(cur.getLeft());
		System.out.print(cur);
		inOrder(cur.getRight());
	}

	public void postOrder() {
		postOrder(root);
		System.out.println();
	}

	private void postOrder(BTNode<T> cur) {
		if (cur == null)
			return;
		postOrder(cur.getLeft());
		postOrder(cur.getRight());
		System.out.print(cur);
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

		bin.preOrder();
		System.out.println(bin.depth());
		System.out.println(bin.nodeCount());
		BTNode<Osobe> cur = bin.DFS(new Osobe(11, "Jovan"));
		if (cur == null) {
			System.out.println("Ne postoji!!!");
		} else {
			System.out.println("Postoji: " + cur);
		}

	}
}
