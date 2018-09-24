package github.chorman0773.sentry.save.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;

public class NBTTagByteArray extends NBTTagBase{
	private byte[] array;
	public NBTTagByteArray() {}
	public NBTTagByteArray(int val) {
		array = new byte[val];
	}
	public NBTTagByteArray(byte[] b) {
		array = new byte[b.length];
		System.arraycopy(b, 0, array, 0, b.length);
	}
	@Override
	public int getTagType() {
		// TODO Auto-generated method stub
		return TAG_BYTE_ARRAY;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "B"+Arrays.toString(array);
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(array.length);
		out.write(array);
	}

	@Override
	public void read(DataInput in) throws IOException {
		int len = in.readInt();
		array = new byte[len];
		in.readFully(array);
	}
	
	public byte get(int i) {
		return array[i];
	}
	public void set(int i,byte b) {
		array[i] = b;
	}

}
