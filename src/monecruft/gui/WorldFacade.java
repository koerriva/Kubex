package monecruft.gui;

public class WorldFacade 
{
	private World world;
	public WorldFacade(World world)
	{
		this.world=world;
	}
	public float getWorldGravity()
	{
		return world.getGravity();
	}
	public float getWorldAirFriction()
	{
		return world.getAirFriction();
	}
	public float getDaylightAmount()
	{
		return world.getDaylightAmount();
	}
	public byte getContent(float x,float y,float z)
	{
		return world.getContent(x, y, z);
	}
	public void requestChunkUpdate(Chunk c)
	{
		this.world.getChunkUpdater().updateChunk(c);
	}
	public void requestChunkUpdatePrioritary(Chunk c)
	{
		this.world.getChunkUpdater().updateChunk(c,true);
	}
	public float getContentNaturalLight(float x,float y,float z)
	{
		return world.getContentNaturalLight(x, y, z) *world.getDaylightAmount();
	}
	public float getContentMaxLight(float x,float y,float z)
	{
		float art=this.getContentArtificialLight(x, y, z);
		float nat=this.getContentNaturalLight(x, y, z);
		if(art>nat) return art;
		else return nat;
	}
	public float getContentArtificialLight(float x,float y,float z)
	{
		return world.getContentArtificialLight(x, y, z);
	}
	public void addChunkAddPetition(Chunk c)
	{
		synchronized(this.world)
		{
			this.world.getAddList().add(c);
		}
	}
	public void insertChunkInUpdateList(Chunk c)
	{
		this.world.addChunkToUpdateList(c);
	}
	public Chunk getChunkInAddList(int x,int y,int z)
	{
		synchronized(this.world)
		{
			for(Chunk ch:this.world.getAddList())
			{
				if(ch.getX()==x&&ch.getY()==y&&ch.getZ()==z)
				{
					return ch;
				}
			}
			return null;
		}
	}
	public boolean[] getNeighboursAdded(Chunk c)
	{
		boolean[] neigh=new boolean[6];
		neigh[Chunk.Direction.XP.ordinal()]=getChunkByIndex(c.getX()+1,c.getY(),c.getZ())!=null;
		neigh[Chunk.Direction.XM.ordinal()]=getChunkByIndex(c.getX()-1,c.getY(),c.getZ())!=null;
		neigh[Chunk.Direction.YP.ordinal()]=getChunkByIndex(c.getX(),c.getY()+1,c.getZ())!=null;
		neigh[Chunk.Direction.YM.ordinal()]=getChunkByIndex(c.getX(),c.getY()-1,c.getZ())!=null;
		neigh[Chunk.Direction.ZP.ordinal()]=getChunkByIndex(c.getX(),c.getY(),c.getZ()+1)!=null;
		neigh[Chunk.Direction.ZM.ordinal()]=getChunkByIndex(c.getX(),c.getY(),c.getZ()-1)!=null;
		return neigh;
	}
	public Chunk[] getNeighbours(Chunk c)
	{
		Chunk[] neigh=new Chunk[6];
		neigh[Chunk.Direction.XP.ordinal()]=getChunkByIndex(c.getX()+1,c.getY(),c.getZ());
		neigh[Chunk.Direction.XM.ordinal()]=getChunkByIndex(c.getX()-1,c.getY(),c.getZ());
		neigh[Chunk.Direction.YP.ordinal()]=getChunkByIndex(c.getX(),c.getY()+1,c.getZ());
		neigh[Chunk.Direction.YM.ordinal()]=getChunkByIndex(c.getX(),c.getY()-1,c.getZ());
		neigh[Chunk.Direction.ZP.ordinal()]=getChunkByIndex(c.getX(),c.getY(),c.getZ()+1);
		neigh[Chunk.Direction.ZM.ordinal()]=getChunkByIndex(c.getX(),c.getY(),c.getZ()-1);
		return neigh;
	}
	public int getAddListSize()
	{
		return this.world.getAddList().size();
	}
	public void reloadPlayerFOV(int x,int y,int z)
	{
		this.world.reloadChunks(x,y,z);
	}
	public boolean isLoaded(int x,int z)
	{
		return this.world.getChunkStorage().isLoaded(x,z);
	}
	public MapHandler getMapHandler()
	{
		return this.world.getMapGenerator();
	}
	public Chunk getChunkByIndex(int x,int y,int z)
	{
		return this.world.getChunkStorage().getChunkByIndex(x, y,z);
	}
	/*public Chunk getChunkByIndexStrict(int x,int y,int z)
	{
		Chunk c=this.world.getChunkStorage().getChunkByIndex(x, y,z);
		if(c==null) return getChunkInAddList(x,y,z);
		return c;
	}*/
	
}
