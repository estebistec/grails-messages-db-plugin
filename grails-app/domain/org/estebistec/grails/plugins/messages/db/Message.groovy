package org.estebistec.grails.plugins.messages.db

/**
 * I18n message stored in a database.
 * @author Steven Cummings
 */
class Message {
    String code
    Locale locale
    String text

    static constraints = {
        code(blank: false)
        locale(nullable: false, unique: 'code')
        text(blank: false)
    }

    static mapping = {
        cache true
    }
}
