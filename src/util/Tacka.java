package util;

public class Tacka {
	private double x, y;

	public Tacka(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}
	
	public double dist(Tacka t) {
		return Math.sqrt((t.x - x) * (t.x - x) + (t.y - y) * (t.y - y));
	}
	
	public String toString() {
		return "{" + x + ", " + y + "}";
	}
	
	public static int compareX(Tacka t1, Tacka t2) {
		if(t1.x == t2.x)
			return 0;
		if(t1.x < t2.x)
			return -1;
		return 1;
	}
	
	public static int compareY(Tacka t1, Tacka t2) {
		if(t1.y == t2.y)
			return 0;
		if(t1.y < t2.y)
			return -1;
		return 1;
	}
}
