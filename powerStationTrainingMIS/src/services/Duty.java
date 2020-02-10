package services;

import java.util.Vector;

public enum Duty {
 
    FACTORY_MANAGER("����", "1"), HEAD("����", "2"), TEAM_LEADER("�೤", "3"), TEAM_EMP("Ա��", "4");
    // ��Ա����
    private String name;
    private String index;

    public static void main(String[] args){
    	System.out.println(getIndex("����"));
    	System.out.println(getNames());
    }
    // ���췽��
    private Duty(String name, String index) {
        this.name = name;
        this.index = index;
    }
    public static Vector<String> getNames(){
    	Vector<String> names =  new Vector<String>();
    	for(Duty d : Duty.values()){
    		names.add(d.name);
    	}
    	return names;
    }
    // ��ͨ����
    public static String getName(String index) {
    	
        for (Duty c : Duty.values()) {
            if (c.getIndex().equals(index)) {
                return c.name;
            }
        }
        return null;
    }
    public static String getIndex(String name){
    	for (Duty c : Duty.values()) {
            if (c.getName().equals(name)) {
                return c.index;
            }
        }
        return null;
    }

    // get set ����
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
