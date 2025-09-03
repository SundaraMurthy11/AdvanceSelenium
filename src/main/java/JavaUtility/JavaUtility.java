package JavaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaUtility {
 
	
	public String getCurrentDate() {
		Date date= new Date();
		SimpleDateFormat sim = new SimpleDateFormat("dd-MM-YYYY");
		String currentDate=sim.format(date);
		return currentDate;
		
	}
	
	public String toGetRequired(int days) {
		
		
		Date date = new Date();
		SimpleDateFormat sim= new SimpleDateFormat("dd-MM-YYYY");
		sim.format(date);
		Calendar cal= sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String dateRequired= sim.format(cal.getTime());
		return dateRequired;
	}
	
	
}
