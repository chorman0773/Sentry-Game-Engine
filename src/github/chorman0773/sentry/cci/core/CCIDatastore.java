package github.chorman0773.sentry.cci.core;

import java.io.InputStream;

public interface CCIDatastore {
	InputStream datastore();
	String datastoreURI();
	Object datastoreReadLock();
}
