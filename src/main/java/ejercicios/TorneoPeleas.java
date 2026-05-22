package main.java.ejercicios;

import java.util.ArrayList;

class Torneo{
    private String nombreTorneo;
    private ArrayList<Player> participantes;

    public Torneo(String nombreTorneo) {
        this.nombreTorneo = nombreTorneo;
        this.participantes = new ArrayList<>();
    }
    public void addParticipante(Player participante){
        this.participantes.add(participante);
    }

    public void addParticipante(Player[] participantes){
        for(Player pl: participantes){
            addParticipante(pl);
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

        Player player1 = new Player(TypeCharacter.player,"Paladin",250, 20);
        tn.addParticipante(player1);
        Player player2 = new Player(TypeCharacter.player,"Espadachín",200, 25);
        Player player3 = new Player(TypeCharacter.player,"Asesino",125, 40);
        Player player4 = new Player(TypeCharacter.player,"Paladín",230, 22);
        Player player5 = new Player(TypeCharacter.player,"Paladin",290, 15);
        Player player6 = new Player(TypeCharacter.player,"Espadachín",200, 23);
        tn.addParticipante(new Player[]{player2,player3,player4,player5,player6});

        tn.imprimirParticipantes();

    }
}
