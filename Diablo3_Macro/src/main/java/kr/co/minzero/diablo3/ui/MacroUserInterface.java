package kr.co.minzero.diablo3.ui;

import kr.co.minzero.diablo3.bean.ChangeUserSetting;
import kr.co.minzero.diablo3.bean.UserSetting;
import org.jnativehook.GlobalScreen;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import javax.swing.*;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("serial")
public class MacroUserInterface extends JFrame implements NativeKeyListener{
	boolean macroRun;
	JCheckBox skill1;
	JCheckBox skill2;
	JCheckBox skill3;
	JCheckBox skill4;
	
	JTextField time1;
	JTextField time2;
	JTextField time3;
	JTextField time4;
	
	KeyThread key1;
	KeyThread key2;
	KeyThread key3;
	KeyThread key4;
	
	UserSetting us;
	ChangeUserSetting changeSetting = new ChangeUserSetting();

	private static final Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());

	public MacroUserInterface(){
		super("Diablo III Macro");
		
		logger.setUseParentHandlers(false);
		logger.setLevel(Level.ALL);
		
		macroRun = false;
		
		setTitle("Diable III Macro");
		setBounds(100 , 100 , 300 , 80);
		
		JPanel mainPanel = new JPanel();
		
		skill1 = new JCheckBox("Skill 1");
		skill2 = new JCheckBox("Skill 2");
		skill3 = new JCheckBox("Skill 3");
		skill4 = new JCheckBox("Skill 4");
		time1 = new JTextField();
		time2 = new JTextField();
		time3 = new JTextField();
		time4 = new JTextField();
		time1.setDocument(new ex());
		time2.setDocument(new ex());
		time3.setDocument(new ex());
		time4.setDocument(new ex());

		us = changeSetting.readSetting();
		if(us.isSkill1Select()){
			skill1.setSelected(true);
		}
		if(us.isSkill2Select()){
			skill2.setSelected(true);
		}
		if(us.isSkill3Select()){
			skill3.setSelected(true);
		}
		if(us.isSkill4Select()){
			skill4.setSelected(true);
		}
		time1.setText(us.getSkill1Time()+"");
		time2.setText(us.getSkill2Time()+"");
		time3.setText(us.getSkill3Time()+"");
		time4.setText(us.getSkill4Time()+"");
		
		mainPanel.add(skill1);
		mainPanel.add(skill2);
		mainPanel.add(skill3);
		mainPanel.add(skill4);
		mainPanel.add(time1);
		mainPanel.add(time2);
		mainPanel.add(time3);
		mainPanel.add(time4);
		mainPanel.setLayout(new GridLayout(2,4));
		this.add(mainPanel);
		this.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent event){
				us.setSkill1Select(skill1.isSelected());
				us.setSkill2Select(skill2.isSelected());
				us.setSkill3Select(skill3.isSelected());
				us.setSkill4Select(skill4.isSelected());
				us.setSkill1Time(time1.getText());
				us.setSkill2Time(time2.getText());
				us.setSkill3Time(time3.getText());
				us.setSkill4Time(time4.getText());
				changeSetting.writeSetting(us);
				System.exit(0);
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		this.setResizable(false);
		startHook();
	}
	
	public void startHook(){
		try{
			GlobalScreen.registerNativeHook();
			GlobalScreen.addNativeKeyListener(this);
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public int stringToKeyCode(String keycode){
		int key = 0;
		try{
			KeyStroke ks = KeyStroke.getKeyStroke(keycode.charAt(0), 0);
			key = ks.getKeyCode();
		}catch(Exception ignored){
		}
		return key;
	}
	
	public void startKeyPress(){
		if(skill1.isSelected()){
			key1 = null;
			key1 = new KeyThread(stringToKeyCode(us.getSkill1Key()), time1.getText().equals("") ? 10 : Integer.parseInt(time1.getText())); // 숫자 1 1초 간격
			key1.start();
		}
		if(skill2.isSelected()){
			key2 = null;
			key2 = new KeyThread(stringToKeyCode(us.getSkill2Key()), time2.getText().equals("") ? 10 : Integer.parseInt(time2.getText())); // 숫자 2 1초 간격
			key2.start();
		}
		if(skill3.isSelected()){
			key3 = null;
			key3 = new KeyThread(stringToKeyCode(us.getSkill3Key()), time3.getText().equals("") ? 10 : Integer.parseInt(time3.getText())); // 숫자 3 1초 간격
			key3.start();
		}
		if(skill4.isSelected()){
			key4 = null;
			key4 = new KeyThread(stringToKeyCode(us.getSkill4Key()), time4.getText().equals("") ? 10 : Integer.parseInt(time4.getText())); // 숫자 4 1초 간격
			key4.start();
		}
		
		skill1.setEnabled(false);
		time1.setEnabled(false);
		skill2.setEnabled(false);
		time2.setEnabled(false);
		skill3.setEnabled(false);
		time3.setEnabled(false);
		skill4.setEnabled(false);
		time4.setEnabled(false);
	}
	
	public void stopKeyPress(){
		if(skill1.isSelected()){
			key1.interrupt();
		}
		if(skill2.isSelected()){
			key2.interrupt();
		}
		if(skill3.isSelected()){
			key3.interrupt();
		}
		if(skill4.isSelected()){
			key4.interrupt();
		}

		skill1.setEnabled(true);
		time1.setEnabled(true);
		skill2.setEnabled(true);
		time2.setEnabled(true);
		skill3.setEnabled(true);
		time3.setEnabled(true);
		skill4.setEnabled(true);
		time4.setEnabled(true);
		
		Runtime.getRuntime().gc();
	}
	
	@Override
	public void nativeKeyPressed(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
//		System.out.println(macroRun + " : " + arg0.getKeyCode());
		int keyCode = arg0.getKeyCode();
		if(keyCode == 43){
			macroRun = !(macroRun);
			if(macroRun){
				startKeyPress();
			}else{
				stopKeyPress();
			}
		}else if(keyCode == 28 || keyCode == 20 || keyCode == 1){
			if(macroRun){
				macroRun = false;
				stopKeyPress();
			}
		}
	}

	@Override
	public void nativeKeyReleased(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nativeKeyTyped(NativeKeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
	static class KeyThread extends Thread{
		private int keyCode;
		private int delayTime;
		
		public KeyThread (int keyCode, int delayTime){
			this.keyCode = keyCode;
			this.delayTime = delayTime;
		}
		public void run(){
			try{
				while(!Thread.currentThread().isInterrupted()){
					Robot rb = new Robot();
					rb.keyPress(keyCode);
					rb.keyRelease(keyCode);
					sleep((long)100*delayTime); 
				}
			}catch(Exception e){
//					e.printStackTrace();
			}
		}
	}
	
	static class ex extends PlainDocument{
		ex() {
			super();
		}
		
		public void insertString(int offset, String str, AttributeSet attr)throws BadLocationException{
			if(str == null)
				return;
			if(offset > 3)
				return;
			if(str.charAt(0) >= '0' && str.charAt(0) <= '9')
				super.insertString(offset, str, attr);
		}
	}
}
