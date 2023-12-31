public class Profile {

    private Player player;
    private GameCore gameCore;

    public Profile(Player player, GameCore gameCore) {
        this.player = player;
        this.gameCore = gameCore;
    }

    public void getProfile(Player player) {
        System.out.println("❤\uFE0F " + player.getHp() + " (VIDA)");
        System.out.println("✨ " + player.getXp() + " (XP)");
        System.out.println("\uD83D\uDEE1\uFE0F " + player.getArmour() + " % (ARMADURA)");
        System.out.println("\uD83E\uDD5E " + player.getCoins() + " (MOEDAS)");
        System.out.println("");

        System.out.println(gameCore.getZombie().getHp() <= 0 ? "Zombie: ✅" : "Zombie: ❌");
        System.out.println(gameCore.getSlime().getHp() <= 0 ? "Slime: ✅" : "Slime: ❌");
        System.out.println(gameCore.getWither().getHp() <= 0 ? "Wither: ✅" : "Wither: ❌");
        System.out.println("");
        System.out.println(player.getXpMultiplier() == 0 ? "XP Multiplier: ❌" : "XP Multiplier: ✅");
        System.out.println(player.getDamageMultiplier() == 2.30 ? "Espada encantada: ❌" : "Espada encantada: ✅");
        System.out.println(!gameCore.dungeonConcluded ? "Dungeon concluída: ❌" : "Dungeon concluída: ✅");
        gameCore.start();
}
