import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TimeStampWork {

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("MMddyyyyhhmmssms");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate); 
	}
}
