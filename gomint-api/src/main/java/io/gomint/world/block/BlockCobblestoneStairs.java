/*
 * Copyright (c) 2020 Gomint team
 *
 * This code is licensed under the BSD license found in the
 * LICENSE file in the root directory of this source tree.
 */

package io.gomint.world.block;

import io.gomint.world.block.data.CobblestoneType;

/**
 * @author geNAZt
 * @version 1.0
 * @stability 3
 */
public interface BlockCobblestoneStairs extends BlockStairs<BlockCobblestoneStairs> {

    /**
     * Set the type of cobble stone
     *
     * @param type of cobble stone
     */
    BlockCobblestoneStairs type(CobblestoneType type);

    /**
     * Get the type of cobble stone
     *
     * @return type of cobble stone
     */
    CobblestoneType type();

}