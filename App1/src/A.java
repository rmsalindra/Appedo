import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


public class A {

	private static final SimpleDateFormat monthDayYearformatter = new SimpleDateFormat("dd-MM-yyyy");
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		System.out.println("test:"+"VARIABLES: "+200+"\r\n"+"userrid= ");
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String strStartDate = "10-09-2014";
		String strEndDate = "30-09-2014";
		Date startDate = df.parse(strStartDate);
		Date endDate = df.parse(strEndDate);
		java.util.Date date= new java.util.Date();
		String strtoday = monthDayYearformatter.format(new Timestamp(date.getTime()));
		Date today = df.parse(strtoday);
		if (startDate.before(today)&&today.before(endDate)) {
            System.out.println("Running");
        } else if(startDate.after(today)){
        	System.out.println("active");
        } else if(endDate.before(today)){
        	System.out.println("stopped");
        }



	}
	public static String timestampToMonthDayYear(Timestamp timestamp) {
	    if (timestamp == null) {
	      return null;
	    } else {
	      return monthDayYearformatter.format((java.util.Date) timestamp);
	    }
	  }

}
//java.util.Date today = new java.util.Date();
//java.sql.Timestamp ts1 = new java.sql.Timestamp(today.getTime());
//java.sql.Timestamp ts2 = java.sql.Timestamp.valueOf("2005-04-06 09:01:10");
//
//long tsTime1 = ts1.getTime();
//long tsTime2 = ts2.getTime();
//
//System.out.println(tsTime1);
//System.out.println(tsTime2);