package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemObsidian;
import io.gomint.inventory.item.ItemStack;
import io.gomint.math.Vector;
import io.gomint.server.entity.Entity;
import io.gomint.server.entity.tileentity.EnderChestTileEntity;
import io.gomint.server.entity.tileentity.TileEntity;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.taglib.NBTTagCompound;
import io.gomint.world.block.BlockEnderChest;
import io.gomint.world.block.BlockType;
import io.gomint.world.block.data.Facing;

import java.util.ArrayList;
import java.util.List;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( sId = "minecraft:ender_chest" )
public class EnderChest extends ContainerBlock implements BlockEnderChest {

    @Override
    public String getBlockId() {
        return "minecraft:ender_chest";
    }

    @Override
    public long getBreakTime() {
        return 33750;
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public boolean interact(Entity entity, Facing face, Vector facePos, ItemStack item ) {
        EnderChestTileEntity tileEntity = this.getTileEntity();
        if ( tileEntity != null ) {
            tileEntity.interact( entity, face, facePos, item );
            return true;
        }

        return false;
    }

    @Override
    public float getBlastResistance() {
        return 3000.0f;
    }

    @Override
    public BlockType getBlockType() {
        return BlockType.ENDER_CHEST;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public boolean needsTileEntity() {
        return true;
    }

    @Override
    TileEntity createTileEntity( NBTTagCompound compound ) {
        super.createTileEntity( compound );
        return this.world.getServer().getTileEntities().construct(EnderChestTileEntity.class, compound, this, this.world.getServer().getItems());
    }

    @Override
    public List<ItemStack> getDrops( ItemStack itemInHand ) {
        return new ArrayList<>() {{
            add(ItemObsidian.create(8));
        }};
    }

    @Override
    public Class<? extends ItemStack>[] getToolInterfaces() {
        return ToolPresets.PICKAXE;
    }
}
