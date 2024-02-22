import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        int number = rnd.nextInt(100);
        Scanner input = new Scanner(System.in);
        int[] wrong = new int[5];
        boolean isWrong = false;
        boolean isWin=false;
        int live = 0;
        while (live < 5) {
            System.out.print("Lütfen tahmininizi giriniz: ");
            int guess = input.nextInt();
            if (guess < 100 && guess > 0) {
                if (guess == number) {
                    System.out.println("Tebrikler doğru tahmin! Tahmininiz: " + guess);
                    isWin=true;

                } else {
                    wrong[live] = guess;
                    if (guess < number) {
                        System.out.println("Tahmin ettiğiniz " + guess + " sayısı gizli sayıdan küçüktür.");
                    } else {
                        System.out.println("Tahmin ettiğiniz " + guess + " sayısı gizli sayıdan büyüktür.");
                    }

                    System.out.println("Kalan hakkınız: " + (5 - ++live));
                }

                if (live == 5 || isWin==true) {
                    if(live==5){
                    System.out.println("=======KAYBETTİNİZ======\nGizli sayı: " + number);}
                     System.out.println("Tahmin Ettiğiniz Sayılar: ");
                    for (int i : wrong) {
                        if (i != 0) {
                            System.out.print(i + " ");
                        }
                    }
                    break;
                }
            } else {
                if (!isWrong) {
                    System.out.println("Belirtilen aralıkta sayı giriniz! Hata tekrarlanırsa 1 hakkınız eksilecektir.");
                    isWrong=true;
                }else{
                    System.out.println("Birden fazla hatalı giriş yaptınız. Kalan hakkınız: "+(5- ++live));
                }
            }
        }
    }
}