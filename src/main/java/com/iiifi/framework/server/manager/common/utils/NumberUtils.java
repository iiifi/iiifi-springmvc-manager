package com.iiifi.framework.server.manager.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberUtils {
	
	public static void main(String[] args) {
		System.out.println(generateMemberNo());
	}
	
	/**
	 * 生成9位数字的会员号
	 * @return
	 */
	public static Integer generateMemberNo() {
		String tmpNum;
		while (true) {
				tmpNum = getN();
				int num = Integer.parseInt(tmpNum);
				String lastIndex1 = tmpNum.substring(7, 8);
				String lastIndex2 = tmpNum.substring(6, 8);
				String lastIndex4 = tmpNum.substring(4, 8);
				if (!lastIndex1.equals("4") || !lastIndex2.equals("13")
						|| !lastIndex4.equals("0001")) {
					return num;
				}
		}
	}
	
	/**
	 * 生成邀请码
	 * @return
	 */
	public static String generateInviteCode(){
		return getCharAndNumr(6);
	}
	
	/**
	 * 方法说明：生成6位随机数字
	 * @return
	 */
	public static String generateSixRandomNum(){
		String val = "";
		  Random random = new Random();
		  for (int i = 0; i < 6; i++) {
		   // 输出字母还是数字
		   String charOrNum = random.nextInt(2) % 2 == 0 ? "num" : "num";
		   // 字符串
		   if ("char".equalsIgnoreCase(charOrNum)) {
		    // 取得大写字母还是小写字母
		    int choice = random.nextInt(2) % 2 == 0 ? 65 : 65;//如果要小些可以将后面的65改成97
		    val += (char) (choice + random.nextInt(26));
		   } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
		    val += String.valueOf(random.nextInt(10));
		   }
		  }
		  return val;
	}
	
	public static String generateSixShortMsgCode(){
		String val = "";
		  Random random = new Random();
		  for (int i = 0; i < 6; i++) {
		   // 输出字母还是数字
		   String charOrNum = random.nextInt(2) % 2 == 0 ? "num" : "num";
		   // 字符串
		   if ("char".equalsIgnoreCase(charOrNum)) {
		    // 取得大写字母还是小写字母
		    int choice = random.nextInt(2) % 2 == 0 ? 65 : 65;//如果要小些可以将后面的65改成97
		    val += (char) (choice + random.nextInt(26));
		   } else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
		    val += String.valueOf(random.nextInt(10));
		   }
		  }
		  return val;
	}
	
	/**
	 * 生成6为随机字母数字
	 * 
	 * @param length
	 * @return
	 */
	public static String getCharAndNumr(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// 输出字母还是数字
			String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
			// 字符串
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 取得大写字母还是小写字母
				int choice = random.nextInt(2) % 2 == 0 ? 97 : 97;// 如果要小些可以将后面的65改成97
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}
	
	
	/**
	 * 生成9位随机数字
	 * 
	 * @param length
	 * @return
	 */
	@SuppressWarnings("unused")
	private static String getNumber(int length) {
		String val = "";
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			// 输出字母还是数字
			String charOrNum = random.nextInt(2) % 2 == 0 ? "num" : "num";
			// 字符串
			if ("char".equalsIgnoreCase(charOrNum)) {
				// 取得大写字母还是小写字母
				int choice = random.nextInt(2) % 2 == 0 ? 65 : 65;// 如果要小些可以将后面的65改成97
				val += (char) (choice + random.nextInt(26));
			} else if ("num".equalsIgnoreCase(charOrNum)) { // 数字
				val += String.valueOf(random.nextInt(10));
			}
		}
		return val;
	}

	private static String getN() {
		String str = "0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		List<Integer> list = new ArrayList<Integer>();
		while (sb.length() < 9) {
			int number = random.nextInt(10);
			if (!"0".equals(String.valueOf(str.charAt(number)))
					&& sb.length() == 0) {
				sb.append(str.charAt(number));
				list.add(number);
			} else {
				int n = 0;
				for (int i = 0; i < list.size(); i++) {
					if (!((Object) number).equals(list.get(i))) {
						n++;
					}
				}
				if (n == sb.length()) {
					sb.append(str.charAt(number));
					list.add(number);
				}
			}
		}
		return sb.toString();
	}
}
