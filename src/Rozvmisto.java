import java.util.Scanner;

public class Rozvmisto {
    private double human,money,misc,starthuman;
    private int bind;
    private String biom,bindbiom,biomfvus;
    private int hospital,bazar,sfood,year;
    private int roz;
    private int hospitalneed,sfoodneed;
    public Rozvmisto(String biom,int  human, int bazar, int   money, int  sfood, int year, int hospital ) {//тут ініацізовуються зміні

        this.hospital = hospital;
        this.bazar = bazar;
        this.money = money;
        this.sfood=sfood;
        this.year=year;
        this.human=human;
        this.biom=biom;
        mistobiom();
        bind=year;
        starthuman=human;
    }
    public Rozvmisto(Scanner vod){
        System.out.println("Ведіть місцевіть:Ліс,Пустиння,Гори,Побережя.");
        if (vod.hasNextLine()){
            biom=vod.nextLine();
            mistobiom();
        }
        else{
            System.out.println("Невірно ведені дані машинка поламалася з вас 1 літра коли.");
        }
        System.out.println("Ведіть кількість людей:");
        if (vod.hasNextInt()){
            starthuman=human=vod.nextInt();
        }
        else{
            System.out.println("Невірно ведені дані машинка поламалася з вас 1 літра коли.");
        }
        System.out.println("Ведіть кількість лікарень");
        if (vod.hasNextInt()){
            hospital=vod.nextInt();
        }
        else{
            System.out.println("Невірно ведені дані машинка поламалася з вас 1 літра коли.");
        }
        System.out.println("Ведіть кількість продуктових:");
        if (vod.hasNextInt()){
            sfood=vod.nextInt();
        }
        else{
            System.out.println("Невірно ведені дані машинка поламалася з вас 1 літра коли.");
        }
        System.out.println("Ведіть кількість "+ bindbiom);
        if (vod.hasNextInt()){
            bazar=vod.nextInt();
        }
        else{
            System.out.println("Невірно ведені дані машинка поламалася з вас 1 літра коли.");
        }
        System.out.println("Ведіть початковий капітал:");
        if (vod.hasNextInt()){
            money=vod.nextInt();
        }
        else{
            System.out.println("Невірно ведені дані машинка поламалася з вас 1 літра коли.");
        }
        System.out.println("Ведіть кількість минувших років:");
        if (vod.hasNextInt()){
            bind=year=vod.nextInt();
        }
        else{
            System.out.println("Невірно ведені дані машинка поламалася з вас 1 літра коли.");
        }
    }
    public  Rozvmisto(){
        System.out.println("Ви вишли на поле двилючись на захід сонця і ви вирішили вернутися до додому, бо вам не було потріб но це нове місто");
    }
    public Rozvmisto(int starthuman){//перевизначення конструктора
        human=1;
        year= starthuman;
        bind=year;
        money=0;
        hospital=bazar=sfood=0;
        biom="Ліс";
        mistobiom();
    }

    public double getStarthuman() {
        return starthuman;
    }

    public void setStarthuman(double starthuman) {
        this.starthuman = starthuman;
    }

    public String getBiomfvus() {
        return biomfvus;
    }

    public String getBiom() {
        return biom;
    }

    public void setBiom(String biom) {
        this.biom = biom;
    }

    public String getBindbiom() {
        return bindbiom;
    }

    public void setBindbiom(String bindbiom) {
        this.bindbiom = bindbiom;
    }

    public double getHuman() {
        return human;
    }

    public void setHuman(double human) {
        this.human = human;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getBind() {
        return bind;
    }

    public void setBind(int bind) {
        this.bind = bind;
    }

    public int getHospital() {
        return hospital;
    }

    public void setHospital(int hospital) {
        this.hospital = hospital;
    }

    public int getBazar() {
        return bazar;
    }

    public void setBazar(int bazar) {
        this.bazar = bazar;
    }

    public int getSfood() {
        return sfood;
    }

    public void setSfood(int sfood) {
        this.sfood = sfood;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    void mistobiom(){
        switch (biom){
            case "Ліс":
                roz=105;
                misc=0.8;
                bindbiom="лісопилок:";
                biomfvus="Лісопилок:";
                break;
            case "Пустеля":
                roz=99;
                misc=1.3;
                bindbiom="караванів:";
                biomfvus="Караванів:";
                break;
            case "Гори":
                roz=101;
                misc=1;
                bindbiom="шахт:";
                biomfvus="Шахт:";
                break;
            case "Побережя":
                roz=107;
                misc=1.1;
                bindbiom="портів:";
                biomfvus="Портів:";
                break;
            case "End":
                roz=0;
                misc=0;
            default:
                roz=105;
                misc=0.8;
                bindbiom="лісопилок:";
                biomfvus="Лісопилок:";
                break;
        }
    }
    int rozhuman(){// медот визначення що потрібно людям для розмноження
        if (sfood*4>human){
            roz=roz+10;
        }
        else if(sfood*2>human){
            roz=roz;
            sfoodneed++;
        }
        else{
            roz=roz-10;
            sfoodneed=+2;
        }
        if (hospital*6>human){
            roz=roz+10;
        }
        else if(hospital*3>human){
            roz=roz;
            hospitalneed++;
        }
        else{
            roz=roz-10;
            hospitalneed=+2;
        }
        if(roz<=1){
            roz=1;
        }
        return roz;
    }
    void building(){// мотод який будує нобхідні будинки людям
        while (budzet()>=100){
            if ( hospitalneed >= 2) {
                hospital++;
                hospitalneed--;
                money = money - 20 * misc;
            } else if (  sfoodneed >= 2) {
                sfood++;
                sfoodneed--;
                money = money - 15 * misc;
            } else{
                bazar++;
                money = money - 36 * misc;
            }
            money=money/2; //інфляція ми не маємо диплома з економічних наук тому ми все діли просто на щоб не вмерла економіка, це фантастичний світ вдамо
        }
    }
    double budzet(){//обчислення бюджета
        return money;
    }
    void zrostbudzet(){
        double pascivemoney =human*9;
        money = money + (pascivemoney * (100 + 5 * bazar) / 100);
        if (money<0){
            money=0;
        }
    }
}
