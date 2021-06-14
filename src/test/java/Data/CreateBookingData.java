package Data;

import Models.Booking;
import Models.BookingDate;

public class CreateBookingData {

    public Object getData()
    {
        BookingDate bookingDate=new BookingDate();
        Booking booking=new Booking();
        booking.setFirstname("");
        booking.setLastname("");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);
        booking.setBookingdates(bookingDate);
        bookingDate.setCheckin("2020-01-01");
        bookingDate.setCheckout("2021-01-01");
        booking.setAdditionalneeds("Breakfast");

        return booking;


    }
}
