package main.java.ejercicios;

import java.util.ArrayList;

class TipoPersonajeException extends RuntimeException{
    public TipoPersonajeException(String mensaje){super(mensaje);}
}

class Torneo{
    private String nombreTorneo;
    private ArrayList<Player> participantes;

    public Torneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
        this.participantes = new ArrayList<>();
    }
    public boolean validarTipoPersonaje(Player participante){ return TypeCharacter.player == participante.getType();}

    public void addParticipante(Player participante){
        if(validarTipoPersonaje(participante)){
            this.participantes.add(participante);
        } else {
            throw new TipoPersonajeException("El personaje debe ser de tipo Player");
        }

    }

    public void addParticipante(Player[] participantes){
        for(Player pl: participantes){
            if(validarTipoPersonaje(pl)){
                this.participantes.add(pl);
            } else {
                throw new TipoPersonajeException("El personaje debe ser de tipo Player");
            }
        }
    }

    public void imprimirParticipantes(){
        System.out.println("=== Participantes ===");
        for(Player pl: this.participantes){
            System.out.println("\nClase:"+pl.getCharNameClass());
        }
    }
}

public class TorneoPeleas {
    public static void main(String[] args) {

        Torneo tn = new Torneo("Torneo de artes marciales");

        Player player1 = new Player(TypeCharacter.monster,"Zombie",200, 25);
        Player player2 = new Player(TypeCharacter.monster,"Zombie",200, 25);
        Player player3 = new Player(TypeCharacter.player,"Asesino",125, 40);
        Player player4 = new Player(TypeCharacter.player,"Paladín",230, 22);
        Player player5 = new Player(TypeCharacter.player,"Paladin",290, 15);
        Player player6 = new Player(TypeCharacter.player,"Espadachín",200, 23);

        tn.addParticipante(new Player[]{player1,player2,player3,player4,player5,player6});

        tn.imprimirParticipantes();

    }
}
