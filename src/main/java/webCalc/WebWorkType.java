package webCalc;

import java.util.ArrayList;
import java.util.List;

public class WebWorkType {
    private String name;
    private boolean select;
 
    public WebWorkType(String name, String whatSelect) {
        super();
        this.name = name;
        if (name.equals(whatSelect)) {
        	this.select = true;
        } 
    }

    public boolean getSelect() {
    	return select;
    }
    
    public String getName() {
        return name;
    }
    
    public static List<WebWorkType> getList(String whatSelect) {
    	String[] masType = repairCalculator.WorkType.getWorkTypeList();
        List<WebWorkType> listCategory = new ArrayList<>();
        for (String m1 : masType) {
        	listCategory.add(new WebWorkType(m1 ,whatSelect)); 
        }
        return listCategory;
    }
}
