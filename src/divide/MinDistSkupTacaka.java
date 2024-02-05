package divide;

import java.util.LinkedList;

import naprednoSortiranje.SortiranjeNap;
import util.Tacka;
import util.Util;

public class MinDistSkupTacaka {
	private Tacka[] tacke;

	public MinDistSkupTacaka(Tacka[] tacke) {
		if (tacke.length <= 2)
			throw new IllegalArgumentException("Mora bas 2 elementa");
		this.tacke = tacke;
	}

	public double findMin() {
		SortiranjeNap.quickSort(tacke, Tacka::compareX);
		return findMin(0, tacke.length - 1);
	}

	private double findMin(int l, int r) {
		if (l == r)
			return Double.MAX_VALUE;
		if (r - l == 1)
			return tacke[l].dist(tacke[r]);
		int mid = l + r >> 1;
		double bestL = findMin(l, mid);
		double bestR = findMin(mid + 1, r);
		double delta = Math.min(bestL, bestR);
		double bestDelta = findBestDelta(l, r, mid, delta);
		return bestDelta;
	}

	private Tacka[] tackePoY(int l, int r, int mid, double delta) {
		double median = tacke[mid].getX();
		LinkedList<Tacka> cur = new LinkedList<Tacka>();
		int boxSize = 0;
		for (int i = l; i <= r; i++) {
			if (Math.abs(median - tacke[i].getX()) <= delta) {
				cur.add(tacke[i]);
			}
		}
		Tacka[] tacke = new Tacka[cur.size()];
		for (int i = 0; i < tacke.length; i++) {
			tacke[i] = cur.remove();
		}
		SortiranjeNap.quickSort(tacke, Tacka::compareY);
		return tacke;
	}

	private double findBestDelta(int l, int r, int mid, double delta) {
		double bestDelta = delta;
		Tacka[] noveTacke = tackePoY(l, r, mid, delta);
		for (int i = 0; i < noveTacke.length; i++) {
			Tacka cur = noveTacke[i];
			for (int j = i + 1; j < noveTacke.length; j++) {
				if (tacke[j].getY() - cur.getY() >= bestDelta) {
					break;
				}
				double d = tacke[j].dist(cur);
				if (d < bestDelta) {
					bestDelta = d;
				}
			}
		}
		return bestDelta;
	}

	public double findBruteForce() {
		double best = Double.MAX_VALUE;
		for (int i = 0; i < tacke.length; i++) {
			for (int j = i + 1; j < tacke.length; j++) {
				best = Math.min(best, tacke[i].dist(tacke[j]));
			}
		}
		return best;
	}

	public static void main(String args[]) {
		MinDistSkupTacaka min = new MinDistSkupTacaka(Util.tacke);
		System.out.println(min.findMin());
		System.out.println(min.findBruteForce());
	}
}
