package sortiranjeLista;

public class SortableList<T extends Comparable<T>> {
	private class Node {
		T info;
		Node next;

		public Node(T info) {
			this.info = info;
		}
	}

	private Node root;

	public SortableList() {
		this.root = null;
	}

	public void add(T elem) {
		Node cur = new Node(elem);
		cur.next = root;
		root = cur;
	}

	public void ispis() {
		Node cur = root;
		while (cur != null) {
			System.out.print(cur.info + " ");
			cur = cur.next;
		}
		System.out.println();
	}

	public void umetanjeSort() {
		if (root == null || root.next == null)
			return;
		Node lastSorted = root;
		while (lastSorted.next != null) {
			Node firstUnsorted = lastSorted.next;
			if (firstUnsorted.info.compareTo(lastSorted.info) >= 0) {
				lastSorted = firstUnsorted;
				continue;
			}
			lastSorted.next = firstUnsorted.next;
			if (firstUnsorted.info.compareTo(root.info) < 0) {
				firstUnsorted.next = root;
				root = firstUnsorted;
				continue;
			}
			Node i = root;
			while (i.next.info.compareTo(firstUnsorted.info) < 0) {
				i = i.next;
			}
			Node tmp = i.next;
			i.next = firstUnsorted;
			firstUnsorted.next = tmp;
		}
	}
	
	private Node quickSort(Node start) {
		Node left = null, right = null;
		Node pivot = start;
		Node cur = pivot.next;
		while(cur != null) {
			Node next = cur.next;
			if(cur.info.compareTo(pivot.info) <= 0) {
				cur.next = left;
				left = cur;
			}
			else {
				cur.next = right;
				right = cur;
			}
			cur = next;
		}
		if(left != null) {
			left = quickSort(left);
		}
		if(right != null) {
			right = quickSort(right);
		}
		pivot.next = right;
		if(left == null) return pivot;
		Node tmp = left;
		while(tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = pivot;
		pivot = left;
		return pivot;
	}
	
	public void quickSort() {
		if(root == null) return;
		root = quickSort(root);
	}
}
