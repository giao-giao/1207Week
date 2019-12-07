package com.lxk.utils;

import java.util.Calendar;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	/***
	 * �ж�Դ�ַ����Ƿ���ֵ��������Ҳ��ûֵ
	 */
	public static boolean isNull(String str) {
		if(str!=null&&str.length()>0) {
			return true;
		}
		return false;
	}
	/***
	 * �ж�Դ�ַ����Ƿ���ֵ�������źͿո�Ҳ��ûֵ"" "   "
	 */
	public static boolean isBlank(String str) {
		//trim()
		if(str!=null&&str.length()>0&&str.trim().length()>0) {
			return true;
		}
		return false;
	}

	/***
	 * �ж��Ƿ�Ϊ�ֻ�����
	 * 
	 */
	public static boolean isPhone(String str) {
		//���ж��ַ������ǿյ�
		boolean blank = isBlank(str);
		if(!blank) {
			return false;
		}
		Pattern pattern = Pattern.compile("^1[3|4|5|7|8][0-9]\\d{8}$");
		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}
	/***
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		//���ж��ַ������ǿյ�
		boolean blank = isBlank(str);
		if(!blank) {
			return false;
		}
		Pattern pattern = Pattern.compile("^[0-9]+$");
		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	/***
	 * �ж��Ƿ�Ϊ��������
	 * xxx@ss.ss
	 * ^(\w+((-\w+)|(\.\w+))*)\+\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$  
	 */
	public static boolean isEmail(String str) {
		//���ж��ַ������ǿյ�
		boolean blank = isBlank(str);
		if(!blank) {
			return false;
		}
		Pattern pattern = Pattern.
				compile("^([a-z0-9A-Z]+)@([a-z0-9A-Z]+\\.)+[a-zA-Z]{2,}$");
		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()) {
			return true;
		}
		return false;
	}

	/***
	 * �ж��ַ���ȫ����ĸ
	 * @param str
	 * @return
	 */
	public static boolean isEnglish(String str) {
		//���ж��ַ������ǿյ�
		boolean blank = isBlank(str);
		if(!blank) {
			return false;
		}
		Pattern pattern = Pattern.
				compile("^[a-zA-Z]+$");
		Matcher matcher = pattern.matcher(str);
		if(matcher.matches()) {
			return true;
		}

		return false;
	}
	/***
	 * ��ȡnλ���Ӣ���ַ���
	 * @return
	 */
	public static String getRandomEmailSuffex() {
		String [] arr = {"@qq.com","@163.com","@sian.com","@gmail.com","@sohu.com","@hotmail.com"};
		int len = arr.length;
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		//����С��len����������ֵ
		int nextInt = random.nextInt(len);
		//ȡ����ֵ
		int abs = Math.abs(nextInt);
		String c = arr[abs];
		buffer.append(c);
		return buffer.toString();
	}
	public static String getRandomStr(int length) {
		char [] arr = {'A','B','C','D','E','F','G',
				'H','I','J','K','L','M','N',
				'O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int len = arr.length;
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			//����С��len����������ֵ
			int nextInt = random.nextInt(len);
			//ȡ����ֵ
			int abs = Math.abs(nextInt);
			char c = arr[abs];
			buffer.append(c);
		}
		return buffer.toString();
	}
	/***
	 * ��ȡnλ���Ӣ���ַ���������
	 * @return
	 */
	public static String getRandomStrAndNumber(int length) {
		char [] arr = {'A','B','C','D','E','F','G',
				'H','I','J','K','L','M','N',
				'O','P','Q','R','S','T','U','V','W','X','Y','Z',
				'0','1','2','3','4','5','6','7','8','9'};
		int len = arr.length;
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			//����С��len����������ֵ
			int nextInt = random.nextInt(len);
			//ȡ����ֵ
			int abs = Math.abs(nextInt);
			char c = arr[abs];
			buffer.append(c);
		}
		return buffer.toString();
	}

	public static String getRandomNumber(int length) {
		char [] arr = {'0','1','2','3','4','5','6','7','8','9'};
		int len = arr.length;
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			//����С��len����������ֵ
			int nextInt = random.nextInt(len);
			//ȡ����ֵ
			int abs = Math.abs(nextInt);
			char c = arr[abs];
			buffer.append(c);
		}
		return buffer.toString();
	}
	/****
	 * ��ȡn����������ַ���
	 */
	public static String getRandomChinese(int length) {
		// Unicode�к�����ռ����\u4e00-\u9fa5,��4e00��9fa5תΪ10����
		int start = Integer.parseInt("4e00", 16);
		int end = Integer.parseInt("9fa5", 16);
		// ������
		// 19968
		// 40869
		// �����
		StringBuffer buffer = new StringBuffer();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int code = random.nextInt(end - start + 1) + start;
			// תΪ�ַ�
			String str = new String(new char[] { (char) code });
			buffer.append(str);
		}
		return buffer.toString();
	}

	/***
	 * �������
	 * @return
	 */
	public static String randomBirthday() {
		Calendar birthday = Calendar.getInstance();
		birthday.set(Calendar.YEAR, (int) (Math.random() * 52) + 1949);
		birthday.set(Calendar.MONTH, (int) (Math.random() * 12));
		birthday.set(Calendar.DATE, (int) (Math.random() * 31));

		StringBuilder builder = new StringBuilder();
		builder.append(birthday.get(Calendar.YEAR));
		long month = birthday.get(Calendar.MONTH) + 1;
		if (month < 10) {
			builder.append("0");
		}
		builder.append(month);
		long date = birthday.get(Calendar.DATE);
		if (date < 10) {
			builder.append("0");
		}
		builder.append(date);
		return builder.toString();
	}

	/***
	 * ��ȡ�����ַ���
	 * http://news.cnstock.com/newswww,yw-201908-4412690.htm
	 * @return
	 */
	public static String getPartString(String str) {
		Pattern pattern = Pattern.compile("\\d{7}");
		Matcher matcher = pattern.matcher(str);
		String group = "";
		while (matcher.find()) {
			group = matcher.group();
		}
		return group;
	}

	public static void main(String[] args) {
		/*String str = "aaaa\r\nbbbb\r\nv\rvvv\r\nc\rccc\r\ndddd";
		String[] split = str.split("(\r\n)");
		StringBuffer buffer = new StringBuffer();
		for (String string : split) {
			string = string.replaceAll("(\r)", "<br/>");
			buffer.append("<p>");
			buffer.append(string);
			buffer.append("</p>   ");
		}*/
		System.out.println(getRandomNumber(9));
	}
	public static String replace(String str) {
		String[] split = str.split("(\r\n)");
		StringBuffer buffer = new StringBuffer();
		for (String string : split) {
			string = string.replaceAll("(\r)", "<br/>");
			buffer.append("<p>");
			buffer.append(string);
			buffer.append("</p>   ");
		}
		return buffer.toString();
	}

}
