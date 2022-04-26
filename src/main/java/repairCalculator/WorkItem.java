package repairCalculator;

/** 
 * Класс отвечает за элемент работы
 * @author Mamleeva Z
 * @author Skityaeva A
 * @version 1.0
*/
public final class WorkItem extends Work{
	/** Вид работ */
	private WorkKind wk;
	
	/** Кол-во */
	private int count;
	
	/** Сумма */
	private Double sum;
	
    /** 
     * Конструктор создание нового элемента работ
     * @param kind вид работы
     * @param cnt количество
     */
	public WorkItem(WorkKind kind,int cnt){
		this.wk = kind;
		this.count = cnt;
		this.sum = wk.getPrice()*count;
	}
	
	public String getTypeName() {
		return wk.getType().getName();
	} 
    /**
     * Получение значения поля {@link WorkItem#wk}
     * @return возвращает вид работ
     */
	public WorkKind getKind() {
		return wk;
	}
	
	public String getPrice() {
		return wk.getPrice().toString();
	}
    /**
     * Получение значения поля {@link WorkItem#count}
     * @return возвращает количество
     */
	public Integer getCount() {
		return count;
	}
	
    /**
     * Получение значения поля {@link WorkItem#sum}
     * @return возвращает сумму
     */
	public Double getSum() {
		return sum;
	}
	
    /**
     * Получение строки с кол-вом и ед.измерения
     * @return возвращает кол-во и ед.измерения
     */
	@Override
	public String toString() {
		String str = count + " " + wk.getUnit();
		return str;
	}
}
