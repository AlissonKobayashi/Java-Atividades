let xBolinha = 300;
let yBolinha = 200;
let diametro = 20;
let raio = diametro / 2;
let vxBolinha = 6;
let vyBolinha = 6;
let xRaquete = 10;
let yRaquete = 150;
let compRaquete = 10;
let largRaquete = 80;
let xRaqueteOponente = 580;
let yRaqueteOponente = 150;
let compRaqueteOponente = 10;
let largRaqueteOponente = 80;
let velocidadeOponente = 5;
let meusPontos = 0;
let pontosDoOponente = 0;

function setup() {
    createCanvas(600, 400);
}

function draw() {
    background(0);
    
    CriarBolinha();
    VerificarColisaoBorda();
    
    MoverRaquete();
    MoverRaqueteOponente();
    
    VerificarColisaoRaquete(xRaquete, yRaquete);
    VerificarColisaoRaquete(xRaqueteOponente, yRaqueteOponente);
    
    incluiPlacar();
}

function CriarBolinha() {
    circle(xBolinha, yBolinha, diametro);
    xBolinha += vxBolinha;
    yBolinha += vyBolinha;
}

function VerificarColisaoBorda() {
    if (xBolinha + raio > width) {
        meusPontos++;
        resetBolinha();
    }
    if (xBolinha - raio < 0) {
        pontosDoOponente++;
        resetBolinha();
    }
    if (yBolinha + raio > height || yBolinha - raio < 0) {
        vyBolinha *= -1;
    }
}

function MoverRaquete() {
    rect(xRaquete, yRaquete, compRaquete, largRaquete);
    
    if (keyIsDown(87) && yRaquete > 0) {
        yRaquete -= 10;
    }
    if (keyIsDown(83) && yRaquete < height - largRaquete) { 
        yRaquete += 10;
    }
}

function MoverRaqueteOponente() {
    rect(xRaqueteOponente, yRaqueteOponente, compRaqueteOponente, largRaqueteOponente);
    
    let meioRaquete = yRaqueteOponente + largRaqueteOponente / 2;
    
    if (yBolinha < meioRaquete - 10) {
        yRaqueteOponente -= velocidadeOponente;
    } else if (yBolinha > meioRaquete + 10) {
        yRaqueteOponente += velocidadeOponente;
    }
}

function VerificarColisaoRaquete(x, y) {
    if (xBolinha - raio < x + compRaquete && 
        xBolinha + raio > x &&
        yBolinha > y && 
        yBolinha < y + largRaquete) {
        vxBolinha *= -1;
    }
}

function incluiPlacar() {
    fill(255);
    textSize(32);
    text(meusPontos, 270, 50);
    text(pontosDoOponente, 320, 50);
}

function resetBolinha() {
    xBolinha = width / 2;
    yBolinha = height / 2;
    vxBolinha *= -1;
}
