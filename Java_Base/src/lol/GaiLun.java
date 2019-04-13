package lol;

import java.util.ArrayList;
import java.util.List;

public class GaiLun extends LolHero {
	public GaiLun() {
		this.HP = 2000;
		this.MP = 1000;
		List<String> skills = new ArrayList<String>();
		skills.add("沉默打击");
		skills.add("德玛西亚大招");
		this.skills = skills;
		this.profession = "战士";
	}
}
