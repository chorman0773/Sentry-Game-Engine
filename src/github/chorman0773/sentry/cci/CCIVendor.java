package github.chorman0773.sentry.cci;

import java.security.PublicKey;
import java.util.UUID;

import github.chorman0773.sentry.cci.core.ICCICore;

/**
 * Represents a Vendor of Sentry Software
 * @author connor
 */
public interface CCIVendor {
	/**
	 * Checks if the Vendor Information can be verified by the Sentry CCI Vendor List
	 * @return true if and only if the Vendor has an associated public key, and the CCI Vendors List contains that certificate
	 */
	boolean isVerifiable();
	/**
	 * Checks if the given core is actually provided by this vendor.
	 * @param core the CCI Core to check
	 * @return true if and only if the Vendor can be verified and the Core is signed by the Certificate Associated with the Vendor
	 */
	boolean verify(ICCICore core);
	/**
	 * Gets the UUID of the Vendor
	 */
	UUID getVendorId();
	
	/**
	 * Gets the name of the vendor
	 */
	String getVendorName();
	
	/**
	 * Obtains the public key of the vendor or null if its not available
	 */
	PublicKey getPublicKey();
}
