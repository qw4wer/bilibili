package com.qw4wer.bilibili.test;

import java.io.*;
import java.net.*;
import java.nio.channels.*;
import java.util.*;
import java.util.regex.*;

public class Ping {
	public static void main(String[] args) {
		try {
			for (int i = 0; i < 100; i++) {
				Runtime.getRuntime().exec("cmd /c start ping -n 50 -f -l 1000 192.168.1.1");
			}
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}