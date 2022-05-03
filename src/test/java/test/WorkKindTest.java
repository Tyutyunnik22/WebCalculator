package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

import repairCalculator.WorkKind;

/**tutunik*/
public class WorkKindTest {

	@Test
	public void testFindWorkKind() {
		String path = "src/main/webapp";

		File file = new File(path);
		String folderPath = file.getAbsolutePath()  + File.separator;
		String filePath = folderPath + "data.txt";
		File f = new File(filePath);
		if(!f.exists() || f.isDirectory()) { 
			fail("Файл не найден: " + filePath);
		}
		
		WorkKind.filePath = folderPath;
		
		String typeName = "Полы (монтажные работы)";
		String kindName	= "Грунтовка полов в 1 слой";
		String kindUnit = "кв.м";
		
		WorkKind wk = WorkKind.findWorkKind(typeName, kindName);
		if (wk == null) {
			fail("Не найден вид работ: " + kindName);
		}
		if (!wk.getType().getName().equals(typeName)) {
			fail("Не определился тип работ: " + typeName);
		}
		if (!wk.getName().equals(kindName)) {
			fail("Не определилось название вида работ: " + kindName);
		}
		if (!wk.getUnit().equals(kindUnit)) {
			fail("Не определилось ед. измерения работ: " + kindUnit);
		}
		
		Double kindPrice = 50d;
		double epsilon = 0.000001d;
		if (wk.getPrice()-kindPrice > epsilon) {
			fail("Не определилась цена работ: " + kindPrice + "; в виде указана цена: " +wk.getPrice());
		}
	}

}
