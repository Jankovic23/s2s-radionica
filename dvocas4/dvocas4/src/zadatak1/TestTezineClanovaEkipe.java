package zadatak1;

public class TestTezineClanovaEkipe{
    public static void main(String[] args) {

        TezineClanovaEkipe ekipa2 = new TezineClanovaEkipe();
        TezineClanovaEkipe ekipa1 = new TezineClanovaEkipe(3);

        ekipa1.unesi(100.0);
        ekipa1.unesi(55.5);
        ekipa1.unesi(44.5);

        ekipa2.unesi(66.6);
        ekipa2.unesi(44.3);
        ekipa2.unesi(150.0);

        boolean daLiIma1 = ekipa1.pronadjiTezinu(100.0);
        boolean daLiIma2 = ekipa2.pronadjiTezinu(70.0);

        double najlaksi1 = ekipa1.pronadjiNajlakseg();
        double najlaksi2 = ekipa2.pronadjiNajlakseg();

        System.out.println("U ekipi1 ima trazena tezina:"+ daLiIma1 + ". Najlaksi je tezak: " + najlaksi1);
        System.out.println("U ekipi2 ima trazena tezina:"+ daLiIma2 + ". Najlaksi je tezak: " + najlaksi2);

        ekipa1.ispisi();
        ekipa2.ispisi();

        ekipa1.ispisiKategorije();
        ekipa2.ispisiKategorije();
        
    }
}