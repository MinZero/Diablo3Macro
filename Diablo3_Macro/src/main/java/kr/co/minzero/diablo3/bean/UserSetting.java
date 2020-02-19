package kr.co.minzero.diablo3.bean;

import java.util.HashMap;

public class UserSetting {
	private String skill1Key;
	private String skill2Key;
	private String skill3Key;
	private String skill4Key;
	private int skill1Time;
	private int skill2Time;
	private int skill3Time;
	private int skill4Time;
	private boolean skill1Select;
	private boolean skill2Select;
	private boolean skill3Select;
	private boolean skill4Select;
	
	public String getSkill1Key() {
		return skill1Key;
	}
	public void setSkill1Key(String skill1Key) {
		this.skill1Key = skill1Key == null?"1":skill1Key;
	}
	public String getSkill2Key() {
		return skill2Key;
	}
	public void setSkill2Key(String skill2Key) {
		this.skill2Key = skill2Key == null?"2":skill2Key;
	}
	public String getSkill3Key() {
		return skill3Key;
	}
	public void setSkill3Key(String skill3Key) {
		this.skill3Key = skill3Key == null?"3":skill3Key;
	}
	public String getSkill4Key() {
		return skill4Key;
	}
	public void setSkill4Key(String skill4Key) {
		this.skill4Key = skill4Key == null?"4":skill4Key;
	}
	public int getSkill1Time() {
		return skill1Time;
	}
	public void setSkill1Time(String skill1Time) {
		this.skill1Time = skill1Time == null?10:Integer.parseInt(skill1Time);
	}
	public int getSkill2Time() {
		return skill2Time;
	}
	public void setSkill2Time(String skill2Time) {
		this.skill2Time = skill2Time == null?10:Integer.parseInt(skill2Time);
	}
	public int getSkill3Time() {
		return skill3Time;
	}
	public void setSkill3Time(String skill3Time) {
		this.skill3Time = skill3Time == null?10:Integer.parseInt(skill3Time);
	}
	public int getSkill4Time() {
		return skill4Time;
	}
	public void setSkill4Time(String skill4Time) {
		this.skill4Time = skill4Time == null?10:Integer.parseInt(skill4Time);
	}
	public boolean isSkill1Select() {
		return skill1Select;
	}
	public void setSkill1Select(String skill1Select) {
		this.skill1Select = skill1Select != null && skill1Select.equals("Y");
	}
	public boolean isSkill2Select() {
		return skill2Select;
	}
	public void setSkill2Select(String skill2Select) {
		this.skill2Select = skill2Select != null && skill2Select.equals("Y");
	}
	public boolean isSkill3Select() {
		return skill3Select;
	}
	public void setSkill3Select(String skill3Select) {
		this.skill3Select = skill3Select != null && skill3Select.equals("Y");
	}
	public boolean isSkill4Select() {
		return skill4Select;
	}
	public void setSkill4Select(String skill4Select) {
		this.skill4Select = skill4Select != null && skill4Select.equals("Y");
	}
	public void setSkill1Select(boolean skill1Select) {
		this.skill1Select = skill1Select;
	}
	public void setSkill2Select(boolean skill2Select) {
		this.skill2Select = skill2Select;
	}
	public void setSkill3Select(boolean skill3Select) {
		this.skill3Select = skill3Select;
	}
	public void setSkill4Select(boolean skill4Select) {
		this.skill4Select = skill4Select;
	}
	public String toString() {
		return "skill1Key=" + skill1Key + ",skill2Key=" + skill2Key + ",skill3Key=" + skill3Key
				+ ",skill4Key=" + skill4Key + ",skill1Time=" + skill1Time + ",skill2Time=" + skill2Time
				+ ",skill3Time=" + skill3Time + ",skill4Time=" + skill4Time + ",skill1Select=" + (skill1Select?"Y":"N")
				+ ",skill2Select=" + (skill2Select?"Y":"N") + ",skill3Select=" + (skill3Select?"Y":"N") + ",skill4Select=" + (skill4Select?"Y":"N")
				+ "";
	}
	public UserSetting(){
		setSkill1Key(null);
		setSkill2Key(null);
		setSkill3Key(null);
		setSkill4Key(null);
		setSkill1Time(null);
		setSkill2Time(null);
		setSkill3Time(null);
		setSkill4Time(null);
		setSkill1Select(false);
		setSkill2Select(false);
		setSkill3Select(false);
		setSkill4Select(false);
	}
	
	public UserSetting(String data){
		HashMap<String,String> prop = new HashMap<>();
		try{
			String[] split = data.split(",");
			for (String s : split) {
//				System.out.println(split[i]);
				String[] set = s.split("=");
				prop.put(set[0], set[1]);
			}
		}catch(Exception e){
			prop.put("skill1Key", "1");
			prop.put("skill2Key", "2");
			prop.put("skill3Key", "3");
			prop.put("skill4Key", "4");
			prop.put("skill1Select", "N");
			prop.put("skill2Select", "N");
			prop.put("skill3Select", "N");
			prop.put("skill4Select", "N");
			prop.put("skill1time", "10");
			prop.put("skill2time", "10");
			prop.put("skill3time", "10");
			prop.put("skill4time", "10");
		}finally{
			setSkill1Key(prop.get("skill1Key"));
			setSkill2Key(prop.get("skill2Key"));
			setSkill3Key(prop.get("skill3Key"));
			setSkill4Key(prop.get("skill4Key"));
			setSkill1Time(prop.get("skill1Time"));
			setSkill2Time(prop.get("skill2Time"));
			setSkill3Time(prop.get("skill3Time"));
			setSkill4Time(prop.get("skill4Time"));
			setSkill1Select(prop.get("skill1Select"));
			setSkill2Select(prop.get("skill2Select"));
			setSkill3Select(prop.get("skill3Select"));
			setSkill4Select(prop.get("skill4Select"));
		}
	}
	

}
