package net.chomesan.ars_technica.common.api;

public interface IModifiableCooldown {
    void setCooldownTicks(int ticks);
    int getCooldownTicks();
}
