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
	
	private Node merge(Node l1, Node l2) {
		Node cur;
		if(l1.info.compareTo(l2.info) < 0) {
			cur = l1;
			l1 = l1.next;
		}
		else {
			cur = l2;
			l2 = l2.next;
		}
		Node last = cur;
		while(l1 != null && l2 != null) {
			if(l1.info.compareTo(l2.info) < 0) {
				last.next = l1;
				last = last.next;
				l1 = l1.next;
			}
			else {
				last.next = l2;
				last = last.next;
				l2 = l2.next;
			}
		}
		last.next = l1 == null ? l2 : l1;
		return cur;
	}
	
	private Node mergeSort(Node start) {
		Node l1 = start, l2 = start.next;
		Node l1End = l1, l2End = l2;
		Node cur = start.next.next;
		while(cur != null) {
			l1End.next = cur;
			l1End = l1End.next;
			cur = cur.next;
			if(cur != null) {
				l2End.next = cur;
				l2End = l2End.next;
				cur = cur.next;
			}
		}
		l1End.next = null;
		l2End.next = null;
		if(l1.next != null) l1 = mergeSort(l1);
		if(l2.next != null) l2 = mergeSort(l2);
		return merge(l1, l2);
	}
	
	public void mergeSort() {
		if(root == null || root.next == null) return;
		root = mergeSort(root);
	}
}
