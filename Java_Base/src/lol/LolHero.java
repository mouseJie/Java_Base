package lol;

import java.util.List;

public class LolHero {
	int HP;
	int MP;
	String name;
	boolean isMP;
	String profession;
	List<String> skills;
	
	public LolHero() {}
	
	public LolHero(String name, int HP, int MP, String profession, List<String> skills, String[] equip) {
		this.name = name;
		this.HP = HP;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public int getMP() {
		return MP;
	}

	public void setMP(int mP) {
		MP = mP;
	}

	public boolean isMP() {
		return isMP;
	}

	public void setMP(boolean isMP) {
		this.isMP = isMP;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

}
