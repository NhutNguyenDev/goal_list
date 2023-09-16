package workspace;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class child_function {

	// Add task
	public LocalDateTime convertStringToLocalDateTime(String data) {

		int index1 = data.indexOf("/");
		int index2 = data.lastIndexOf("/");
		int index3 = data.indexOf(">");
		int index4 = data.indexOf(":");
		int index5 = data.lastIndexOf(":");

		String day = data.substring(0, index1);
		String month = data.substring(index1 + 1, index2);
		String year = data.substring(index2 + 1, index3);
		String hours = data.substring(index3 + 1, index4);
		String minutes = data.substring(index4 + 1, index5);
		String second = data.substring(index5 + 1);

		int day1 = Integer.parseInt(day);
		int month1 = Integer.parseInt(month);
		int year1 = Integer.parseInt(year);
		int hours1 = Integer.parseInt(hours);
		int minutes1 = Integer.parseInt(minutes);
		int second1 = Integer.parseInt(second);

		LocalDateTime result = LocalDateTime.of(year1, month1, day1, hours1, minutes1, second1);

		return result;
	}

	public void convertDataFromFileToObj2(String data, List L, int index) {
		
		LocalDateTime dayStart;
		LocalDateTime dayEnd;
		
		String Name = data.substring(0, data.indexOf("-"));
		String Level = data.substring(data.indexOf("-")+1, data.lastIndexOf("-"));
		String DayStart = data.substring(data.lastIndexOf("-")+1,data.indexOf("|"));
		String DayEnd = data.substring(data.indexOf("|")+1,data.indexOf("&"));
		String DateDone = data.substring(data.indexOf("&")+1);
		
		int index6 = data.indexOf("&");
		// Excuted of day Start
		{
			int index1 = DayStart.indexOf("/");
			int index2 = DayStart.lastIndexOf("/");
			int index3 = DayStart.indexOf(">");
			int index4 = DayStart.indexOf(":");
			int index5 = DayStart.lastIndexOf(":");

			String day = DayStart.substring(0, index1);
			String month = DayStart.substring(index1 + 1, index2);
			String year = DayStart.substring(index2 + 1, index3);
			String hours = DayStart.substring(index3 + 1, index4);
			String minutes = DayStart.substring(index4 + 1, index5);
			String second = DayStart.substring(index5 + 1);

			int day1 = Integer.parseInt(day);
			int month1 = Integer.parseInt(month);
			int year1 = Integer.parseInt(year);
			int hours1 = Integer.parseInt(hours);
			int minutes1 = Integer.parseInt(minutes);
			int second1 = Integer.parseInt(second);
			
		
			dayStart = LocalDateTime.of(year1, month1, day1, hours1, minutes1);

		}
		
		
		
		// Excuted of day End
		{
			int index1 = DayEnd.indexOf("/");
			int index2 = DayEnd.lastIndexOf("/");
			int index3 = DayEnd.indexOf(">");
			int index4 = DayEnd.indexOf(":");
			int index5 = DayEnd.lastIndexOf(":");

			String day = DayEnd.substring(0, index1);
			String month = DayEnd.substring(index1 + 1, index2);
			String year = DayEnd.substring(index2 + 1, index3);
			String hours = DayEnd.substring(index3 + 1, index4);
			String minutes = DayEnd.substring(index4 + 1, index5);
			String second = DayEnd.substring(index5 + 1);

			int day1 = Integer.parseInt(day);
			int month1 = Integer.parseInt(month);
			int year1 = Integer.parseInt(year);
			int hours1 = Integer.parseInt(hours);
			int minutes1 = Integer.parseInt(minutes);
			int second1 = Integer.parseInt(second);
			
			dayEnd = LocalDateTime.of(year1, month1, day1, hours1, minutes1);

		}
		//Excuted of date DOne
		String dateDone;
		{
			int index1 = DateDone.indexOf("/");
			int index2 = DateDone.lastIndexOf("/");
			int index3 = DateDone.indexOf(">");
			int index4 = DateDone.indexOf(":");
			int index5 = DateDone.lastIndexOf(":");

			String day = DateDone.substring(0, index1);
			String month = DateDone.substring(index1 + 1, index2);
			String year = DateDone.substring(index2 + 1, index3);
			String hours = DateDone.substring(index3 + 1, index4);
			String minutes = DateDone.substring(index4 + 1, index5);
			String second = DateDone.substring(index5 + 1);
			
			 dateDone = day + "/" + month + "/" + year + ">" + hours + ":" + minutes + ":00";

		}
//		System.out.println(dateDone);
		L.listTask[index] = new task(Name,Level,dayStart,dayEnd,dateDone);
		L.listTask[index].setDateDoned(dateDone);

	}
	public void convertDataFromFileToObj(String data, List L, int index) {
		LocalDateTime dayStart;
		LocalDateTime dayEnd;
		String Name = data.substring(0, data.indexOf("-"));
		String Level = data.substring(data.indexOf("-")+1, data.lastIndexOf("-"));
		String DayStart = data.substring(data.lastIndexOf("-")+1,data.indexOf("|"));
		String DayEnd = data.substring(data.indexOf("|")+1);
		
		// Excuted of day Start
		{
			int index1 = DayStart.indexOf("/");
			int index2 = DayStart.lastIndexOf("/");
			int index3 = DayStart.indexOf(">");
			int index4 = DayStart.indexOf(":");
			int index5 = DayStart.lastIndexOf(":");

			String day = DayStart.substring(0, index1);
			String month = DayStart.substring(index1 + 1, index2);
			String year = DayStart.substring(index2 + 1, index3);
			String hours = DayStart.substring(index3 + 1, index4);
			String minutes = DayStart.substring(index4 + 1, index5);
			String second = DayStart.substring(index5 + 1);

			int day1 = Integer.parseInt(day);
			int month1 = Integer.parseInt(month);
			int year1 = Integer.parseInt(year);
			int hours1 = Integer.parseInt(hours);
			int minutes1 = Integer.parseInt(minutes);
			int second1 = Integer.parseInt(second);
			
		
			dayStart = LocalDateTime.of(year1, month1, day1, hours1, minutes1);

		}
		
		
		
		// Excuted of day End
		{
			int index1 = DayEnd.indexOf("/");
			int index2 = DayEnd.lastIndexOf("/");
			int index3 = DayEnd.indexOf(">");
			int index4 = DayEnd.indexOf(":");
			int index5 = DayEnd.lastIndexOf(":");

			String day = DayEnd.substring(0, index1);
			String month = DayEnd.substring(index1 + 1, index2);
			String year = DayEnd.substring(index2 + 1, index3);
			String hours = DayEnd.substring(index3 + 1, index4);
			String minutes = DayEnd.substring(index4 + 1, index5);
			String second = DayEnd.substring(index5 + 1);

			int day1 = Integer.parseInt(day);
			int month1 = Integer.parseInt(month);
			int year1 = Integer.parseInt(year);
			int hours1 = Integer.parseInt(hours);
			int minutes1 = Integer.parseInt(minutes);
			int second1 = Integer.parseInt(second);
			
			dayEnd = LocalDateTime.of(year1, month1, day1, hours1, minutes1);

		}
		
		L.listTask[index] = new task(Name,Level,dayStart,dayEnd);

	}
	
	public String caculateTimeLeft(LocalDateTime from, LocalDateTime To) {
		
		LocalDateTime fromDateTime = from;
		LocalDateTime toDateTime = To;
		
		LocalDateTime tempDateTime = LocalDateTime.from( fromDateTime );


		long years = tempDateTime.until( toDateTime, ChronoUnit.YEARS );
		tempDateTime = tempDateTime.plusYears( years );

		long months = tempDateTime.until( toDateTime, ChronoUnit.MONTHS );
		tempDateTime = tempDateTime.plusMonths( months );

		long days = tempDateTime.until( toDateTime, ChronoUnit.DAYS );
		tempDateTime = tempDateTime.plusDays( days );


		long hours = tempDateTime.until( toDateTime, ChronoUnit.HOURS );
		tempDateTime = tempDateTime.plusHours( hours );

		long minutes = tempDateTime.until( toDateTime, ChronoUnit.MINUTES );
		tempDateTime = tempDateTime.plusMinutes( minutes );

		long seconds = tempDateTime.until( toDateTime, ChronoUnit.SECONDS );

		if(years == 0 && months == 0 && days == 0 && hours == 0) {
			return minutes + " minutes " ;
		}
		else if(years == 0 && months == 0 && days == 0){
			return hours + " hours " +
			        minutes + " minutes";
		}
		else if(years == 0 && months == 0)
				return days + " days " +
				        hours + " hours " +
				        minutes + " minutes ";
		else if(years == 0)
				return months + " months " + 
				        days + " days " +
				        hours + " hours " +
				        minutes + " minutes ";
		else return years + " years " + 
		        months + " months " + 
		        days + " days " +
		        hours + " hours " +
		        minutes + " minutes ";

		//prints: 29 years 8 months 24 days 22 hours 54 minutes 50 seconds.
	}
}
