package com.github.lazylazuli.traps.block;

import com.github.lazylazuli.lazylazulilib.block.BlockBase;
import com.github.lazylazuli.lazylazulilib.block.BlockDyed;
import com.github.lazylazuli.lazylazulilib.block.state.BlockState;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.BlockStone;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;

public class BlockDyedSlab extends BlockDyed
{
	public static final AxisAlignedBB AABB = new AxisAlignedBB(0.0D, 0.0D, 0.0D, 1.0D, 0.5D, 1.0D);
	
	private final BlockStone.EnumType type;
	
	public BlockDyedSlab(BlockStone.EnumType type)
	{
		super(Material.ROCK);
		
		this.type = type;
		
		String name = type.getName() + "_slab";
		
		setRegistryName(name);
		setUnlocalizedName(name);
		setHardness(1.5F);
		setResistance(10.0F);
		setSoundType(SoundType.STONE);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
	}
	
	@Override
	public com.github.lazylazuli.lazylazulilib.block.state.BlockState createBlockState(
			ImmutableMap<IProperty<?>, Comparable<?>> propertiesIn)
	{
		return new State(this, propertiesIn);
	}
	
	private class State extends BlockState
	{
		public State(BlockBase blockIn, ImmutableMap<IProperty<?>, Comparable<?>> propertiesIn)
		{
			super(blockIn, propertiesIn);
		}
		
		@Override
		public MapColor getMapColor()
		{
			return ((BlockDyedSlab) getBlock()).type.getMapColor();
		}
		
		@Override
		public AxisAlignedBB getBoundingBox(IBlockAccess source, BlockPos pos)
		{
			return AABB;
		}
		
		@Override
		public boolean isFullCube()
		{
			return false;
		}
		
		@Override
		public boolean isOpaqueCube()
		{
			return false;
		}
		
		@Override
		public EnumBlockRenderType getRenderType()
		{
			return EnumBlockRenderType.MODEL;
		}
	}
}
