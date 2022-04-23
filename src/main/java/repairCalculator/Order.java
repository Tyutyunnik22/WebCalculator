package repairCalculator;

import java.util.ArrayList;

/** 
 * Класс отвечает за заказ работ
 * @author Mamleeva Z
 * @author Skityaeva A
 * @author Salimgareev K
 * @version 1.0
*/
public final class Order {
	/** Итоговая сумма */
	private static Double totalSum;
	
	/** список элементов для заказа */
	private static ArrayList<WorkItem> workList = new ArrayList<WorkItem>();
	
    /**
     * Получение значения поля {@link Order#workList}
     * @return возвращает список элементов заказа
     */
	public static ArrayList<WorkItem> getWorkItemList(){
		return workList;
	}
	
    /**
     * Получение экземпляра элемента заказа и добавление его в список
     * @param wk вид
     * @param count кол-во
     * @return возвращает экземпляр элемента заказа
     */
	public static WorkItem addWorkItem(WorkKind wk,int count) {
		WorkItem wItem = new WorkItem(wk,count);
		workList.add(wItem);
		return wItem;
	}
	
    /**
     * Очистка списка элементов заказа {@link Order#workList}
     */
	public static void clearWorkItems() {
		workList.removeAll(workList);
	}
	
    /**
     * Удаление элемента заказа по переданному индексу
     * @param idx индекс для очистки элемента
     */
	public static void removeWorkItem(int idx) {
		workList.remove(idx);
	}
	
    /**
     * Расчет и получение итоговой суммы {@link Order#totalSum}
     * @return возвращает итоговую сумму
     */
	public static Double getTotalsum() {
		totalSum = 0.0;
		for (WorkItem wi : workList) {
			totalSum = totalSum + wi.getSum();
		}
		return totalSum;
	}
}

