package com.flying.email.test;

import com.flying.email.util.*;

/**
 * auth:flying date:2017年7月14日
 **/
public class mainTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String temp = "feixiang1229";

		System.out.println(Encrypt.aesEncrypt(temp));
		String tempde = "XRG4HMl7RIQdCG79yWuedT+qKEiGfT1HCGveqO1Kw0g=";
		System.out.println(Encrypt.aesDecrypt(tempde));
	}

}
