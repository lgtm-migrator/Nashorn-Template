import bindings.Console;
import bindings.FileSystem;
import com.coveo.nashorn_modules.Require;
import com.coveo.nashorn_modules.ResourceFolder;
import jdk.nashorn.api.scripting.NashornScriptEngine;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class ExecJsScriptEngine {

    private static String mainJsFilePath = "js/main.js";


    public static void main(String[] args) throws ScriptException, IOException {

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");

        Console.enable(engine);
        FileSystem.enable(engine);

        Require.enable((NashornScriptEngine) engine, ResourceFolder.create(ExecJsScriptEngine.class.getClassLoader(), "js", "UTF-8"));

        InputStream is = ExecJsScriptEngine.class.getResourceAsStream(mainJsFilePath);
        Reader reader = new InputStreamReader(is);

        engine.eval(reader);
        reader.close();

    }

}