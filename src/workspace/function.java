package workspace;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class function {
	child_function x = new child_function();
	File file = new File("D:\\my_app\\TaskList\\data\\task.txt");
	File file1 = new File("D:\\my_app\\TaskList\\data\\2023\\February.txt");
	LocalDateTime toDay = LocalDateTime.now();

	public void showTarget() {
		List temp = this.loadDataDone();
		this.showDataDone();
	}

	public List loadDataDone() {

		task[] listTask = null;
		List list = null;

		try {

			Scanner myReadFile = new Scanner(file1);

			String numberLoad = myReadFile.nextLine();
			int numberInt = Integer.parseInt(numberLoad);

			listTask = new task[numberInt];
			list = new List(listTask);

			for (int i = 0; i < numberInt; i++) {

				String data = myReadFile.nextLine();

				x.convertDataFromFileToObj2(data, list, i);

			}

		} catch (FileNotFoundException e) {
			System.out.println("Can't load data from file");
		}

//		list = new List(listTask);

		return list;

	}

	// LOAD DATA
	public List loadData() {

		task[] listTask = null;
		List list;

		try {

			Scanner myReadFile = new Scanner(file);

			String numberLoad = myReadFile.nextLine();
			int numberInt = Integer.parseInt(numberLoad);

			listTask = new task[numberInt];
			list = new List(listTask);

			for (int i = 0; i < numberInt; i++) {

				String data = myReadFile.nextLine();

				x.convertDataFromFileToObj(data, list, i);

			}

		} catch (FileNotFoundException e) {
			System.out.println("Can't load data from file");
		}

		list = new List(listTask);

		return list;

	}

	public void changeData() {

		List temp = this.loadData();

		System.out.println("Position change ?");
		Scanner sc = new Scanner(System.in);
		// Position change
		String positionChangeString = sc.nextLine();
		int positionChange = Integer.parseInt(positionChangeString);
		// Change element is
		System.out.println("What do you want to change ? ( name - level - day end ) ?");
		String changeX = sc.nextLine();

		if (changeX.compareTo("name") == 0) {
			System.out.println("Change into ?");
			temp.listTask[positionChange - 1].setName(sc.nextLine());
			System.out.println("Successful Change !!!");
		}
		if (changeX.compareTo("level") == 0) {
			System.out.println("Change into ?");
			temp.listTask[positionChange - 1].setLevel(sc.nextLine());
			System.out.println("Successful Change !!!");
		}
		if (changeX.compareTo("day end") == 0) {
			System.out.println("With exactly time pass 1 or 0");
			String choose = sc.nextLine();
			int choose1 = Integer.parseInt(choose);
			if (choose1 == 1) {
				System.out.println("Day done ?");
				String dayDone = sc.nextLine();
				System.out.println("Time Done ?");
				String timeDone = sc.nextLine();
				String resultDay = dayDone.concat(">");
				resultDay = resultDay.concat(timeDone);
				temp.listTask[positionChange - 1].setDateEnd(x.convertStringToLocalDateTime(resultDay));
			} else {
				System.out.println("Day done ?");
				String dayDone = sc.nextLine();

				int index1 = dayDone.indexOf("/");
				int index2 = dayDone.lastIndexOf("/");
				String day = dayDone.substring(0, index1);
				String month = dayDone.substring(index1 + 1, index2);
				String year = dayDone.substring(index2 + 1);

				LocalDateTime dayResult = LocalDateTime.of(Integer.parseInt(year), Integer.parseInt(month),
						Integer.parseInt(day), 0, 0);
				temp.listTask[positionChange - 1].setDateEnd(dayResult);

			}
			System.out.println("Successful Change !!!");

		}
		this.saveData(temp);

	}

	// Load data from file
	public void addTask(String nameTask, String levelTask, LocalDateTime dayStart, LocalDateTime dayEnd) {

		List temp = this.loadData();

		task[] NewTask = new task[temp.listTask.length + 1];

		for (int i = 0; i < temp.listTask.length; i++) {
			NewTask[i] = new task(temp.listTask[i].getName(), temp.listTask[i].getLevel(),
					temp.listTask[i].getDateStart(), temp.listTask[i].getDateEnd());
		}
		NewTask[temp.listTask.length] = new task(nameTask, levelTask, dayStart, dayEnd);
		temp = new List(NewTask);
		this.saveData(temp);
		this.showData();

	}

	// Show data
	public void showData() {

		int k = 0;
		List temp = this.loadData();

		while (k < 3) {
			System.out.println(" ");
			k++;
		}

		System.out.println("TASK                                 TYPE         TIME REMAINING");

		int count = 0;
		int int1 = 0;
		for (task task : temp.listTask) {
			if (temp.listTask[int1] != null) {
				count++;
			}
		}

		for (int i = 0; i < count; i++) {

			if (temp.listTask[i] != null) {
				LocalDateTime toDay = LocalDateTime.now();

				int j;

				System.out.print(i + 1 + "." + temp.listTask[i].getName());

				for (j = 0; j < (35 - (temp.listTask[i].getName().length())); j++) {
					System.out.print(" ");
				}

				System.out.print(temp.listTask[i].getLevel());
				for (j = 0; j < (13 - (temp.listTask[i].getLevel().length())); j++) {
					System.out.print(" ");
				}

				System.out.println(x.caculateTimeLeft(toDay, temp.listTask[i].getDateEnd()));

			} else
				break;
		}

		k = 0;
		while (k < 3) {
			System.out.println(" ");
			k++;
		}

	}

	// Delete task with index
	public void deleteTask() {

		File file1 = new File("D:\\my_app\\TaskList\\data\\2023\\February.txt");

		// data main
		List temp = this.loadData();
		// data doned
		List temp1 = this.loadDataDone();
		// data Doned
		task[] NewTask = new task[temp1.listTask.length + 1];

		for (int i = 0; i < temp1.listTask.length; i++) {
			NewTask[i] = new task(temp1.listTask[i].getName(), temp1.listTask[i].getLevel(),
					temp1.listTask[i].getDateStart(), temp1.listTask[i].getDateEnd(),
					temp1.listTask[temp1.listTask.length - 1].getDateDoned());
		}

		String date = toDay.getDayOfMonth() + "/" + toDay.getMonthValue() + "/" + toDay.getYear() + ">"
				+ toDay.getHour() + ":" + toDay.getMinute() + ":00";
		NewTask[temp1.listTask.length] = new task(temp.listTask[temp.listTask.length - 1].getName(),
				temp.listTask[temp.listTask.length - 1].getLevel(),
				temp.listTask[temp.listTask.length - 1].getDateStart(),
				temp.listTask[temp.listTask.length - 1].getDateEnd(), date);

		temp1 = new List(NewTask);

		temp.listTask[temp.listTask.length - 1] = null;
		this.saveData(temp);
		this.saveDataDone(temp1);
	}

	public void saveDataDone(List L) {
		File newFile = new File("D:\\my_app\\TaskList\\data\\2023\\February.txt");

		PrintWriter pw;
		try {
			pw = new PrintWriter(newFile);
			int count = 0, i = 0;
			for (task task : L.listTask) {
				if (L.listTask[i++] != null) {
					count++;
				}
			}
			pw.println(count);
			for (int j = 0; j < count; j++) {
				if (L.listTask[j] != null)
					pw.println(L.listTask[j].getDataDoneSave());
			}
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void saveData(List L) {
		File newFile = new File("D:\\my_app\\TaskList\\data\\task.txt");

		PrintWriter pw;
		try {
			pw = new PrintWriter(newFile);
			int count = 0, i = 0;
			for (task task : L.listTask) {
				if (L.listTask[i++] != null) {
					count++;
				}
			}
			pw.println(count);
			for (int j = 0; j < count; j++) {
				if (L.listTask[j] != null)
					pw.println(L.listTask[j].getDataSave());
			}
			pw.flush();
			pw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void showDataDone() {

		int k = 0;
		List temp = this.loadDataDone();

		while (k < 3) {
			System.out.println(" ");
			k++;
		}

		System.out.println("TASK                                 TYPE         REAL IS                 THE TIME ALLOWED");

		int count = 0;
		int int1 = 0;
		for (task task : temp.listTask) {
			if (temp.listTask[int1] != null) {
				count++;
			}
		}

		for (int i = 0; i < count; i++) {

			if (temp.listTask[i] != null) {

				int j;

				System.out.print(i + 1 + "." + temp.listTask[i].getName());

				for (j = 0; j < (35 - (temp.listTask[i].getName().length())); j++) {
					System.out.print(" ");
				}

//				System.out.print(temp.listTask[i].getLevel());
//
//				for (j = 0; j < (13 - (temp.listTask[i].getLevel().length())); j++) {
//					System.out.print(" ");
//				}
				// date DOne
				String dateDone = temp.listTask[i].getDateDoned();
				int index1 = dateDone.indexOf("/");
				int index2 = dateDone.lastIndexOf("/");
				int index3 = dateDone.indexOf(">");
				int index4 = dateDone.indexOf(":");
				int index5 = dateDone.lastIndexOf(":");

				String day = dateDone.substring(0, index1);
				String month = dateDone.substring(index1 + 1, index2);
				String year = dateDone.substring(index2 + 1, index3);
				String hours = dateDone.substring(index3 + 1, index4);
				String minutes = dateDone.substring(index4 + 1, index5);

				int day1 = Integer.parseInt(day);
				int month1 = Integer.parseInt(month);
				int year1 = Integer.parseInt(year);
				int hours1 = Integer.parseInt(hours);
				int minutes1 = Integer.parseInt(minutes);

				LocalDateTime toDay1 = LocalDateTime.of(year1, month1, day1, hours1, minutes1);

				System.out.print(x.caculateTimeLeft(toDay1, temp.listTask[i].getDateEnd()));


				
				//=======
				int maxLenght = 0;
				for (int k1 = 0; k1 < count; k1++) {

					if (temp.listTask[k1] != null) {
						if(x.caculateTimeLeft(toDay1, temp.listTask[i].getDateEnd()).length() > maxLenght) {
							maxLenght = x.caculateTimeLeft(toDay1, temp.listTask[i].getDateEnd()).length();
						}
					}
				}
				
				for (j = 0; j <35- maxLenght; j++) {
					System.out.print(" ");
				}
				System.out.println(x.caculateTimeLeft(temp.listTask[i].getDateStart(), temp.listTask[i].getDateEnd()));
			} else
				break;
		}

	k=0;while(k<3)

	{
		System.out.println(" ");
		k++;
	}

}}
