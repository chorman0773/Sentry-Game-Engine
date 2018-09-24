package github.chorman0773.sentry.cci.core;


import java.security.cert.Certificate;

import github.chorman0773.sentry.cci.DestroyableByteArray;

public interface ICCIProvider {
	String uri();
	Certificate getCertificate();
	String vendor();
	DestroyableByteArray vendorSecurityPointer();
}
