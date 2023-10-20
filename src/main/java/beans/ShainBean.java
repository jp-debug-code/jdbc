package beans;

import java.io.Serializable;

public class ShainBean implements Serializable {
    
private String shain_id;
private String shain_name;
private String bu_name;
private String enter_date;
public String getShain_id() {
	return shain_id;
}
public void setShain_id(String shain_id) {
	this.shain_id = shain_id;
}
public String getShain_name() {
	return shain_name;
}
public void setShain_name(String shain_name) {
	this.shain_name = shain_name;
}
public String getBu_name() {
	return bu_name;
}
public void setBu_name(String bu_name) {
	this.bu_name = bu_name;
}
public String getEnter_date() {
	return enter_date;
}
public void setEnter_date(String enter_date) {
	this.enter_date = enter_date;
}
}
