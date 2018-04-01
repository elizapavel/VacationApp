import java.sql.Date;

/**
 * 
 * @author Pavel Eliza
 * 
 *         It's an object that describes the period of time in which a place is
 *         available.
 *
 */

public class DateInterval {
	private Date startDate;
	private Date endDate;

	@SuppressWarnings("deprecation")
	public DateInterval(int startYear, int startMonth, int startDay, int endYear, int endMonth, int endDay) {
		startDate = new Date(startYear, startMonth, startDay);
		endDate = new Date(endYear, endMonth, endDay);
	}

	public Date getStart() {
		return startDate;
	}

	public Date getEnd() {
		return endDate;
	}
}
