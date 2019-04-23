package wenjian;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FangsheTest {
	public static void main(String[] args) {
		// 读取Spring.txt
		File file = new File("D:\\git\\Java_Base\\Java_Base\\src\\wenjian\\spring.txt");
		Properties springConfig = new Properties();
		try {
			springConfig.load(new FileInputStream(file));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String className = (String) springConfig.get("class");
		String methodName = springConfig.getProperty("method");

		List<Object> list = new ArrayList<>();
		list.add("我是你爸爸");
		
		executeReflectMethod(className, methodName, list);
	}

	/**
	 * 
	 * @param className
	 *            类名
	 * @param methodName
	 *            方法名
	 * @param list
	 *            参数值集合
	 */
	private static void executeReflectMethod(String className, String methodName, List<Object> list) {
		try {
			Object clazz = Class.forName(className).newInstance();
			Method[] obj = clazz.getClass().getMethods();
			for (Method method : obj) {
				if (methodName != null && methodName.equals(method.getName())) {
					// 如果是private修饰符的，则把可访问性设置为true
					if (!method.isAccessible()) {
						method.setAccessible(false);
					}
					// 得到方法中的所有参数信息
					Class<?>[] parameterClazz = method.getParameterTypes();
					List<Object> listValue = new ArrayList<>();
					// 循环参数类型
					for (int i = 0; i < parameterClazz.length; i++) {
						fillList(listValue, parameterClazz[i], list.get(i));
					}
					method.invoke(clazz, listValue.toArray());
				}
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 需进行for遍历（多个参数）---该方法就是把请求参数对应好放进list
	 * @param list (放置请求参数数据)
	 * @param parameter(请求参数数据类型)
	 * @param value (设置参数数据)
	 */
	private static void fillList(List<Object> list, Class<?> parameter, Object value) {
		System.out.println(parameter.getTypeName());
		if ("java.lang.String".equals(parameter.getTypeName())) {
			list.add(value);
		} else if ("java.lang.Character".equals(parameter.getTypeName())) {
			char[] ch = ((String) value).toCharArray();
			list.add(ch[0]);
		} else if ("char".equals(parameter.getTypeName())) {
			char[] ch = ((String) value).toCharArray();
			list.add(ch[0]);
		} else if ("java.lang.Double".equals(parameter.getTypeName())) {
			list.add(Double.parseDouble((String) value));
		} else if ("double".equals(parameter.getTypeName())) {
			list.add(Double.parseDouble((String) value));
		} else if ("java.lang.Integer".equals(parameter.getTypeName())) {
			list.add(Integer.parseInt((String) value));
		} else if ("int".equals(parameter.getTypeName())) {
			list.add(Integer.parseInt((String) value));
		} else if ("java.lang.Long".equals(parameter.getTypeName())) {
			list.add(Long.parseLong((String) value));
		} else if ("long".equals(parameter.getTypeName())) {
			list.add(Long.parseLong((String) value));
		} else if ("java.lang.Float".equals(parameter.getTypeName())) {
			list.add(Float.parseFloat((String) value));
		} else if ("float".equals(parameter.getTypeName())) {
			list.add(Float.parseFloat((String) value));
		} else if ("java.lang.Short".equals(parameter.getTypeName())) {
			list.add(Short.parseShort((String) value));
		} else if ("shrot".equals(parameter.getTypeName())) {
			list.add(Short.parseShort((String) value));
		} else if ("java.lang.Byte".equals(parameter.getTypeName())) {
			list.add(Byte.parseByte((String) value));
		} else if ("byte".equals(parameter.getTypeName())) {
			list.add(Byte.parseByte((String) value));
		} else if ("java.lang.Boolean".equals(parameter.getTypeName())) {
			if ("false".equals(value) || "0".equals(value)) {
				list.add(false);
			} else if ("true".equals(value) || "1".equals(value)) {
				list.add(true);
			}
		} else if ("boolean".equals(parameter.getTypeName())) {
			if ("false".equals(value) || "0".equals(value)) {
				list.add(false);
			} else if ("true".equals(value) || "1".equals(value)) {
				list.add(true);
			}
		}
	}
}
