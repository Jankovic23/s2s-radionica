//ovde cemo startivati nasu aplikaciju sa sifrom koju korisnik upise

const dugmeZaStart = document.querySelector('.unesi-radionicu button');

dugmeZaStart.addEventListener('click', submitCode);

function submitCode() {
    //console.log('kod radionice je poslat');
    //kod koji je unet u input 
    const kod = document.querySelector('.unesi-radionicu input').value;
    console.log(kod);
    // sakrivamo elemnt
    document.querySelector(".unesi-radionicu").style.display = "none";
    document.querySelector(".glavni-deo").classList.add("pokrenuto");

    document.getElementById("radionica").textContent = kod;

    //pratimo promene u bazi i dodajemo nova pitanja

    const pitanja = baza.ref(kod + "/pitanja");

    pitanja.on('child_added', function(podaci) {
        //da bi pristupili samo podacima koji nam trebaju korisitimo val()
        dodajPitanje(podaci.val())
    });

}

function dodajPitanje(podaci) {
    // console.log(podaci.autor);//pristupamo smo podacima o autor
    //mozemo napisati i podaci["autor"]
    const pitanjeHtml = `<li>${podaci.autor}:${podaci.poruka}, ${new Date(podaci.vreme).toLocaleTimeString()}</li>`;
    //pogledati document.createElement
    document.querySelector(".pitanje ul").innerHTML += pitanjeHtml;
}

const baza = firebase.database(); //pristup referenci baze

let randomIme = "";
let kod;

function dodeliRadnomIme() {
    //iskoristimo link da dobijemo random ime iz nekog trecen izvora
    //koristimo fetch
    //fetch(LINK, PARAMETAR)

    //link iz kojeg dobijamo radnom ime
    const API_LINK = "https://namey.muffinlabs.com/name.json"
        //korsitimo then kao callback fju nakon izvrsenja neke fje koja traje ili ceka
    fetch(API_LINK, {
        mode: 'cors',
        method: 'GET'
    }).then(odgovor => //arrow fja sa ulazim parametrom odgovor

        odgovor.json()).then(podaci => {
        randomIme = podaci[0];
        document.querySelector('#ime1').textContent = randomIme;
        //console.log(podaci)
    }).catch(greska => {
        console.log("DOSLO JE DO GRESKE");
        console.warn("GRESKA");
        console.error("greska2");
        randomIme = "nesrecnik";
        document.querySelector("#ime1").textContent = randomIme;
    });
}
dodeliRadnomIme();

const dugmeZaPitanje = document.querySelector(".pitanje button");
dugmeZaPitanje = addEventListener("click", posaljiPitanje);

function posaljiPitanje() {

    const pitanje = document.querySelector(".pitanje input").value;
    console.log("pitanje je: " + pitanje);
    //referenca ka bazi,parametri su imena npr.
    baza.ref(kod + '/pitanja').push({
        autor: randomIme,
        poruka: pitanje,
        vreme: firebase.database.ServerValue.TIMESTAMP
    }, function(greska) {
        if (greska) {
            console.error("DOSLO JE DO GRESKE");
            console.error(greska);
        } else {
            alert("pitanje je poslato");
            document.querySelector(".pitanje input").value = "";
        }

    });

    //kod ="web"
    // pristupamo referenci u bazi sa putanjom web/pitanja

}