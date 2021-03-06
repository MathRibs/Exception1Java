package Aplication;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Principal {
public static void main (String[]args) throws ParseException {

	Scanner leitor = new Scanner(System.in);
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

System.out.print("Room Number: ");
int number = leitor.nextInt();
System.out.print("Check-in date (dd/MM/yyyy): ");
Date checkIn = sdf.parse(leitor.next());
System.out.print("Check-out date (dd/MM/yyyy): ");
Date checkOut = sdf.parse(leitor.next());
if (!checkOut.after(checkIn)) {
	System.out.println("Error in Reservation: Check-out date must be after Check-in date");
}
else {
Reservation	reservation = new Reservation(number, checkIn, checkOut);
System.out.println("Reservation: " + reservation);

System.out.println();
System.out.println("Enter data to update the Reservation: ");
System.out.print("Check-in date (dd/MM/yyyy): ");
 checkIn = sdf.parse(leitor.next());
System.out.print("Check-out date (dd/MM/yyyy): ");
 checkOut = sdf.parse(leitor.next());

 Date now = new Date();
 if(checkIn.before(now) || checkOut.before(now)) {
	System.out.println("Error in Reservation : Reservation dates for update must be future dates"); 
 }
 else if (!checkOut.after(checkIn)){
	 System.out.println("Error in Reservation: Check-out date must be after Check-in date");
 }
 else {
 
	 reservation.updateDates(checkIn, checkOut);
System.out.println("Reservation: " + reservation);

}
}
}
}