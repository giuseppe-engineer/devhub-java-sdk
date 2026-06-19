package com.devhubapi.sdk.module.convert;

/**
 * Defines how JSON arrays are represented in XML output.
 */
public enum ArrayMode {
    /**
     * Flattens arrays without wrapper elements.
     */
    FLAT,

    /**
     * Wraps arrays inside a container element.
     */
    WRAPPED
}