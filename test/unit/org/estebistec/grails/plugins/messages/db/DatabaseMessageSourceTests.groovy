package org.estebistec.grails.plugins.messages.db

import grails.test.GrailsUnitTestCase

class DatabaseMessageSourceTests extends GrailsUnitTestCase {
    def databaseMessageSource

    void setUp() {
        super.setUp()
        mockDomain(Message, [new Message(code:'code', locale:Locale.US, text:'text')])
        databaseMessageSource = new DatabaseMessageSource()
    }

    void testResolveCode_NonNullResult() {
        assertNotNull databaseMessageSource.resolveCode('code', Locale.UK)
    }

    void testResolveCode_MessageFound() {
        def message = databaseMessageSource.resolveCode('code', Locale.US)
        assertEquals 'text', message.toPattern()
    }

    void testResolveCode_MessageNotFound() {
        def message = databaseMessageSource.resolveCode('code', Locale.UK)
        assertEquals 'code', message.toPattern()
    }
}