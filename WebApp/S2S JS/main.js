console.log("ovo je iz main.js");

var dugme = document.querySelector(".unos-html button");
dugme.addEventListener("click", function() {

    var unos = document.querySelector(".unos-html input");

    var unetaVrednost = unos.value;

    //console.log(unetaVrednost);
    dodajItem(unetaVrednost);
    unos.value = "";
});

function dodajItem(content) {
    var div = document.querySelector('.unos-html ul');
    // ubacujemo elemente u listu
    //content=test
    div.innerHTML += `<li> ${content} </li>`; //<li>test</li>

}

var nizReci = ["s2s", "js", "web dev", "html"];
var trenutniIndeks = 0;

//forma s emoze submitovati tako sto se klikne na dugme
var forma = document.querySelector('form');
forma.addEventListener('submit', function(event) {
    //ne dajemo da se izvrsi default operacija na submit forme
    event.preventDefault();
    // console.log(event);
    if (trenutniIndeks > nizReci.length - 1) {
        console.log("KRAJ");
        return;
    }
    console.log("forma je submitovana");
    document.querySelector('form span').textContent = nizReci[trenutniIndeks++];

});

//let i const
//let je kao var mozemo da ga menjamo
//const je konstanta, ne moze da se menja, obicno kod Query.selecor-a se korsiti

const kvadrat = document.querySelector(".box");

//arrow funkcije
kvadrat.addEventListener('click', () => {
    console.log("kvadrat je kliknut")
});

//ova linija ispisuje "kliknut", bez naseg kliktanja
//kvadrat.addEventListener('click', console.log("kliknut"));