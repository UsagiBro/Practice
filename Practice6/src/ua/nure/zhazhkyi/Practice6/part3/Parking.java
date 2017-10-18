package ua.nure.zhazhkyi.Practice6.part3;


import java.util.ArrayList;
import java.util.List;

public class Parking {

    static class Car {}
    int n;
    static List<Car> parkingContent;

    Parking(int value) {
        n = value;
        parkingContent = new ArrayList(n);
        for (int i = 0; i < n; i++) {
            parkingContent.add(null);
        }
    }

    public boolean arrival(Car car, int place) {
        if (place > n - 1) {
            System.out.println("Place N" + place + " is occupied!");
            return false;
        }
        if (parkingContent.get(place) != null) {
            arrival(car, place + 1);
        } else {
            parkingContent.set(place, car);
            return true;
        }
        return false;
    }

    public boolean departure(int place) {
        if (parkingContent.get(place) != null) {
            parkingContent.set(place, null);
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Car[] arr = new Car[parkingContent.size()];
        arr = parkingContent.toArray(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                sb.append("null");
            } else {
                sb.append("Car#" + (i + 1));
            }
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append("]");
        return sb.toString();
    }

}
