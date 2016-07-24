package kr.co.minzero.diablo3.test;

import javax.swing.KeyStroke;

public class KeyCodeTest {
	public static void main(String[] args){
		KeyStroke ks = KeyStroke.getKeyStroke(("a").charAt(0), 0);
		System.out.println(ks.getKeyCode());
	}
}
