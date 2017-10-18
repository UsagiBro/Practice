package ua.nure.zhazhkyi.Practice6.part3;

public class Part3 {
	
	public static void main(String[] args) {
		Parking parking = new Parking(10);
        parking.arrival(new Parking.Car(), 9);
        System.out.println(parking.toString());
        parking.arrival(new Parking.Car(), 0);
        System.out.println(parking.toString());
        parking.departure(0);
        System.out.println(parking.toString());
    }

}
