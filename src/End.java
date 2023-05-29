import java.util.Scanner;

public class  End extends Rozvmisto {
    public End(String biom,int human, int bazar, int money, int sfood, int year, int hospital) {
        super(biom,human, bazar, money, sfood, year, hospital);
    }
    double peronrozv;

    public End(int starthuman) {
        super(starthuman);
    }

    public End() {
    }
    public End(Scanner vod){
        super(vod);
    }
    void vusnovok() {// обчислення і виведення за  n-ну кількість рокі розвинулося місто
        for (; getYear() >= 1; setYear(getYear() - 1)) {
            if (getHuman() <= 0.1) {
                setHuman(0);
                System.out.println("End Game: Лишилися тільки руїни");
                break;
            }
            zrostbudzet();
            setHuman((getHuman() * rozhuman()) / 100);
            building();
        }
        if (getHuman() <= 10) {
            System.out.println("Село розвивлося за " + getBind() + " років:");
        } else if (getHuman() >= 100 && getHuman() >= 10 && getHuman() <= 1000) {
            System.out.println("Місто розвивлося за " + getBind() + " років:");
        } else if (getHuman() >= 1000 && getHuman() <= 10000) {
            System.out.println("Королівство розвивлося за " + getBind() + " років:");
        } else if (getHuman() >= 10000 && getHuman() <= 100000) {
            System.out.println("Імперія розвивлося за " + getBind() + " років:");
        } else if (getHuman() >= 100000 && getHuman() <= 1000000) {
            System.out.println("Царство земля розвивлося за " + getBind() + " років:");
        } else if (getHuman() >= 1000000 && getHuman() <= 10000000) {
            System.out.println("Галактична республіка людей розвивлося за " + getBind() + " років:");
        } else if (getHuman() >= 10000000) {
            System.out.println("Галактична імперіум розвивлося за " + getBind() + " років:");
        }
        vidrozvm();
        System.out.println("Люди:" + (int) getHuman() + ".тис");
        System.out.println("Лікарні:" + getHospital());
        System.out.println("Продуктові:" + getSfood());
        System.out.println(getBiomfvus() + getBazar());
        System.out.println("Ваше місто виросло на "+(int)peronrozv+"%");
        // System.out.println("Бюджет:" +(int) budzet()+" магічні кристали");
    }
    void vidrozvm(){
        peronrozv=((100*getHuman())/getStarthuman());
    }
}
