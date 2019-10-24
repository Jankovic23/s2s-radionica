package zadatak2;

public class VisineClanovaEkipe{

    int[] nizVisina;
    int brojac=0;

    public VisineClanovaEkipe(int max){

        if(max>0){
            nizVisina= new int [max];
        }else{
            nizVisina= new int [20];
        }
        for(int i=0;i<nizVisina.length;i++){
            nizVisina[i]=0;
        }

    }

    void unesi(int visina){

        if(visina>160 && visina<250 && brojac+1<nizVisina.length){
            nizVisina[brojac]=visina;
            brojac++;
        }else{
            System.out.println("GRESKA");
        }

    }
    int vratiProsek(){
        int suma=0;
        for(int i=0;i<brojac;i++){
            suma=suma+nizVisina[i];
        }
        return suma/brojac;
    }
    int  vratiNajvecuRazliku(){
        int min=nizVisina[0];
        int max=nizVisina[0];

        for(int i=0;i<brojac;i++){
            if(min>nizVisina[i]){
                min=nizVisina[i];
            }
        }
        for(int i=0;i<nizVisina.length;i++){
            if(max<nizVisina[i]){
                max=nizVisina[i];
            }
        }
        return max-min;
    }

}