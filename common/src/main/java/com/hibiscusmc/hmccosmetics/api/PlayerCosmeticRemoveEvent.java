package com.hibiscusmc.hmccosmetics.api;

import com.hibiscusmc.hmccosmetics.cosmetic.Cosmetic;
import com.hibiscusmc.hmccosmetics.user.CosmeticUser;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class PlayerCosmeticRemoveEvent extends Event implements Cancellable {

    private final CosmeticUser user;
    private final Cosmetic cosmetic;
    private boolean isCancelled;

    public PlayerCosmeticRemoveEvent(CosmeticUser user, Cosmetic cosmetic) {
        this.user = user;
        this.cosmetic = cosmetic;
        this.isCancelled = false;
    }

    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        isCancelled = cancel;
    }

    private static final HandlerList handlers = new HandlerList();

    @Override
    @NotNull
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    public CosmeticUser getUser() {
        return user;
    }

    public Cosmetic getCosmetic() {
        return cosmetic;
    }
}