class MessagesDbGrailsPlugin {
    def version = "1.0-SNAPSHOT"
    def grailsVersion = "1.3.1 > *"
    def dependsOn = [:]
    def pluginExcludes = [
        'grails-app/conf/DataSource.groovy'
    ]

    def author = "Steven Cummings"
    def authorEmail = "estebistec@gmail.com"
    def title = "Store i18n messages in the database"
    def description = '''\\
Store i18 messages in the database. An alternate messageSource bean is provided that utilizes this
storage in providing messages via the message(...) tag. The primary benefit of this is that i18n
messages can be managed without having to re-assemble your application WAR, as it is with the
messages properties files. This plugin is based on a blog post by Graeme Rocher describing the
simple implementation you find here. [1].

[1] http://graemerocher.blogspot.com/2010/04/reading-i18n-messages-from-database.html
'''

    // URL to the plugin's documentation
    def documentation = "http://grails.org/plugin/messages-db"

    def doWithWebDescriptor = { xml ->
    }

    def doWithSpring = {
        messageSource(org.estebistec.grails.plugins.messages.db.DatabaseMessageSource)
    }

    def doWithDynamicMethods = { ctx ->
    }

    def doWithApplicationContext = { applicationContext ->
    }

    def onChange = { event ->
    }

    def onConfigChange = { event ->
    }
}
