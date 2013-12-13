package org.jui.core.dynamic;

import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import java.io.IOException;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.net.URI;

public class JavaClassObject extends SimpleJavaFileObject {

    protected final ByteArrayOutputStream bos =
        new ByteArrayOutputStream();


    public JavaClassObject(String name, JavaFileObject.Kind kind) {
        super(URI.create("string:///" + name.replace('.', '/')
            + kind.extension), kind);
        System.out.println("JavaClassObject init:\t" + URI.create("string:///" + name.replace('.', '/')
            + kind.extension));
    }


    public byte[] getBytes() {
        return bos.toByteArray();
    }

    @Override
    public OutputStream openOutputStream() throws IOException {
        return bos;
    }
}
