package github.chorman0773.sentry.save;

import github.chorman0773.sentry.save.nbt.NBTTagCompound;

public interface NBTSerializable {
	public void writeNBT(NBTTagCompound comp);
	public void readNBT(NBTTagCompound comp);
	public default NBTTagCompound serializeNBT() {
		NBTTagCompound write = new NBTTagCompound();
		writeNBT(write);
		return write;
	}
}
