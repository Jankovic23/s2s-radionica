package zadatak1;

public class TezineClanovaEkipe{

    double[] nizTezina;
    int brojac = 0;
    public TezineClanovaEkipe(){
        nizTezina= new double[20];
        for(int i=0;i<20;i++){
            nizTezina[i]=-1;
        }
    }
    public TezineClanovaEkipe(int n){
        nizTezina= new double[n];
        for(int i=0;i<n;i++){
            nizTezina[i]=-1;
        }
    }
    void unesi(double noviClan){
        if(noviClan>40.5 && brojac+1<nizTezina.length){
            nizTezina[brojac]=noviClan;
            brojac++;
        }else{
            System.out.println("GRESKA");
        }
    }
    void ispisi(){
        for (int i=0;i<brojac;i++) {
            System.out.println("Tezina " + (i+1) + ". clana je: " + nizTezina[i]);
        }
    }
    boolean pronadjiTezinu(double prov){
        boolean daLi=false;
        for (int i=0;i<brojac;i++){
            if(nizTezina[i]==prov){
                daLi=true;
            }
        }
        return daLi;
    }
    double pronadjiNajlakseg(){
        if(brojac==0){
            return -1;
        }else{
            double min=nizTezina[0];
            for (int i=1;i<brojac;i++){
                if(min>nizTezina[i]){
                   min=nizTezina[i]; 
                }
            }
            return min;
        }
    }
    void ispisiKategorije(){

        int laka=0, srednja=0, teska=0;
        for(int i=0;i<brojac;i++){
            if(nizTezina[i]<65){
                laka++;
            }else if(nizTezina[i]>=65 && nizTezina[i]<85){
                srednja++;
            }else{
                teska++;
            }
        }
        System.out.println("Laka: " + laka + "\nSrednja: " + srednja + "\nTeska: " + teska);
    }

}