/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.llamaperm;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author raffa
 */
public class LlamaPerm extends JavaPlugin{
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        getCommand("lperm").setExecutor(new PermCommand(this));
    }
    public boolean hasPerm(Player player, String plugin,String permission) {
        return this.getConfig().getBoolean(plugin + "." + player.getPlayerListName() + "."+ permission);
    }
    public void setPerm(Player player, String plugin,String permission,boolean boo) {
        this.getConfig().set(plugin + "." + player.getPlayerListName() + "."+ permission, boo);
        this.saveConfig();
    }
}
