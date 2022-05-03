package test;

import static org.junit.Assert.*;

import org.junit.Test;

import repairCalculator.Order;
import repairCalculator.WorkKind;
import repairCalculator.WorkType;

/** 
 * Тестовый класс проверки итоговой суммы заказа
 * @author Mamleeva Z
 * @version 1.0
*/
public class OrderTest {
	/**
	 * Проверяет расчет итоговой суммы
	 */
	@Test
	public void testGetTotalsum() {
		//Создаем экземпляр вида работ
		WorkKind wk = new WorkKind(new WorkType(null),"имя",100.0,"кв.м");
		Order order = new Order();
		//Добавляем строки в список
		order.addWorkItem(wk, 10);
		order.addWorkItem(wk, 5);
		//Получаем итоговую сумму
		Double d = order.getTotalsum();
		if (d != 1500.0) {
			fail("Итоговая сумма посчитана неверно");
		}
	}
}
