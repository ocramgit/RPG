public class Inventory {

    Player player;

    public Inventory(Player player) {
        this.player = player;
    }

    public void check() {
        if(player.haveSword) {
            System.out.println("=======================");
            System.out.println("[Espada de Esmeralda]");
            System.out.println("=======================");
        }

        if(!player.haveSword) {
            System.out.println("Inventário vazio.");
        }
    }

}
