package study.test;

import study.common.util.GlobalUtil;

public class DateFormatTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(GlobalUtil.getFormatDate("yyyy.MM.dd"));
		System.out.println(GlobalUtil.getFormatDate("yy.MM.dd"));
		System.out.println(GlobalUtil.getFormatDate("yyyy.MM.dd HH:mm:ss"));

	}

}
