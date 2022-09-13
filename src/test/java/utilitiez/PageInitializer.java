package utilitiez;

import pages.commonPage;
import pages.loginPage;

public class PageInitializer extends BaseClass {

	public static loginPage lp;
	public static commonPage cP;

	public static void initialize() {

		lp = new loginPage();
		cP = new commonPage();

	}

}
