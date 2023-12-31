package workspace;

import java.time.LocalDateTime;

public class task {
	String name;
	String level;
	LocalDateTime dateStart;
	LocalDateTime dateEnd;
	String dateDoned;
	
	


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public LocalDateTime getDateStart() {
		return dateStart;
	}
	public void setDateStart(LocalDateTime dateStart) {
		this.dateStart = dateStart;
	}
	public LocalDateTime getDateEnd() {
		return dateEnd;
	}
	public void setDateEnd(LocalDateTime dateEnd) {
		this.dateEnd = dateEnd;
	}
	public task(String name, String level, LocalDateTime dateStart, LocalDateTime dateEnd) {
		this.name = name;
		this.level = level;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
	}
	public task(String name, String level, LocalDateTime dateStart, LocalDateTime dateEnd,String dateDone) {
		this.name = name;
		this.level = level;
		this.dateStart = dateStart;
		this.dateEnd = dateEnd;
		this.dateDoned = dateDone;
	}
	
	public String getDataSave() {
		return this.name + "-"
			+ this.level + "-"
			+ this.dateStart.getDayOfMonth() + "/"
			+ this.dateStart.getMonthValue() + "/"
			+ this.dateStart.getYear() + ">"
			+ this.dateStart.getHour() + ":"
			+ this.dateStart.getMinute() + ":"
			+ this.dateStart.getSecond() + "|"
			+ this.dateEnd.getDayOfMonth() + "/"
			+ this.dateEnd.getMonthValue() + "/"
			+ this.dateEnd.getYear() + ">"
			+ this.dateEnd.getHour() + ":"
			+ this.dateEnd.getMinute() + ":"
			+ this.dateEnd.getSecond();

	}
	public String getDataDoneSave() {
		return this.name + "-"
			+ this.level + "-"
			+ this.dateStart.getDayOfMonth() + "/"
			+ this.dateStart.getMonthValue() + "/"
			+ this.dateStart.getYear() + ">"
			+ this.dateStart.getHour() + ":"
			+ this.dateStart.getMinute() + ":"
			+ this.dateStart.getSecond() + "|"
			+ this.dateEnd.getDayOfMonth() + "/"
			+ this.dateEnd.getMonthValue() + "/"
			+ this.dateEnd.getYear() + ">"
			+ this.dateEnd.getHour() + ":"
			+ this.dateEnd.getMinute() + ":"
			+ this.dateEnd.getSecond() + "&"
			+ this.getDateDoned();

	}
	public String getDateDoned() {
		return dateDoned;
	}
	public void setDateDoned(String dateDoned1) {
		System.out.println(dateDoned1);
		this.dateDoned = dateDoned1;
	}
	
	
	
	
	
	

}
