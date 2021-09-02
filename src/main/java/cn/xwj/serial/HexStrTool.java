package cn.xwj.serial;

import java.util.Locale;

public class HexStrTool {

	/**
	 * 16进制表示的字符串转换为字节数组
	 * @param hexString  16进制表示的字符串
	 * @return
	 */
	public static byte[] hexStringToBytes(String hexString){
		hexString = hexString.replaceAll(" ", "");
		int len = hexString.length();
		byte[] bytes = new byte[len/2];
		for (int i=0; i<len; i+=2){
			bytes[i/2] = (byte) ((Character.digit(hexString.charAt(i), 16)<<4)+Character.digit(hexString.charAt(i+1), 16));
		}
		return bytes;
	}

	/**
	 * 16进制的字符串表示转成字节数组
	 * @param hexString   16进制格式的字符串
	 * @return
	 */
	public static byte[] toByteArray(String hexString) {
		hexString = hexString.replaceAll(" ", "");
		int len = hexString.length();
		byte[] byteArray = new byte[len/2];
		int k = 0;
		for (int i=0; i<len; i++){
			byte high = (byte) (Character.digit(hexString.charAt(k), 16)&0xff);
			byte low  = (byte) (Character.digit(hexString.charAt(k+1), 16)&0xff);
			byteArray[i] = (byte) (high<<4|low);
		}
		return byteArray;
	}

	/**
	 * byte[]数组转换为16进制的字符串
	 * @param bytes
	 * @return
	 */
	public static String bytesToHexString(byte[] bytes){
		StringBuilder sBuilder = new StringBuilder();
		for (int i=0; i<bytes.length; i++){
			String hex = Integer.toHexString(0xFF & bytes[i]);
			if (hex.length() == 1){
				sBuilder.append("0");
			}
			sBuilder.append(hex);
		}
		return sBuilder.toString();
	}

	/**
	 * byte[]数组转换为16进制的字符串
	 * @param data
	 * @return
	 */
	public static String byteArrayToHexString(byte[] data){
		StringBuilder sbBuilder = new StringBuilder(data.length*2);
		for (byte b : data){
			int v = b & 0xff;
			if (v < 16){
				sbBuilder.append("0");
			}
			sbBuilder.append(Integer.toHexString(v));
		}
		return sbBuilder.toString().toUpperCase(Locale.getDefault());
	}

	/**
	 * 字节数组转成16进制表示格式的字符串
	 * @param byteArray
	 * @return
	 */
	public static String toHexString(byte[] byteArray){
		if (byteArray ==null || byteArray.length<1){
			throw new IllegalArgumentException("byte[] can not null or empty");
		}
		StringBuilder hexString = new StringBuilder();
		for (int i=0; i<byteArray.length; i++){
			if ((byteArray[i]&0xff)<0x10){
				hexString.append("0");
			}
			hexString.append(Integer.toHexString(0xFF&byteArray[i]));
		}
		return hexString.toString().toLowerCase();
	}


}
