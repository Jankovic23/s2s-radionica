package zadatak2;

public class TestVisineClanovaEkipe{

    public static void main(String[] args) {
        
        VisineClanovaEkipe ekipa1 = new VisineClanovaEkipe(20);
        VisineClanovaEkipe ekipa2 = new VisineClanovaEkipe(30);
        VisineClanovaEkipe ekipa3 = new VisineClanovaEkipe(40);

        ekipa2.unesi(186);
        ekipa2.unesi(196);
        ekipa2.unesi(169);
        ekipa2.unesi(145);
        ekipa2.unesi(201);

        int prosek = ekipa2.vratiProsek();
        int razlika  = ekipa2.vratiNajvecuRazliku();
        System.out.println("Prosecna visina ekipe2 je: " + prosek + ".\nNajveca razlika je: "+  razlika);

    }
}
