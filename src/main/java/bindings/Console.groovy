package bindings

import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.script.ScriptEngine

class Console {

    private Logger logger = LoggerFactory.getLogger(getClass())

    def log(... args) {
        switch (args.length) {
            case 1:
                logger.info(s[0])
                break;
            case 0:
                break;
            default:
                logger.info(args.join(" "))
        }
    }

    def warn(s) {
        logger.warn(s)
    }

    def error(s) {
        logger.error(s)
    }

    static void enable(ScriptEngine engine) {
        engine.put("console", new Console())
    }

}
