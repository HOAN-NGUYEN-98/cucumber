package Data;

import Models.BookingID;

public class GetBookingIDData {
    public Object getData(){
        BookingID bookingID=new BookingID();
        bookingID.setFirstname("Nguyen");
        bookingID.setLastname("Hoan");
        bookingID.setCheckin("2013-02-23");
        bookingID.setCheckout("2014-10-23");
        return bookingID;
    }
}
