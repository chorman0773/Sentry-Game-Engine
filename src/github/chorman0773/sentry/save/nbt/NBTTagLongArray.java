package github.chorman0773.sentry.save.nbt;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Arrays;

public class NBTTagLongArray extends NBTTagBase {
	private long[] array;
	public NBTTagLongArray() {
		// TODO Auto-generated constructor stub
	}
	public NBTTagLongArray(int len) {
		array = new long[len];
	}
	public NBTTagLongArray(long[] l) {
		array = new long[l.length];
		System.arraycopy(l,0,array,0,l.length);
	}

	@Override
	public int getTagType() {
		// TODO Auto-generated method stub
		return TAG_LONG_ARRAY;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "L"+Arrays.toString(array);
	}

	@Override
	public void write(DataOutput out) throws IOException {
		out.writeInt(array.length);
		for(long l:array)
			out.writeLong(l);
	}

	@Override
	public void read(DataInput in) throws IOException {
		int len = in.readInt();
		array = new long[len];
		for(int i =0;i<len;i++)
			array[i] = in.readLong();
	}
	public long get(int idx) {
		return array[idx];
	}
	public void set(int idx,long val) {
		array[idx] = val;
	}
}
