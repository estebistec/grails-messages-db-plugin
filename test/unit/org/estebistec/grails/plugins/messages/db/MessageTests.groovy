package org.estebistec.grails.plugins.messages.db

import grails.test.GrailsUnitTestCase

class MessageTests extends GrailsUnitTestCase {
    void setUp() {
        super.setUp()
        mockDomain(Message)
    }

    void testNullCode() {
        def message = new Message(code:null, locale:Locale.US, text:'text')
        assertFalse 'validation should have failed', message.validate()
        assertEquals 1, message.errors.errorCount
        assertEquals 'nullable', message.errors.code
    }

    void testBlankCode() {
        def message = new Message(code:' \t\n\r', locale:Locale.US, text:'text')
        assertFalse 'validation should have failed', message.validate()
        assertEquals 1, message.errors.errorCount
        assertEquals 'blank', message.errors.code
    }

    void testNullLocale() {
        def message = new Message(code:'code', locale:null, text:'text')
        assertFalse 'validation should have failed', message.validate()
        assertEquals 1, message.errors.errorCount
        assertEquals 'nullable', message.errors.locale
    }

    void testDuplicateCodeAndLocale() {
        def message1 = new Message(code:'code', locale:Locale.US, text:'text')
        message1.save()
        def message2 = new Message(code:'code', locale:Locale.US, text:'text')        
        assertFalse 'validation should have failed', message2.validate()
        assertEquals 1, message2.errors.errorCount
        assertEquals 'unique', message2.errors.locale
    }

    void testNullText() {
        def message = new Message(code:'code', locale:Locale.US, text:null)
        assertFalse 'validation should have failed', message.validate()
        assertEquals 1, message.errors.errorCount
        assertEquals 'nullable', message.errors.text
    }

    void testBlankText() {
        def message = new Message(code:'code', locale:Locale.US, text:' \t\n\r')
        assertFalse 'validation should have failed', message.validate()
        assertEquals 1, message.errors.errorCount
        assertEquals 'blank', message.errors.text
    }

    void testValidMessage() {
        def message = new Message(code:'code', locale:Locale.US, text:'text')
        assertTrue 'validation should have succeeded', message.validate()
    }

    void testValidMessages() {
        def message1 = new Message(code:'code', locale:Locale.US, text:'text')
        assertTrue 'validation should have succeeded', message1.validate()
        message1.save()
        def message2 = new Message(code:'code', locale:Locale.UK, text:'text')        
        assertTrue 'validation should have succeeded', message2.validate()
    }
}
