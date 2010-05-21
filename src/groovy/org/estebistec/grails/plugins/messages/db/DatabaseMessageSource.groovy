package org.estebistec.grails.plugins.messages.db

import org.springframework.context.support.AbstractMessageSource

import java.text.MessageFormat

/**
 * Provides i18n messages from database storage.
 * @author Steven Cummings
 */
class DatabaseMessageSource extends AbstractMessageSource {
    protected MessageFormat resolveCode(String code, Locale locale) { 
        Message msg = Message.findByCodeAndLocale(code, locale)
        def format
        if(msg) {
            format = new MessageFormat(msg.text, msg.locale)
        }
        else {
            format = new MessageFormat(code, locale)
        }
        return format;
    }
}