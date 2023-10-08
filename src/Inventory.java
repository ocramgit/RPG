public class Inventory {

    Player player;

    public Inventory(Player player) {
        this.player = player;
    }

    public void check(Player player) {
        System.out.println("====================");
        if(player.haveSword) {
            System.out.println("[Espada de Esmeralda]");
        }

        if(player.magicPowder > 0) {
            System.out.println("[" + player.magicPowder + " de pó mágico]");
        }

        if(!player.haveSword) {
            if(player.magicPowder == 0) {
                System.out.println("Inventário vazio.");
            }
        }
        System.out.println("====================");

    }

}
