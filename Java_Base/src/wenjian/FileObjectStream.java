package wenjian;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileObjectStream {
	public static void main(String[] args) {
		Hero[] heros = new Hero[10];
		for (int i = 0; i < 10; i++) {
			Hero hero = new Hero();
			hero.setName("mouse" + i);
			heros[i] = hero;
		}

//		for (Hero h : heros) {
//			System.out.println(h.getName());
//		}
		
		write("F://java2test//hero.lol", heros);
		read("F://java2test//hero.lol");
	}

	public static void read(String filePath) {
		File file = new File(filePath);
		try (
				FileInputStream fis = new FileInputStream(file); 
				ObjectInputStream ois = new ObjectInputStream(fis);
				) {
				while(true) {
					try {
						Hero hero = (Hero)ois.readObject();
						System.out.println(hero.getName());
					} catch (EOFException e) {
						e.printStackTrace();
						break;
					} catch (NullPointerException e) {
						continue;
					}
				}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void write(String filePath, Object[] o) {
		File file = new File(filePath);
		try(
				FileOutputStream fos = new FileOutputStream(file);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				){
			Hero[] heros = (Hero[])o;
			for(Hero h : heros) {
				oos.writeObject(h);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
