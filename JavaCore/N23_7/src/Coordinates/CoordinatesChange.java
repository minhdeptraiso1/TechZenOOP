package Coordinates;

import Fraction.Fraction;

import java.util.ArrayList;

public class CoordinatesChange {
    public static void main(String[] args) {
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            System.out.println("Nhập tọa độ " + (i + 1) + ":");
            Coordinates f = new Coordinates();
            f.input();
            coordinates.add(f);
        }
        Coordinates f1 = coordinates.get(0);
        Coordinates f2 = coordinates.get(1);
        f1.output();
        f2.output();
        double a = Coordinates.distanceTo(f1,f2);
        System.out.println(a);
    }
}
