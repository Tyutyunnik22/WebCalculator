package webCalc;

import java.util.ArrayList;
import java.util.List;

public class WebWorkKind {
    private String name;
    private boolean select;
 
    public WebWorkKind(String name, String whatSelect) {
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
    
    public static List<WebWorkKind> getList(String workType, String whatSelect) {
    	String[] masKind = repairCalculator.WorkKind.getNameList(workType);
        List<WebWorkKind> listWorkKind = new ArrayList<>();
        for (String m1 : masKind) {
        	listWorkKind.add(new WebWorkKind(m1 ,whatSelect)); 
        }
        
        return listWorkKind;
    }
}
