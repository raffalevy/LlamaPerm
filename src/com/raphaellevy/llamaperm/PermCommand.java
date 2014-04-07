/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.raphaellevy.llamaperm;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author raffa
 */
public class PermCommand implements CommandExecutor{
    private LlamaPerm plug;
    public PermCommand(LlamaPerm plug) {
        this.plug = plug;
    }
    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if (this.plug.hasPerm((Player) cs, "LlamaPerm", "lperm")) {
            if (strings.length == 3) {
                cs.sendMessage(String.valueOf(this.plug.hasPerm(Bukkit.getPlayer(strings[0]), strings[1], strings[2])));
            } else if (strings.length == 4) {
                this.plug.setPerm(Bukkit.getPlayer(strings[0]), strings[1], strings[2], Boolean.valueOf(strings[3]));
            } else {
                return false;
            }
            return true;
        } else {
            cs.sendMessage("no perm");
            return true;
        }
    }
    
}
