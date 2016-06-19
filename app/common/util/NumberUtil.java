package common.util;

import java.util.Random;

public class NumberUtil {

	public static int getRandomNo(int max) {
		Random rnd = new Random();
		int r = rnd.nextInt(max);

		return r;
	}

}
