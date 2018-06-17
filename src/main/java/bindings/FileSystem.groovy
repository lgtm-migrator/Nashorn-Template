package bindings

import org.apache.commons.io.FileUtils

import javax.script.ScriptEngine

class FileSystem {

    String readFileSync(String path) {

        return FileUtils.readFileToString(new File(path), "UTF-8")

    }

    void writeFileSync(String path, String content) {

        FileUtils.writeStringToFile(new File(path), content)

    }

    static void enable(ScriptEngine engine) {
        engine.put("fs", new FileSystem())
    }

}
