package com.example.common_base64_3des;



	import java.io.UnsupportedEncodingException;

	import javax.crypto.Cipher;
	import javax.crypto.SecretKey;
	import javax.crypto.spec.SecretKeySpec;

	/**
	 * 
	 * @ClassName: com.qust.SecretUtils
	 * @Description: 3DES���ܽ��ܹ�����
	 * @author zhaokaiqiang
	 * @date 2014-11-13 ����11:28:14
	 * 
	 */
	public class DES {

		// ��������㷨��DESede��3DES
		private static final String Algorithm = "DESede";
		// ������Կ
		private static final String PASSWORD_CRYPT_KEY = "zhaokaiqiang1992";

		/**
		 * ���ܷ���
		 * 
		 * @param src
		 *            Դ���ݵ��ֽ�����
		 * @return
		 */
		public static byte[] encryptMode(byte[] src) {
			try {
				// ������Կ
				SecretKey deskey = new SecretKeySpec(
						build3DesKey(PASSWORD_CRYPT_KEY), Algorithm);
				// ʵ����Cipher
				Cipher cipher = Cipher.getInstance(Algorithm);
				cipher.init(Cipher.ENCRYPT_MODE, deskey);
				return cipher.doFinal(src);
			} catch (java.security.NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			} catch (javax.crypto.NoSuchPaddingException e2) {
				e2.printStackTrace();
			} catch (java.lang.Exception e3) {
				e3.printStackTrace();
			}
			return null;
		}

		/**
		 * ���ܺ���
		 * 
		 * @param src
		 *            ���ĵ��ֽ�����
		 * @return
		 */
		public static byte[] decryptMode(byte[] src) {
			try {
				SecretKey deskey = new SecretKeySpec(
						build3DesKey(PASSWORD_CRYPT_KEY), Algorithm);
				Cipher c1 = Cipher.getInstance(Algorithm);
				c1.init(Cipher.DECRYPT_MODE, deskey);
				return c1.doFinal(src);
			} catch (java.security.NoSuchAlgorithmException e1) {
				e1.printStackTrace();
			} catch (javax.crypto.NoSuchPaddingException e2) {
				e2.printStackTrace();
			} catch (java.lang.Exception e3) {
				e3.printStackTrace();
			}
			return null;
		}

		/**
		 * �����ַ���������Կ24λ���ֽ�����
		 * 
		 * @param keyStr
		 * @return
		 * @throws UnsupportedEncodingException
		 */
		public static byte[] build3DesKey(String keyStr)
				throws UnsupportedEncodingException {
			byte[] key = new byte[24];
			byte[] temp = keyStr.getBytes("UTF-8");

			if (key.length > temp.length) {
				System.arraycopy(temp, 0, key, 0, temp.length);
			} else {
				System.arraycopy(temp, 0, key, 0, key.length);
			}
			return key;
		}
	}

