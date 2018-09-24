package github.chorman0773.sentry.cci.core;

public interface ICCICore {
	CCIDatastore openDatastore(String uri);
	String uri();
}
