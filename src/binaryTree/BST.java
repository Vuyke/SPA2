package binaryTree;

import set.Set;
import util.Osobe;
import util.Util;

public class BST<T extends Comparable<T>> implements Set<T> {
	private class SearchResult {
		BTNode<T> node, parent;

		public SearchResult(BTNode<T> node, BTNode<T> parent) {
			this.node = node;
			this.parent = parent;
		}
	}

	private BTNode<T> root;
	
	public BST() {
		this.root = null;
	}

	private SearchResult search(T info) {
		BTNode<T> parent = null;
		BTNode<T> cur = root;
		while (cur != null) {
			int cmp = cur.getInfo().compareTo(info);
			if (cmp == 0) {
				return new SearchResult(cur, parent);
			}
			parent = cur;
			if (cmp > 0) {
				cur = cur.getLeft();
			} else {
				cur = cur.getRight();
			}
		}
		return new SearchResult(cur, parent);
	}

	@Override
	public boolean add(T element) {
		SearchResult s = search(element);
		if (s.node != null)
			return false;
		BTNode<T> node = new BTNode<T>(element);
		if (s.parent == null) {
			root = node;
			return true;
		}
		if (s.parent.getInfo().compareTo(element) > 0) {
			s.parent.setLeft(node);
		} else {
			s.parent.setRight(node);
		}
		return true;
	}

	private void removeTrivial(SearchResult s) { // funkcija za brisanje cvora koji ima <= 1 dete
		BTNode<T> exists = s.node.getRight() == null ? s.node.getLeft() : s.node.getRight();
		if (s.parent == null) {
			root = exists;
		} else if (s.parent.getLeft() == s.node) {
			s.parent.setLeft(exists);
		} else {
			s.parent.setRight(exists);
		}
	}

	@Override
	public boolean remove(T element) {
		SearchResult s = search(element);
		if (s.node == null)
			return false;
		if (s.node.getLeft() == null || s.node.getRight() == null) {
			removeTrivial(s); //cvor ima <= 1 dete
			return true;
		}
		BTNode<T> cur = s.node.getRight(); //odavde cvor ima 2 deteta pa ga menjamo sa prvim vecim od njega
		BTNode<T> par = s.node;
		while (cur.getLeft() != null) {
			par = cur;
			cur = cur.getLeft();
		}//cur je sada prvi veci od njega i sigurno ima <= 1 dete
		T info = cur.getInfo(); //cuvamo info iz cura posto cemo ga dati s.node-u
		removeTrivial(new SearchResult(cur, par));//brisemo bez problema posto ima <= 1 dete
		s.node.setInfo(info);//namestamo info u node kako treba
		return true;
	}

	@Override
	public boolean contains(T element) {
		SearchResult s = search(element);
		return s.node != null;
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
	
	public static void main(String args[]) {
		BST<Osobe> bin = new BST<Osobe>();
		Osobe[] osobe = Util.osobe;
		for(Osobe osoba : osobe) {
			bin.add(osoba);
		}
		bin.preOrder();
		if(bin.remove(osobe[3])) {
			System.out.println("Obrisan!!!");
		}
		bin.preOrder();	
	}
}
