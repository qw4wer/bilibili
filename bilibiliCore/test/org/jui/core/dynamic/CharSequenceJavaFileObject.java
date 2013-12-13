package org.jui.core.dynamic;

import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import java.net.URI;

public class CharSequenceJavaFileObject extends SimpleJavaFileObject {

	private CharSequence content;

	public CharSequenceJavaFileObject(String className, CharSequence content) {

		super(URI.create("string:///" + className.replace('.', '/')
				+ JavaFileObject.Kind.SOURCE.extension),
				JavaFileObject.Kind.SOURCE);
		System.out.println("CharSequenceJavaFileObject init:\t"+URI.create("string:///" + className.replace('.', '/')
				+ JavaFileObject.Kind.SOURCE.extension));
		this.content = content;
	}

	@Override
	public CharSequence getCharContent(boolean ignoreEncodingErrors) {
		return content;
	}
}
