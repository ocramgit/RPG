public class Inventory {

    Player player;

    public Inventory(Player player) {
        this.player = player;
    }

    public void check(Player player) {
        System.out.println("====================");
            if(player.haveSword) {
                if(player.damageMultiplier == 2.30) {
                    System.out.println("\uD83D\uDDE1 1x Espada de Esmeralda");
                } else {
                    System.out.println("\uD83D\uDDE1 1x Espada de Esmeralda Encantada");
                }
        }

        if(player.magicPowder > 0) {
            System.out.println("\uD83D\uDD2E " + player.magicPowder + "x pó mágico");
        }

        if(!player.haveSword) {
            if(player.magicPowder == 0) {
                System.out.println("Inventário vazio.");
            }
        }
        System.out.println("====================");

    }

}
