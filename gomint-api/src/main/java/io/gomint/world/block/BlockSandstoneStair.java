/*
 * Copyright (c) 2020 Gomint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.world.block;

import io.gomint.world.block.data.RoughnessType;
import io.gomint.world.block.data.Sandcolor;

/**
 * @author geNAZt
 * @version 1.0
 * @stability 3
 */
public interface BlockSandstoneStair extends Block {

    /**
     * Set the color of this item
     *
     * @param color of this item
     * @return item for chaining
     */
    BlockSandstoneStair color(Sandcolor color);

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
    BlockSandstoneStair type(RoughnessType type);

    /**
     * Get the type of this item
     *
     * @return type of this item
     */
    RoughnessType type();

}
