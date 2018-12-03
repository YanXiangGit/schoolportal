package com.portal.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.TreeMap;

/**
 * MD5加密工具
 *
 */
public class Md5Util {
	/**
	 * 
	 * @功能描述: 把字符串MD5加密 
	 * @param str
	 * @return
	 * @throws NoSuchAlgorithmException
	 * @throws UnsupportedEncodingException String 返回类型
	 */
//	public static String StringToMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
//		String ret="";
//		MessageDigest md5 = MessageDigest.getInstance("MD5");
//		ret=new String(md5.digest(str.getBytes("UTF-8")),"UTF-8");
//		byte []bytes=md5.digest(str.getBytes("UTF-8"));
//		StringBuilder sb=new StringBuilder(bytes.length<<1);
//		for(int i=0;i<bytes.length;i++){
//			sb.append(Character.forDigit((bytes[i]>>4)&0xf,16));
//			sb.append(Character.forDigit(bytes[i]&0xf,16));
//		}
//		return sb.toString();
//	}
	public static String StringToMd5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		String ret="";
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		ret=new String(md5.digest(str.getBytes("UTF-8")),"UTF-8");
		byte []bytes=md5.digest(str.getBytes("UTF-8"));
		StringBuilder sb=new StringBuilder(bytes.length<<1);
		for(int i=0;i<bytes.length;i++){
			sb.append(Character.forDigit((bytes[i]>>4)&0xf,16));
			sb.append(Character.forDigit(bytes[i]&0xf,16));
		}
		return sb.toString().toUpperCase();
	}
	/**
	 * 
	 * @功能描述: 获取md5sign用来人大登录使用
	 * @return String 返回类型
	 * @throws UnsupportedEncodingException 
	 * @throws NoSuchAlgorithmException 
	 */
	public static String getMD5Sign(Map<String,Object> map,String secret) throws NoSuchAlgorithmException, UnsupportedEncodingException{
		if(map==null){
			return null;
		}else{
			Map<String,Object> treeMap=new TreeMap<String, Object>();
			for(Map.Entry<String, Object> kv : map.entrySet()){
				treeMap.put(kv.getKey(), kv.getValue());
			}
			StringBuffer newStr=new StringBuffer();
			for(Map.Entry<String, Object> kv : treeMap.entrySet()){
				newStr.append(kv.getKey()).append(kv.getValue());
			}
			newStr.append(secret);
			return StringToMd5(newStr.toString());
		}
	}
	/**
	 * @Des 得到相应的一个MD5加密后的字符串
	 * @param psd
	 * @param salt
	 * @return    MD5加密后的字符串
	 */
	public static String encoder(String psd, String salt) {
	    try {
	        StringBuffer stingBuffer = new StringBuffer();
	        // 1.指定加密算法
	        MessageDigest digest = MessageDigest.getInstance("MD5");
	        // 2.将需要加密的字符串转化成byte类型的数据，然后进行哈希过程
	        byte[] bs = digest.digest((psd + salt).getBytes());
	        // 3.遍历bs,让其生成32位字符串，固定写法

	        // 4.拼接字符串
	        for (byte b : bs) {
	            int i = b & 0xff;
	            String hexString = Integer.toHexString(i);
	            if (hexString.length() < 2) {
	                hexString = "0" + hexString;
	            }
	            stingBuffer.append(hexString);
	        }
	        return stingBuffer.toString();
	    } catch (NoSuchAlgorithmException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	 public static void main(String[] args) {
		 Md5Util md5= new Md5Util();
			String text = "020644";
			String encodeAfter="";
		
				//encodeAfter=md5.encoder("15899999999","888888");
				try {
					encodeAfter = md5.StringToMd5(text);
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//				encodeAfter=md5.StringToMd5(encodeAfter)
				//1bd7f53b81b16a59ceaec1dfb2db6379 1bd7f53b81b16a59ceaec1dfb2db6379
				
				
			System.out.println(encodeAfter);

		}
	  
}
