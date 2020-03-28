package armankavian;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class IOCContainer {

    public static final IOCContainer INSTANCE = new IOCContainer();

    private final Map<String, Object> pool = new HashMap<>();

    private void init() {
        Reflections reflections = new Reflections("armankavian");
        for (Class<?> clazz : reflections.getTypesAnnotatedWith(ControlClass.class)) {
            try {
                Object controlClass = clazz.getConstructor().newInstance();

                System.out.println(controlClass.toString());
            } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private IOCContainer() {
        init();
    }

    public Map<String, Object> getPool() {
        return pool;
    }
}
