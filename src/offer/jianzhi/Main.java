package offer.jianzhi;

public class Main {
	public static void main(String[] args) {
		MatrixPath test = new MatrixPath();
		char[] array = "ABCEHJIGSFCSLOPQADEEMNOEADIDEJFMVCEIFGGS".toCharArray();
		char[] str = "SGGFIECVAASABCEHJIGQEMS".toCharArray();
		System.out.println(test.hasPath(array, 5, 8, str));
	}
}

/**
 * ABCEHJIG
 * SFCSLOPQ
 * ADEEMNOE
 * ADIDEJFM
 * VCEIFGGS
 */
