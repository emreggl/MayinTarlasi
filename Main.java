import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int row, column;
        System.out.println("Mayın tarlasına hoşgeldiniz! ");
        System.out.println("Lütfen oynamak istediğiniz boyutları giriniz !");
        System.out.print("Satır sayısı: ");
      row = in.nextInt();
        System.out.print("Sütun sayısı: ");
        column = in.nextInt();

        MayinTarlasi mayin = new MayinTarlasi(row,column);
        mayin.run();

    }
}