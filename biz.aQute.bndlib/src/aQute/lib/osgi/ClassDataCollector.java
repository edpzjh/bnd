package aQute.lib.osgi;

public class ClassDataCollector {
    public void classBegin(int access, String name) {
    }

    public boolean classStart(int access, String name) {
        classBegin(access,name);
        return true;
    }

    public void extendsClass(String name) {
    }

    public void implementsInterfaces(String name[]) {
    }

    public void addReference(String token) {
    }

    public void annotation(Annotation annotation) {
    }

    public void parameter(int p) {
    }

    public void method(Clazz.MethodDef defined) {
        if (defined.isConstructor())
            constructor(defined.access, defined.descriptor);
        else
            method(defined.access, defined.name, defined.descriptor);
    }

    public void field(Clazz.FieldDef defined) {
        field(defined.access, defined.name, defined.descriptor);
    }

    public void reference(Clazz.MethodDef referenced) {
    }

    public void reference(Clazz.FieldDef referenced) {
    }

    public void classEnd() {
    }

    @Deprecated // Will really be removed!
    public void field(int access, String name, String descriptor) {
    }

    @Deprecated // Will really be removed!
    public void constructor(int access, String descriptor) {
    }

    @Deprecated // Will really be removed!
    public void method(int access, String name, String descriptor) {
    }

    /**
     * The EnclosingMethod attribute
     * 
     * @param cName The name of the enclosing class, never null. Name is with slashes.
     * @param mName The name of the enclosing method in the class with cName or null
     * @param mDescriptor The descriptor of this type
     */
	public void enclosingMethod(String cName, String mName, String mDescriptor) {
		
	}

	/**
	 * The InnerClass attribute
	 * 
	 * @param innerClass The name of the inner class (with slashes). Can be null.
	 * @param outerClass The name of the outer class (with slashes) Can be null.
	 * @param innerName The name inside the outer class, can be null.
	 * @param modifiers The access flags 
	 */
	public void innerClass(String innerClass, String outerClass, String innerName,
			int innerClassAccessFlags) {		
	}

	public void signature(String signature) {
	}

	public void constant(Object object) {
	}

	public void memberEnd() {
	}

	public void version(int minor, int major) {
		// TODO Auto-generated method stub
		
	}

}
