import org.estebistec.grails.plugins.messages.db.Message

class BootStrap {
     def init = { servletContext ->
         new Message(code:'code', locale:Locale.US, text:'US code Text. Arg {0}').save()
         new Message(code:'code', locale:Locale.FRENCH, text:'FR code Text. Arg {0}').save()
     }
     def destroy = {
     }
}
