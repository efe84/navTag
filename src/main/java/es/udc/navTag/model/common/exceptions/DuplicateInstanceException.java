package es.udc.navTag.model.common.exceptions;

/**
 * The Class DuplicateInstanceException.
 */
public class DuplicateInstanceException extends InstanceException{
    
    /**
     * Instantiates a new duplicate instance exception.
     *
     * @param name the name
     * @param key the key
     */
    public DuplicateInstanceException(String name, Object key) {
    	super(name, key); 	
    }

}
