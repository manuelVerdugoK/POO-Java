package main.java.ejercicios;
enum TypeCharacter{
    player, monster
}
interface ICharacter {
    void reduceHp(int valor);
    void incrementHp(int valor);
    int getHp();
    boolean getStatus();
}
abstract class Character implements ICharacter {
    TypeCharacter type;
    String charClass;
    int hp;
    int damage;
    boolean isDead = false;

    public Character(TypeCharacter type, String name, int hp, int damage) {
        this.type = type;
        this.charClass = name;
        this.hp = hp;
        this.damage = damage;
    }
    public boolean getStatus(){return this.isDead;}
    public int getHp(){return this.hp;}
    public void reduceHp(int valor){
        this.hp = (this.hp - valor);
        if(this.getHp() <=0){
            this.isDead = true;
        }
    }
    public void incrementHp(int valor){ this.hp = (this.hp + valor);}
    public int getAtackDamage(){return this.damage;};
    public String getCharNameClass(){return this.charClass;};
}
class Monster extends Character{
    public Monster(TypeCharacter type, String name, int hp, int damage) {
        super(type, name, hp, damage);
    }
}
class Player extends Character{
    public Player(TypeCharacter type, String name, int hp, int damage) {
        super(type, name, hp, damage);
    }
}

public class Jueguito {
    public static void main(String[] args) {
        Monster monster1 = new Monster(TypeCharacter.monster,"Zombie", 100,12);
        Player player1 = new Player(TypeCharacter.player,"Paladin",250, 20);
        boolean haveWinner = false;
        int assault = 0;
        while (!haveWinner){

            System.out.println("Round ---> "+ assault);
            // 0 is for players and 1 is for monsters.
            int whoAtack = generateAndEvaluate();
            // 0 es for Not, 1 is for Yes -> give hp to the character.
            int gaveHp = generateAndEvaluate();
            // determine how much hp give to.
            int hpToSum = numberGenerator();

            switch (whoAtack){
                case 0:
                    System.out.println("Player goint to atack...");
                    monster1.reduceHp(player1.getAtackDamage());
                    if (monster1.getStatus()){
                        haveWinner = true;
                    }
                    if (gaveHp==1){
                        player1.incrementHp((int) Math.round(hpToSum / 2.0));
                    }
                    break;
                case 1:
                    System.out.println("Monster goint to atack...");
                    player1.reduceHp(monster1.getAtackDamage());
                    if (player1.getStatus()){
                        haveWinner = true;
                    }
                    if (gaveHp==1){
                        monster1.incrementHp((int) Math.round(hpToSum / 2.0));
                    }
                    break;
            }
            if (haveWinner){
                System.out.println("Match ended");
                if ( player1.getStatus()){
                    System.out.println("Winner was " + monster1.getCharNameClass());
                } else{
                    System.out.println("Winner was  " + player1.getCharNameClass());
                }
            } else{
                System.out.println(" === Round finished ===");
                assault++;
            }
        }
    }

    public static int numberGenerator(){
        return (int) (Math.random() * 10) + 1;
    }
    public static int generateAndEvaluate() {
        return numberGenerator() % 2 == 0 ? 0 : 1;
    }
}
