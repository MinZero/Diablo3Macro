package kr.co.minzero.diablo3.bean;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class ChangeUserSetting {
	public UserSetting readSetting(){
		UserSetting us = null;
		try{
			BufferedReader in = new BufferedReader(new FileReader("diablo3macro.cfg"));

			String s;

			while ((s = in.readLine()) != null) {
				us = new UserSetting(s);
			}
			in.close();
		}catch(Exception e){
			System.out.println("FileNotFound");
			us = new UserSetting();
		}
		if (us != null)
			System.out.println(us.toString());

		return us;
	}
	
	public void writeSetting(UserSetting us){
		try{
			BufferedWriter out = new BufferedWriter(new FileWriter("diablo3macro.cfg", false));
			out.write(us.toString());
			out.close();
		}catch(Exception ignored){
			
		}
	}
}
