package lol;

import java.util.ArrayList;
import java.util.List;

public class TiMo extends LolHero {
	public TiMo() {
		this.HP = 2000;
		this.MP = 1000;
		List<String> skills = new ArrayList<String>();
		skills.add("有毒吐射");
		skills.add("种蘑菇");
		this.skills = skills;
		this.profession = "法师";
	}
}
