package binaryTree;

public class BTNode<T extends Comparable<T>> implements Comparable<BTNode<T>>{
	private T info;
	private BTNode left;
	private BTNode right;

	public BTNode(T info, BTNode left, BTNode right) {
		this.info = info;
		this.left = left;
		this.right = right;
	}

	public BTNode(T info) {
		this(info, null, null);
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public BTNode getLeft() {
		return left;
	}

	public void setLeft(BTNode left) {
		this.left = left;
	}

	public BTNode getRight() {
		return right;
	}

	public void setRight(BTNode right) {
		this.right = right;
	}

	public String toString() {
		return info.toString();
	}

	@Override
	public int compareTo(BTNode<T> o) {
		return info.compareTo(o.info);
	}
}
