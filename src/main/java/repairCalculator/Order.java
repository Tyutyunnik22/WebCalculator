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
	private Double totalSum;
	
	/** список элементов для заказа */
	private ArrayList<WorkItem> workList = new ArrayList<WorkItem>();
	
    /**
     * Получение значения поля {@link Order#workList}
     * @return возвращает список элементов заказа
     */
	public ArrayList<WorkItem> getWorkItemList(){
		return workList;
	}
	
    /**
     * Получение экземпляра элемента заказа и добавление его в список
     * @param wk вид
     * @param count кол-во
     * @return возвращает экземпляр элемента заказа
     */
	public WorkItem addWorkItem(WorkKind wk,int count) {
		WorkItem wItem = new WorkItem(wk,count);
		workList.add(wItem);
		return wItem;
	}
	
    /**
     * Очистка списка элементов заказа {@link Order#workList}
     */
	public void clearWorkItems() {
		workList.removeAll(workList);
	}
	
    /**
     * Удаление элемента заказа по переданному индексу
     * @param idx индекс для очистки элемента
     */
	public void removeWorkItem(int idx) {
		workList.remove(idx);
	}
	
    /**
     * Расчет и получение итоговой суммы {@link Order#totalSum}
     * @return возвращает итоговую сумму
     */
	public Double getTotalsum() {
		totalSum = 0.0;
		for (WorkItem wi : workList) {
			totalSum = totalSum + wi.getSum();
		}
		return totalSum;
	}
}

