import java.util.Arrays;

/**
 * Created by apple on 28/06/16.
 */
public class Startup {


    public static void main(String[] args) {
        StandardObjectInstaller.installStandardObjects(Arrays.asList("tenant1", "tenant2"));
    }
}
