import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CustomClassloader extends ClassLoader {

    public CustomClassloader(ClassLoader parent) {
        super(parent);
    }

    @Override
    public synchronized Class loadClass(String name) throws ClassNotFoundException {

        try {
            System.out.println("try loadClass (" + name + ") in System classLoader");
            return super.loadClass(name);
        } catch (Throwable e) {
            try {
                System.out.println("try loadClass (" + name + ") in Custom classLoader");
                FileInputStream fin = new FileInputStream(name);
                byte[] buff = new byte[(int) (new File(name).length())];
                fin.read(buff);
                fin.close();
                Class<?> aClass = defineClass(getSimpleName(name), buff, 0, buff.length);
                System.out.println("Class (" + name + ") was loaded in Custom classLoader");
                return aClass;
            } catch (IOException err) {
                throw new ClassNotFoundException(e.getMessage(), err);
            }
        }
    }

    private String getSimpleName(String name) {
        String[] splitName = name.split("/");
        return splitName[splitName.length - 1].split(".class")[0];
    }
}
