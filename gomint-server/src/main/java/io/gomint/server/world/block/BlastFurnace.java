package io.gomint.server.world.block;

import io.gomint.inventory.item.ItemStack;
import io.gomint.math.Vector;
import io.gomint.server.entity.Entity;
import io.gomint.server.entity.tileentity.FurnaceTileEntity;
import io.gomint.server.entity.tileentity.TileEntity;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.server.world.block.helper.ToolPresets;
import io.gomint.server.world.block.state.BlockfaceBlockState;
import io.gomint.taglib.NBTTagCompound;
import io.gomint.world.block.data.Facing;
import io.gomint.world.block.BlockType;
import lombok.EqualsAndHashCode;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo( sId = "minecraft:lit_blast_furnace" )
@RegisterInfo( sId = "minecraft:blast_furnace", def = true )
@EqualsAndHashCode( callSuper = true )
public class BlastFurnace extends Block implements io.gomint.world.block.BlockBlastFurnace {

    private final BlockfaceBlockState facing = new BlockfaceBlockState( this, () -> new String[]{"facing_direction"} );

    @Override
    public long getBreakTime() {
        return 5250;
    }

    @Override
    public boolean isTransparent() {
        return true;
    }

    @Override
    public float getBlastResistance() {
        return 17.5f;
    }

    @Override
    public BlockType getBlockType() {
        return BlockType.FURNACE;
    }

    @Override
    public boolean canBeBrokenWithHand() {
        return true;
    }

    @Override
    public Class<? extends ItemStack>[] getToolInterfaces() {
        return ToolPresets.PICKAXE;
    }

    @Override
    TileEntity createTileEntity( NBTTagCompound compound ) {
        super.createTileEntity( compound );
        return new FurnaceTileEntity( this );
    }

    @Override
    public boolean needsTileEntity() {
        return true;
    }

    @Override
    public boolean interact(Entity entity, Facing face, Vector facePos, ItemStack item ) {
        FurnaceTileEntity tileEntity = this.getTileEntity();
        tileEntity.interact( entity, face, facePos, item );

        return true;
    }

    @Override
    public boolean onBreak( boolean creative ) {
        if ( !creative ) {
            FurnaceTileEntity tileEntity = this.getTileEntity();
            for ( ItemStack itemStack : tileEntity.getInventory().getContentsArray() ) {
                this.world.dropItem( this.location, itemStack );
            }

            tileEntity.getInventory().clear();

            // Remove all viewers
            tileEntity.getInventory().clearViewers();
        }

        return super.onBreak( creative );
    }

    @Override
    public boolean isBurning() {
        return this.getBlockId().equals( "minecraft:lit_furnace" );
    }

    @Override
    public void setBurning( boolean burning ) {
        if ( burning ) {
            this.setBlockId( "minecraft:lit_furnace" );
        } else {
            this.setBlockId( "minecraft:furnace" );
        }
    }

    @Override
    public void setFacing(Facing facing) {
        this.facing.setState(facing);
    }

    @Override
    public Facing getFacing() {
        return this.facing.getState();
    }

}