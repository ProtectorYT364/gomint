package io.gomint.server.inventory.item;

import io.gomint.inventory.item.ItemType;
import io.gomint.server.registry.RegisterInfo;
import io.gomint.world.block.Block;
import io.gomint.world.block.BlockStoneWall;
import io.gomint.world.block.BlockWall;
import io.gomint.world.block.data.StoneType;

/**
 * @author geNAZt
 * @version 1.0
 */
@RegisterInfo(sId = "minecraft:cobblestone_wall", def = true)
@RegisterInfo( sId = "minecraft:polished_blackstone_brick_wall" )
@RegisterInfo( sId = "minecraft:polished_blackstone_wall" )
@RegisterInfo( sId = "minecraft:blackstone_wall" )
public class ItemStoneWall extends ItemStack<io.gomint.inventory.item.ItemStoneWall> implements io.gomint.inventory.item.ItemStoneWall {

    private static final String WALL_ID = "minecraft:cobblestone_wall";

    private enum StoneTypeMagic {

        STONE_BRICK(WALL_ID, (short) 7),
        NETHER_BRICK(WALL_ID, (short) 10),
        QUARTZ(WALL_ID, (short) 0),
        SMOOTH_STONE(WALL_ID, (short) 0),


        SMOOTH_SANDSTONE(WALL_ID, (short) 5),
        PURPUR(WALL_ID, (short) 0),
        RED_NETHER_BRICK(WALL_ID, (short) 13),

        GRANITE(WALL_ID, (short) 2),
        DIORITE(WALL_ID, (short) 3),
        ANDESITE(WALL_ID, (short) 4),
        POLISHED_GRANITE(WALL_ID, (short) 2),
        POLISHED_DIORITE(WALL_ID, (short) 3),
        POLISHED_ANDESITE(WALL_ID, (short) 4),
        END_STONE_BRICK(WALL_ID, (short) 9),
        SMOOTH_RED_SANDSTONE(WALL_ID, (short) 12),

        STONE(WALL_ID, (short) 0),
        MOSSY_STONE_BRICK(WALL_ID, (short) 1),
        SMOOTH_QUARTZ(WALL_ID, (short) 0),

        BLACKSTONE("minecraft:blackstone_wall", (short) 0),
        POLISHED_BLACKSTONE("minecraft:polished_blackstone_wall", (short) 0),
        POLISHED_BLACKSTONE_BRICK("minecraft:polished_blackstone_brick_wall", (short) 0);

        private final String wallId;
        private final short data;
        StoneTypeMagic(String wallId, short data) {
            this.wallId = wallId;
            this.data = data;
        }
    }

    @Override
    public ItemType itemType() {
        return ItemType.WALL;
    }

    @Override
    public StoneType type() {
        for (StoneTypeMagic value : StoneTypeMagic.values()) {
            if (value.wallId.equals(this.material()) && value.data == this.data()) {
                return StoneType.valueOf(value.name());
            }
        }

        return null;
    }

    @Override
    public ItemStoneWall type(StoneType stoneType) {
        StoneTypeMagic state = StoneTypeMagic.valueOf(stoneType.name());
        this.material(state.wallId);
        this.data(state.data);
        return this;
    }

    @Override
    public Block block() {
        return this.blocks
            .get(BlockStoneWall.class)
            .type(this.type());
    }

}