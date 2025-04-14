package net.chomesan.ars_technica.client.gui;

import com.hollingsworth.arsnouveau.common.block.tile.RelayTile;
import net.chomesan.ars_technica.ConfigHandler;
import net.chomesan.ars_technica.common.api.IModifiableCooldown;
import net.chomesan.ars_technica.common.packets.CustomCooldownPacket;
import net.chomesan.ars_technica.setup.NetworkHandler;

public class RelayTileScreen extends CooldownScreen<RelayTile> {
    public RelayTileScreen(String title, RelayTile be) {
        super(title, be, ConfigHandler.Common.RELAY_MIN_COOLDOWN_VALUE.get(), ConfigHandler.Common.RELAY_MAX_COOLDOWN_VALUE.get());
    }

    @Override
    protected void updateEntity(Integer sliderValue) {
        if (blockEntity instanceof IModifiableCooldown customizable) {
            customizable.setCooldownTicks(sliderValue);
        }
    }

    @Override
    protected int getInitialEntityStateValue() {
        if (blockEntity instanceof IModifiableCooldown customizable) {
            return customizable.getCooldownTicks();
        }
        return 20;
    }

    @Override
    protected void send(int value) {
        NetworkHandler.CHANNEL.sendToServer(new CustomCooldownPacket(value, blockEntity.getBlockPos()));
    }
}
