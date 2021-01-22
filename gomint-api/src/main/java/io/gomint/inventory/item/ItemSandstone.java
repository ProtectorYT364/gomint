package io.gomint.inventory.item;

import io.gomint.GoMint;
import io.gomint.world.block.data.Sandcolor;
import io.gomint.world.block.data.SandstoneType;

/**
 * @author geNAZt
 * @version 1.0
 * @stability 3
 */
public interface ItemSandstone extends ItemStack<ItemSandstone> {

    /**
     * Create a new item stack with given class and amount
     *
     * @param amount which is used for the creation
	 * @return freshly generated item
     */
    static ItemSandstone create( int amount ) {
        return GoMint.instance().createItemStack( ItemSandstone.class, amount );
    }

    /**
     * Set the color of this item
     *
     * @param color of this item
     * @return item for chaining
     */
    ItemSandstone color(Sandcolor color);

    /**
     * Get the color of this item
     *
     * @return color of this item
     */
    Sandcolor color();

    /**
     * Set the type of this item
     *
     * @param type of this item
     * @return item for chaining
     */
    ItemSandstone type(SandstoneType type);

    /**
     * Get the type of this item
     *
     * @return type of this item
     */
    SandstoneType type();

}
