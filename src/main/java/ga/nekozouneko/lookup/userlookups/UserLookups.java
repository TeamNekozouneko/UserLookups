package ga.nekozouneko.lookup.userlookups;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public final class UserLookups extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("§3Enabled Plugin");
        getLogger().info("--------------------------------------------------");
        getLogger().info("§6|　| §3|　 §rFor §eSpigot §rEdition API: " + getServer().getBukkitVersion());
        getLogger().info("§6|＿| §3|＿ §rRunning on §a" + getServer().getName() + " Server");
        getLogger().info("--------------------------------------------------");
        getLogger().info("UserLookups (C) Nekozouneko TEAM 2021 ALL RIGHTS RESERVED.");
        getLogger().info("MIT LICENSE / https://github.com/NekozounekoTEAM/UserLookups");
    }

    @Override
    public void onDisable() {
        getLogger().info("§4Disabled Plugin");
        getLogger().info("--------------------------------------------------");
        getLogger().info("§6|　| §3|　 §rFor §eSpigot §rEdition API: " + getServer().getBukkitVersion());
        getLogger().info("§6|＿| §3|＿ §rRunning on §a" + getServer().getName() + " Server");
        getLogger().info("--------------------------------------------------");
        getLogger().info("UserLookups (C) Nekozouneko TEAM 2021 ALL RIGHTS RESERVED.");
        getLogger().info("MIT LICENSE / https://github.com/NekozounekoTEAM/UserLookups");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("lookup")) {
            if (args[0].equalsIgnoreCase("help")) {
                sender.sendMessage("----------------------------------------");
                sender.sendMessage("§l§n§bUser§8Lookups §r§3Ver.1.0.0");
                sender.sendMessage("§l§nCommands:\n§r§n§7/lookup user <player> §rユーザーデータをLookupします。\n§r§n§7/lookup server §rサーバーデータをLookupします。\n§r§n§7/lookup help §rこれを表示します。");
                sender.sendMessage("----------------------------------------\n(C) Nekozouneko TEAM ALL RIGHTS RESERVED.");
            }
            else if (args[0].equalsIgnoreCase("user")) {
                if (args[1].equalsIgnoreCase("")) {
                    sender.sendMessage("§4§lError: 引数 <player> は必須です。");
                } else {
                    String playerUUID = Bukkit.getPlayer(args[1]).getUniqueId().toString();
                    String IP = Bukkit.getPlayer(args[1]).getAddress().getAddress().toString();
                    int Ping = Bukkit.getPlayer(args[1]).getPing();
                    sender.sendMessage("§l§3" + args[1] + "の情報\n§r§l§9IPアドレス: §r§8§n" + IP + "\n§r§l§9Ping: §r§8" + Ping + "ms\n" + "§r§l§9プレイヤーUUID: §r§8" + playerUUID);
                }

            } else if (args[0].equalsIgnoreCase("server")) {
                String motd_svr = getServer().getMotd();
                String svr_name = getServer().getName();
                String api = getServer().getBukkitVersion();
                sender.sendMessage("----------------------------------------");
                sender.sendMessage("§l§nこのサーバーの情報:\n§r§9§lサーバーソフトウェア: §r§n" + svr_name + "\n§r§9§lSpigot / Bukkit API: §r§n" + api + "\n§r§l§9バージョン: §r§n" + getServer().getVersion() +"\n§r§9§l--------- Motd ---------\n§r" + motd_svr);
                sender.sendMessage("----------------------------------------\n");
            }
        }

        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if (!command.getName().equalsIgnoreCase("lookup")) return super.onTabComplete(sender, command, alias, args);
        if (args.length == 1) {
            if (args[0].length() == 0) { // /testまで
                return Arrays.asList("help", "user", "server");
            } else {
                //入力されている文字列と先頭一致
                if ("help".startsWith(args[0])) {
                    return Collections.singletonList("help");
                } else if ("user".startsWith(args[0])) {
                    return Collections.singletonList("user");
                } else if ("server".startsWith(args[0])) {
                    return Collections.singletonList("server");
                }
                if (args.length == 2) {
                    if (args[0].length() == 1) { // /testまで
                        if (args[0] == "server") {
                            return Arrays.asList("[DO NOT ENTER]");
                        } else if (args[0] == "help") {
                            return Arrays.asList("[CREATING]");
                        }
                    }
                }
            }

        }
        return super.onTabComplete(sender, command, alias, args);
    }
}
