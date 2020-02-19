package kr.co.minzero.diablo3.test;

import org.junit.Test;

import javax.swing.*;

public class KeyCodeTest {
	@Test
	public void testKeyCode() {
		KeyStroke ks = KeyStroke.getKeyStroke(("a").charAt(0), 0);
		System.out.println(ks.getKeyCode());
	}
}
